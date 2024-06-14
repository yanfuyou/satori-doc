<script setup lang="ts">
import { onMounted, reactive, ref, toRefs } from "vue";
import type { FormProps } from "element-plus";
import { Edit, Check, More } from "@element-plus/icons-vue";
import { addTitle, addParagraph } from "../server";
import { IResponseData } from "@/@types/utils.request";
import { ITitle } from "../data";
import { useRoute } from "vue-router";

const route = useRoute();
const { query } = toRefs(route);

const titleVisible = ref(false);
const labelPosition = ref<FormProps["labelPosition"]>("right");
const formLabelAlign = reactive({
	name: "",
	region: "",
	type: "",
});
const titleForm = reactive<ITitle>({
	docId: 1,
	content: "",
	followId: 3,
	configuration: {
		level: 1,
		fontConfiguration: {
			fontFamily: 1,
			glyph: 4,
		},
	},
});
const componentList = ref([]);
const dataList = ref([]);

const addEle = (type: number) => {
	componentList.value.push(type);
	if (type === 1) {
		dataList.value.push({
			docId: query.value.docId,
			content: "",
			followId: 3,
			configuration: {
				level: 1,
				fontConfiguration: {
					fontFamily: 1,
					glyph: 4,
				},
			},
			isTitle: true,
		});
	} else {
		dataList.value.push({
			id: null,
			docId: query.value.docId,
			titleId: null,
			content: "",
			configuration: {
				fontConfiguration: {
					fontFamily: 1,
					glyph: 4,
				},
				indentConfiguration: {
					special: 2,
					indentVal: 4,
				},
			},
			isTitle: false,
		});
	}
};
const elePop = () => {
	componentList.value.pop();
	dataList.value.pop();
};

const curTitleIndex = ref(null);
const showTitleConf = (index: number) => {
	titleVisible.value = true;
	curTitleIndex.value = index;
};

const titleAdd = async (index: number) => {
	if (index === 0) {
		dataList.value[index].followId = 0;
	} else {
		dataList.value[index].followId = dataList.value[index - 1].id;
	}
	const titleRes: IResponseData<any> = await addTitle(dataList.value[index]);
	dataList.value[index].id = titleRes.data;
};

const paragraphAdd = async (index: number) => {
	if (index === 0) {
		dataList.value[index].followId = 0;
		dataList.value[index].titleId = 0;
	} else if (dataList.value[index - 1].isTitle) {
		dataList.value[index].followId = 0;
		dataList.value[index].titleId = dataList.value[index - 1].id;
	} else {
		dataList.value[index].followId = dataList.value[index - 1].id;
	}
	const titleRes: IResponseData<any> = await addParagraph(dataList.value[index]);
	dataList.value[index].id = titleRes.data;
};

const exportDoc = (id: number) => {
	console.log(id);
};

const titleLevel = ref([
	{
		label: "一级",
		value: 1,
	},
	{
		label: "二级",
		value: 2,
	},
	{
		label: "三级",
		value: 3,
	},
]);

const fontFamily = ref([
	{
		label: "黑体",
		value: 1,
	},
	{
		label: "宋体",
		value: 2,
	},
	{
		label: "Times New Roman",
		value: 3,
	},
]);

const glyph = ref([
	{
		label: "初号",
		value: 1,
	},
	{
		label: "小初号",
		value: 2,
	},
	{
		label: "一号",
		value: 3,
	},
	{
		label: "小一",
		value: 4,
	},
]);

onMounted(() => {
	console.log("docId:", query.value.docId);
});
</script>
<template>
	<div class="doc-add">
		<el-row :gutter="20">
			<el-col :span="20" :offset="4">
				<el-button type="primary" :icon="Edit" @click="addEle(1)">添加标题</el-button>
				<el-button color="#626aef" :icon="Edit" @click="addEle(2)">添加段落</el-button>
				<el-button color="#620fff" :icon="Edit" @click="elePop">POP</el-button>
				<el-button color="#aaafff" :icon="Edit" @click="exportDoc">导出</el-button>
			</el-col>
		</el-row>
		<br />
		<el-row :gutter="5">
			<el-col :span="20" :offset="4">
				<el-form :label-position="labelPosition" label-width="auto" :model="formLabelAlign" style="max-width: 600px">
					<el-form-item v-for="(flag, index) in componentList" :key="index" :label="flag === 1 ? '标题' : '段落'">
						<el-row v-if="flag === 1" :gutter="5">
							<el-col :span="18">
								<el-input v-model="dataList[index].content" />
							</el-col>
							<el-col :span="4">
								<!-- 样式 -->
								<el-button @click="showTitleConf(index)" type="warning" :icon="More" />
							</el-col>
							<el-col :span="2">
								<el-button @click="titleAdd(index)" type="success" :icon="Check" circle />
							</el-col>
						</el-row>
						<el-row v-else :gutter="5">
							<el-col :span="20">
								<el-input v-model="dataList[index].content" type="textarea"></el-input>
							</el-col>

							<el-col :span="4">
								<!-- 样式 -->
								<el-button @click="paragraphAdd(index)" type="success" :icon="Check" circle />
							</el-col>
						</el-row>
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>

		<el-dialog v-model="titleVisible" title="标题设置" width="500">
			<el-form label-position="top" :model="titleForm">
				<el-form-item label="标题级别" :label-width="20">
					<el-select v-model="dataList[curTitleIndex].configuration.level" placeholder="请选择标题级别">
						<el-option v-for="item in titleLevel" :key="item.value" :label="item.label" :value="item.value" />
					</el-select>
				</el-form-item>
				<el-form-item label="字体" :label-width="20">
					<el-select
						v-model="dataList[curTitleIndex].configuration.fontConfiguration.fontFamily"
						placeholder="请选择字体"
					>
						<el-option v-for="item in fontFamily" :key="item.value" :label="item.label" :value="item.value" />
					</el-select>
				</el-form-item>
				<el-form-item label="字号" :label-width="20">
					<el-select v-model="dataList[curTitleIndex].configuration.fontConfiguration.glyph" placeholder="请选择字号">
						<el-option v-for="item in glyph" :key="item.value" :label="item.label" :value="item.value" />
					</el-select>
				</el-form-item>
			</el-form>
			<template #footer>
				<div class="dialog-footer">
					<el-button @click="titleVisible = false">取消</el-button>
					<el-button type="primary" @click="titleVisible = false">确认</el-button>
				</div>
			</template>
		</el-dialog>
	</div>
</template>

<style lang="scss" scoped>
.doc-add {
	width: 100%;
	height: 100%;
}
</style>

<script setup lang="ts">
import { reactive, ref } from "vue";
import type { FormProps } from "element-plus";
import { Edit } from "@element-plus/icons-vue";
const labelPosition = ref<FormProps["labelPosition"]>("right");

const formLabelAlign = reactive({
	name: "",
	region: "",
	type: "",
});
const componentList = ref([1, 2]);
const addEle = (type: number) => {
	componentList.value.push(type);
};
const elePop = () => {
	componentList.value.pop();
};
</script>
<template>
	<div class="doc-add">
		<el-row :gutter="20">
			<el-col :span="20" :offset="4">
				<el-button type="primary" :icon="Edit" @click="addEle(1)">添加标题</el-button>
				<el-button color="#626aef" :icon="Edit" @click="addEle(2)">添加段落</el-button>
				<el-button color="#620fff" :icon="Edit" @click="elePop">POP</el-button>
			</el-col>
		</el-row>
		<br />
		<el-row :gutter="20">
			<el-col :span="20" :offset="4">
				<el-form
					:label-position="labelPosition"
					label-width="auto"
					:model="formLabelAlign"
					style="max-width: 600px"
				>
					<el-form-item
						v-for="(flag, index) in componentList"
						:key="index"
						:label="flag === 1 ? '标题' : '段落'"
					>
						<el-input v-if="flag === 1" v-model="formLabelAlign.name" />
						<el-input v-else v-model="formLabelAlign.name" type="textarea" />
					</el-form-item>
				</el-form>
			</el-col>
		</el-row>
	</div>
</template>

<style lang="scss" scoped>
.doc-add {
	width: 100%;
	height: 100%;
}
</style>

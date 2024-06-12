<script setup lang="ts">
import { onMounted, reactive, ref } from "vue";
import { listAll, addDoc } from "./server";
import { IDoc } from "./data";

const docDialog = ref(false);
const docList = ref([]);

const doc = reactive<IDoc>({
	id: null,
	name: "",
	type: 1,
});

const listDoc = async () => {
	const { data } = await listAll();
	docList.value = data;
};

const add = async () => {
	await addDoc(doc);
	docDialog.value = false;
	listDoc();
};

onMounted(() => {
	listDoc();
});
</script>

<template>
	<div>
		<el-button type="success" @click="docDialog = true">新建文档</el-button>
		<el-table :data="docList" style="width: 100%">
			<el-table-column prop="id" label="id" />
			<el-table-column prop="name" label="名称" />
			<el-table-column prop="createTime" label="创建时间" />
		</el-table>
		<el-dialog v-model="docDialog" title="文档名称" width="800">
			<el-input v-model="doc.name" style="width: 240px" placeholder="文档名称" />
			<template #footer>
				<div class="dialog-footer">
					<el-button
						@click="
							docDialog = false;
							docTitle = '';
						"
						>取消</el-button
					>
					<el-button type="primary" @click="add"> 确认 </el-button>
				</div>
			</template>
		</el-dialog>
	</div>
</template>

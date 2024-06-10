<script setup lang="ts">
import { ref } from "vue";
const dialogVisible = ref(false);

const open = ()=> {
	dialogVisible.value = true;
}
</script>

<template>
	<el-dialog v-model="dialogVisible" title="Shipping address" width="500">
		<!-- <el-form :model="form">
			<el-form-item label="Promotion name" :label-width="formLabelWidth">
				<el-input v-model="form.name" autocomplete="off" />
			</el-form-item>
			<el-form-item label="Zones" :label-width="formLabelWidth">
				<el-select v-model="form.region" placeholder="Please select a zone">
					<el-option label="Zone No.1" value="shanghai" />
					<el-option label="Zone No.2" value="beijing" />
				</el-select>
			</el-form-item>
		</el-form>-->
		<template #footer>
			<div class="dialog-footer">
				<el-button @click="dialogVisible = false">取消</el-button>
				<el-button type="primary" @click="dialogVisible = false">确认</el-button>
			</div>
		</template>
	</el-dialog>
</template>

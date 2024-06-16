import request from "@/utils/request";

import { ITitle, IDoc, IParagraph } from "./data";

/**
 *
 * @param params 添加标题
 */
export async function addTitle(params: ITitle): Promise<any> {
	return request({
		url: "/title/add",
		method: "POST",
		data: params,
	});
}

/**
 *
 * 所有文档
 */
export async function listAll(): Promise<any> {
	return request({
		url: "/doc/list/all",
		method: "GET",
	});
}

/**
 *
 * 创建文档
 */
export async function addDoc(params: IDoc): Promise<any> {
	return request({
		url: "/doc/add",
		method: "POST",
		data: params,
	});
}

/**
 * 添加段落
 */
export async function addParagraph(params: IParagraph) {
	return request({
		url: "/paragraph/add",
		method: "POST",
		data: params,
	});
}

/**
 * 生成文档
 */
export async function createDoc(id: number) {
	return request({
		url: `/doc/create/${id}`,
		method: "GET",
	});
}

/**
 * 删除文档
 */
export async function delDoc(id: number) {
	return request({
		url: `/doc/del/${id}`,
		method: "DELETE",
	});
}

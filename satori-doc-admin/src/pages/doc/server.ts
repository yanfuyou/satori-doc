import request from "@/utils/request";

import { ITitle } from "./data";

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

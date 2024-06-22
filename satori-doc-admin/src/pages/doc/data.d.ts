import { AlignMethodEnum, FontFamilyEnum, GlyphEnum, IndentSpecialEnum, TitleLevelEnum } from "@/enums/doc.enum";

/**
 * 标题
 */
export interface ITitle {
	docId: number;
	content: string;
	followId: number;
	configuration: TitleConfiguration;
}

/**
 * 文档
 */
export interface IDoc {
	id: number;
	name: string;
	type: number;
}

/**
 * 段落
 */
export interface IParagraph {
	id: number;
	docId: number;
	titleId: number;
	content: string;
	configuration: ParagraphConfiguration;
	followId: number;
}

/**
 * 段落
 */
export class Paragraph implements IParagraph {
	id: number;
	docId: number;
	titleId: number;
	content: string;
	configuration: ParagraphConfiguration;
	followId: number;
}

/**
 * 标题配置
 */
interface TitleConfiguration extends BaseConfiguration {
	level: TitleLevelEnum;
}

/**
 * 段落配置
 */
interface ParagraphConfiguration extends BaseConfiguration {
	test?: number;
}

/**
 * 字体配置
 */
interface FontConfiguration {
	fontFamily: FontFamilyEnum;
	glyph: GlyphEnum;
}

/**
 * 缩进配置
 */
interface IndentConfiguration {
	special: IndentSpecialEnum;
	indentVal: number;
}

/**
 * 基础配置
 */
interface BaseConfiguration {
	fontConfiguration?: FontConfiguration;
	indentConfiguration?: FontConfiguration;
	align?: AlignMethodEnum;
}

/**
 * 对齐方式
 */
export const alignMethod = [
	{ value: 1, label: "左对齐" },
	{ value: 2, label: "居中对齐" },
	{ value: 3, label: "右对齐" },
	{ value: 4, label: "两端对齐" },
	{ value: 5, label: "分散对齐" },
];

/**
 * 字体样式
 */
export const fontStyle = [
	{ value: 1, label: "常规" },
	{ value: 2, label: "加粗" },
	{ value: 3, label: "倾斜" },
];

/**
 * 缩进-特殊
 */
export const indentSpecial = [
	{ value: 1, label: "无" },
	{ value: 2, label: "首行" },
	{ value: 3, label: "悬挂" },
];

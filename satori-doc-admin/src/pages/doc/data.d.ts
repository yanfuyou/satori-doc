import { FontFamilyEnum, GlyphEnum, IndentSpecialEnum } from '@/enums/utils.config.enum'

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
	constructor() { }
}

/**
 * 标题配置
 */
interface TitleConfiguration {
	level: number;
	fontConfiguration: FontConfiguration;
}

/**
 * 段落配置
 */
interface ParagraphConfiguration {
	fontConfiguration: FontConfiguration;
	indentConfiguration: IndentConfiguration;
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

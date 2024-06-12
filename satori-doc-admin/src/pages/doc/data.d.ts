import { FontFamilyEnum, GlyphEnum } from '@/enums/utils.config.enum'

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
 * 标题配置
 */
interface TitleConfiguration {
	level: number;
	fontConfiguration: FontConfiguration;
}

/**
 * 字体配置
 */
interface FontConfiguration {
	fontFamily: FontFamilyEnum;
	glyph: GlyphEnum;
}

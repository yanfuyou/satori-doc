

/**
 * 文档类型
 */
export enum DocTypeEnum {
	XLSX = 1,
}


/**
 * 字体
 */
export enum FontFamilyEnum {
	// 黑体
	HEI_TI = 1,
	// 宋体
	SONG_TI = 2,
	// time new roman
	T_N_R = 3,
}

/**
 * 字号
 */
export enum GlyphEnum {
	// 初号
	FIRST = 1,
	// 小初号
	TRUMPET = 2,
	// 一号
	NUMBER_ONE = 3,
	// 小一
	TRUMPET_NUMBER_ONE = 4,
}

/**
 * 缩进-特殊规则
 */
export enum IndentSpecialEnum {
	// 无
	NONE = 1,
	// 首行
	OEN_LINE = 2,
	// 悬挂
	HANG = 3,
}

/**
 * 对齐方式
 */
export enum AlignMethodEnum {
	// 左对齐
	LEFT = 1,
	// 居中
	CENTER = 2,
	// 右对齐
	RIGHT = 3,
	// 两端对齐
	ENDS = 4,
	// 分散对齐
	VARIANCE = 5,
}

/**
 * 字体样式
 */
export enum FontStyleEnum {
	// 常规
	NORMAL = 1,
	// 加粗
	BOLD = 2,
	// 倾斜
	INCLINE = 3,
}

/**
 * 标题级别
 */
export enum TitleLevelEnum {
	LEVEL_1 = 1,
	LEVEL_2 = 2,
	LEVEL_3 = 3,
	LEVEL_4 = 4,
}

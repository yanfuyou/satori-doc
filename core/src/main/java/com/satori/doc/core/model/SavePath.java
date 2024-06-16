package com.satori.doc.core.model;

import lombok.Data;

/**
 * 保存路径
 *
 * @author cat_y
 */

@Data
public class SavePath {
    /**
     * 本地路径
     */
    private String localPath;

    /**
     * 远程路径
     */
    private String originPath;
}

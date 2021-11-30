package com.zhy.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/11/2 11:46
 */
@Data
public class Announcement implements Serializable {
    private static final long serialVersionUID = 629861961179219025L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 是否删除,0:显示;1:不显示
     */
    private Integer showStatus;

    private String showStatusName;
    /**
     * 是否删除,0:未删;1:已删
     */
    private Integer deleted;
    private Integer gmtCreate;

    private String createTime;

    private Integer gmtModified;
}

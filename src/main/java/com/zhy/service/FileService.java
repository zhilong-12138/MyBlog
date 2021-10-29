package com.zhy.service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/10/28 13:26
 */
public interface FileService {
    /**
     * 上传文件
     *
     * @param inputStream inputStream
     * @param fileName fileName
     * @param img         img
     * @return UUID
     */
    String upload(InputStream inputStream, String fileName, boolean img);


    /**
     * 下载文件
     *
     * @param fdsFileName 文件在fds中的名称
     * @param fileName    重新指定的文件名
     * @param response    response
     */
    void download(String fdsFileName, String fileName, HttpServletResponse response);

    /**
     * 删除
     *
     * @param fdsFileName fdsFileName
     */
    void delete(String fdsFileName);
}

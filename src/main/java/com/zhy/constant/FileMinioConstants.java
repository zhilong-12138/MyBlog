package com.zhy.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/10/28 14:08
 */
@Component
public class FileMinioConstants {

    public static String MINIO_ENDPOINT;

    public static String MINIO_ACCESS_KEY;

    public static String MINIO_SECRET_KEY;

    public static String MINIO_BUCKET_NAME;

    @Value("${minio.endpoint}")
    public void setMinioEndpoint(String minioEndpoint) {
        MINIO_ENDPOINT = minioEndpoint;
    }

    @Value("${minio.accesskey}")
    public void setMinioAccessKey(String minioAccessKey) {
        MINIO_ACCESS_KEY = minioAccessKey;
    }

    @Value("${minio.secretKey}")
    public void setMinioSecretKey(String minioSecretKey) {
        MINIO_SECRET_KEY = minioSecretKey;
    }

    @Value("${minio.bucketName}")
    public void setMinioBucketName(String minioBucketName) {
        MINIO_BUCKET_NAME = minioBucketName;
    }
}

package com.zhy.service.impl;

import com.zhy.constant.FileMinioConstants;
import com.zhy.service.FileService;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

/**
 * @author zhiLong
 * @version 1.0
 * @date 2021/10/28 13:27
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private static final String ENDPOINT;

    private static final String ACCESS_KEY_ID;

    private static final String ACCESS_KEY_SECRET;

    private static final String BUCKET_NAME;

    //初始化属性
    static {
        ENDPOINT = FileMinioConstants.MINIO_ENDPOINT;
        ACCESS_KEY_ID = FileMinioConstants.MINIO_ACCESS_KEY;
        ACCESS_KEY_SECRET = FileMinioConstants.MINIO_SECRET_KEY;
        BUCKET_NAME = FileMinioConstants.MINIO_BUCKET_NAME;
    }

    @Override
    public String upload(InputStream inputStream, String fileName, boolean img) {
        try {
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(ENDPOINT)
                            .credentials(ACCESS_KEY_ID, ACCESS_KEY_SECRET)
                            .build();

            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (found) {
                log.info("Bucket already exists.");
            } else {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            }

            if (!img) {
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(BUCKET_NAME)
                                .object(fileName)
                                .stream(inputStream, inputStream.available(), -1)
                                .build());
            } else {
                minioClient.putObject(
                        PutObjectArgs.builder()
                                .bucket(BUCKET_NAME)
                                .object(fileName)
                                .stream(inputStream, inputStream.available(), -1)
                                .contentType("image/png")
                                .build());
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("文件上传成功,访问地址->{},", ENDPOINT.concat("/").concat(BUCKET_NAME).concat("/").concat(fileName));
        return ENDPOINT.concat("/").concat(BUCKET_NAME).concat("/").concat(fileName);
    }


    @Override
    public void download(String fdsFileName, String fileName, HttpServletResponse response) {

    }

    @Override
    public void delete(String fdsFileName) {

    }
}

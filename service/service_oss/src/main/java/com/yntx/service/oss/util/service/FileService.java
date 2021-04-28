package com.yntx.service.oss.util.service;


import com.yntx.common.base.result.R;

import java.io.InputStream;

public interface FileService {

    /**
     * 文件上传至阿里云
     */
    String upload(InputStream inputStream, String module, String originalFilename);

    R removeFile(String url);
}

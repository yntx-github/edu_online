package com.yntx.service.oss.util.controller;

import com.yntx.common.base.result.R;
import com.yntx.common.base.result.ResultCodeEnum;
import com.yntx.common.base.util.ExceptionUtils;
import com.yntx.handler.CustomException;
import com.yntx.service.oss.util.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Api(description="阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/admin/oss/file")
@Slf4j
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     * @param file
     */
    @ApiOperation("文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam(value = "文件", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(value = "模块", required = true)
            @RequestParam("module") String module) throws IOException {

        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);
            //返回r对象
            return R.ok().message("文件上传成功").data("url", uploadUrl);
        }catch (Exception e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new CustomException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        }
    }

    @ApiOperation("文件删除")
    @DeleteMapping("remove")
    public R removeFile(
            @ApiParam(value = "要删除的文件路径", required = true)
            @RequestBody String url) {

        fileService.removeFile(url);
        return R.ok().message("文件刪除成功");
    }
}

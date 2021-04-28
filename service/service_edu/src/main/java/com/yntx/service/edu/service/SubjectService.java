package com.yntx.service.edu.service;

import com.yntx.service.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yntx.service.edu.entity.vo.SubjectVo;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
public interface SubjectService extends IService<Subject> {

    void batchImport(InputStream inputStream);

    List<SubjectVo> nestedList();
}

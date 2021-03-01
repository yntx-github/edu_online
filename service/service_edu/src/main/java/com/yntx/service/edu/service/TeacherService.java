package com.yntx.service.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yntx.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yntx.service.edu.entity.vo.TeacherQueryVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
public interface TeacherService extends IService<Teacher> {

    Page<Teacher> selectPage(Page<Teacher> teacherPage, TeacherQueryVo teacherQueryVo);

    //根据关键字自动查询讲师名称
    List<Map<String, Object>> selectNameListByKey(String key);
}

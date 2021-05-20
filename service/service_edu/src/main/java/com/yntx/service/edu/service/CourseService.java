package com.yntx.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yntx.service.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yntx.service.edu.entity.form.CourseInfoForm;
import com.yntx.service.edu.entity.vo.CourseQueryVo;
import com.yntx.service.edu.entity.vo.CourseVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
public interface CourseService extends IService<Course> {

    /**
     * 保存课程和课程详情信息
     * @param courseInfoForm
     * @return 新生成的课程id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    IPage<CourseVo> selectPage(Long page, Long limit, CourseQueryVo courseQueryVo);

    boolean removeCoverById(String id);

    boolean removeCourseById(String id);
}

package com.yntx.service.edu.service.impl;

import com.yntx.service.edu.entity.Course;
import com.yntx.service.edu.entity.CourseDescription;
import com.yntx.service.edu.entity.form.CourseInfoForm;
import com.yntx.service.edu.mapper.CourseDescriptionMapper;
import com.yntx.service.edu.mapper.CourseMapper;
import com.yntx.service.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    //我们可以在CourseDescriptionMapper接口上添加@Repository注解
    @Autowired
    private CourseDescriptionMapper courseDescriptionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveCourseInfo(CourseInfoForm courseInfoForm) {

        //保存课程基本信息
        Course course = new Course();
        course.setStatus(Course.COURSE_DRAFT);
        BeanUtils.copyProperties(courseInfoForm, course);
        baseMapper.insert(course);

        //保存课程详情信息
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseInfoForm.getDescription());
        courseDescription.setId(course.getId());
        courseDescriptionMapper.insert(courseDescription);

        return course.getId();
    }
}

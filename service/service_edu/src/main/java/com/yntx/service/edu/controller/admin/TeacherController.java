package com.yntx.service.edu.controller.admin;

import com.yntx.common.base.result.R;
import com.yntx.service.edu.entity.Teacher;
import com.yntx.service.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("list")
    public R findAll(){
        List<Teacher> teacherList = teacherService.list();
        return R.ok().data("list",teacherList).message("获取讲师列表成功！");
    }

    @GetMapping("selectById/{id}")
    public R selectById(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if (teacher != null){
            return R.ok().data("techer",teacher);
        }
        return R.ok().message("该讲师不存在！");
    }

    @DeleteMapping("removeById/{id}")
    public R removeById(@PathVariable String id){

        boolean res = teacherService.removeById(id);
        if (res){
            return R.ok().message("删除成功！");
        }
        return R.ok().message("该讲师不存在！");
    }


}


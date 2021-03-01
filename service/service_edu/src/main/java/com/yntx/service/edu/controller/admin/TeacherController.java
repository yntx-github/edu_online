package com.yntx.service.edu.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yntx.common.base.result.R;
import com.yntx.service.edu.entity.Teacher;
import com.yntx.service.edu.entity.vo.TeacherQueryVo;
import com.yntx.service.edu.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
@CrossOrigin
@RestController
@RequestMapping("/admin/edu/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("list")
    public R findAll(){
        List<Teacher> teacherList = teacherService.list();
        return R.ok().data("list",teacherList).message("获取讲师列表成功！");
    }

    //分页
    @GetMapping("list/{page}/{limit}")
    public R listPage(@PathVariable(value = "page") Long page, @PathVariable(value = "limit") Long limit,
                      @ApiParam("讲师查询对象") TeacherQueryVo teacherQueryVo){
        Page<Teacher> teacherPage = new Page<>(page, limit);
        Page<Teacher> pageModel = teacherService.selectPage(teacherPage,teacherQueryVo);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total",total).data("rows",records);

    }

    @GetMapping("selectById/{id}")
    public R selectById(@PathVariable(value = "id") String id){
        Teacher teacher = teacherService.getById(id);
        if (teacher != null){
            return R.ok().data("teacher",teacher);
        }
        return R.error().message("该讲师不存在！");
    }

    @DeleteMapping("removeById/{id}")
    public R removeById(@PathVariable(value = "id") String id){

        boolean res = teacherService.removeById(id);
        if (res){
            return R.ok().message("删除成功！");
        }
        return R.error().message("该讲师不存在！");
    }

    @PostMapping("save")
    public R save(@RequestBody Teacher teacher){
        boolean b = teacherService.save(teacher);
        if (!b){
            return R.error().message("添加讲师失败！");
        }
        return R.ok().message("添加讲师成功！");
    }

    @PutMapping("update")
    public R updateById(@RequestBody Teacher teacher){
        boolean b = teacherService.updateById(teacher);
        if (!b){
            return R.error().message("更新讲师信息失败！");
        }
        return R.ok().message("更新讲师信息成功！");
    }

    @ApiOperation("根据id列表删除讲师")
    @DeleteMapping("remove")
    public R removeByIds(@RequestBody List<String> idList){
        boolean byIds = teacherService.removeByIds(idList);
        if (byIds){
            return R.ok().message("删除成功！");
        }
        return R.error().message("删除失败！");
    }

    @ApiOperation("根据左关键字查询讲师名列表")
    @GetMapping("list/name/{key}")
    public R selectNameListByKey(
            @ApiParam(value = "查询关键字", required = true)
            @PathVariable String key){

        List<Map<String, Object>> nameList = teacherService.selectNameListByKey(key);

        return R.ok().data("nameList", nameList);
    }

}


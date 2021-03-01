package com.yntx.service.edu.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer level;
    private String joinDateBegin;//入职时间
    private String joinDateEnd;//离职时间
}

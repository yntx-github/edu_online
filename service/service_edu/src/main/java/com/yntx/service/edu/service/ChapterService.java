package com.yntx.service.edu.service;

import com.yntx.service.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yntx.service.edu.entity.vo.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
public interface ChapterService extends IService<Chapter> {

    boolean removeChapterById(String id);

    List<ChapterVo> nestedList(String courseId);
}

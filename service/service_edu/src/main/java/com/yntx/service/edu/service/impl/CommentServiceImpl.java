package com.yntx.service.edu.service.impl;

import com.yntx.service.edu.entity.Comment;
import com.yntx.service.edu.mapper.CommentMapper;
import com.yntx.service.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author yntx
 * @since 2021-01-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}

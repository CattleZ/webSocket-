package com.example.elog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.CommentVo;
import com.example.elog.entity.MComment;
import com.example.elog.mapper.MCommentMapper;
import com.example.elog.service.MCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gorge
 * @since 2023-04-30
 */
@Service
public class MCommentServiceImpl extends ServiceImpl<MCommentMapper, MComment> implements MCommentService {

    @Resource
    MCommentMapper mCommentMapper;
    @Override
    public IPage<CommentVo> paging(Page page, Long postId, Long userId, String created) {
        return mCommentMapper.selectComments(page,new QueryWrapper<MComment>()
                .eq(postId!= null,"post_id",postId)
        .eq(userId != null,"user_id",userId)
        .orderByDesc(created!=null,"created",created));
    }
}

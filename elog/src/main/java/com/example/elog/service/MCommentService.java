package com.example.elog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.CommentVo;
import com.example.elog.entity.MComment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gorge
 * @since 2023-04-30
 */
public interface MCommentService extends IService<MComment> {

    IPage<CommentVo> paging(Page page, Long articalId, Long userId, String created);
}

package com.example.elog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.CommentVo;
import com.example.elog.Vo.MPostVo;
import com.example.elog.entity.MComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gorge
 * @since 2023-04-30
 */
@Mapper
public interface MCommentMapper extends BaseMapper<MComment> {

    /**
     *
     * @param page
     * @param wrapper
     * @return
     */
    IPage<CommentVo> selectComments(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}

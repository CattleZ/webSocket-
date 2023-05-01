package com.example.elog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.MPostVo;
import com.example.elog.entity.MPost;
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
public interface MPostMapper extends BaseMapper<MPost> {

    /**
     * 分页查询博客内容
     * @param page
     * @param wrapper 通过设置@Param(Constants.WRAPPER) 能够自动生成sql并动态在mapper中
     *                使用，对应${ew.customSqlSegment}
     * @return
     */
    IPage<MPostVo> selectPosts(Page page, @Param(Constants.WRAPPER) QueryWrapper wrapper);
}

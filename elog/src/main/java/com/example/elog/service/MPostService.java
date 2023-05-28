package com.example.elog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.MPostVo;
import com.example.elog.entity.MPost;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Gorge
 * @since 2023-04-30
 */
public interface MPostService extends IService<MPost> {

    IPage<MPostVo> paging(Page page, Long o, Long o1, Integer level, Boolean recommand, String created);
    MPostVo selectOnePost(QueryWrapper<MPost> queryWrapper);
    void initWeekRank();
}

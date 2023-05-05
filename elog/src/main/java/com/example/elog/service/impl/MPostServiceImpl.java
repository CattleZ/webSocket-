package com.example.elog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.MPostVo;
import com.example.elog.entity.MPost;
import com.example.elog.mapper.MPostMapper;
import com.example.elog.service.MPostService;
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
public class MPostServiceImpl extends ServiceImpl<MPostMapper, MPost> implements MPostService {

    @Resource
    MPostMapper mPostMapper;

    @Override
    public IPage<MPostVo> paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommand, String created) {
        if(level == null){
            level = -1;
        }
        QueryWrapper wrapper = new QueryWrapper<MPost>()
                .eq(categoryId!=null,"category_id",categoryId)
                .eq(userId != null,"user_id",userId)
                .eq(level.equals(0),"level",0)
                .gt(level>0,"level",0)
                .orderByDesc(created!=null,"created")
                ;

        return mPostMapper.selectPosts(page,wrapper);
    }

    @Override
    public MPostVo selectOnePost(QueryWrapper<MPost> queryWrapper) {
        return mPostMapper.selectOnePost(queryWrapper);
    }
}

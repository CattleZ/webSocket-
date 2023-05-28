package com.example.elog.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
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
import java.util.Date;
import java.util.List;

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

    @Override
    public void initWeekRank() {
        // 获取7天发表的文章
        List<MPost> posts = this.list(new QueryWrapper<MPost>()
        .eq("created", DateUtil.offsetDay(new Date(),-7))
                .select("id,title,user_id,comment_cont,view_count,created")
        ); // 获取7天前
        // 初始化文章的总阅读量，缓存文章的基本信息（id，标题，评论数量，作者）
        for(MPost post : posts){
            // 先指定一个key 使用zadd命令
            String key = "day:rank:"+DateUtil.format(post.getCreated(), DatePattern.PURE_DATE_FORMAT);
        }
        // 做并集

        //

    }
}

package com.example.elog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elog.Vo.CommentVo;
import com.example.elog.Vo.MPostVo;
import com.example.elog.entity.MPost;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/4/30 15:16
 **/
@Controller
public class PostController extends BaseController{

    /**
     * 分类
     * @param id 冒号后面可以通过正则表达式设置类型为数字类型
     * @return
     */
    @GetMapping("/category/{id:\\d*}")
    public String category(@PathVariable(name="id") Long id){
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        req.setAttribute("categoryId",id);
        req.setAttribute("pn", pn);
        return "post/category";
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping("/detail/{id:\\d*}")
    public String detail(@PathVariable(name="id") Long id){
        MPostVo postVo = mPostService.selectOnePost(new QueryWrapper<MPost>().eq("p.id",id));
        // 获取评论的列表
        Page page = getPage();
        // 1. 分页 2. 文章id 3. 用户id 4. 排序关键字 created
        IPage<CommentVo> results = mCommentService.paging(page,null,null,"created");
        Assert.notNull(postVo,"文章已经被删除");
        req.setAttribute("categoryId",postVo.getCategoryId());
        req.setAttribute("post",postVo);
        req.setAttribute("pageData",results);
        return "post/detail";
    }
}

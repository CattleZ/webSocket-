package com.example.elog.Vo;

import com.example.elog.entity.MPost;
import lombok.Data;

/**
 * @Author gorge
 * @Version 1.0
 * @Date 2023/5/1 07:39
 **/
@Data
public class MPostVo extends MPost {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

    private String categoryName;
}

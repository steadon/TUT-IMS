package com.tut.tutims.mapper;

import com.tut.tutims.entry.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Integer addArticle(Integer departmentId, String title, String author, Integer weekNum, String time);

    Article selectNewOne();

    Integer updateForeignId(Integer id1, Integer id2);

    List<Article> selectAll();
}

package com.tut.tutims.mapper;

import com.tut.tutims.pojo.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Integer addArticle(Integer departmentId, String title, String author,  String time);

    Article selectNewOne();

    Integer updateForeignId(Integer id1, Integer id2, Integer articleId);

    List<Article> selectAll();

    Integer updateAgreeInfo(String info, Double score, Integer articleId);

    Integer updateLoseInfo(String info, Double score, Integer articleId);

    Integer updateAddInfo(String info, Integer articleId);
}

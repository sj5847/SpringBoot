package com.demo.demo.repository;


import com.demo.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;


public interface ArticleRepository extends CrudRepository<Article, Long> {

}

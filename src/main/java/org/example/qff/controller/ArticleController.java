package org.example.qff.controller;

import io.swagger.annotations.Api;
import org.example.qff.common.result.QffResponse;
import org.example.qff.entity.Article;
import org.example.qff.param.MenuParam;
import org.example.qff.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：liufan
 * @Package：org.example.qff.controller
 * @Project：qff-admin
 * @name：ArticleController
 * @Date：2025/4/8 10:23
 */
@Api(tags = "文章")
@RequestMapping("/article")
@RestController
public class ArticleController {

    @Resource
    ArticleService articleService;

    @PostMapping("/insertArticle")
    public QffResponse insertArticle(@RequestBody Article articleParam ) {
        return articleService.insertArticle(articleParam);
    }







}

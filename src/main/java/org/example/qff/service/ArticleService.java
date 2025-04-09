package org.example.qff.service;

import org.example.qff.common.result.QffResponse;
import org.example.qff.entity.Article;

/**
 * @Author：liufan
 * @Package：org.example.qff.service
 * @Project：qff-admin
 * @name：ArticleService
 * @Date：2025/4/8 10:44
 */
public interface ArticleService {
    QffResponse insertArticle(Article articleParam);
}

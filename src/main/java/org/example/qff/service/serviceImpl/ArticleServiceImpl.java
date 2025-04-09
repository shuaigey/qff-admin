package org.example.qff.service.serviceImpl;

import org.example.qff.common.result.QffResponse;
import org.example.qff.common.result.ResultUtils;
import org.example.qff.common.util.ConstantUtil;
import org.example.qff.dao.ArticleMapper;
import org.example.qff.entity.Article;
import org.example.qff.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author：liufan
 * @Package：org.example.qff.service.serviceImpl
 * @Project：qff-admin
 * @name：ArticleServiceImpl
 * @Date：2025/4/8 10:44
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper mapper;
    @Override
    public QffResponse insertArticle(Article articleParam) {
        articleParam.setCreateTime(String.valueOf(new Date()));
        int insert = mapper.insert(articleParam);
        return ResultUtils.success(insert);
    }
}

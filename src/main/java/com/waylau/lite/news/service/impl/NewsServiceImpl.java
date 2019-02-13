/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.waylau.lite.news.domain.News;
import com.waylau.lite.news.mapper.NewsMapper;
import com.waylau.lite.news.service.NewsService;

/**
 * News Service.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;

	@Override
	@Cacheable(cacheNames="news", key="#newsId")
	public News getNews(Long newsId) {
		return newsMapper.getNews(newsId);
	}
	
	@Override
	public List<News> getNewsList() {
		return newsMapper.getNewsList();
	}

	@Override
	@CachePut(cacheNames="news", key="#news.newsId")
	public void updateNews(News news) {
		newsMapper.updateNews(news);
	}

	@Override
	public void createNews(News news) {
		newsMapper.createNews(news);
	}

	@Override
	@CacheEvict(cacheNames="news", key="#news.newsId")
	public void deleteNews(Long newsId) {
		newsMapper.deleteNews(newsId);
	}

}

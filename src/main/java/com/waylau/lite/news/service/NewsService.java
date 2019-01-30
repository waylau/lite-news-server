package com.waylau.lite.news.service;

import com.waylau.lite.news.domain.News;

/**
 * News Service.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface NewsService {

	void createNews(News news);

	void deleteNews(Long newsId);
	
	void updateNews(News news);

	News getNews(Long newsId);
}

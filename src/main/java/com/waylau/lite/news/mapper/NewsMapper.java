/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.mapper;

import java.util.List;

import com.waylau.lite.news.domain.News;

/**
 * News Mapper.
 * 
 * @since 1.0.0 2019年1月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface NewsMapper {

	void createNews(News news);

	void updateNews(News news);

	void deleteNews(Long newsId);
		
	News getNews(Long newsId);
	
	List<News> getNewsList();

}

/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import com.waylau.lite.news.AppConfig;
import com.waylau.lite.news.domain.News;

/**
 * NewsMapper Tests.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@SpringJUnitWebConfig(classes = AppConfig.class)
@Transactional
class NewsMapperTests {

	static final Logger logger = LoggerFactory.getLogger(NewsMapperTests.class);

	@Autowired
	private NewsMapper newsMapper;

	@Test
	void testCreatetNews() {
		News news = new News();
		news.setTitle("达沃斯风向标，新一轮全球化下的“中国面貌”");
		news.setAuthor("waylau");
		news.setCreation(new Date());
		news.setContent("世界经济的复苏和增长需要第四次工业革命的驱动，这是2019年世界经济论坛年会多数与会嘉宾共认的趋势。");
		newsMapper.createNews(news);
		logger.info(news.toString());
	}

	@Test
	void testDeleteNews() {
		newsMapper.deleteNews(2L);

		News newsNew = newsMapper.getNews(1L);
		assertNull(newsNew);
	}

	@Test
	void testUpdateNews() {
		News news = newsMapper.getNews(1L);
		news.setAuthor("老卫");
		news.setContent("世界经济的复苏和增长需要第四次工业革命的驱动。");
		newsMapper.updateNews(news);

		News newsNew = newsMapper.getNews(1L);
		assertEquals(news.getAuthor(), newsNew.getAuthor());
	}

	@Test
	void testGetNews() {
		News news = newsMapper.getNews(1L);
		assertEquals("老卫", news.getTitle());
	}

}

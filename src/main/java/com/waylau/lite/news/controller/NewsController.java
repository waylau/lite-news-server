package com.waylau.lite.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.lite.news.domain.News;
import com.waylau.lite.news.service.NewsService;

/**
 * News 控制器.
 * 
 * @since 1.0.0 2019年1月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@GetMapping("/{newsId}")
	public News getNews(@PathVariable("newsId") Long newsId) {
		return newsService.getNews(newsId);
	}

	@PutMapping
	public void updateNews(News user) {
		newsService.updateNews(user);
	}

	@PostMapping
	public void createNews(News user) {
		newsService.createNews(user);
	}

	@DeleteMapping("/{newsId}")
	public void deleteNews(@PathVariable("newsId") Long newsId) {
		newsService.deleteNews(newsId);
	}

}

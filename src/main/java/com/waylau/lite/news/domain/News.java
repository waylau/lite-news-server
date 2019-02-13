/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * News.
 * 
 * @since 1.0.0 2019年1月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long newsId;
	private String title;
	private String author;
	private Date creation;
	private String content;

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

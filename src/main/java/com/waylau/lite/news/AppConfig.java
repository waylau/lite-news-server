/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.waylau.lite.LiteConfig;
import com.waylau.lite.news.security.WebSecurityConfig;

/**
 * Application Configuration.
 * 
 * @since 1.0.0 2018年8月19日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@ComponentScan(basePackages = { "com.waylau.lite.mall" })  
@Import({WebSecurityConfig.class})
public class AppConfig extends LiteConfig {

}

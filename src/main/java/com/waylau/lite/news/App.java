/**
 * Welcome to https://waylau.com
 */
package com.waylau.lite.news;

import com.waylau.lite.jetty.LiteJettyServer;

/**
 * Main Application.
 * 
 * @since 1.0.0 2018年8月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class App {
	public static void main(String[] args) {
		new LiteJettyServer(AppConfig.class).run(args);
	}
}

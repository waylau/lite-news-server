## 13.1 lite-news概述

lite-news是一款新闻资讯类手机应用，所实现的功能与市面上的新闻头条等类似，主要提供用户阅读实时的新闻信息。

lite-news采用当前互联网应用所流行的前后台分离的技术。前台（lite-news-ui）采用以Angular为主要技术的前端框架；后台（lite-news-server）则完全基于Lite框架。前后台通过REST API进行通讯。整体架构如图13-1所示。

![图13-1 lite-news整体架构](../../images/ch13/13-1-all.jpg)

从图中也可看出，lite-news主要包含的功能有用户管理、新闻管理、分类管理、新闻展示等。

其中新闻数据存储在关系型数据库中，新闻图片存储于图片服务器中。同时，还设置了缓存服务器，用于存储经常被访问的数据。


### 13.1.1 初始化数据库

创建名为“lite_news”的数据库：


```
mysql> CREATE DATABASE lite_news;
Query OK, 1 row affected (0.13 sec)
```

并使用该数据库：


mysql> USE lite_news;
Database changed


### 13.1.2 创建用户表

创建名为“t_user”的用户表。该表用于存储用户信息：


```
mysql> CREATE TABLE t_user (user_id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20) COMMENT '用户名称', password VARCHAR(80) COMMENT '密码', email VARCHAR(20)) COMMENT='用户';
Query OK, 0 rows affected (0.22 sec)
```

其中，PRIMARY KEY用于标识user_id为表的主键；AUTO_INCREMENT用于设置主键是自增长。

*注意*：为了简化业务模型，这里的用户只设置了用户名称（username）、密码（password）、email等字段。在实际项目中，可以按需进行字段的扩展。


### 13.1.3 创建新闻表

创建名为“t_news”的新闻表。该表用于存储新闻信息：


```
mysql> CREATE TABLE t_news (news_id BIGINT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(100)  COMMENT '标题', author VARCHAR(20) COMMENT '作者', creation DATETIME COMMENT '创建时间', content TEXT COMMENT '正文') COMMENT='新闻';
Query OK, 0 rows affected (0.38 sec)
```



### 13.1.4 创建后台应用lite-news-server

lite-news-server是作为我们的后台应用（服务器端），是一个典型的Maven项目。lite-news-server使用了Lite框架，因此，需要在pom.xml文件文件中添加Lite框架的依赖坐标：

```xml
<dependency>
    <groupId>com.waylau</groupId>
    <artifactId>lite</artifactId>
    <version>${lite.version}</version>
</dependency>
```

### 13.1.5 创建Spring配置文件

创建spring.xml文件，主要配置MyBatis的配置信息：


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop  
        http://www.springframework.org/schema/aop/spring-aop.xsd">

	<!-- 扫描 MyBatis Mapper 接口所在的包 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage"
			value="com.waylau.lite.news.mapper" />
	</bean>

	<!-- MyBatis 工厂 -->
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
	</bean>

</beans>
```

在上述配置中，定义了Mapper接口所在的包以及MyBati工厂（sqlSessionFactory）。其中，MyBati工厂所引用的数据源，是Lite框架自带的数据源。

除了XML方式来配置Spring外，还可以通过JavaConfig的方式来配置。以下是配置示例：

```java
@ComponentScan(basePackages = { "com.waylau.lite.news" })  
@Import({WebSecurityConfig.class})
public class AppConfig extends LiteConfig {

}
```


### 13.1.6 自定义Lite配置文件

可以通过创建lite.properties文件，来覆盖Lite的默认配置信息。以下是lite.properties定义的内容：

```
lite.jdbc.driverClassName=com.mysql.cj.jdbc.Driver
lite.jdbc.url=jdbc:mysql://localhost:3306/lite_news?useSSL=false&serverTimezone=UTC
lite.jdbc.username=root
lite.jdbc.password=123456
```


上述配置涵盖了JDBC相关的配置信息。


### 13.1.7 自定义日志格式

如果想要自定义日志的格式信息，可以新增logback.xml。配置示例如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <layout class="ch.qos.logback.classic.PatternLayout">
      <Pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</Pattern>
    </layout>
  </appender>

  <root level="debug">
    <appender-ref ref="STDOUT" />
  </root>
</configuration>
```
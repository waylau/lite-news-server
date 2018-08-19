# Hello World

How to use Lite.

## Controller

```java
@RestController
@RequestMapping("/mall")
public class HelloController {

	@GetMapping("/hi")
	public String sayHi() {
	    return "Hello World! Welcome to visit waylau.com!";
	}

}
```

## Configuration

```java
import org.springframework.context.annotation.ComponentScan;

import com.waylau.lite.LiteConfig;


@ComponentScan(basePackages = { "com.waylau.lite.mall" })  
public class AppConfig extends LiteConfig {

}
```

## Main App

```java
import com.waylau.lite.jetty.LiteJettyServer;

public class App {
	public static void main(String[] args) {
		new LiteJettyServer(AppConfig.class).run(args);
	}
}
```


## Run App

```
java -jar target/lite-book-mall-1.0.0.jar
```

## Visit App

Visit <http://localhost:8080/mall/hi> in brower, and you will get "Hello World! Welcome to visit waylau.com!".
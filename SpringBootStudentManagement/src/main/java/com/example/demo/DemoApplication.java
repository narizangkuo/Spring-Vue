package com.example.demo;

/**
 *    主程序入口
 * 
 * @author zack
 * @date 2023-09-28
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("test.dao")
public class DemoApplication {
	/**
	 * 程序调用入口
	 * 
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

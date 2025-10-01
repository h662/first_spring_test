package com.example.first_spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FirstSpringTestApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {

		assertThat(applicationContext).isNotNull();

		assertThat(applicationContext.getId()).isNotNull();

		System.out.println("✅ 애플리케이션 컨텍스트 로딩 성공");
		System.out.println("📋 컨텍스트 ID: " + applicationContext.getId());
	}

	@Test
	void checkBeanCount() {

		String[] beanNames = applicationContext.getBeanDefinitionNames();

		assertThat(beanNames.length).isGreaterThan(100);

		System.out.println("📊 등록된 Bean 개수: " + beanNames.length);

		assertThat(applicationContext.containsBean("userService")).isTrue();
		assertThat(applicationContext.containsBean("userRepository")).isTrue();
		assertThat(applicationContext.containsBean("userController")).isTrue();

		System.out.println("✅ 핵심 Bean들이 정상 등록됨");
	}
}

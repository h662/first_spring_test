package com.example.first_spring_test;

import com.example.first_spring_test.controller.UserController;
import com.example.first_spring_test.repository.UserRepository;
import com.example.first_spring_test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DependencyInjectionTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void allBeansAreInjected() {
        assertThat(userController).isNotNull();
        assertThat(userService).isNotNull();
        assertThat(userRepository).isNotNull();

        System.out.println("✅ Controller 주입 성공: " + userController.getClass().getSimpleName());
        System.out.println("✅ Service 주입 성공: " + userService.getClass().getSimpleName());
        System.out.println("✅ Repository 주입 성공: " + userRepository.getClass().getSimpleName());
    }

    @Test
    void serviceLayerDependencyInjection() {

        long initialCount = userService.getUserCount();

        assertThat(initialCount).isGreaterThanOrEqualTo(0);

        System.out.println("✅ Service 계층 의존성 주입 및 동작 확인");
        System.out.println("📊 초기 사용자 수: " + initialCount);
    }
}

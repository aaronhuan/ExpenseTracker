package com.aaronhuang.expensetracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestSecurityConfig.class)
class ExpensetrackerApplicationTests {

    @Test
    void contextLoads() {
    }
}
package com.example.spring6.junit.junit5;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestJUnit5 {

    @Resource
    User user;

    @Test
    public void testUser() {
        user.run();
        System.out.println(user);

    }

}

package project.spring.apirestpet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiRestPetApplicationTests {

    @Test
    void contextLoads() {
        int quantity = 10;
        double price = 72.99;
        double result = quantity * price;
        Assertions.assertEquals(result, quantity * price);
    }

}

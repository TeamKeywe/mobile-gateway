package com.doubleo.mobilegateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"test", "redis", "security", "eureka", "swagger", "routes", "actuator"})
class MobileGatewayApplicationTests {

    @Test
    void contextLoads() {}
}

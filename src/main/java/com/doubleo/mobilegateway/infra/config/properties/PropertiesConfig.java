package com.doubleo.mobilegateway.infra.config.properties;

import com.doubleo.mobilegateway.infra.config.jwt.JwtProperties;
import com.doubleo.mobilegateway.infra.config.redis.RedisProperties;
import com.doubleo.mobilegateway.infra.config.route.GatewayPathProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
    JwtProperties.class,
    RedisProperties.class,
    GatewayPathProperties.class
})
@Configuration
public class PropertiesConfig {}

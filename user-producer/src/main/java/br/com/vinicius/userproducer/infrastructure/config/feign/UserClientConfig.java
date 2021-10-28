package br.com.vinicius.userproducer.infrastructure.config.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "br.com.vinicius.userproducer.infrastructure.feign.client")
public class UserClientConfig {
}

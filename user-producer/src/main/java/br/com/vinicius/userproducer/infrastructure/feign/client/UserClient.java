package br.com.vinicius.userproducer.infrastructure.feign.client;

import br.com.vinicius.commons.domain.user.source.UserSource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(value = "${feign.client.config.user-client.value}", url = "${feign.client.config.user-client.url}")
public interface UserClient {

    @GetMapping
    Set<UserSource> getUsers();
}

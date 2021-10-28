package br.com.vinicius.userproducer.domain.user.message.service.validate;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.function.Consumer;

@Service
public class ValidateUserSimpleData implements Consumer<UserMessage> {
    @Override
    public void accept(UserMessage userMessage) {
        if (Objects.isNull(userMessage)
                || Objects.isNull(Objects.requireNonNull(userMessage).getId())
                || !StringUtils.hasText(userMessage.getUsername())
                || !StringUtils.hasText(userMessage.getEmail())
                || !StringUtils.hasText(userMessage.getName())
                || !StringUtils.hasText(userMessage.getPhone())
                || !StringUtils.hasText(userMessage.getWebsite()))
            throw new IllegalArgumentException("User is not valid.");
    }
}

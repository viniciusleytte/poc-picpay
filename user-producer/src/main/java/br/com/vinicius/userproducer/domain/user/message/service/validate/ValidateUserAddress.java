package br.com.vinicius.userproducer.domain.user.message.service.validate;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.function.Consumer;

@Service
public class ValidateUserAddress implements Consumer<UserMessage> {
    @Override
    public void accept(UserMessage userMessage) {
        if (Objects.isNull(userMessage.getAddress())
                || Objects.isNull(userMessage.getAddress().getId())
                || !StringUtils.hasText(userMessage.getAddress().getZipcode())
                || !StringUtils.hasText(userMessage.getAddress().getStreet())
                || !StringUtils.hasText(userMessage.getAddress().getSuite())
                || !StringUtils.hasText(userMessage.getAddress().getCity()))
            throw new IllegalArgumentException("Address is not valid.");
    }
}

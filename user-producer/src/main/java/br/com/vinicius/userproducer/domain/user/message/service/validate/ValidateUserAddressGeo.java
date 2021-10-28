package br.com.vinicius.userproducer.domain.user.message.service.validate;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.function.Consumer;

@Service
public class ValidateUserAddressGeo implements Consumer<UserMessage> {
    @Override
    public void accept(UserMessage userMessage) {
        if (Objects.isNull(userMessage.getAddress().getGeo())
                || Objects.isNull(userMessage.getAddress().getGeo().getId())
                || !StringUtils.hasText(userMessage.getAddress().getGeo().getLat())
                || !StringUtils.hasText(userMessage.getAddress().getGeo().getLng()))
            throw new IllegalArgumentException("Geo is not valid.");
    }
}

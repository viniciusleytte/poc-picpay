package br.com.vinicius.userproducer.domain.user.message.service.validate;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.function.Consumer;

@Service
public class ValidateUserCompany implements Consumer<UserMessage> {
    @Override
    public void accept(UserMessage userMessage) {
        if (Objects.isNull(userMessage.getCompany())
                || Objects.isNull(userMessage.getCompany().getId())
                || !StringUtils.hasText(userMessage.getCompany().getName())
                || !StringUtils.hasText(userMessage.getCompany().getBs())
                || !StringUtils.hasText(userMessage.getCompany().getCatchPhrase()))
            throw new IllegalArgumentException("Company is not valid.");
    }
}

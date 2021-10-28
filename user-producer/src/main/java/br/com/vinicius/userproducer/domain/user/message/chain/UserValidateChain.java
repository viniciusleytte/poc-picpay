package br.com.vinicius.userproducer.domain.user.message.chain;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class UserValidateChain implements Consumer<UserMessage> {
    private final Consumer<UserMessage> validateUserSimpleData;
    private final Consumer<UserMessage> validateUserAddress;
    private final Consumer<UserMessage> validateUserAddressGeo;
    private final Consumer<UserMessage> validateUserCompany;

    @Override
    public void accept(UserMessage userMessage) {
        validateUserSimpleData
                .andThen(validateUserAddress)
                .andThen(validateUserAddressGeo)
                .andThen(validateUserCompany)
                .accept(userMessage);
    }
}

package br.com.vinicius.userproducer.domain.user.message.chain;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CallCoreChains implements ProcessChain<UserMessage> {
    private final Consumer<UserMessage> userValidateChain;
    private final Consumer<UserMessage> userProcessChain;

    @Override
    public void execute(UserMessage userMessage) {
        userValidateChain.andThen(userProcessChain).accept(userMessage);
    }
}

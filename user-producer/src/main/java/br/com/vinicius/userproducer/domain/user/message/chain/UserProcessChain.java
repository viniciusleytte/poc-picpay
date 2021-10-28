package br.com.vinicius.userproducer.domain.user.message.chain;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import br.com.vinicius.userproducer.infrastructure.kafka.producer.ProducesMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class UserProcessChain implements Consumer<UserMessage> {
    private final ProducesMessage<UserMessage> producesKafkaUserMessage;

    @Override
    public void accept(UserMessage userMessage) {
        producesKafkaUserMessage.execute(userMessage);
    }
}

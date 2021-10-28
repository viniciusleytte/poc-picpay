package br.com.vinicius.userproducer.infrastructure.kafka.producer.impl;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import br.com.vinicius.userproducer.infrastructure.kafka.producer.ProducesMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProducesKafkaUserMessage implements ProducesMessage<UserMessage> {
    private final KafkaTemplate<String, UserMessage> kafkaTemplate;

    @Value("${spring.kafka.producer.properties.topic}")
    private String topic;

    @Override
    public void execute(UserMessage userMessage) {
        kafkaTemplate.executeInTransaction(kafkaOperations -> kafkaOperations.send(this.topic, userMessage));
    }
}

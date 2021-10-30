package br.com.vinicius.userconsumer.application.consumer;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserKafkaListener {
    @RetryableTopic(
            backoff = @Backoff(delay = 1000),
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)
    @KafkaListener(topics = "${spring.kafka.consumer.properties.topic}")
    public void handle(UserMessage userMessage) {
        log.info(userMessage.toString());
    }

    @DltHandler
    public void handleDLT(UserMessage userMessageWithProblem, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info(userMessageWithProblem.toString() + " from " + topic);
    }
}
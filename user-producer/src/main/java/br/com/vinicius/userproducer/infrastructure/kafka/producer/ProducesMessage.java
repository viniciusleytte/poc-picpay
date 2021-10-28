package br.com.vinicius.userproducer.infrastructure.kafka.producer;

public interface ProducesMessage<T> {
    void execute(T t);
}

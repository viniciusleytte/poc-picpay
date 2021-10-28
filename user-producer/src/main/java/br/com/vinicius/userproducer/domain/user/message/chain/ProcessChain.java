package br.com.vinicius.userproducer.domain.user.message.chain;

public interface ProcessChain<T> {
    void execute(T t);
}

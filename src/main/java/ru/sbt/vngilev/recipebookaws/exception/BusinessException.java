package ru.sbt.vngilev.recipebookaws.exception;


public class BusinessException extends RuntimeException {
    public BusinessException(String msg, Throwable e) {
        super(msg, e);
    }

    public BusinessException(String msg) {
        super(msg);
    }
}

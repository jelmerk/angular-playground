package org.github.jkuperus.addressbook.backend.service;

/**
 * @author Jelmer Kuperus
 */
public class ServiceException extends Exception {

    public ServiceException() {
    }

    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }
}

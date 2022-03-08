package ru.se4oev.spring.rest.exception_handling;

/**
 * Created by se4oev on 08.03.2022
 * Description:
 */
public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String message) {
        super(message);
    }

}

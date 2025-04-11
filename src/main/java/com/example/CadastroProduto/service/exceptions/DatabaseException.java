package com.example.CadastroProduto.service.exceptions;

import javax.xml.crypto.Data;

public class DatabaseException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }
}

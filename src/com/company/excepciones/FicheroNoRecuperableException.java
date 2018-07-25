package com.company.excepciones;

import java.io.FileNotFoundException;

public class FicheroNoRecuperableException extends FileNotFoundException {

    public FicheroNoRecuperableException(){
        super("No se encuentra el fichero");
    }

    public FicheroNoRecuperableException(String msg) {
        super(msg);
    }
}

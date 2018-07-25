package com.company.excepciones;

public class DatoNoParseableException extends Exception {


    public DatoNoParseableException(){
        super("Objeto no parseable a numero");
    }

    public DatoNoParseableException(String msg){
        super(msg);
    }
}

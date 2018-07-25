package com.company.logica;

import java.io.*;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Almacen {

    private File fichero;
    private FileWriter writer;
    private BufferedReader reader;

    public Almacen(){
        prepararRecursos();
    }

    public void almacenarNumero(int numero){
        //TODO: generar la logica para almacenar el numero en el fichero.
        try {
            writer.append(String.valueOf(numero));
            writer.append(";");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> recuperarNumeros() {
        //TODO: generar la logica que lea el fichero responda con una lista de numeros.
        List<Integer> resultado = null;
        try {

//            resultado = Arrays.asList(reader.readLine().split(";"))
//                    .stream()
//                    .map(cadena -> Integer.parseInt(cadena))
//                    .collect(Collectors.toList());

            resultado = reader.lines()
                    .flatMap(cadena ->
                            Arrays.asList(cadena.split(";"))
                                    .stream()
                                    .map(dato -> Integer.parseInt(dato)))
                    .collect(Collectors.toList());

//            String[] split = reader.readLine().split(";");
//            List<String> strings = Arrays.asList(split);
//            Stream<String> stream = strings.stream();
//            Stream<Integer> integerStream = stream.map(cadena -> Integer.parseInt(cadena));
//            resultado = integerStream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    private void prepararRecursos(){
        this.fichero = new File("src/fichero.txt");
        try {
            if (!this.fichero.exists()) {
                this.fichero.createNewFile();
            }
            this.writer = new FileWriter(this.fichero, true);
            this.reader = new BufferedReader(new FileReader(this.fichero));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cerrarRecursos(){
        try {
            this.reader.close();
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

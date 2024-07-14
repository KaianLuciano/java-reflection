package com.javareflection.test.reflection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javareflection.test.pessoa.Pessoa;

public class ObjectToJsonTester {

    public static void main(String... x) throws JsonProcessingException {
        Pessoa pessoa = new Pessoa(1, "João", "12345");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
        System.out.println("Teste pessoal: " + objectMapper.writeValueAsString(pessoa));
    }
}

package com.javareflection.test.pessoa;

import com.javareflection.test.reflection.Transformator;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationTargetException;

@RequiredArgsConstructor
public class PessoaService {
    private final Transformator transformator;

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().list();
        return transformator.transform(pessoa);
    }
}

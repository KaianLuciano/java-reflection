package com.javareflection.test.pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private String nome;
    private String cpf;
}

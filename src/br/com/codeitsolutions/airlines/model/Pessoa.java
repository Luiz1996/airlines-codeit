package br.com.codeitsolutions.airlines.model;

import lombok.*;

/**
 *
 * @author Luiz Flávio
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
}

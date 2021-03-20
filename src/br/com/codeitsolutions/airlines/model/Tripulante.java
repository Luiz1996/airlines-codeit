package br.com.codeitsolutions.airlines.model;

import lombok.*;

/**
 *
 * @author Luiz Flávio
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Tripulante extends Pessoa {
    private TipoTripulante tpTripulante;
    
    public Tripulante(String nome, String cpf, int idade, TipoTripulante tipoTripulante) {
        super(nome, cpf, idade);
        this.tpTripulante = tipoTripulante;
    }
}

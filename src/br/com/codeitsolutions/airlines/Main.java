package br.com.codeitsolutions.airlines;

import br.com.codeitsolutions.airlines.model.TipoTripulante;
import br.com.codeitsolutions.airlines.model.Tripulante;
import br.com.codeitsolutions.airlines.controller.ViagemSmartFortwoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luiz Flávio
 */
public class Main {
    
    public static void main(String[] args) {
        int iniciaAirlines = 1;
        Scanner in = new Scanner(System.in);
        
        while(iniciaAirlines >= 1){
            iniciaAirlines = 0;
            List<Tripulante> tripulacaoTerminal = inicializaTripulacaoTerminal();
            List<Tripulante> tripulacaoAviao = new ArrayList<>();
            
            while(tripulacaoTerminal.size() > 0 && tripulacaoAviao.size() < 8){
                ViagemSmartFortwoController.movimentaPassageiros(tripulacaoTerminal, tripulacaoAviao);
            }
            
            System.out.print("Deseja continuar? Sim[>=1]/Não[<1]\nR: ");
            iniciaAirlines = in.nextInt();
        }
        System.gc();
        System.out.println("\nFim de jogo!");
    }
    
    private static List<Tripulante> inicializaTripulacaoTerminal(){
        List<Tripulante> tripulacaoTerminal = new ArrayList<>();
        
        tripulacaoTerminal.add(new Tripulante("Sgtº Fahur", "123.456.789-57", 57, TipoTripulante.POLICIAL));
        tripulacaoTerminal.add(new Tripulante("Lula", "123.456.789-75", 75, TipoTripulante.PRESIDIARIO));
        tripulacaoTerminal.add(new Tripulante("João", "123.456.789-55", 55, TipoTripulante.PILOTO));
        tripulacaoTerminal.add(new Tripulante("Marcos", "123.456.789-54", 54, TipoTripulante.OFICIAL));
        tripulacaoTerminal.add(new Tripulante("Mateus", "123.456.789-53", 53, TipoTripulante.OFICIAL));
        tripulacaoTerminal.add(new Tripulante("Gabriel", "123.456.789-52", 52, TipoTripulante.CHEFE));
        tripulacaoTerminal.add(new Tripulante("Maria", "123.456.789-51", 51, TipoTripulante.COMISSARIA));
        tripulacaoTerminal.add(new Tripulante("Isabel", "123.456.789-50", 50, TipoTripulante.COMISSARIA));
        
        return tripulacaoTerminal;
    }
}

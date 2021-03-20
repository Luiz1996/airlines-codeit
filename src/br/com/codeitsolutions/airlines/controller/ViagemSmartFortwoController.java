package br.com.codeitsolutions.airlines.controller;

import br.com.codeitsolutions.airlines.model.TipoTripulante;
import br.com.codeitsolutions.airlines.model.Tripulante;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Luiz Flávio
 */
public class ViagemSmartFortwoController {
    
    public static void movimentaPassageiros(List<Tripulante> tripulacaoTerminal, List<Tripulante> tripulacaoAviao) {
        encontraPossiveisMotoristas(tripulacaoAviao, tripulacaoTerminal, "avião");
        encontraPossiveisPassageiros(tripulacaoAviao, tripulacaoTerminal);
        
        if(!validandoOficialAcompanhadoDoChefe(tripulacaoTerminal, tripulacaoAviao)       ||
           !validandoComissariasAcompanhadasDoPiloto(tripulacaoTerminal, tripulacaoAviao) ||
           !validaPresidiarioAcompanhado(tripulacaoTerminal, tripulacaoAviao)){ 
            return; 
        }
        
        //Validando se todos foram transportados
        if(tripulacaoAviao.size() == 8 && tripulacaoTerminal.isEmpty()){
            System.out.println("\n\nParabéns, você conseguiu movimentar todos os passageiros respeitando as regras impostas!\n");
            imprimindoEstadoAtualTerminalEAviao(tripulacaoTerminal, tripulacaoAviao);
            return;
        }
        
        encontraPossiveisMotoristas(tripulacaoTerminal, tripulacaoAviao, "terminal");
        imprimindoEstadoAtualTerminalEAviao(tripulacaoTerminal, tripulacaoAviao);
        
        if(!validandoOficialAcompanhadoDoChefe(tripulacaoTerminal, tripulacaoAviao) ||
           !validandoComissariasAcompanhadasDoPiloto(tripulacaoTerminal, tripulacaoAviao)){ 
            return; 
        }
        validaPresidiarioAcompanhado(tripulacaoTerminal, tripulacaoAviao);
    }

    private static void encontraPossiveisMotoristas(List<Tripulante> tripulacaoAdd, List<Tripulante> tripulacaoRemove, String localIda) {
        Scanner in = new Scanner(System.in);
        Tripulante tripAux =  new Tripulante();
        System.out.println("\nInforme o índice do motorista até o " + localIda + ":");
        
        List<Tripulante> motoristas = tripulacaoRemove.stream()
                                                      .filter(map -> TipoTripulante.PILOTO.equals(map.getTpTripulante())    ||
                                                                     TipoTripulante.CHEFE.equals(map.getTpTripulante())     ||
                                                                     TipoTripulante.POLICIAL.equals(map.getTpTripulante()))
                                                      .collect(Collectors.toList());
        
        for(int i = 0; i < motoristas.size(); i++){
            System.out.println("Índice [" + i + "] -> " + motoristas.get(i).getTpTripulante().toString().concat("(" + motoristas.get(i).getNome()) + ")");
        }
        
        System.out.print("R: ");
        
        try{
            tripAux = motoristas.get(in.nextInt());
        }catch(IndexOutOfBoundsException ex){
            System.out.println("\nVocê digitou um índice inválido. Jogo será encerrado!\n");
            System.exit(1);
        }
        
        atualizaTerminalEAviao(tripulacaoAdd, tripulacaoRemove, tripAux);
    }
    
    private static void encontraPossiveisPassageiros(List<Tripulante> tripulacaoAdd, List<Tripulante> tripulacaoRemove) {
        Scanner in = new Scanner(System.in);
        Tripulante tripAux =  new Tripulante();
        System.out.println("\nInforme o índice do passageiro até o avião:");
        
        for(int i = 0; i < tripulacaoRemove.size(); i++){
            System.out.println("Índice [" + i + "] -> " + tripulacaoRemove.get(i).getTpTripulante().toString().concat("(" + tripulacaoRemove.get(i).getNome()) + ")");
        }
        
        System.out.print("R: ");
        
        try{
            tripAux = tripulacaoRemove.get(in.nextInt());
        }catch(IndexOutOfBoundsException ex){
            System.out.println("\nVocê digitou um índice inválido. Jogo será encerrado!\n");
            System.exit(1);
        }
        
        atualizaTerminalEAviao(tripulacaoAdd, tripulacaoRemove, tripAux);
    }
    
    private static void atualizaTerminalEAviao(List<Tripulante> tripulacaoAdd, List<Tripulante> tripulacaoRemove, Tripulante tripulante){
        tripulacaoAdd.add(tripulante);
        tripulacaoRemove.remove(tripulante);
    }

    private static boolean validaPresidiarioAcompanhado(List<Tripulante> tripulacaoTerminal, List<Tripulante> tripulacaoAviao) {
        int qtdeRegsTerminal = tripulacaoTerminal.stream()
                                                 .filter(map -> TipoTripulante.POLICIAL.equals(map.getTpTripulante())    ||
                                                                TipoTripulante.PRESIDIARIO.equals(map.getTpTripulante()))
                                                 .collect(Collectors.toList()).size();
        
        int qtdeRegsAviao = tripulacaoAviao.stream()
                                           .filter(map -> TipoTripulante.POLICIAL.equals(map.getTpTripulante())    ||
                                                          TipoTripulante.PRESIDIARIO.equals(map.getTpTripulante()))
                                           .collect(Collectors.toList()).size();
        
        if(qtdeRegsTerminal != 2 && qtdeRegsAviao != 2){
            System.out.println("\n\nOh não!!! Você afastou o policial do presidiário... GAME OVER!\n");
            tripulacaoAviao.addAll(tripulacaoTerminal);
            tripulacaoTerminal = new ArrayList<>();
            return false;
        }
        return true;
    }

    private static void imprimindoEstadoAtualTerminalEAviao(List<Tripulante> tripulacaoTerminal, List<Tripulante> tripulacaoAviao) {
        System.out.println("\n********************** Passageiros no Terminal **********************");
        tripulacaoTerminal.forEach((tripTerminal) -> {
            System.out.println(tripTerminal.getTpTripulante().toString().concat("(" + tripTerminal.getNome() + ")"));
        });
        
        System.out.println("*********************** Passageiros no Avião ************************");
        tripulacaoAviao.forEach((tripAviao) -> {
            System.out.println(tripAviao.getTpTripulante().toString().concat("(" + tripAviao.getNome() + ")"));
        });
        System.out.println("*********************************************************************");
    }

    private static boolean validaOficialEChefeSozinhos(List<Tripulante> tripulacao){
        int qtdeRegsOficialEChefe = tripulacao.stream()
                                              .filter(map -> TipoTripulante.OFICIAL.equals(map.getTpTripulante()) ||
                                                             TipoTripulante.CHEFE.equals(map.getTpTripulante()))
                                              .collect(Collectors.toList()).size();
        
        int qtdeRegsChefe = tripulacao.stream()
                                      .filter(map -> TipoTripulante.CHEFE.equals(map.getTpTripulante()))
                                      .collect(Collectors.toList()).size();

        return !(tripulacao.size() == qtdeRegsOficialEChefe && qtdeRegsChefe == 1 && qtdeRegsOficialEChefe >= 2);
    }
    
    private static boolean validandoOficialAcompanhadoDoChefe(List<Tripulante> tripulacaoTerminal, List<Tripulante> tripulacaoAviao) {
        boolean oficialEChefeTerminal = validaOficialEChefeSozinhos(tripulacaoTerminal);
        boolean oficialEChefeAviao = validaOficialEChefeSozinhos(tripulacaoAviao);
        
        if(!oficialEChefeTerminal || !oficialEChefeAviao){
            System.out.println("\n\nOh não!!! Você deixou Oficial(is) e Chefe de Serviços sozinhos... GAME OVER!\n");
            tripulacaoAviao.addAll(tripulacaoTerminal);
            tripulacaoTerminal = new ArrayList<>();
            return false;
        }
        
        return true;
    }

    private static boolean validaComissariaEPilotoSozinhos(List<Tripulante> tripulacao){
        int qtdeRegsComissariaEPiloto = tripulacao.stream()
                                                  .filter(map -> TipoTripulante.COMISSARIA.equals(map.getTpTripulante()) ||
                                                                 TipoTripulante.PILOTO.equals(map.getTpTripulante()))
                                                  .collect(Collectors.toList()).size();
        
        int qtdeRegsPiloto = tripulacao.stream()
                                       .filter(map -> TipoTripulante.PILOTO.equals(map.getTpTripulante()))
                                       .collect(Collectors.toList()).size();
        
        return !(tripulacao.size() == qtdeRegsComissariaEPiloto && qtdeRegsPiloto == 1 && qtdeRegsComissariaEPiloto >= 2);
    }
    
    private static boolean validandoComissariasAcompanhadasDoPiloto(List<Tripulante> tripulacaoTerminal, List<Tripulante> tripulacaoAviao) {
        boolean comissariaEPilotoTerminal = validaComissariaEPilotoSozinhos(tripulacaoTerminal);
        boolean comissariaEPilotoAviao = validaComissariaEPilotoSozinhos(tripulacaoAviao);
        
        if(!comissariaEPilotoTerminal || !comissariaEPilotoAviao){
            System.out.println("\n\nOh não!!! Você deixou Comissária(s) e Piloto de Serviços sozinhos... GAME OVER!\n");
            tripulacaoAviao.addAll(tripulacaoTerminal);
            tripulacaoTerminal = new ArrayList<>();
            return false;
        }
        return true;
    }
}

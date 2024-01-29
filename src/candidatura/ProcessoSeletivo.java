package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"Francisco", "André", "Paula", "Ana Maria", "Hilda"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }
    static  void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            // elas precisarão sofrer alterações
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");

        }while(continuarTentando && tentativasRealizadas < 3);
        if (atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativas");
        else
            System.out.println("Não conseguimos contato com " + candidato + ", número máximo tentativas " + tentativasRealizadas + " realizadas");
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void  imprimirSelecionados(){
        String [] candidatos = {"Francisco", "André", "Paula", "Ana Maria", "Hilda"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de número " + (indice+1) + " é o " + candidatos[indice]);
        }
        System.out.println("Forma abreviada de interação for each");

        for(String candidato: candidatos){
            System.out.println("O Candidato selecionado foi " + candidato);
        }
    }
    static void selecaoCandidatos() {
        String[] candidatos = {"Francisco", "André", "Paula", "Ana Maria", "Hilda", "Dalva", "João", "Maria Julia", "Umberto", "Cláudia"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretandido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretandido);
            if (salarioBase >= salarioPretandido){
                System.out.println("O candidato " + candidato + " foi selecionaldo para a vaga de emprego X");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }
    static  double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");            
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando o resultado dos demais candidato");
        }
    }
}

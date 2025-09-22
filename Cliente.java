import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        String resposta;
        
        // O IP do servidor será passado como argumento na linha de comando
        if (args.length == 0) {
            System.err.println("Uso: java Cliente 10.40.134.106 ");
            return;
        }
        String host = args[0];

        try {
            Registry registro = LocateRegistry.getRegistry(host, 1099);
            Controle controle = (Controle) registro.lookup("TV_Principal");

            do { 
            System.out.println("============================\n");
            System.out.println("1 - ligar/desligar");
            System.out.println("2 - aumentar volume");
            System.out.println("3 - diminuir volume");
            System.out.println("4 - mudo");
            System.out.println("5 - trocar de canal");
            System.out.println("6 - Status");
            System.out.println("0 - encerra\n");
            System.out.println("============================ \n");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println("");


            switch (opcao) {
                case 1:
                    resposta = controle.ligarDesligar();

                    System.out.println("TV -> " + resposta + "\n");
                break;

                case 2:
                    resposta = controle.aumentarVolume();
                    
                    System.out.println("TV -> " + resposta + "\n");
                break;

                case 3:
                    resposta = controle.diminuirVolume();

                    System.out.println("TV -> " + resposta + "\n");
                break;

                case 4:
                    resposta = controle.silenciar();

                    System.out.println("TV -> " + resposta + "\n");
                break;

                case 5:
                    System.out.println("Escolha o canal: ");
                    int canal = scanner.nextInt();
                    resposta = controle.trocarCanal(canal);

                    System.out.println("TV -> " + resposta + "\n");
                break;

                case 6:
                    resposta = controle.consultarStatus();

                    System.out.println("TV -> " + resposta + "\n");
                break;

                default:
                break;
                }
            } while (opcao != 0);
            


            /*System.out.println("Conectado à TV. Enviando comandos...");
            System.out.println("\n--- STATUS INICIAL: " + controle.consultarStatus());

            controle.ligarDesligar();
            System.out.println("--- STATUS após ligar: " + controle.consultarStatus());

            controle.aumentarVolume();
            controle.aumentarVolume();
            System.out.println("--- STATUS após aumentar volume: " + controle.consultarStatus());

            controle.trocarCanal(10);
            System.out.println("--- STATUS após trocar canal: " + controle.consultarStatus());

            controle.silenciar();
            System.out.println("--- STATUS após silenciar: " + controle.consultarStatus());

            controle.silenciar();
            System.out.println("--- STATUS após dessilenciar: " + controle.consultarStatus());

            controle.ligarDesligar();
            System.out.println("--- STATUS FINAL: " + controle.consultarStatus());*/

        } catch (Exception e) {
            System.err.println("Erro no Cliente: " + e.toString());
            e.printStackTrace();
        }

        scanner.close();
    }
}
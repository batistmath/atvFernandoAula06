import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        // O IP do servidor será passado como argumento na linha de comando
        if (args.length == 0) {
            System.err.println("Uso: java Cliente 10.40.134.106 ");
            return;
        }
        String host = args[0];

        try {
            Registry registro = LocateRegistry.getRegistry(host, 1099);
            Controle controle = (Controle) registro.lookup("TV_Principal");

            System.out.println("Conectado à TV. Enviando comandos...");
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
            System.out.println("--- STATUS FINAL: " + controle.consultarStatus());

        } catch (Exception e) {
            System.err.println("Erro no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
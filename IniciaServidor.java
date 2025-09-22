    import java.rmi.registry.LocateRegistry;
    import java.rmi.registry.Registry;

    public class IniciaServidor {
        public static void main(String[] args) {
            try {

                System.setProperty("java.rmi.server.hostname", "127.0.0.1"); 

                Controle tv = new Servidor();
                Registry registro = LocateRegistry.createRegistry(1099);
                registro.rebind("TV_Principal", tv);
                System.out.println("Servidor RMI pronto. A TV está esperando comandos...");
            } catch (Exception e) {
                System.err.println("Erro no Servidor: " + e.toString());
                e.printStackTrace();
            }
        }
    }
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements Controle {
    private boolean ligada = false;
    private int volume = 10;
    private int canal = 1;
    private boolean silenciada = false;
    private int volumeAntesSilenciar = 0;

    public Servidor() throws RemoteException {}

    @Override
    public void ligarDesligar() throws RemoteException {
        this.ligada = !this.ligada;
        if (this.ligada) {
            System.out.println("A TV foi ligada.");
        } else {
            System.out.println("A TV foi desligada.");
        }
    }

    @Override
    public void aumentarVolume() throws RemoteException {
        if (ligada && !silenciada) {
            if (volume < 100) {
                this.volume++;
            }
            System.out.println("Volume aumentado. Volume atual: " + this.volume);
        } else if (silenciada) {
            System.out.println("TV silenciada. Desative o modo 'mudo' primeiro.");
        } else {
            System.out.println("A TV está desligada.");
        }
    }

    @Override
    public void diminuirVolume() throws RemoteException {
        if (ligada && !silenciada) {
            if (volume > 0) {
                this.volume--;
            }
            System.out.println("Volume diminuído. Volume atual: " + this.volume);
        } else if (silenciada) {
            System.out.println("TV silenciada. Desative o modo 'mudo' primeiro.");
        } else {
            System.out.println("A TV está desligada.");
        }
    }

    @Override
    public void trocarCanal(int canal_) throws RemoteException {
        if (ligada) {
            this.canal = canal_;
            System.out.println("Canal trocado. Canal atual: " + this.canal);
        } else {
            System.out.println("A TV está desligada.");
        }
    }

    @Override
    public void silenciar() throws RemoteException {
        if (ligada) {
            if (!silenciada) {
                this.volumeAntesSilenciar = this.volume;
                this.volume = 0;
                this.silenciada = true;
                System.out.println("TV silenciada. Volume atual: " + this.volume);
            } else {
                this.volume = this.volumeAntesSilenciar;
                this.silenciada = false;
                System.out.println("TV dessilenciada. Volume atual: " + this.volume);
            }
        } else {
            System.out.println("A TV está desligada.");
        }
    }

    @Override
    public String consultarStatus() throws RemoteException {
        if (ligada) {
            String statusSilencio = silenciada ? " (silenciada)" : "";
            return "TV ligada. Canal: " + this.canal + ", Volume: " + this.volume + statusSilencio;
        } else {
            return "TV desligada.";
        }
    }
}
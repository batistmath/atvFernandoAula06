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
    public String ligarDesligar() throws RemoteException {
        this.ligada = !this.ligada;
        if (this.ligada) {
            return "A TV foi ligada";
        } else {
            return "A TV foi desligada.";
        }
    }

    @Override
    public String aumentarVolume() throws RemoteException {
        if (ligada && !silenciada) {
            if (volume < 100) {
                this.volume++;
            }
            return "Volume aumentado. Volume atual: " + this.volume;
        } else if (silenciada) {
            return "TV silenciada. Desative o modo 'mudo' primeiro.";
        } else {
            return "A TV está desligada.";
        }
    }

    @Override
    public String diminuirVolume() throws RemoteException {
        if (ligada && !silenciada) {
            if (volume > 0) {
                this.volume--;
            }
            return "Volume diminuído. Volume atual: " + this.volume;
        } else if (silenciada) {
            return "TV silenciada. Desative o modo 'mudo' primeiro.";
        } else {
            return "A TV está desligada.";
        }
    }

    @Override
    public String trocarCanal(int canal_) throws RemoteException {
        if (ligada) {
            this.canal = canal_;
            return "Canal trocado. Canal atual: " + this.canal;
        } else {
            return "A TV está desligada.";
        }
    }

    @Override
    public String silenciar() throws RemoteException {
        if (ligada) {
            if (!silenciada) {
                this.volumeAntesSilenciar = this.volume;
                this.volume = 0;
                this.silenciada = true;
                return "TV silenciada. Volume atual: " + this.volume;
            } else {
                this.volume = this.volumeAntesSilenciar;
                this.silenciada = false;
                return "TV dessilenciada. Volume atual: " + this.volume;
            }
        } else {
            return "A TV está desligada.";  
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
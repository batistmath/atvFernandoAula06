import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controle extends Remote{
    void ligarDesligar() throws RemoteException;

    void aumentarVolume() throws RemoteException;

    void diminuirVolume() throws RemoteException;

    void trocarCanal(int canal) throws RemoteException;

    void silenciar() throws RemoteException;

    String consultarStatus() throws RemoteException;
}

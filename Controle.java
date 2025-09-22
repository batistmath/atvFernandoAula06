import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Controle extends Remote{
    String ligarDesligar() throws RemoteException;

    String aumentarVolume() throws RemoteException;

    String diminuirVolume() throws RemoteException;

    String trocarCanal(int canal) throws RemoteException;

    String silenciar() throws RemoteException;

    String consultarStatus() throws RemoteException;
}

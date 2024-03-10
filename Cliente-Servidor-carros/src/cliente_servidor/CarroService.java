package cliente_servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Carro;

public interface CarroService extends Remote {
  void adicionarCarro(Carro carro) throws RemoteException;

  void removerCarro(String renavam) throws RemoteException;

  Carro busCarroNome(String nome) throws RemoteException;

  Carro busCarroRevavam(String renavam) throws RemoteException;
}

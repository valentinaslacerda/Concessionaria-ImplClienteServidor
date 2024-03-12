package gerenciamento_carros;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entidades.Carro;

public interface BancoDadosService extends Remote {
  void adicionarCarro(Carro carro) throws RemoteException;

  void removerCarro(String renavam) throws RemoteException;

  Carro buscarCarroNome(String nome) throws RemoteException;

  Carro buscarCarroRevavam(String renavam) throws RemoteException;

  Carro alterarCarro(Carro carro) throws RemoteException;

  int checarQtd() throws RemoteException;

  List<Carro> listarCarros() throws RemoteException;

}

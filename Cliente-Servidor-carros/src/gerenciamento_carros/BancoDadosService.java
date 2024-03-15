package gerenciamento_carros;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entidades.Carro;

public interface BancoDadosService extends Remote {
  String adicionarCarro(Carro carro) throws RemoteException;

  String removerCarro(String renavam) throws RemoteException;

  Carro buscarCarroNome(String nome) throws RemoteException;

  Carro buscarCarroRevavam(String renavam) throws RemoteException;

  Carro alterarCarro(Carro carro) throws RemoteException;

  int checarQtd() throws RemoteException;

  ArrayList<Carro> listarCarros() throws RemoteException;

}

package gerenciamento_carros;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entidades.Carro;

public interface BancoDadosService extends Remote {
  String adicionarCarro(Carro carro) throws RemoteException;

  String removerCarro(String renavam) throws RemoteException;

  ArrayList<Carro> buscarCarroNome(String nome) throws RemoteException;

  Carro buscarCarroRenavam(String renavam) throws RemoteException;

  String alterarCarro(String renavam, Carro carro) throws RemoteException;

  int checarQtd() throws RemoteException;

  void alterarQtdPorNome(String nome, String novoNome) throws RemoteException;

  ArrayList<Carro> listarCarros() throws RemoteException;

  ArrayList<Carro> listarCarrosCategoria(String categoria) throws RemoteException;

  Carro comprarCarro(String renavam) throws RemoteException;
}

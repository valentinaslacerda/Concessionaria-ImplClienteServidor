package gerenciamento_carros;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.Carro;

public interface BancoDadosService extends Remote {
  String adicionarCarro(Carro carro) throws RemoteException;

  String removerCarro(String renavam) throws RemoteException;

  String removerCarroPorNome(String nome) throws RemoteException;

  ArrayList<Carro> buscarCarroNome(String nome) throws RemoteException;

  Carro buscarCarroRenavam(String renavam) throws RemoteException;

  String alterarCarro(String renavam, Carro carro) throws RemoteException;

  HashMap<String, Integer> checarQtd() throws RemoteException;

  ArrayList<Carro> listarCarros() throws RemoteException;

  ArrayList<Carro> listarCarrosCategoria(String categoria) throws RemoteException;

  Carro comprarCarro(String renavam) throws RemoteException;
}

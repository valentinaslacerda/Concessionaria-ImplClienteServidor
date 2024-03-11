package cliente_servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entidades.Carro;
import entidades.Usuario;

public interface Service extends Remote {
  void adicionarCarro(Carro carro) throws RemoteException;

  void removerCarro(String renavam) throws RemoteException;

  Carro busCarroNome(String nome) throws RemoteException;

  Carro busCarroRevavam(String renavam) throws RemoteException;

  Carro alterarCarro(Carro carro) throws RemoteException;

  int checarQtd() throws RemoteException;

  List<Carro> listarCarros() throws RemoteException;

  String autenticarUser(Usuario usuario) throws RemoteException;
}

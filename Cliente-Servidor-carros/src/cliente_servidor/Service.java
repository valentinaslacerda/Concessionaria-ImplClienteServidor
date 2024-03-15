package cliente_servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entidades.Carro;
import entidades.Usuario;

public interface Service extends Remote {
  String adicionarCarro(Carro carro) throws RemoteException;

  String removerCarro(String renavam) throws RemoteException;

  ArrayList<Carro> buscarCarroNome(String nome) throws RemoteException;

  Carro buscarCarroRenavam(String renavam) throws RemoteException;

  String alterarCarro(String renavam, Carro carro) throws RemoteException;

  int checarQtd() throws RemoteException;

  ArrayList<Carro> listarCarros() throws RemoteException;

  ArrayList<Carro> listarCarrosCategoria(String categoria) throws RemoteException;

  String autenticarUser(Usuario usuario) throws RemoteException;
}

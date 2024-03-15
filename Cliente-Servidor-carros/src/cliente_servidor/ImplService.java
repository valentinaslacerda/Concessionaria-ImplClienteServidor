package cliente_servidor;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import autenticacao.AutenticacaoService;
import entidades.Carro;
import entidades.Usuario;
import gerenciamento_carros.BancoDadosService;

public class ImplService extends UnicastRemoteObject implements Service {
  AutenticacaoService stubAutenticacao;
  BancoDadosService stubBanco;

  public ImplService() throws RemoteException {
    super();
    try {
      Registry registro = LocateRegistry.getRegistry("localhost", 1100);
      stubAutenticacao = (AutenticacaoService) registro.lookup("AutenticacaoService");

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }

    try {
      Registry registro = LocateRegistry.getRegistry("localhost", 1101);
      stubBanco = (BancoDadosService) registro.lookup("BancoDadosService");

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }

  }

  @Override
  public String adicionarCarro(Carro carro) throws RemoteException {
    try {
      return stubBanco.adicionarCarro(carro);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public String removerCarro(String renavam) throws RemoteException {
    try {
      return stubBanco.removerCarro(renavam);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;

  }

  @Override
  public Carro buscarCarroNome(String nome) throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'busCarroNome'");
  }

  @Override
  public Carro buscarCarroRevavam(String renavam) throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'busCarroRevavam'");
  }

  @Override
  public Carro alterarCarro(Carro carro) throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'alterarCarro'");
  }

  @Override
  public int checarQtd() throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'checarQtd'");
  }

  @Override
  public ArrayList<Carro> listarCarros() throws RemoteException {
    return stubBanco.listarCarros();
  }

  @Override
  public String autenticarUser(Usuario usuario) throws RemoteException {
    String resultado;

    try {
      resultado = stubAutenticacao.isAutenticado(usuario);
      if (resultado != null) {
        return resultado;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

}
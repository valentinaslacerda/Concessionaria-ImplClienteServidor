package cliente_servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import autenticacao.AutenticacaoService;
import entidades.Carro;
import entidades.Usuario;

public class ImplService extends UnicastRemoteObject implements Service {
  public ImplService() throws RemoteException {
    super();
  }

  @Override
  public void adicionarCarro(Carro carro) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'adicionarCarro'");
  }

  @Override
  public void removerCarro(String renavam) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removerCarro'");
  }

  @Override
  public Carro busCarroNome(String nome) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'busCarroNome'");
  }

  @Override
  public Carro busCarroRevavam(String renavam) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'busCarroRevavam'");
  }

  @Override
  public Carro alterarCarro(Carro carro) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'alterarCarro'");
  }

  @Override
  public int checarQtd() throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'checarQtd'");
  }

  @Override
  public List<Carro> listarCarros() throws RemoteException {
    throw new UnsupportedOperationException("Unimplemented method 'listarCarros'");
  }

  @Override
  public String autenticarUser(Usuario usuario) throws RemoteException {
    String resultado;
    try {
      Registry registro = LocateRegistry.getRegistry("localhost");
      AutenticacaoService stub = (AutenticacaoService) registro.lookup("AutenticacaoService");

      resultado = stub.isAutenticado(usuario);
      if (resultado != null) {
        return resultado;
      }
    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
    return null;
  }

}
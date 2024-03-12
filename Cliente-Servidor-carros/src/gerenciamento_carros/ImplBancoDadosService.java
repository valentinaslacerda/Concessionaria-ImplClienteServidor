package gerenciamento_carros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entidades.Carro;

public class ImplBancoDadosService extends UnicastRemoteObject implements BancoDadosService {

  public ImplBancoDadosService() throws RemoteException {
    super();
  }

  @Override
  public void adicionarCarro(Carro carro) throws RemoteException {

  }

  @Override
  public void removerCarro(String renavam) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removerCarro'");
  }

  @Override
  public Carro buscarCarroNome(String nome) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'buscarCarroNome'");
  }

  @Override
  public Carro buscarCarroRevavam(String renavam) throws RemoteException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'buscarCarroRevavam'");
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listarCarros'");
  }

}

package cliente_servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import entidades.Carro;

public class ImplCarroService extends UnicastRemoteObject implements CarroService {
  public ImplCarroService() throws RemoteException {
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
}

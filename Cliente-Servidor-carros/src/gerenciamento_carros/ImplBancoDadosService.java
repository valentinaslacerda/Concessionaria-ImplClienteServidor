package gerenciamento_carros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import entidades.Carro;

public class ImplBancoDadosService extends UnicastRemoteObject implements BancoDadosService {
  HashMap<String, Carro> bancoDados = new HashMap<String, Carro>();

  public ImplBancoDadosService() throws RemoteException {
    super();

  }

  @Override
  public String adicionarCarro(Carro carro) throws RemoteException {
    int qtd = 1;
    if (bancoDados != null) {
      for (Carro i : bancoDados.values()) {
        if (carro.getRenavam().equals(i.getRenavam())) {
          System.out.println("Carro com renavam: " + i.getRenavam() + " já existe");
          return "carro já existe";
        } else if (carro.getNome().equals(i.getNome())) {
          qtd++;
        }
      }
      carro.setQtd(qtd);
      bancoDados.put(carro.getRenavam(), carro);
      return "carro registrado com sucesso";
    }
    return null;
  }

  @Override
  public String removerCarro(String renavam) throws RemoteException {
    if (bancoDados != null) {
      for (String i : bancoDados.keySet()) {
        if (i.equals(renavam)) {
          for (Carro carro : bancoDados.values()) {
            if (carro.getNome().equals(bancoDados.get(renavam).getNome())) {
              int qtd = bancoDados.get(renavam).getQtd();
              bancoDados.get(renavam).setQtd(qtd--);
            }
          }
          bancoDados.remove(renavam);
          return "carro removido com sucesso";
        }
      }
      return "carro não encontrado";
    }
    return "não há carros cadastrados";
  }

  @Override
  public Carro buscarCarroNome(String nome) throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'buscarCarroNome'");
  }

  @Override
  public Carro buscarCarroRevavam(String renavam) throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'buscarCarroRevavam'");
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
  public List<Carro> listarCarros() throws RemoteException {

    throw new UnsupportedOperationException("Unimplemented method 'listarCarros'");
  }

}

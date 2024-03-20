package gerenciamento_carros;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import entidades.Carro;

public class ImplBancoDadosService extends UnicastRemoteObject implements BancoDadosService {
  HashMap<String, Carro> bancoDados = new HashMap<String, Carro>();
  int qtdTotal = 0;

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

      for (Carro i : bancoDados.values()) {
        if (carro.getNome().equals(i.getNome())) {
          bancoDados.get(i.getRenavam()).setQtd(qtd);
        }
      }
      carro.setQtd(qtd);

      bancoDados.put(carro.getRenavam(), carro);
      ++qtdTotal;
      return "carro registrado com sucesso";
    }
    return null;
  }

  @Override
  public String removerCarro(String renavam) throws RemoteException {
    if (bancoDados != null) {
      for (String key : bancoDados.keySet()) {
        if (key.equals(renavam)) { // se carro existe
          for (Carro carro : bancoDados.values()) {
            if (carro.getNome().equals(bancoDados.get(renavam).getNome())) {
              int qtd = bancoDados.get(carro.getRenavam()).getQtd();
              bancoDados.get(carro.getRenavam()).setQtd(qtd - 1);
            }
          }
          bancoDados.remove(renavam);
          --qtdTotal;
          return "carro removido com sucesso";
        }
      }
      return "carro não encontrado";
    }
    return "não há carros cadastrados";
  }

  @Override
  public ArrayList<Carro> buscarCarroNome(String nome) throws RemoteException {
    ArrayList<Carro> listaCarros = new ArrayList<Carro>();
    if (!bancoDados.isEmpty()) {
      for (Carro carro : bancoDados.values()) {
        if (carro.getNome().equals(nome)) {
          listaCarros.add(carro);
        }

      }
      if (listaCarros.isEmpty()) {
        System.out.println("Não há carros desse modelo");
        return null;
      }

    }
    return listaCarros;

  }

  @Override
  public Carro buscarCarroRenavam(String renavam) throws RemoteException {
    if (!bancoDados.isEmpty()) {
      for (String key : bancoDados.keySet()) {
        if (key.equals(renavam)) {
          return bancoDados.get(key);
        }
      }
      System.out.println("Não há carro com esse renavam cadastrado");
    }
    return null;
  }

  @Override
  public String alterarCarro(String renavam, Carro carro) throws RemoteException {
    Carro carroEncontrado = buscarCarroRenavam(renavam);

    if (carroEncontrado != null) {
      for (Carro veiculo : bancoDados.values()) {
        if (veiculo.getNome().equals(carroEncontrado.getNome())) {
          bancoDados.get(veiculo.getRenavam()).setQtd(veiculo.getQtd() - 1);
        }
      }
      for (Carro veiculo : bancoDados.values()) {
        if (veiculo.getNome().equals(carro.getNome())) { // se nome é igual novo nome
          bancoDados.get(veiculo.getRenavam()).setQtd(veiculo.getQtd() + 1);
          // altera qtd para novo carro
          bancoDados.get(renavam).setQtd(veiculo.getQtd());
        }
      }

      bancoDados.get(renavam).setNome(carro.getNome());
      bancoDados.get(renavam).setRenavam(carro.getRenavam());
      bancoDados.get(renavam).setPlaca(carro.getPlaca());
      bancoDados.get(renavam).setCategoria(carro.getCategoria());
      bancoDados.get(renavam).setAnoFab(carro.getAnoFab());
      bancoDados.get(renavam).setPreco(carro.getPreco());

      return "Carro alterado com sucesso";
    }
    return "Carro que você está tentando alterar não existe";
  }

  @Override
  public HashMap<String, Integer> checarQtd() throws RemoteException {
    HashMap<String, Integer> estoque = new HashMap<String, Integer>();
    for (Carro carro : bancoDados.values()) {
      estoque.put(carro.getNome(), carro.getQtd());
    }
    estoque.put("total", qtdTotal);
    return estoque;
  }

  @Override
  public ArrayList<Carro> listarCarros() throws RemoteException {
    ArrayList<Carro> listaCarros = new ArrayList<Carro>();
    if (!bancoDados.isEmpty()) {
      for (Carro carro : bancoDados.values()) {
        listaCarros.add(carro);
      }
      Collections.sort(listaCarros, Comparator.comparing(Carro::getNome));
      return listaCarros;
    }
    return null;
  }

  @Override
  public ArrayList<Carro> listarCarrosCategoria(String categoria) throws RemoteException {
    ArrayList<Carro> listaCarros = new ArrayList<Carro>();
    if (!bancoDados.isEmpty()) {
      for (Carro carro : bancoDados.values()) {
        if (carro.getCategoria().equals(categoria)) {
          listaCarros.add(carro);
        }

      }
      if (listaCarros.isEmpty()) {
        System.out.println("Não há carros nessa categoria");
      } else {
        return listaCarros;
      }

    }
    return null;
  }

  @Override
  public Carro comprarCarro(String renavam) throws RemoteException {
    Carro carroEncontrado = buscarCarroRenavam(renavam);
    if (carroEncontrado != null) {
      System.out.println(removerCarro(renavam));
      return carroEncontrado;
    }
    return null;
  }

  @Override
  public String removerCarroPorNome(String nome) throws RemoteException {
    ArrayList<Carro> carrosEncontrados = buscarCarroNome(nome);
    if (carrosEncontrados.size() != 0) {
      for (Carro carro : carrosEncontrados) {
        removerCarro(carro.getRenavam());
      }
      return "Todo estoque de carros removidos com sucesso.";
    }
    return null;
  }

}

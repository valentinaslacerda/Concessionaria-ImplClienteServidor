package autenticacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entidades.Usuario;

public class ImplAutenticacaoService extends UnicastRemoteObject implements AutenticacaoService {

  protected ImplAutenticacaoService() throws RemoteException {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String isAutenticado(Usuario user) throws IOException {
    ArrayList<String> resultado = new ArrayList<>();
    ;
    try {
      BufferedReader buffRead = new BufferedReader(new FileReader("dadosUser.txt"));
      String linha = "";
      while (true) {
        if (linha != null) {
          resultado.add(linha);

        } else
          break;
        linha = buffRead.readLine();

      }
      buffRead.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    for (String line : resultado) {
      String partes[] = line.split(" ");
      String userCad = partes[1];
      String senhaCad = partes[3];
      String categoria = partes[5];
      if (userCad == user.getUser() && senhaCad == user.getSenha()) {
        return categoria;
      }
    }
    return null;
  }

}

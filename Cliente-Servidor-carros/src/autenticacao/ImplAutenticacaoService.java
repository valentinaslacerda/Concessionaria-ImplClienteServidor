package autenticacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import entidades.Usuario;

public class ImplAutenticacaoService extends UnicastRemoteObject implements AutenticacaoService {

  public ImplAutenticacaoService() throws RemoteException {
    super();

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

      e.printStackTrace();
    }
    for (String line : resultado) {
      String partes[] = line.split(" ");
      if (partes.length == 6) {
        System.out.println(partes);
        String userCad = partes[1];
        String senhaCad = partes[3];
        String categoria = partes[5];
        if (user.getUser().equals(userCad) && user.getSenha().equals(senhaCad)) {
          return categoria;
        }
      }
    }
    return null;
  }

}

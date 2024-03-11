package autenticacao;

import java.io.IOException;
import java.rmi.Remote;

import entidades.Usuario;

public interface AutenticacaoService extends Remote {
  String isAutenticado(Usuario user) throws IOException;

}

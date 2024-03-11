package autenticacao;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorAutenticacao {
  public static void main(String[] args) {
    try {
      ImplAutenticacaoService skeleton = new ImplAutenticacaoService();

      Registry registro = LocateRegistry.createRegistry(1099);
      registro.rebind("AutenticacaoService", skeleton);
      System.out.println("Servidor de autenticação pronto para receber conexões...");

    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}

package gerenciamento_carros;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BancoDadosServidor {
  public static void main(String[] args) {
    try {
      ImplBancoDadosService skeleton = new ImplBancoDadosService();

      Registry registro = LocateRegistry.createRegistry(1101);
      registro.rebind("BancoDadosService", skeleton);
      System.out.println("Servidor pronto para receber conexões...");

    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}

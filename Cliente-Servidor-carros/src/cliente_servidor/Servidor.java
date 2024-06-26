package cliente_servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
  public static void main(String[] args) {
    try {
      ImplService skeleton = new ImplService();

      Registry registro = LocateRegistry.createRegistry(1099);
      registro.rebind("Service", skeleton);
      System.out.println("Servidor pronto para receber conexões...");

    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}

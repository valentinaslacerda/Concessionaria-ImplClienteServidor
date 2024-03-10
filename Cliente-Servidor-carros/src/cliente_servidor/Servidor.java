package cliente_servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
  public static void main(String[] args) {
    try {
      ImplCarroService carroService = new ImplCarroService();
      CarroService stub = (CarroService) UnicastRemoteObject.exportObject(carroService, 0);

      Registry registro = LocateRegistry.createRegistry(1099);
      registro.rebind("Carro", stub);
      System.out.println("Servidor pronto para receber conexões...");
    } catch (Exception e) {
      System.err.println("Erro no servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}

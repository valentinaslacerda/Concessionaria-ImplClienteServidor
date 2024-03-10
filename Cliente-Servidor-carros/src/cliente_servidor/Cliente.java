package cliente_servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import entidades.Carro;

public class Cliente {
  public static void main(String[] args) {
    try {
      Registry registro = LocateRegistry.getRegistry("localhost");
      CarroService stub = (CarroService) registro.lookup("CarroService");

      // Exemplo
      Carro carro = new Carro(null, null, null, null, 0, 0);
      stub.adicionarCarro(carro);
    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
  }
}

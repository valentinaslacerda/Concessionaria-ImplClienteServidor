package cliente_servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import entidades.Usuario;

public class Cliente {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      Registry registro = LocateRegistry.getRegistry("localhost");
      Service stub = (Service) registro.lookup("Service");
      System.out.println("Usuário: ");
      String inputUser = scanner.nextLine();
      System.out.println("Senha: ");
      String inputSenha = scanner.nextLine();
      Usuario user = new Usuario(inputUser, inputSenha, null);
      String categoria = stub.autenticarUser(user);
      if (categoria == null) {
        System.out.println("Usuário não encontrado");
      } else if (categoria == "funcionario") {
        System.out.println("funcionario");
      } else {
        System.out.println("cliente");
      }
      scanner.close();
    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
  }
}

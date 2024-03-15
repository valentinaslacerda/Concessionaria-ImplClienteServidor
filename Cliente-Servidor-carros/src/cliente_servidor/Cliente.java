package cliente_servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import entidades.Carro;
import entidades.Usuario;

public class Cliente {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      Registry registro = LocateRegistry.getRegistry("localhost");
      Service stub = (Service) registro.lookup("Service");
      while (true) {
        System.out.println("Usuário: ");
        String inputUser = scanner.nextLine();

        System.out.println("Senha: ");
        String inputSenha = scanner.nextLine();

        Usuario user = new Usuario(inputUser, inputSenha, null);
        String acesso = stub.autenticarUser(user);
        boolean execucao = true;

        if (acesso == null) {
          System.out.println("Usuário não encontrado");
        } else if (acesso.equals("funcionario")) {

          while (execucao) {
            System.out.println("\n============Painel Funcionário============");
            System.out.println("[1] Adicionar carro");
            System.out.println("[2] Apagar carro");
            System.out.println("[3] Listar carros");
            System.out.println("[4] Listar carros por categoria");
            System.out.println("[5] Pesquisar carro");
            System.out.println("[6] Exibir quantidade de carros");
            System.out.println("[7] Comprar carro");
            System.out.println("[0] Sair");
            int escolha = scanner.nextInt();
            switch (escolha) {
              case 0:
                execucao = false;
                break;
              case 1:
                System.out.println("Nome do carro: ");
                String nome = scanner.next();

                System.out.println("Categoria: ");
                String categoria = scanner.next();

                System.out.println("Renavam: ");
                String renavam = scanner.next();

                System.out.println("Placa: ");
                String placa = scanner.next();

                System.out.println("Ano de fabricação: ");
                int anoFab = scanner.nextInt();

                System.out.println("Preço: ");
                double preco = scanner.nextDouble();
                Carro carro = new Carro(renavam, placa, nome, categoria, anoFab, preco, 1);
                System.out.println(stub.adicionarCarro(carro));
                break;

              case 2:
                System.out.println("Renavam: ");
                String renavamRemover = scanner.next();
                System.out.println(stub.removerCarro(renavamRemover));
                break;

              case 3:
                ArrayList<Carro> carros = new ArrayList<Carro>();
                carros = stub.listarCarros();
                if (carros != null) {
                  for (Carro veiculo : carros) {
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Nome do carro: " + veiculo.getNome());

                    System.out.println("Categoria: " + veiculo.getCategoria());

                    System.out.println("Renavam: " + veiculo.getRenavam());

                    System.out.println("Placa: " + veiculo.getPlaca());

                    System.out.println("Ano de fabricação: " + veiculo.getAnoFab());

                    System.out.println("Preço: " + veiculo.getPreco());

                    System.out.println("Quantidade: " + veiculo.getQtd());
                  }
                } else {
                  System.out.println("Não há carro cadastrado: ");
                }
                break;
              default:
                break;
            }
          }

        } else {
          System.out.println("cliente");
        }
      }

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
    scanner.close();
  }
}

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
            System.out.println("[5] Pesquisar carro por nome");
            System.out.println("[6] Pesquisar carro por renavam");
            System.out.println("[7] Alterar carro");
            System.out.println("[8] Exibir quantidade de carros");
            System.out.println("[9] Comprar carro");
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
                  System.out.println("Não há carro cadastrado");
                }
                break;
              case 4:
                ArrayList<Carro> carrosCategoria = new ArrayList<Carro>();
                System.out.println("Categoria: ");
                categoria = scanner.next();
                carrosCategoria = stub.listarCarrosCategoria(categoria);
                if (carrosCategoria != null) {
                  for (Carro veiculo : carrosCategoria) {
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
                  System.out.println("Não há carro cadastrado nessa categoria");
                }
                break;

              case 5:
                ArrayList<Carro> carrosPorNome = new ArrayList<Carro>();
                System.out.println("Nome: ");
                nome = scanner.next();
                carrosPorNome = stub.buscarCarroNome(nome);
                if (carrosPorNome != null) {
                  for (Carro veiculo : carrosPorNome) {
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
                  System.out.println("Não há carro cadastrado desse modelo");
                }
                break;
              case 6:
                System.out.println("Renavam: ");
                renavam = scanner.next();
                Carro carroPorRenavam = stub.buscarCarroRenavam(renavam);
                if (carroPorRenavam != null) {
                  System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                  System.out.println("Nome do carro: " + carroPorRenavam.getNome());

                  System.out.println("Categoria: " + carroPorRenavam.getCategoria());

                  System.out.println("Renavam: " + carroPorRenavam.getRenavam());

                  System.out.println("Placa: " + carroPorRenavam.getPlaca());

                  System.out.println("Ano de fabricação: " + carroPorRenavam.getAnoFab());

                  System.out.println("Preço: " + carroPorRenavam.getPreco());

                  System.out.println("Quantidade: " + carroPorRenavam.getQtd());

                } else {
                  System.out.println("Não há carro cadastrado desse modelo");
                }
                break;
              case 7:
                System.out.println("Digite renavam do carro que você deseja alterar: ");
                String renavamAlterar = scanner.next();

                System.out.println("Alterar nome do carro: ");
                nome = scanner.next();

                System.out.println("Alterar categoria: ");
                categoria = scanner.next();

                System.out.println("Alterar renavam: ");
                renavam = scanner.next();

                System.out.println("Alterar placa: ");
                placa = scanner.next();

                System.out.println("Alterar ano de fabricação: ");
                anoFab = scanner.nextInt();

                System.out.println("Alterar preço: ");
                preco = scanner.nextDouble();
                Carro carroAlterado = new Carro(renavam, placa, nome, categoria, anoFab, preco, 1);
                System.out.println(stub.alterarCarro(renavamAlterar, carroAlterado));
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

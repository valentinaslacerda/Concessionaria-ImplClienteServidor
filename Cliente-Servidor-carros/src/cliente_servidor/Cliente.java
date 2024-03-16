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
          stub.adicionarCarro(new Carro("12345678901", "abc-1234", "audi", "economico", 2012, 654321, 1));
          stub.adicionarCarro(new Carro("12245678901", "bbc-1234", "fiat", "economico", 2022, 654321, 1));
          stub.adicionarCarro(new Carro("11345678901", "ccc-1211", "fiat", "imp", 2012, 834321, 1));
          stub.adicionarCarro(new Carro("12344678901", "aac-1234", "uno", "imp", 2010, 954321, 1));
          stub.adicionarCarro(new Carro("12345668901", "abc-4444", "gol", "popular", 2013, 784321, 1));
          stub.adicionarCarro(new Carro("12345778901", "abc-2334", "palio", "imp", 2018, 954321, 1));
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
                System.out.println("Sessão encerrada");
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
                  System.out.println("Não há carro cadastrado com esse renavam");
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
              case 8:
                System.out.println("Quantidade de carros: " + stub.checarQtd());
                break;
              case 9:
                System.out.println("Informe o renavam do carro que deseja comprar: ");
                renavam = scanner.next();
                carro = stub.comprarCarro(renavam);
                if (carro != null) {
                  System.out.println("Compra efetuada. Informações do veículo: ");
                  System.out.println("Nome do carro: " + carro.getNome());

                  System.out.println("Categoria: " + carro.getCategoria());

                  System.out.println("Renavam: " + carro.getRenavam());

                  System.out.println("Placa: " + carro.getPlaca());

                  System.out.println("Ano de fabricação: " + carro.getAnoFab());

                  System.out.println("Preço: " + carro.getPreco());
                }
                break;

              default:
                System.out.println("Comando não existe");
                break;
            }
          }

        } else {
          while (execucao) {
            System.out.println("\n============Painel Cliente============");
            System.out.println("[1] Listar carros");
            System.out.println("[2] Listar carros por categoria");
            System.out.println("[3] Pesquisar carro por nome");
            System.out.println("[4] Pesquisar carro por renavam");
            System.out.println("[5] Exibir quantidade de carros");
            System.out.println("[6] Comprar carro");
            System.out.println("[0] Sair");
            int escolha = scanner.nextInt();
            switch (escolha) {
              case 0:
                System.out.println("Sessão encerrada");
                execucao = false;
                break;

              case 1:
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
              case 2:
                ArrayList<Carro> carrosCategoria = new ArrayList<Carro>();
                System.out.println("Categoria: ");
                String categoria = scanner.next();
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

              case 3:
                ArrayList<Carro> carrosPorNome = new ArrayList<Carro>();
                System.out.println("Nome: ");
                String nome = scanner.next();
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
              case 4:
                System.out.println("Renavam: ");
                String renavam = scanner.next();
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
                  System.out.println("Não há carro cadastrado com esse renavam");
                }
                break;
              case 5:
                System.out.println("Quantidade de carros: " + stub.checarQtd());
                break;
              case 6:
                System.out.println("Informe o renavam do carro que deseja comprar: ");
                renavam = scanner.next();
                Carro carro = stub.comprarCarro(renavam);
                if (carro != null) {
                  System.out.println("Compra efetuada. Informações do veículo: ");
                  System.out.println("Nome do carro: " + carro.getNome());

                  System.out.println("Categoria: " + carro.getCategoria());

                  System.out.println("Renavam: " + carro.getRenavam());

                  System.out.println("Placa: " + carro.getPlaca());

                  System.out.println("Ano de fabricação: " + carro.getAnoFab());

                  System.out.println("Preço: " + carro.getPreco());
                }
                break;

              default:
                System.out.println("Comando não existe");
                break;
            }
          }
        }
      }

    } catch (Exception e) {
      System.err.println("Erro no cliente: " + e.toString());
      e.printStackTrace();
    }
    scanner.close();
  }
}

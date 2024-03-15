package entidades;

import java.io.Serializable;

public class Carro implements Serializable {
  private static final long serialVersionUID = 2L;
  private String renavam;
  private String placa;
  private String nome;
  private String categoria;
  private int anoFab;
  private double preco;
  private int qtd;

  public Carro(String renavam, String placa, String nome, String categoria, int anoFab, double preco, int qtd) {
    setRenavam(renavam);
    setPlaca(placa);
    setNome(nome);
    setCategoria(categoria);
    setAnoFab(anoFab);
    setPreco(preco);
    setQtd(qtd);
  }

  public String getRenavam() {
    return renavam;
  }

  public void setRenavam(String renavam) {
    try {
      if (renavam.length() != 11) {
        this.renavam = null;
        throw new IllegalArgumentException("Renavam inválido");
      } else {
        this.renavam = renavam;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    try {
      if (placa.length() != 8) {
        throw new IllegalArgumentException("Placa inválida");
      } else {
        this.placa = placa;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    try {
      if (nome == null) {
        throw new IllegalArgumentException("Nome null");
      } else {
        this.nome = nome;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    try {
      if (categoria == null) {
        throw new IllegalArgumentException("Categoria null");
      } else {
        this.categoria = categoria;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getAnoFab() {
    return anoFab;
  }

  public void setAnoFab(int anoFab) {
    try {
      if (anoFab < 0) {
        throw new IllegalArgumentException("Ano de fabricação inválido");
      } else {
        this.anoFab = anoFab;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    try {
      if (preco < 0) {
        throw new IllegalArgumentException("Preço inválido");
      } else {
        this.preco = preco;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getQtd() {
    return qtd;
  }

  public void setQtd(int qtd) {
    try {
      if (qtd < 0) {
        throw new IllegalArgumentException("Quantidade inválida");
      } else {
        this.qtd = qtd;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}

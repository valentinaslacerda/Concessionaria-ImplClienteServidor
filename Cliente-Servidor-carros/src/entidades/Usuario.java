package entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
  private static final long serialVersionUID = 1L;
  private String user;
  private String senha;
  private String acesso;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    try {
      if (user == null) {
        throw new IllegalArgumentException("Nome de usuário não preenchido");
      } else {
        this.user = user;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    try {
      if (senha == null) {
        throw new IllegalArgumentException("Senha não preenchida");
      } else {
        this.senha = senha;
      }
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  public String getAcesso() {
    return acesso;
  }

  public void setAcesso(String acesso) {
    this.acesso = acesso;
  }

  public Usuario(String user, String senha, String acesso) {
    setUser(user);
    setSenha(senha);
    setAcesso(acesso);
  }

}

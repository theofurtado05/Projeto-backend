public class Usuario {
   private int Id;
   private String login, senha,perfil_usuario;

    //Construtor
    // public void AtualizarDadosUsuario(Integer valor_id, String valor_login, String valor_senha, String valor_perfilusuario ){
    //     this.Id = valor_id;
    //     this.login = valor_login;
    //     this.senha = valor_senha;
    //     this.perfil_usuario = valor_perfilusuario;
    // }

    public void AtualizarDadosUsuario(String valor_login, String valor_senha, String valor_perfilusuario ){
        if(login != null)
        this.login = valor_login;
        if(senha != null)
        this.senha = valor_senha;
        if(perfil_usuario != null)
        this.perfil_usuario = valor_perfilusuario;
    }


    // Getters
  public int GetId() {
    return this.Id;
  }
  public String GetLogin(){
    return this.login;
    
  }
  public String GetSenha(){
    return this.senha;
  }
  public String GetPerfilUsuario(){
    return this.perfil_usuario;
  }
  // Setter
  public void setId(int newId) {
    this.Id = newId;
  }
  public void SetLogin(String newLogin){
    this.login = newLogin;
  }
  public void SetSenha(String newSenha){
    this.senha = newSenha;
  }
  public void SetPerfilUsuario(String newPerfilUsuario){
    this.perfil_usuario = newPerfilUsuario;
  }

  
        
}    

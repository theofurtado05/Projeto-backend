package model;

public class Usuario {
    int pk_id, departamentoId;
    PerfilUsuario perfilUsuario;
    String nome, sobrenome, email, senha;


    //CONSTRUTORES
    public Usuario(String nome, String sobrenome, String email, PerfilUsuario perfilUsuario, String senha, int departamentoId){
        this.departamentoId = departamentoId;
        this.perfilUsuario = perfilUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(){

    }

    //GETTERS
    public int getPk_id(){
        return this.pk_id;
    }
    
    public int getDepartamentoId(){
        return this.departamentoId;
    }

    public PerfilUsuario getPerfilUsuario(){
        return this.perfilUsuario;
    }

    public String getNome(){
        return this.nome;
    }
    public String getSobrenome(){
        return this.sobrenome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSenha(){
        return this.senha;
    }


    //SETTERS
    public void setPk_id(int pk_id){
        this.pk_id = pk_id;
    }
    
    public void setDepartamentoId(int departamentoId){
        this.departamentoId = departamentoId;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario){
        this.perfilUsuario = perfilUsuario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

}

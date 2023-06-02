package model;

public class Usuario {
    int pk_id;
    Departamento departamento;
    PerfilUsuario perfilUsuario;
    String nome, sobrenome, email, senha;


    //CONSTRUTORES
    public Usuario(int pk_id,String nome, String sobrenome, String email, PerfilUsuario perfilUsuario, String senha, Departamento departamento){
        this.pk_id = pk_id;
        this.departamento = departamento;
        this.perfilUsuario = perfilUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String sobrenome, String email, PerfilUsuario perfilUsuario, String senha, Departamento departamento){
        this.departamento = departamento;
        this.perfilUsuario = perfilUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int pk_id){
        this.pk_id = pk_id;
    }
    public Usuario(){

    }

    //GETTERS
    public int getPk_id(){
        return this.pk_id;
    }
    
    public Departamento getDepartamento(){
        return this.departamento;
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
    
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
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

    @Override
    public String toString(){
        return "\nId: " + this.pk_id 
            + "\nNome completo: " + this.nome + " " + this.sobrenome
            + "\nEmail: " + this.email
            + "\nDepartamento: " + this.departamento.getId()
            + "\nPerfil Usuario: " + this.perfilUsuario
            + "\n";
    }
   
}

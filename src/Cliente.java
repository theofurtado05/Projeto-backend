public class Cliente {
    private int id, idusuario;   
    private String nome_completo, email, celular, cpf;

    //Getters
    public int getId(){
        return this.id;
    }

    public int getUsuarioId(){
        return this.idusuario;
    }

    public String getNome_Completo(){
        return this.nome_completo;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCelular(){
        return this.celular;
    }

    public String getCpf(){
        return this.cpf;
    }


    //Setters
    public void setId(int id){
        this.id = id;
    }

    public void setUsuarioId(int id){
        this.id = id;
    }

    public void setNome_completo(String nome_completo){
        this.nome_completo = nome_completo;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setCelular(String celular){
        this.celular = celular;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }




    
}

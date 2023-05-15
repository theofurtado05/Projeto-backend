package model;

public class Departamento {
    private Integer id;
    private String nome;
    
    //CONSTRUTORES
    public Departamento(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Departamento(String nome){
        this.nome = nome;
    }

    public Departamento(){

    }


    //UPDATE
    public void AtualizaDadosDepartamento(String nome){
        if(nome != null){
            this.nome = nome;
        }
    }

    //GETTERS
    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }


    //SETTERS
    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}

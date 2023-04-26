public class Departamento {
    private Integer id;
    private String nome;

    //CONSTRUTOR = CREATE
    //Construtor com ID
    public Departamento(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    //Construtor sem ID
    public Departamento(String nome){
        this.nome = nome;
    }


    //UPDATE - atualiza todos os dados de uma vez
    public void AtualizaDadosDepartamentos(String nome){  
        if(nome != null)
            this.nome = nome;
    }

    
    //Getters = READ
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }

    //Setters = UPDATE de um a um
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }


    //DELETE

}

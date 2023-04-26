public class Departamento {
    private int id;
    private String nome;

    //Construtor
    Departamento(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    //Getters
    public int getId(){
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }

    //Setters
    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}

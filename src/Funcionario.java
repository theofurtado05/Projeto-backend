public class Funcionario {
    private int pk_id, usuarioid, departamentoid;
    private String nome_completo, email, celular, cpf;


    // Update
    public void AtualizaDadosFuncioanrio(Integer usuarioid, Integer departamentoid, String nome_completo, String email, String celular, String cpf){
        if(usuarioid != null)
            this.usuarioid = usuarioid;
        if(departamentoid != null)
            this.departamentoid = departamentoid;
        if(nome_completo != null)
            this.nome_completo = nome_completo;
        if(email != null)
            this.email = email;
        if(celular != null)
            this.celular = celular;
        if(cpf != null)
            this.cpf = cpf;
    }
    
    // Getters
    public int getPk_id() {
        return this.pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getUsuarioid() {
        return this.usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getDepartamentoid() {
        return this.departamentoid;
    }

    public void setDepartamentoid(int departamentoid) {
        this.departamentoid = departamentoid;
    }

    public String getNome_completo() {
        return this.nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    //Construtor
    public Funcionario(int pk_id, int usuarioid, int departamentoid, String nome_completo, String email, String celular, String cpf) {
        this.pk_id = pk_id;
        this.usuarioid = usuarioid;
        this.departamentoid = departamentoid;
        this.nome_completo = nome_completo;
        this.email = email;
        this.celular = celular;
        this.cpf = cpf;
    }

}

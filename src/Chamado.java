import java.util.Date;

public class Chamado {
    int pk_id, clienteid, departamentoid, funcionarioid, nivel_urgencia;
    Date data_abertura, data_prazo, data_fechamento;
    String status, assunto, descricao;

    // Construtor
    public Chamado(int pk_id, int clienteid, int departamentoid, int funcionarioid, int nivel_urgencia, Date data_abertura, Date data_prazo, Date data_fechamento, String status, String assunto, String descricao) {
        this.pk_id = pk_id;
        this.clienteid = clienteid;
        this.departamentoid = departamentoid;
        this.funcionarioid = funcionarioid;
        this.nivel_urgencia = nivel_urgencia;
        this.data_abertura = data_abertura;
        this.data_prazo = data_prazo;
        this.data_fechamento = data_fechamento;
        this.status = status;
        this.assunto = assunto;
        this.descricao = descricao;
    }


    // Update
    public void AtualizaDadosChamado(Integer clienteid, Integer departamentoid, Integer funcionarioid, Integer nivel_urgencia, String status, String assunto, String descricao, Date data_abertura, Date data_prazo, Date data_fechamento){
        if(clienteid != null)
            this.clienteid = clienteid;
        if(departamentoid != null)
            this.departamentoid = departamentoid;
        if(funcionarioid != null)
            this.funcionarioid = funcionarioid;
        if(nivel_urgencia != null)
            this.nivel_urgencia = nivel_urgencia;
        if(status != null)
            this.status = status;
        if(assunto != null)
            this.assunto = assunto;
        if(descricao != null)
            this.descricao = descricao;
        if(data_abertura != null)
            this.data_abertura = data_abertura;
        if(data_fechamento != null)
            this.data_fechamento = data_fechamento;
        if(data_prazo != null)
            this.data_prazo = data_prazo;

    }

    // Getters and Setters
    public int getPk_id() {
        return this.pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public int getClienteid() {
        return this.clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getDepartamentoid() {
        return this.departamentoid;
    }

    public void setDepartamentoid(int departamentoid) {
        this.departamentoid = departamentoid;
    }

    public int getFuncionarioid() {
        return this.funcionarioid;
    }

    public void setFuncionarioid(int funcionarioid) {
        this.funcionarioid = funcionarioid;
    }

    public int getNivel_urgencia() {
        return this.nivel_urgencia;
    }

    public void setNivel_urgencia(int nivel_urgencia) {
        this.nivel_urgencia = nivel_urgencia;
    }

    public Date getData_abertura() {
        return this.data_abertura;
    }

    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Date getData_prazo() {
        return this.data_prazo;
    }

    public void setData_prazo(Date data_prazo) {
        this.data_prazo = data_prazo;
    }

    public Date getData_fechamento() {
        return this.data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

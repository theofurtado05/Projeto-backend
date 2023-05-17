package model;


import java.sql.Date;

public class Chamado {
    int pk_id, usuarioAbriuId, departamentoId, usuarioAssumiuId;
    NivelUrgencia nivelUrgencia;
    StatusChamado statusChamado;
    Date dataAbertura, dataPrazo, dataFechamento;
    String assunto, descricao;

    //CONSTRUTORES
    public Chamado(int pk_id, int usuarioAbriuId, int departamentoId, int usuarioAssumiuId, NivelUrgencia nivelUrgencia, StatusChamado statusChamado, Date dataAbertura, Date dataPrazo, Date dataFechamento, String assunto, String descricao){

        // this.pk_id = pk_id;
        this.usuarioAbriuId = usuarioAbriuId;
        this.departamentoId = departamentoId;
        this.usuarioAssumiuId = usuarioAssumiuId;
        this.nivelUrgencia = nivelUrgencia;
        this.statusChamado = statusChamado;
        this.dataAbertura = dataAbertura;
        this.dataPrazo = dataPrazo;
        this.dataFechamento = dataFechamento;
        this.assunto = assunto;
        this.descricao = descricao;

    }


    public Chamado(Integer usuarioidabriu, Integer departamentoid2, Integer statuschamadoid, String assunto2, String descricao2, Date dataabertura2, Date dataprazo2, Date datafechamamento, Integer nivelurgenciaid, Integer usuarioidassumiu){

    }

    public Chamado(){

    }



    //GETTERS
    public int getPk_id(){
        return this.pk_id;
    }
    public int getUsuarioAbriuId(){
        return this.usuarioAbriuId;
    }
    public int getDepartamentoId(){
        return this.departamentoId;
    }
    public int getUsuarioAssumiuId(){
        return this.usuarioAssumiuId;
    }

    public NivelUrgencia getNivelUrgencia(){
        return this.nivelUrgencia;
    }

    public StatusChamado getStatusChamado(){
        return this.statusChamado;
    }

    public Date getDataAbertura(){
        return this.dataAbertura;
    }

    public Date getDataPrazo(){
        return this.dataPrazo;
    }

    public Date getDataFechamento(){
        return this.dataFechamento;
    }

    public String getAssunto(){
        return this.assunto;
    }

    public String getDescricao(){
        return this.descricao;
    }
    


    //SETTERS
    public void setPk_id(int pk_id){
        this.pk_id = pk_id;
    }
    public void setUsuarioAbriuId(int usuarioAbriuId){
        this.usuarioAbriuId = usuarioAbriuId;
    }
    public void setDepartamentoId(int departamentoId){
        this.departamentoId = departamentoId;
    }
    public void setUsuarioAssumiuId(int usuarioAbriuId){
        this.usuarioAssumiuId = usuarioAbriuId;
    }

    public void getNivelUrgencia(NivelUrgencia nivelUrgencia){
        this.nivelUrgencia = nivelUrgencia;
    }

    public void setStatusChamado(StatusChamado statusChamado){
        this.statusChamado = statusChamado;
    }

    public void setDataAbertura(Date dataAbertura){
        this.dataAbertura = dataAbertura;
    }

    public void setDataPrazo(Date dataPrazo){
        this.dataPrazo = dataPrazo;
    }

    public void setDataFechamento(Date dataFechamento){
        this.dataFechamento = dataFechamento;
    }

    public void setNivelUrgencia(Integer nivelurgencia){
        this.nivelUrgencia = nivelUrgencia;
    }
    public void setAssunto(String assunto){
        this.assunto = assunto;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


    public void setStatusChamadoid(Integer statuschamadoid) {
    }


}

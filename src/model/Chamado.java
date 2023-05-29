package model;


import java.io.ObjectInputFilter.Status;
import java.sql.Date;

public class Chamado<Urgencia> {
    private int pk_id;
    private Usuario usuario;
    private Departamento departamento;
    private Usuario responsavel;
    private NivelUrgencia nivelUrgencia;
    private StatusChamado statusChamado;
    Date dataAbertura, dataPrazo, dataFechamento;
    String assunto, descricao;

    //CONSTRUTORES
    public Chamado(int pk_id, Usuario usuario, Departamento departamento, Usuario responsavel, NivelUrgencia nivelUrgencia , StatusChamado statusChamado, Date dataAbertura, Date dataPrazo, Date dataFechamento, String assunto, String descricao){

        this.pk_id = pk_id;
        this.usuario = usuario;
        this.departamento = departamento;
        this.responsavel = responsavel;
        this.nivelUrgencia = nivelUrgencia;
        this.statusChamado = statusChamado;
        this.dataAbertura = dataAbertura;
        this.dataPrazo = dataPrazo;
        this.dataFechamento = dataFechamento;
        this.assunto = assunto;
        this.descricao = descricao;

    }


    public Chamado(Usuario usuario, Departamento departamento, Usuario responsavel, NivelUrgencia nivelUrgencia , StatusChamado statusChamado, Date dataAbertura, Date dataPrazo, Date dataFechamento, String assunto, String descricao){
        this.usuario = usuario;
        this.departamento = departamento;
        this.responsavel = responsavel;
        this.nivelUrgencia = nivelUrgencia;
        this.statusChamado = statusChamado;
        this.dataAbertura = dataAbertura;
        this.dataPrazo = dataPrazo;
        this.dataFechamento = dataFechamento;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    public Chamado(){
    }



    //GETTERS
    public int getPk_id(){
        return this.pk_id;
    }
    public Usuario getUsuario(){
        return this.usuario;
    }
    public Departamento getDepartamento(){
        return this.departamento;
    }
    public Usuario getResponsavel(){
        return this.responsavel;
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
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    public void setDepartamento(){
        this.departamento = departamento;
    }
    public void setResponsavel(Usuario responsavel){
        this.responsavel = responsavel;
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

    public void setNivelUrgencia(NivelUrgencia nivelUrgencia){
        this.nivelUrgencia = nivelUrgencia;
    }
    public void setAssunto(String assunto){
        this.assunto = assunto;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


    public void setUsuario() {
    }


    public void setNivelUrgencia() {
    }


    public void setResponsavel() {
    }




}

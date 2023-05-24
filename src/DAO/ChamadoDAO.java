package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Chamado;
import model.StatusChamado;

public class ChamadoDAO {
    
    public boolean retrieveAll() throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT * FROM mydb.Chamados");

        ResultSet rst = stm.getResultSet();

        ArrayList<Chamado> usuarios = new ArrayList<Chamado>();
        

        while(rst.next()){
            Integer pkid = rst.getInt("pk_id");
            
            Integer usuarioidabriu = rst.getInt("usuarioidabriu");

            Integer departamentoid = rst.getInt("departamentoid");
            
            Integer statuschamadoid = rst.getInt("statuschamadoid");

            String assunto = rst.getString("assunto");

            String descricao = rst.getString("descricao");

            Date dataabertura = rst.getDate("dataabertura");

            Date dataprazo = rst.getDate("dataprazo");

            Date datafechamamento = rst.getDate("datafechamento");

            Integer nivelurgenciaid = rst.getInt("urgenciaid");

            Integer usuarioidassumiu = rst.getInt("usuarioidassumiu");


         

            // System.out.println(pkid + " Nome: " + nome + " Sobrenome: " + sobrenome + " Email: " + email + " Perfil Usuario: " + perfilUsuario + " DepartamentoId: " + departamentoId);

            Chamado chamado = new Chamado(usuarioidabriu, departamentoid, statuschamadoid, assunto, descricao, dataabertura,dataprazo, datafechamamento, nivelurgenciaid,usuarioidassumiu);

            usuarios.add(chamado);
        }

        connection.close();
        return resultado;
    }

    public Chamado retrieve(Integer id) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT * FROM mydb.chamados WHERE pk_id = " + id);

        ResultSet rst = stm.getResultSet();
        Chamado chamado = new Chamado();

        while(rst.next()){
            while(rst.next()){
                Integer pkid = rst.getInt("pk_id");
            
            Integer usuarioidabriu = rst.getInt("usuarioidabriu");

            Integer departamentoid = rst.getInt("departamentoid");
            
            Integer statuschamadoid = rst.getInt("statuschamadoid");

            String assunto = rst.getString("assunto");

            String descricao = rst.getString("descricao");

            Date dataabertura = rst.getDate("dataabertura");

            Date dataprazo = rst.getDate("dataprazo");

            Date datafechamamento = rst.getDate("datafechamento");

            Integer nivelurgenciaid = rst.getInt("urgenciaid");

            Integer usuarioidassumiu = rst.getInt("usuarioidassumiu");



                // System.out.println(pkid + " Nome: " + nome + " Sobrenome: " + sobrenome + " Email: " + email + " Perfil Usuario: " + perfilUsuario + " DepartamentoId: " + departamentoId);

                chamado.setPk_id(pkid);
                chamado.setUsuario();
                chamado.setDepartamento();
                chamado.setStatusChamado(StatusChamado.ABERTO);
                chamado.setAssunto(assunto);
                chamado.setDescricao(descricao);
                chamado.setDataAbertura(dataabertura);
                chamado.setDataPrazo(dataprazo);
                chamado.setDataFechamento(datafechamamento);
                chamado.setNivelUrgencia();
                chamado.setResponsavel();
            }
        }

        connection.close();
        return chamado;
    }

    public static boolean delete(Chamado ChamadoDelete) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "DELETE FROM mydb.chamados WHERE pk_id = ?";
            
        Chamado chamado = new Chamado();

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, ChamadoDelete.getPk_id());
            pstm.execute();
            ResultSet prst = pstm.getResultSet();


            return pstm.execute();
        }
    }
        
    
    public static boolean update(Chamado ChamadoUpdate) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "UPDATE mydb.chamados SET nome = ?, sobrenome = ?, email = ?, perfilusuario = ?, senha = ?, departamentoid = ?  WHERE pk_id = ?";
            
        Chamado chamado = new Chamado();

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(7, ChamadoUpdate.getPk_id());

            pstm.setInt(1, chamado.getUsuario().getPk_id());
            pstm.setInt(2, chamado.getDepartamento().getId());
            // pstm.setString(3, chamado.getStatusChamado());
            pstm.setString(1, chamado.getAssunto());
            pstm.setString(2, chamado.getDescricao());
            pstm.setDate(3, chamado.getDataAbertura());
            pstm.setDate(4, chamado.getDataPrazo());
            pstm.setDate(5, chamado.getDataFechamento());
            // pstm.setInt(6, chamado.getNivelUrgencia());
            pstm.setInt(7, chamado.getUsuario().getPk_id());
            // pstm.setInt(6, ChamadoUpdate.getDepartamentoId());
            pstm.execute();
            ResultSet prst = pstm.getResultSet();


            return pstm.execute();
        }
    }

    public static boolean create(Chamado chamado) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "INSERT INTO mydb.chamados (usuarioidabriu, departamentoid, statuschamadoid, assunto, descricao, dataabertura, dataprazo, datafechamento, nivelurgenciaid, usuarioidassumiu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            
            pstm.setInt(1, chamado.getUsuario().getPk_id());
            pstm.setInt(2, chamado.getDepartamento().getId());
            pstm.setInt(3, chamado.getStatusChamado().ordinal());
            pstm.setString(4, chamado.getAssunto());
            pstm.setString(5, chamado.getDescricao());
            pstm.setDate(6, chamado.getDataAbertura());
            pstm.setDate(7, chamado.getDataPrazo());
            pstm.setInt(8, chamado.getNivelUrgencia().ordinal());
            pstm.setInt(9, chamado.getResponsavel().getPk_id());

            return pstm.execute();
        }
    }
}
    
    
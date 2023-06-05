package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Chamado;
import model.Departamento;
import model.NivelUrgencia;
import model.StatusChamado;
import model.Usuario;

public class ChamadoDAO {

    private Connection connection;

    public ChamadoDAO(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Chamado> retrieveAll() throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT * FROM mydb.Chamados");

        ResultSet rst = stm.getResultSet();

        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        Usuario usuario = new Usuario();
        Usuario responsavel = new Usuario();
        Departamento departamento = new Departamento();

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

            Integer nivelurgenciaid = rst.getInt("nivelurgenciaid");

            Integer usuarioidassumiu = rst.getInt("usuarioidassumiu");


            usuario.setPk_id(usuarioidabriu);
            responsavel.setPk_id(usuarioidassumiu);
            departamento.setId(departamentoid);

            

            Chamado chamado = new Chamado(usuario, departamento, responsavel, NivelUrgencia.values()[nivelurgenciaid - 1], StatusChamado.values()[statuschamadoid - 1], dataabertura, dataprazo, datafechamamento, assunto, descricao);

            System.out.println(chamado.toString());

            chamados.add(chamado);
        }
        
        

        connection.close();
        return chamados;
    }

    public Chamado retrieve(Integer id) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "SELECT * FROM mydb.chamados WHERE pk_id = ?";

        Chamado chamado = new Chamado();

        Usuario usuario = new Usuario();
        Usuario responsavel = new Usuario();
        Departamento departamento = new Departamento();

       try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
        pstm.setInt(1, id);
        pstm.execute();
        ResultSet prst = pstm.getResultSet();

            while(prst.next()){
                Integer pkid = prst.getInt("pk_id");
            
                Integer usuarioidabriu = prst.getInt("usuarioidabriu");

                Integer departamentoid = prst.getInt("departamentoid");
                
                Integer statuschamadoid = prst.getInt("statuschamadoid");

                String assunto = prst.getString("assunto");

                String descricao = prst.getString("descricao");

                Date dataabertura = prst.getDate("dataabertura");

                Date dataprazo = prst.getDate("dataprazo");

                Date datafechamamento = prst.getDate("datafechamento");

                Integer nivelurgenciaid = prst.getInt("nivelurgenciaid");

                Integer usuarioidassumiu = prst.getInt("usuarioidassumiu");

                
                usuario.setPk_id(usuarioidabriu);                
                responsavel.setPk_id(usuarioidassumiu);
                departamento.setId(departamentoid);

                chamado.setPk_id(pkid);
                chamado.setUsuario(usuario);
                chamado.setDepartamento(departamento);
                chamado.setStatusChamado(StatusChamado.values()[statuschamadoid - 1]);
                chamado.setAssunto(assunto);
                chamado.setDescricao(descricao);
                chamado.setDataAbertura(dataabertura);
                chamado.setDataPrazo(dataprazo);
                chamado.setDataFechamento(datafechamamento);
                chamado.setNivelUrgencia(NivelUrgencia.values()[nivelurgenciaid - 1]);
                chamado.setResponsavel(responsavel);
                
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
        
    
    public static boolean update(Chamado chamadoUpdate) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "UPDATE mydb.chamados SET usuarioidabriu = ?, departamentoid = ?, statuschamadoid = ?, assunto = ?, descricao = ?, dataabertura = ?, dataprazo = ?, datafechamento = ?, nivelurgenciaid = ?, usuarioidassumiu = ? WHERE pk_id = ?";
            
        Chamado chamado = new Chamado();

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(11, chamadoUpdate.getPk_id());

            pstm.setInt(1, chamadoUpdate.getUsuario().getPk_id());
            pstm.setInt(2, chamadoUpdate.getDepartamento().getId());
            pstm.setInt(3, chamadoUpdate.getStatusChamado().ordinal());
            pstm.setString(4, chamadoUpdate.getAssunto());
            pstm.setString(5, chamadoUpdate.getDescricao());
            pstm.setDate(6, chamadoUpdate.getDataAbertura());
            pstm.setDate(7, chamadoUpdate.getDataPrazo());
            pstm.setDate(8, chamadoUpdate.getDataFechamento());
            pstm.setInt(9, chamadoUpdate.getNivelUrgencia().ordinal());
            pstm.setInt(10, chamadoUpdate.getResponsavel().getPk_id());
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
            pstm.setDate(8, chamado.getDataFechamento());
            pstm.setInt(9, chamado.getNivelUrgencia().ordinal());
            pstm.setInt(10, chamado.getResponsavel().getPk_id());
           

            return pstm.execute();
        }
    }


    /*SELECTS*/
    public ArrayList<Chamado> buscaPorSetor(Departamento departamento) throws SQLException{

        ArrayList<Chamado> chamados = new ArrayList<Chamado>();


        //passar json no return
        return chamados;
    }

    public int numChamadosPorStatus(StatusChamado status) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "SELECT count(*) from mydb.chamados WHERE statuschamadoid = ?";

        Chamado chamado = new Chamado();

        int numChamados = 0;
        //where setor e where status,
        //group by data

        return numChamados;
    }


//     /*Chamados por status*/
// select count(*) from mydb.chamados
// where statuschamadoid = 1

// /*Chamados por data de abertura agrupado por status*/
// select count(*), statuschamadoid from mydb.chamados
// where dataabertura = '2023-05-03'
// group by statuschamadoid


// /*Chamados por status agrupado por data*/
// select count(*), dataabertura from mydb.chamados
// where statuschamadoid = 1
// group by dataabertura


// CriarConexao criarConexao = new CriarConexao();
//         Connection connection = criarConexao.recuperarConexao();

//         String sql = "SELECT * FROM mydb.chamados WHERE pk_id = ?";

//         Chamado chamado = new Chamado();

//         Usuario usuario = new Usuario();
//         Usuario responsavel = new Usuario();
//         Departamento departamento = new Departamento();

//        try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
//         pstm.setInt(1, id);
//         pstm.execute();
//         ResultSet prst = pstm.getResultSet();

//             while(prst.next()){
//                 Integer pkid = prst.getInt("pk_id");
            
//                 Integer usuarioidabriu = prst.getInt("usuarioidabriu");

//                 Integer departamentoid = prst.getInt("departamentoid");
                
//                 Integer statuschamadoid = prst.getInt("statuschamadoid");

//                 String assunto = prst.getString("assunto");

//                 String descricao = prst.getString("descricao");

//                 Date dataabertura = prst.getDate("dataabertura");

//                 Date dataprazo = prst.getDate("dataprazo");

//                 Date datafechamamento = prst.getDate("datafechamento");

//                 Integer nivelurgenciaid = prst.getInt("nivelurgenciaid");

//                 Integer usuarioidassumiu = prst.getInt("usuarioidassumiu");

                
//                 usuario.setPk_id(usuarioidabriu);                
//                 responsavel.setPk_id(usuarioidassumiu);
//                 departamento.setId(departamentoid);

//                 chamado.setPk_id(pkid);
//                 chamado.setUsuario(usuario);
//                 chamado.setDepartamento(departamento);
//                 chamado.setStatusChamado(StatusChamado.values()[statuschamadoid - 1]);
//                 chamado.setAssunto(assunto);
//                 chamado.setDescricao(descricao);
//                 chamado.setDataAbertura(dataabertura);
//                 chamado.setDataPrazo(dataprazo);
//                 chamado.setDataFechamento(datafechamamento);
//                 chamado.setNivelUrgencia(NivelUrgencia.values()[nivelurgenciaid - 1]);
//                 chamado.setResponsavel(responsavel);
                
//             }
       
//         }

//         connection.close();
//         return chamado;
// // /**/






}
    
    
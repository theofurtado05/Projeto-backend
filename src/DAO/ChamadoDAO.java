package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Chamado;

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

            // PerfilUsuario perfilUsuario = null;

            // switch(perfilUsuarioId){
            //     case 1:
            //         perfilUsuario = PerfilUsuario.ADMIN;
            //         break;
            //     case 2:
            //         perfilUsuario = PerfilUsuario.GESTORCOMERCIAL;
            //         break;
            //     case 3:
            //         perfilUsuario = PerfilUsuario.GESTOROPERACIONAL;
            //         break;
            //     case 4:
            //         perfilUsuario = PerfilUsuario.ANALISTACOMERCIAL;
            //         break;
            //     case 5:
            //         perfilUsuario = PerfilUsuario.ANALISTAOPERACAO;
            //         break;
            //     case 6:
            //         perfilUsuario = PerfilUsuario.ANALISTATI;
            //         break;
            //     default:
            //         break;
            // }


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

        boolean resultado = stm.execute("SELECT * FROM mydb.usuarios WHERE pk_id = " + id);

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
                chamado.setUsuarioAbriuId(usuarioidabriu);
                chamado.setDepartamentoId(departamentoid);
                chamado.setStatusChamadoid(statuschamadoid);
                chamado.setAssunto(assunto);
                chamado.setDescricao(descricao);
                chamado.setDataAbertura(dataabertura);
                chamado.setDataPrazo(dataprazo);
                chamado.setDataFechamento(datafechamamento);
                chamado.setNivelUrgencia(nivelurgenciaid);
                chamado.setUsuarioAssumiuId(usuarioidassumiu);
            }
        }

        connection.close();
        return chamado;
    }

    // public static boolean create(Chamado chamado) throws SQLException{
    //     CriarConexao criarConexao = new CriarConexao();
    //     Connection connection = criarConexao.recuperarConexao();

    //     String sql = "INSERT INTO mydb.usuarios (nome, sobrenome, email, perfilusuario, senha, departamentoid) VALUES (?, ?, ?, ?, ?, ?)";
            
    //     int perfilUsuarioInt = 0;

    //    switch(usuario.getPerfilUsuario()){
    //         case ADMIN:
    //             perfilUsuarioInt = 1;
    //             break;
            
    //         case GESTORCOMERCIAL:
    //             perfilUsuarioInt = 2;
    //             break;

    //         case GESTOROPERACIONAL:
    //             perfilUsuarioInt = 3;
    //             break;

    //         case ANALISTACOMERCIAL:
    //             perfilUsuarioInt = 4;
    //             break;

    //         case ANALISTAOPERACAO:
    //             perfilUsuarioInt = 5;
    //             break;

    //         case ANALISTATI:
    //             perfilUsuarioInt = 6;
    //             break;

    //         default:
    //             perfilUsuarioInt = 0;
    //             break;
    //    }


        // try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            
        //     pstm.setString(1, usuario.getNome());
        //     pstm.setString(2, usuario.getSobrenome());
        //     pstm.setString(3, usuario.getEmail());
        //     pstm.setInt(4, perfilUsuarioInt);
        //     pstm.setString(5, usuario.getSenha());
        //     pstm.setInt(6, usuario.getDepartamentoId());

        //     return pstm.execute();
        }
    // }

// }

package DAO;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.PerfilUsuario;
import model.Usuario;

public class UsuariosDAO {
    
    ArrayList<Usuario> retrieveAll() throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT nome, sobrenome FROM mydb.usuarios");

        ResultSet rst = stm.getResultSet();

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        

        while(rst.next()){
            Integer pkid = rst.getInt("pk_id");
            
            String nome = rst.getString("nome");
            String sobrenome = rst.getString("sobrenome");
            
            String email = rst.getString("email");

            Integer perfilUsuarioId = rst.getInt("perfilusuario");

            Integer departamentoId = rst.getInt("departamentoid");

            PerfilUsuario perfilUsuario = null;

            switch(perfilUsuarioId){
                case 1:
                    perfilUsuario = PerfilUsuario.ADMIN;
                    break;
                case 2:
                    perfilUsuario = PerfilUsuario.GESTORCOMERCIAL;
                    break;
                case 3:
                    perfilUsuario = PerfilUsuario.GESTOROPERACIONAL;
                    break;
                case 4:
                    perfilUsuario = PerfilUsuario.ANALISTACOMERCIAL;
                    break;
                case 5:
                    perfilUsuario = PerfilUsuario.ANALISTAOPERACAO;
                    break;
                case 6:
                    perfilUsuario = PerfilUsuario.ANALISTATI;
                    break;
                default:
                    break;
            }


            System.out.println(pkid + " Nome: " + nome + " Sobrenome: " + sobrenome + " Email: " + email + " Perfil Usuario: " + perfilUsuario + " DepartamentoId: " + departamentoId);

            Usuario usuario = new Usuario(pkid, departamentoId, perfilUsuario, nome, sobrenome, email);

            usuarios.add(usuario);

        }

        connection.close();
        return usuarios;
    }

    Usuario retrieve(Integer id) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT nome FROM mydb.usuarios WHERE pk_id = 1");

        ResultSet rst = stm.getResultSet();
        Usuario usuario = new Usuario();

        while(rst.next()){
            while(rst.next()){
                Integer pkid = rst.getInt("pk_id");
                String nome = rst.getString("nome");
                String sobrenome = rst.getString("sobrenome");
                
                String email = rst.getString("email");

                Integer perfilUsuarioId = rst.getInt("perfilusuario");

                Integer departamentoId = rst.getInt("departamentoid");

                PerfilUsuario perfilUsuario = null;

                switch(perfilUsuarioId){
                    case 1:
                        perfilUsuario = PerfilUsuario.ADMIN;
                        break;
                    case 2:
                        perfilUsuario = PerfilUsuario.GESTORCOMERCIAL;
                        break;
                    case 3:
                        perfilUsuario = PerfilUsuario.GESTOROPERACIONAL;
                        break;
                    case 4:
                        perfilUsuario = PerfilUsuario.ANALISTACOMERCIAL;
                        break;
                    case 5:
                        perfilUsuario = PerfilUsuario.ANALISTAOPERACAO;
                        break;
                    case 6:
                        perfilUsuario = PerfilUsuario.ANALISTATI;
                        break;
                    default:
                        break;
                }


                System.out.println(pkid + " Nome: " + nome + " Sobrenome: " + sobrenome + " Email: " + email + " Perfil Usuario: " + perfilUsuario + " DepartamentoId: " + departamentoId);

                usuario.setPk_id(pkid);
                usuario.setNome(nome);
                usuario.setSobrenome(sobrenome);
                usuario.setEmail(email);
                usuario.setPerfilUsuario(perfilUsuario);
                usuario.setDepartamentoId(departamentoId);

            }
        }

        connection.close();
        return usuario;
    }

    static boolean create(String nome, String sobrenome, String email, int perfilUsuarioId, int departamentoId) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();

        stm.execute("INSERT INTO mydb.usuarios VALUES (5, " + "'" + nome + "', '"  + sobrenome +  "', '" + email + "'," + perfilUsuarioId + "," + departamentoId + '"');

        ResultSet rst = stm.getGeneratedKeys();

        while(rst.next()){
            Integer pkid = rst.getInt(4);
            String nomeRecebido = rst.getString("nome");
            String sobrenomeRecebido = rst.getString("sobrenome");
            String emailRecebido = rst.getString("email");
            System.out.println(nomeRecebido + sobrenomeRecebido + emailRecebido);
        }

        connection.close();
        return true;
    }

}

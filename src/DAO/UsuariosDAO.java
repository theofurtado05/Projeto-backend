package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.PerfilUsuario;
import model.Usuario;

public class UsuariosDAO {
    
    public ArrayList<Usuario> retrieveAll() throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT * FROM mydb.usuarios");

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

    public Usuario retrieve(Integer id) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT * FROM mydb.usuarios WHERE pk_id = " + id);

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

    public static boolean create(Usuario usuario) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "INSERT INTO mydb.usuarios (nome, sobrenome, email, perfilusuario, senha, departamentoid) VALUES (?, ?, ?, ?, ?, ?)";
            
        int perfilUsuarioInt = 0;

       switch(usuario.getPerfilUsuario()){
            case ADMIN:
                perfilUsuarioInt = 1;
                break;
            
            case GESTORCOMERCIAL:
                perfilUsuarioInt = 2;
                break;

            case GESTOROPERACIONAL:
                perfilUsuarioInt = 3;
                break;

            case ANALISTACOMERCIAL:
                perfilUsuarioInt = 4;
                break;

            case ANALISTAOPERACAO:
                perfilUsuarioInt = 5;
                break;

            case ANALISTATI:
                perfilUsuarioInt = 6;
                break;

            default:
                perfilUsuarioInt = 0;
                break;
       }


        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSobrenome());
            pstm.setString(3, usuario.getEmail());
            pstm.setInt(4, perfilUsuarioInt);
            pstm.setString(5, usuario.getSenha());
            pstm.setInt(6, usuario.getDepartamentoId());

            return pstm.execute();
        }
    }

}

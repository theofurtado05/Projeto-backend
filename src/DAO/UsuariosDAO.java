package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Departamento;
import model.PerfilUsuario;
import model.Usuario;

public class UsuariosDAO {
    
    public ArrayList<Usuario> retrieveAll() throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM mydb.usuarios");
        ResultSet rst = stm.getResultSet();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Departamento departamento = new Departamento();
        
        while(rst.next()){
            Integer pkid = rst.getInt("pk_id");
            String nome = rst.getString("nome");
            String sobrenome = rst.getString("sobrenome");
            String email = rst.getString("email");
            Integer perfilUsuarioId = rst.getInt("perfilusuario");
            String senha = rst.getString("senha");
            Integer departamentoId = rst.getInt("departamentoid");

            departamento.setId(departamentoId);


            PerfilUsuario perfilUsuario = PerfilUsuario.values()[perfilUsuarioId];


            Usuario usuario = new Usuario(nome, sobrenome, email, perfilUsuario, senha, departamento);
            usuarios.add(usuario);

            System.out.println(pkid + " Nome: " + nome + " Sobrenome: " + sobrenome + " Email: " + email + " Perfil Usuario: " + perfilUsuario + " DepartamentoId: " + departamento.getId());

        }
            connection.close();
            return usuarios;
        }

    

    public Usuario retrieve(Integer id) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        

        String sql = "SELECT * FROM mydb.usuarios WHERE pk_id = ?";

        Usuario usuario = new Usuario();

        Departamento departamento = new Departamento();
        

        try(PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, id);
            pstm.execute();
            ResultSet prst = pstm.getResultSet();

            
                while(prst.next()){
                    Integer pkid = prst.getInt("pk_id");
                    String nome = prst.getString("nome");
                    String sobrenome = prst.getString("sobrenome");
                    
                    String email = prst.getString("email");
    
                    Integer perfilUsuarioId = prst.getInt("perfilusuario");
    
                    Integer departamentoId = prst.getInt("departamentoid");
                    
                    departamento.setId(departamentoId);

                    
                    PerfilUsuario perfilUsuario = PerfilUsuario.values()[perfilUsuarioId];

                    System.out.println(pkid + " Nome: " + nome + " Sobrenome: " + sobrenome + " Email: " + email + " Perfil Usuario: " + perfilUsuario + " DepartamentoId: " + departamentoId);
    
                    usuario.setPk_id(pkid);
                    usuario.setNome(nome);
                    usuario.setSobrenome(sobrenome);
                    usuario.setEmail(email);
                    usuario.setPerfilUsuario(perfilUsuario);
                    usuario.setDepartamento(departamento);
    
                
            }

            
        }

        connection.close();
        return usuario;
    }

    public static boolean create(Usuario usuario) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "INSERT INTO mydb.usuarios (nome, sobrenome, email, perfilusuario, senha, departamentoid) VALUES (?, ?, ?, ?, ?, ?)";
            

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSobrenome());
            pstm.setString(3, usuario.getEmail());
            pstm.setInt(4, usuario.getPerfilUsuario().ordinal() - 1);
            pstm.setString(5, usuario.getSenha());
            pstm.setInt(6, usuario.getDepartamento().getId());

            return pstm.execute();
        }
    }


    public static boolean update(Usuario usuarioUpdate) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "UPDATE mydb.usuarios SET nome = ?, sobrenome = ?, email = ?, perfilusuario = ?, senha = ?, departamentoid = ?  WHERE pk_id = ?";
            
        Usuario usuario = new Usuario();

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(7, usuarioUpdate.getPk_id());

            pstm.setString(1, usuarioUpdate.getNome());
            pstm.setString(2, usuarioUpdate.getSobrenome());
            pstm.setString(3, usuarioUpdate.getEmail());
            pstm.setInt(4, usuarioUpdate.getPerfilUsuario().ordinal() - 1); //Menos um para igualar ao indice do banco de dados
            pstm.setString(5, usuarioUpdate.getSenha());
            pstm.setInt(6, usuarioUpdate.getDepartamento().getId());
            pstm.execute();
            ResultSet prst = pstm.getResultSet();


            return pstm.execute();
        }
    }

    public static boolean delete(Usuario usuarioDelete) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();

        String sql = "DELETE FROM mydb.usuarios WHERE pk_id = ?";
            
        Usuario usuario = new Usuario();

        try (PreparedStatement pstm = (PreparedStatement) connection.prepareStatement(sql)){
            pstm.setInt(1, usuarioDelete.getPk_id());
            pstm.execute();
            ResultSet prst = pstm.getResultSet();


            return pstm.execute();
        }
    }

}

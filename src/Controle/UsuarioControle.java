package Controle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CriarConexao;
import DAO.UsuariosDAO;
import model.Usuario;

public class UsuarioControle {

    private Connection connection;

    public UsuarioControle(Connection connection) throws SQLException{
        CriarConexao conexao = new CriarConexao();
        this.connection = conexao.recuperarConexao();
    }

    public ArrayList<Usuario> getTodosUsuarios() throws SQLException{
        UsuariosDAO uDao = new UsuariosDAO();
        return uDao.retrieveAll();
    }

    public Usuario getUsuarioId(Integer id) throws SQLException{
        UsuariosDAO uDao = new UsuariosDAO();
        return uDao.retrieve(id);
    }

    public boolean postCreateUsuario(Usuario usuario) throws SQLException{
        UsuariosDAO uDao = new UsuariosDAO();
        uDao.create(usuario);
        System.out.println("Usuario criado com sucesso!");
        return true;
    }

    public boolean postUpdateUsuario(Usuario usuario) throws SQLException{
        UsuariosDAO uDao = new UsuariosDAO();
        uDao.update(usuario);
        System.out.println("Usuario atualizado com sucesso!");
        return true;
    }

    public boolean deleteUsuario(Usuario usuario) throws SQLException{
        UsuariosDAO uDao = new UsuariosDAO();
        uDao.delete(usuario);
        System.out.println("Usuario deletado com sucesso!");
        return true;
    }
}

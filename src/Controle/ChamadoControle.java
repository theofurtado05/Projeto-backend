package Controle;

import java.sql.Connection;

import DAO.ChamadoDAO;
import DAO.CriarConexao;
import model.Chamado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoControle {

    private Connection connection;

    public ChamadoControle(Connection connection) throws SQLException{
        CriarConexao conexao = new CriarConexao();
        this.connection = conexao.recuperarConexao();   
    }

    //RetrieveAll
    public ArrayList<Chamado> getTodosChamados() throws SQLException{

        ChamadoDAO cDao = new ChamadoDAO();
        return cDao.retrieveAll();
    }

    //Retrieve
    
    //Create
    //Update
    //Delete
    //Outros selects
    


}

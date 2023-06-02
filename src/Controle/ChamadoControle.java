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


    public ArrayList<Chamado> getTodosChamados() throws SQLException{

        ChamadoDAO cDao = new ChamadoDAO();
        return cDao.retrieveAll();
    }


    public Chamado getChamadoId(Integer id) throws SQLException{

        ChamadoDAO cDao = new ChamadoDAO();
        return cDao.retrieve(id);
    }
    
    public boolean createChamado(Chamado chamado) throws SQLException{
        ChamadoDAO cDao = new ChamadoDAO();
        cDao.create(chamado);
        System.out.println("Chamado criado com sucesso!");
        return true;
    }

    public boolean updateChamado(Chamado chamado) throws SQLException{
        ChamadoDAO cDao = new ChamadoDAO();
        cDao.update(chamado);
        System.out.println("Chamado atualizado com sucesso!");
        return true;
    }

    public boolean deleteChamado(Chamado chamado) throws SQLException{
        ChamadoDAO cDao = new ChamadoDAO();
        cDao.delete(chamado);
        System.out.println("Chamado deletado com sucesso!");
        return true;
    }


    //Outros selects
    


}

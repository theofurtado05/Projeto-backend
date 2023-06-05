package Controle;

import java.sql.Connection;

import DAO.ChamadoDAO;
import DAO.CriarConexao;
import model.Chamado;
import model.StatusChamado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChamadoControle {

    private ChamadoDAO chamadoDAO;

    public ChamadoControle() throws SQLException{
        CriarConexao conexao = new CriarConexao();
        Connection connection = conexao.recuperarConexao(); 
        this.chamadoDAO = new ChamadoDAO(connection);  
    }


    public ArrayList<Chamado> getTodosChamados() throws SQLException{

        return this.chamadoDAO.retrieveAll();
    }


    public Chamado getChamadoId(Integer id) throws SQLException{

      
        return this.chamadoDAO.retrieve(id);
    }
    
    public boolean createChamado(Chamado chamado) throws SQLException{

        this.chamadoDAO.create(chamado);
        System.out.println("Chamado criado com sucesso!");
        return true;
    }

    public boolean updateChamado(Chamado chamado) throws SQLException{
        
        this.chamadoDAO.update(chamado);
        System.out.println("Chamado atualizado com sucesso!");
        return true;
    }

    public boolean deleteChamado(Chamado chamado) throws SQLException{
     
        this.chamadoDAO.delete(chamado);
        System.out.println("Chamado deletado com sucesso!");
        return true;
    }


    //Outros selects
    public int getNumChamadosPorStatus(StatusChamado status) throws SQLException{
        return chamadoDAO.numChamadosPorStatus(status);
    }
    


}

package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Departamento;



public class DepartamentoDAO {

    ArrayList<Departamento> retrieveAll() throws SQLException{

        CriarConexao CriaConexao = new CriarConexao();

        Connection connection = CriaConexao.recuperarConexao();

        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT nome FROM mydb.departamento");

        ResultSet rst = stm.getResultSet();

        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

        while(rst.next()){
            Integer id = rst.getInt("pk_id");
            System.out.println(id);
            String nomeDepartamento = rst.getString("nome");
            System.out.println(nomeDepartamento);
            Departamento d = new Departamento(id, nomeDepartamento);

            departamentos.add(d);
        }

        connection.close();
        return departamentos;
    }

    Departamento retrieve(Integer id) throws SQLException{
        CriarConexao criarConexao = new CriarConexao();

        Connection connection = criarConexao.recuperarConexao();

        Statement stm = connection.createStatement();

        boolean resultado = stm.execute("SELECT nome FROM mydb.departamento WHERE pk_id = " + id + "");

        ResultSet rst = stm.getResultSet();
        Departamento departamento = new Departamento();

        while(rst.next()){
            while(rst.next()){
                Integer pkId = rst.getInt("pk_id");
                System.out.println(id);
                String nomeDepartamento = rst.getString("nome");
                System.out.println(nomeDepartamento);
                departamento.setId(pkId);
                departamento.setNome(nomeDepartamento);
            }
        }

        connection.close();
        return departamento;
    }
}

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaListagem {

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        CriarConexao criarConexao = new CriarConexao();

        Connection connection = criarConexao.recuperarConexao();

        Statement stm = connection.createStatement();
        boolean resultado = stm.execute("Select * from mydb.usuarios");
        ResultSet rst = stm.getResultSet();
        
        while(rst.next()){
            Integer id = rst.getInt("pk_id");
            System.out.println(id);
        }
        connection.close();

    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {

    

    public Connection recuperarConexao() throws SQLException{
   

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoBackEnd", "postgres", "0507");

        return connection;
    }   
}


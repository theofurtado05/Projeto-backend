import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {

        Connection conn = null;
        try {
            // Registra o driver JDBC para o PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Cria a conexão com o banco de dados
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb", "myuser", "mypassword");

            System.out.println("Conexão estabelecida com sucesso.");
        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possível encontrar o driver.");
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Não foi possível fechar a conexão.");
            }
        }
        //Criando departamentos
        Departamento dptoTi = new Departamento(1, "TI");
        Departamento dptoOperacao = new Departamento(2, "Operação");
        Departamento dptoComercial = new Departamento(3, "Comercial");

        //Criando usuarios
     
       
        //Criando Funcionarios
        //...
    }
}

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import Controle.ChamadoControle;
import Controle.UsuarioControle;
import DAO.ChamadoDAO;
import DAO.CriarConexao;
import DAO.UsuariosDAO;
import model.Chamado;
import model.Departamento;
import model.NivelUrgencia;
import model.PerfilUsuario;
import model.StatusChamado;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
       
        ChamadoControle cControle = new ChamadoControle(connection);
        UsuarioControle uControle = new UsuarioControle(connection);

        Departamento departamento = new Departamento(3,"TI");

        Usuario usuario = new Usuario(32, "Heitor", "Mauricio", "heitorfurtado05@gmail.com", PerfilUsuario.ADMIN, "123", departamento);

        System.out.println(uControle.deleteUsuario(usuario));
       

    }
}

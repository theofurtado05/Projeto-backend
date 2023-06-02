import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import Controle.ChamadoControle;
import DAO.ChamadoDAO;
import DAO.CriarConexao;
import DAO.UsuariosDAO;
import model.Chamado;
import model.NivelUrgencia;
import model.PerfilUsuario;
import model.StatusChamado;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {

        CriarConexao criarConexao = new CriarConexao();
        Connection connection = criarConexao.recuperarConexao();
       
        ChamadoControle cControle = new ChamadoControle(connection);
        System.out.println(cControle.getTodosChamados());
       

    }
}

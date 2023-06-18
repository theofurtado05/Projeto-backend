import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
        ChamadoDAO chamadoDAO = new ChamadoDAO(connection);
        Usuario usuario = new Usuario(2);
        Usuario responsavel = new Usuario(3);
        Departamento departamento = new Departamento(1, "Comercial");
        Chamado chamado = new Chamado(24, usuario, departamento, responsavel, NivelUrgencia.ALTO, StatusChamado.PENDENTE, new Date(0), null, null, "Testando em apresentaçao", "Estamos fazendo esses testes para a apresentaçao de amanha!");

        
        
       

    }
}

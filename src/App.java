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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataabertura = new Date(05/06/2023);
        Date dataprazo = new Date(8/06/2023);
        Date datafechamento = new Date(07/06/2023);
       
        ChamadoControle cControle = new ChamadoControle(connection);
        UsuarioControle uControle = new UsuarioControle(connection);

        Departamento departamento = new Departamento(3,"TI");

        Usuario usuario = new Usuario(10);

        Usuario responsavel = new Usuario(11);

        

        Chamado chamado = new Chamado(24,usuario, departamento, responsavel, NivelUrgencia.BAIXO, StatusChamado.PENDENTE, dataabertura, dataprazo, datafechamento, "Testando controles 2", "Esse controle de criar chamado esta funcionando.");

        System.out.println(cControle.deleteChamado(chamado));
       

    }
}

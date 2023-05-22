import java.sql.Date;
import java.time.LocalDate;

import DAO.ChamadoDAO;
import DAO.UsuariosDAO;
import model.Chamado;
import model.NivelUrgencia;
import model.PerfilUsuario;
import model.StatusChamado;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        // UsuariosDAO usuarioDao = new UsuariosDAO();
        // Usuario usuario1 = new Usuario(25,"Talita", "Ribeiro", "talit2a@ibmec.com", PerfilUsuario.ANALISTATI, "abc", 1);
        //System.out.println(PerfilUsuario.ANALISTATI.ordinal());
        Date abertura = null;
        Date prazo = null;
        Date fechamento = null;

        ChamadoDAO chamadoDAO = new ChamadoDAO();
        Chamado chamado1 = new Chamado(1, 2, StatusChamado.ABERTO.ordinal(), "MANUTENCAO TESTE", "TESTANDO ESSA MANUTENCAO SEM PENSAR NO AMANHA", null, null, null, NivelUrgencia.ALTO.ordinal(), 3);


        chamadoDAO.create(chamado1);
       

    }
}

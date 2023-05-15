import DAO.UsuariosDAO;
import model.PerfilUsuario;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        UsuariosDAO usuarioDao = new UsuariosDAO();
        Usuario usuario1 = new Usuario("Talita", "Soares", "talita@ibmec.com", PerfilUsuario.ANALISTATI, "abc", 1);

        usuarioDao.retrieveAll();

        //usuarioDao.create(usuario1);
    }
}

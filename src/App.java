import DAO.UsuariosDAO;
import model.PerfilUsuario;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        UsuariosDAO usuarioDao = new UsuariosDAO();
        Usuario usuario1 = new Usuario(1, PerfilUsuario.ADMIN, "Theo", "Furtado", "theo.furtado@gmail.com", "123");

        usuarioDao.create(usuario1);
    }
}

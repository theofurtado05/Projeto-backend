import DAO.UsuariosDAO;
import model.PerfilUsuario;
import model.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        UsuariosDAO usuarioDao = new UsuariosDAO();
        Usuario usuario1 = new Usuario(24,"Talita", "Ribeiro", "talita@ibmec.com", PerfilUsuario.ANALISTATI, "abc", 1);
        //System.out.println(PerfilUsuario.ANALISTATI.ordinal());
       

        //usuarioDao.create(usuario1);

    }
}

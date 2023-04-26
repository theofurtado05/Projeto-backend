public class App {
    public static void main(String[] args) throws Exception {
        //Criando departamentos
        Departamento dptoTi = new Departamento(1, "TI");
        Departamento dptoOperacao = new Departamento(2, "Operação");
        Departamento dptoCiberSeguranca = new Departamento(3, "CiberSegurança");
        Departamento dptoInfraestrutura = new Departamento(4, "Infraestrutura de Software");
        Departamento dptoComercial = new Departamento(5, "Comercial");

        //Criando usuarios
        Usuario usuario1 = new Usuario(1, "Theofurtado05@gmail.com", "123", "ADMIN");
        Usuario usuario2 = new Usuario(2, "JCurveloSoftware@gmail.com", "abc", "Funcionario");
        Usuario usuario3 = new Usuario(3, "joaopcorreia38@gmail.com", "xyz", "Cliente");

        //Criando Funcionarios
        //...
    }
}

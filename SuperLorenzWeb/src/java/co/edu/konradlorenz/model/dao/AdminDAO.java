package co.edu.konradlorenz.model.dao;

public class AdminDAO {

    public boolean esAdmin(String cargo) {
        // Define los cargos considerados como administradores
        return cargo.equals("GERENTE_GENERAL") || 
               cargo.equals("SUBGERENTE") || 
               cargo.equals("JEFE_DE_RECURSOS_HUMANOS");
    }
}

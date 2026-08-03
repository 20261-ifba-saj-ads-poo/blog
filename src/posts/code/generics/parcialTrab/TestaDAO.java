import java.util.UUID;

public class TestaDAO {
    public static void main(String[] args) {
        GenericDAO<Usuario, UUID> dao = new UsuarioDAO();

        UUID idAna = dao.salvar(new Usuario("Ana", "ana@email.com"));
        dao.salvar(new Usuario("Bruno", "bruno@email.com"));

        Usuario ana = dao.buscarPorId(idAna);
        IO.println("Buscar por id: " + ana);

        ana.setNome("Ana Paula");
        dao.atualizar(ana);

        IO.println("Ordenados por nome:");
        ((UsuarioDAO) dao).buscarOrdenadosPorNome().forEach(IO::println);

        dao.deletar(idAna);
        IO.println("Total após deletar: " + dao.buscarTodos().size());
    }
}

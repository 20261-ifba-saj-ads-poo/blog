import java.util.UUID;

public class IdGenerator {
    public static <ID> ID gerarNovoId(Class<ID> tipoIdClass) {
        if (tipoIdClass == UUID.class) {
            return tipoIdClass.cast(UUID.randomUUID());
        }
        throw new IllegalArgumentException(
            "Tipo de ID não suportado: " + tipoIdClass.getName());
    }
}

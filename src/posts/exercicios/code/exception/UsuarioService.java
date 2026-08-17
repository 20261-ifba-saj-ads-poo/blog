package br.edu.ifba.saj.ads.poo.service;

import java.util.Objects;
import java.util.UUID;

public class UsuarioService extends GenericServiceImpl<Usuario, UUID> {

    private static UsuarioService instance;

    public static UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    private UsuarioService() {
        super(new UsuarioDAO());
    }

    @Override
    public void validar(Usuario entidade) throws RegraDeNegocioException {
        if (entidade.getNome() == null || entidade.getNome().trim().isEmpty()) {
            throw new RegraDeNegocioException("O nome do usuário é obrigatório.");
        }
        if (entidade.getEmail() == null || !entidade.getEmail().contains("@")) {
            throw new RegraDeNegocioException("E-mail inválido.");
        }
        if (entidade.getSenha() == null || entidade.getSenha().length() < 3) {
            throw new RegraDeNegocioException("A senha deve ter pelo menos 3 caracteres.");
        }

        // Valida se o email já existe no cadastro
        boolean emailExiste = buscarTodos().stream()
                .anyMatch(u -> u.getEmail().equals(entidade.getEmail()) && !u.getId().equals(entidade.getId()));

        if (emailExiste) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este e-mail.");
        }
    }

    public Usuario autenticar(String email, String senha) throws AutenticacaoInvalidaException {
        if(Objects.isNull(email) || email.isEmpty() || email.isBlank()){
            throw new IllegalArgumentException("Email não pode ser null");
        }
        if(Objects.isNull(senha) || senha.isEmpty() || senha.isBlank()){
            throw new IllegalArgumentException("Senha não pode ser null");
        }
        return buscarTodos().stream()
                .filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha))
                .findFirst()
                .orElseThrow(() -> new AutenticacaoInvalidaException(
                        "Usuario " + email + " não foi encontrado ou a senha está errada"));

    }

}
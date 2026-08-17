package br.edu.ifba.saj.ads.poo.controller;

public class LoginController  {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtSenha;

    @FXML
    void fazerLogin(ActionEvent event) {
        String email = txtUsuario.getText(); // Usando como e-mail
        String senha = txtSenha.getText();

        if (email.isEmpty() || senha.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Aviso", "Preencha o e-mail e a senha.");
            return;
        }

        // Chama a validação
        Usuario usuarioAutenticado;
        try {
            usuarioAutenticado = UsuarioService.getInstance().autenticar(email, senha);
            App.setUsuarioLogado(usuarioAutenticado);
            App.setRoot("menuPrincipal");

        } catch (AutenticacaoInvalidaException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Acesso Negado", e.getMessage());           
        }
            
    }
}
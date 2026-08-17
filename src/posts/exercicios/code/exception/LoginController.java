package br.edu.ifba.saj.ads.poo.controller;

public class LoginController  {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtSenha;

    @FXML
    void fazerLogin(ActionEvent event) {
        try {
            App.setUsuarioLogado(UsuarioService.getInstance().autenticar(txtUsuario.getText(), txtSenha.getText()));
            App.setRoot("menuPrincipal");
        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", e.getMessage());
        } catch (AutenticacaoInvalidaException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Acesso Negado", e.getMessage());
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Erro", "Não foi possível carregar o sistema.");
        }

    }
}
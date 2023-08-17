package view;

import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class LoginScreen {
    private Label title;
    private TextField userField;
    private PasswordField pswField;
    private Button signBtn;
    private VBox box;
    private UserController userController;

    private Scene scene;

    public LoginScreen(){
        userController = new UserController();
        initComponents();
    }

    public void initComponents(){
        title = new Label();
        title.setText("Bem vindo à Loja da Dona Benta");

        userField = new TextField();
        userField.setPromptText("Usuário");

        pswField = new PasswordField();
        pswField.setPromptText("Senha");

        signBtn = new Button("Entrar");
        signBtn.setOnAction(e->{
            if(userController.read(userField.getText(),pswField.getText())){
                System.out.println("Welcome!");
            }
        });

        box = new VBox();
        box.getChildren().addAll(title, userField, pswField, signBtn);

        scene = new Scene(box);
    }

    public Scene getScene(){
        return scene;
    }
}

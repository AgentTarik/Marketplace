package view;

import controller.UserController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScreen {
    private Label title;
    private TextField userField;
    private PasswordField pswField;
    private Button signBtn,registerBtn;
    private VBox box1,box2;
    private HBox box3;
    //private Home home;
    private BLobby bLobby;
    private SLobby sLobby;
    private SignUpScreen signUpScreen;
    private Scene scene;
    private UserController userController;

    public LoginScreen(Stage primaryStage){
        userController = new UserController();
        initComponents(primaryStage);
    }

    public void initComponents(Stage primaryStage){
        title = new Label();
        title.setText("Log In");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));


        userField = new TextField();
        userField.setPromptText("Usuário");
        userField.setMaxWidth(400);
        userField.setAlignment(Pos.CENTER);


        pswField = new PasswordField();
        pswField.setPromptText("Senha");
        pswField.setMaxWidth(400);
        pswField.setAlignment(Pos.CENTER);
        signBtn = new Button("Submit");
        signBtn.setOnAction(e -> {
            if(userController.read(userField.getText(),pswField.getText())){
                System.out.println("Welcome!");
                if(userController.checkType(userField.getText()).equals("Buyer")){
                    bLobby = new BLobby(userField.getText(),primaryStage);
                    primaryStage.setScene(bLobby.getScene());
                }else{
                    sLobby = new SLobby(userField.getText(),primaryStage);
                    primaryStage.setScene(sLobby.getScene());
                }
            }
        });
        registerBtn = new Button("Register");
        registerBtn.setOnAction(event -> {
            signUpScreen = new SignUpScreen(primaryStage);
            primaryStage.setScene(signUpScreen.getScene());
        });


        box1 = new VBox(10);
        box2 = new VBox(10);
        box3 = new HBox(30);

        box2.getChildren().addAll(userField, pswField);


        box3.getChildren().addAll(signBtn,registerBtn);
        box1.getChildren().addAll(title, box2, box3);


        box3.setAlignment(Pos.BASELINE_CENTER);
        box2.setAlignment(Pos.CENTER);
        box1.setAlignment(Pos.CENTER);
        box1.setId("mainBox");

        scene = new Scene(box1);
        scene.getStylesheets().add("style/style.css");



        }
    public Scene getScene() {
        return scene;
    }
}

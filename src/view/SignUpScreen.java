package view;

import controller.UserController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SignUpScreen {
    private String type;
    private Label title;
    private TextField userField;
    private PasswordField pswField1,pswField2;
    private CheckBox check1,check2,check3;
    private Button registerBtn;
    private VBox box1,box2;
    private HBox box3;

    private ALobby alobby;
    private BLobby blobby;
    private SLobby slobby;
    private Scene scene;
    private UserController userController;

    public SignUpScreen(Stage primaryStage){
        userController = new UserController();
        initComponents(primaryStage);
    }

    public void initComponents(Stage primaryStage){
        title = new Label();
        title.setText("Sign Up");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 70));

        userField = new TextField();
        userField.setPromptText("Username");
        userField.setMaxWidth(400);
        userField.setAlignment(Pos.CENTER);

        pswField1 = new PasswordField();
        pswField1.setPromptText("Password");
        pswField1.setMaxWidth(400);
        pswField1.setAlignment(Pos.CENTER);

        pswField2 = new PasswordField();
        pswField2.setPromptText("Confirm Password");
        pswField2.setMaxWidth(400);
        pswField2.setAlignment(Pos.CENTER);

        check1 = new CheckBox("Buyer");
        check1.setOnAction(event -> {
            check2.setSelected(false);
            check3.setSelected(false);
        });

        check2 = new CheckBox("Seller");
        check2.setOnAction(event -> {
            check1.setSelected(false);
            check3.setSelected(false);
        });

        check3 = new CheckBox("Assembler");
        check3.setOnAction(event -> {
            check1.setSelected(false);
            check2.setSelected(false);
        });


        registerBtn = new Button("Sign Up");
        registerBtn.setOnAction(event -> {
            if (check1.isSelected()){
                type = "Buyer";
            } else if (check2.isSelected()) {
                type = "Seller";
            }else{
                type = "Assembler";
            }

            // After validating password goes straight to lobby.
            if (pswField1.getText().equals(pswField2.getText()) && type.equals("Buyer")) {
                userController.create(userField.getText(), pswField1.getText(), type);
                System.out.println("User Created");
                blobby = new BLobby(userField.getText(), primaryStage);
                primaryStage.setScene(blobby.getScene());
            }else if (pswField1.getText().equals(pswField2.getText()) && type.equals("Seller")) {
                userController.create(userField.getText(), pswField1.getText(), type);
                System.out.println("User Created");
                slobby = new SLobby(userField.getText(), primaryStage);
                primaryStage.setScene(slobby.getScene());
            }else if (pswField1.getText().equals(pswField2.getText()) && type.equals("Assembler")){
                userController.create(userField.getText(), pswField1.getText(),type);
                System.out.println("User Created");
                alobby = new ALobby(userField.getText(), primaryStage);
                primaryStage.setScene(alobby.getScene());
            }else{
                System.out.println("Passwords are not equal");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Passwords are not equal.");

                alert.showAndWait();
            }
        });


        box1 = new VBox(10);
        box2 = new VBox(10);
        box3 = new HBox(30);

        box2.getChildren().addAll(userField, pswField1, pswField2);


        box3.getChildren().addAll(check1,check2,check3,registerBtn);
        box1.getChildren().addAll(title, box2, box3);


        box3.setAlignment(Pos.BASELINE_CENTER);
        box2.setAlignment(Pos.CENTER);
        box1.setAlignment(Pos.CENTER);

        scene = new Scene(box1);


    }
    public Scene getScene() {
        return scene;
    }
}

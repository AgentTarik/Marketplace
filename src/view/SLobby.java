package view;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SLobby {
    private Scene scene;
    private Button create, order, pending;
    private Label title;
    private VBox mainBox;


    public SLobby(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Welcome Seller");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 45));

        create = new Button();
        create.setText("Create Sell Order");
        create.setOnAction(event -> {

        });

        order = new Button();
        order.setText("Your Sell Order");
        order.setOnAction(event -> {

        });

        pending = new Button();
        pending.setText("Pending");
        pending.setOnAction(event -> {

        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(title, create, order);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}


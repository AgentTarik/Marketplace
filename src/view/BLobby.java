package view;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BLobby {
    private Scene scene;
    private Button search, pending, cart;
    private Label title;
    private VBox mainBox;


    public BLobby(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Welcome Buyer");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 45));

        search = new Button();
        search.setText("Search");
        search.setOnAction(event -> {

        });

        pending = new Button();
        pending.setText("Pending");
        pending.setOnAction(event -> {

        });

        cart = new Button();
        cart.setText("Cart");
        cart.setOnAction(event -> {

        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(title, search,pending);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

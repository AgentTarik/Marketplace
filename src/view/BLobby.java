package view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BLobby {
    private Scene scene;
    private BParts bParts;
    private BPending bPending;
    private BCart bCart;
    private Button search, pending, cart;
    private Label title;
    private VBox mainBox;


    public BLobby(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Welcome Buyer");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        search = new Button();
        search.setText("Search");
        search.setOnAction(event -> {
            bParts = new BParts(activeUser,primaryStage);
            primaryStage.setScene(bParts.getScene());
        });

        pending = new Button();
        pending.setText("Pending");
        pending.setOnAction(event -> {
            bPending = new BPending(activeUser,primaryStage);
            primaryStage.setScene(bPending.getScene());
        });

        cart = new Button();
        cart.setText("Cart");
        cart.setOnAction(event -> {
            bCart = new BCart(activeUser,primaryStage);
            primaryStage.setScene(bCart.getScene());
        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(title, search,pending,cart);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

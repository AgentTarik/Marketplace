package view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SLobby {
    private Scene scene;
    private SCreate sCreate;
    private SOrders sOrders;
    private SPending sPending;
    private Button create, order, pending;
    private Label title;
    private VBox mainBox;


    public SLobby(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Welcome Seller");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        create = new Button();
        create.setText("Create Sell Order");
        create.setOnAction(event -> {
            sCreate = new SCreate(activeUser,primaryStage);
            primaryStage.setScene(sCreate.getScene());
        });

        order = new Button();
        order.setText("Your Sell Orders");
        order.setOnAction(event -> {
            sOrders = new SOrders(activeUser,primaryStage);
            primaryStage.setScene(sOrders.getScene());
        });

        pending = new Button();
        pending.setText("Pending");
        pending.setOnAction(event -> {
            sPending = new SPending(activeUser,primaryStage);
            primaryStage.setScene(sPending.getScene());
        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(title, create, order, pending);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}


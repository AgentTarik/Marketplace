package view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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

        title = new Label("Welcome Seller");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 100));

        create = new Button();
        create.setStyle("-fx-background-color: transparent;");
        create.setPrefSize(20,20);
        create.setGraphic(new ImageView(new Image(getClass().getResource("/img/create.png").toExternalForm(), 100, 100, false, false)));
        create.setOnAction(event -> {
            sCreate = new SCreate(activeUser,primaryStage);
            primaryStage.setScene(sCreate.getScene());
        });

        order = new Button();
        order.setStyle("-fx-background-color: transparent;");
        order.setPrefSize(20,20);
        order.setGraphic(new ImageView(new Image(getClass().getResource("/img/orders.png").toExternalForm(), 100, 100, false, false)));
        order.setOnAction(event -> {
            sOrders = new SOrders(activeUser,primaryStage);
            primaryStage.setScene(sOrders.getScene());
        });

        pending = new Button();
        pending.setStyle("-fx-background-color: transparent;");
        pending.setPrefSize(20,20);
        pending.setGraphic(new ImageView(new Image(getClass().getResource("/img/pending.png").toExternalForm(), 100, 100, false, false)));
        pending.setOnAction(event -> {
            sPending = new SPending(activeUser,primaryStage);
            primaryStage.setScene(sPending.getScene());
        });

        HBox buttonsBox = new HBox(30);
        buttonsBox.getChildren().addAll(create, order, pending);
        buttonsBox.setAlignment(Pos.CENTER);

        mainBox = new VBox(30);
        mainBox.getChildren().addAll(title, buttonsBox);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}


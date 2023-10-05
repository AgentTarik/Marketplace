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

public class BLobby {
    private Scene scene;
    private BParts bParts;
    private BPCs bPCs;
    private BBuild bBuild;
    private BCart bCart;
    private Button parts,PCs,build, pending, cart;
    private Label title;
    private VBox mainBox;


    public BLobby(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {
        title = new Label();
        title.setText("Welcome Buyer");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 100));

        parts = new Button();
        parts.setStyle("-fx-background-color: transparent;");
        parts.setPrefSize(20,20);
        parts.setGraphic(new ImageView(new Image(getClass().getResource("/img/part.png").toExternalForm(), 100, 100, false, false)));
        parts.setOnAction(event -> {
            bParts = new BParts(activeUser,primaryStage);
            primaryStage.setScene(bParts.getScene());
        });

        PCs = new Button();
        PCs.setPrefSize(20,20);
        PCs.setStyle("-fx-background-color: transparent;");
        PCs.setGraphic(new ImageView(new Image(getClass().getResource("/img/computer.png").toExternalForm(), 100, 100, false, false)));
        PCs.setOnAction(event -> {
            bPCs = new BPCs(activeUser,primaryStage);
            primaryStage.setScene(bPCs.getScene());
        });

        build = new Button();
        build.setStyle("-fx-background-color: transparent;");
        build.setPrefSize(20,20);
        build.setGraphic(new ImageView(new Image(getClass().getResource("/img/build.png").toExternalForm(), 100, 100, false, false)));
        build.setOnAction(event -> {
            bBuild = new BBuild(activeUser,primaryStage);
            primaryStage.setScene(bBuild.getScene());
        });

        cart = new Button();
        cart.setPrefSize(20,20);
        cart.setStyle("-fx-background-color: transparent;");
        cart.setGraphic(new ImageView(new Image(getClass().getResource("/img/cart.png").toExternalForm(), 100, 100, false, false)));
        cart.setOnAction(event -> {
            bCart = new BCart(activeUser,primaryStage);
            primaryStage.setScene(bCart.getScene());
        });

        HBox buttonsBox = new HBox(30);
        buttonsBox.getChildren().addAll(parts,PCs,build,cart);
        buttonsBox.setAlignment(Pos.CENTER);

        mainBox = new VBox(50);
        mainBox.getChildren().addAll(title, buttonsBox);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

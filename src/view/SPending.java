package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SPending {
    private Scene scene;
    private SLobby sLobby;
    private Button back;
    private Label title;
    private VBox mainBox;
    private HBox backBox;


    public SPending(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Create Sell Order");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            sLobby = new SLobby(activeUser,primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        mainBox = new VBox(30);
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

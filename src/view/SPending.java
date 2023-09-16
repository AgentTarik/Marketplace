package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    public SPending(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Create Sell Order");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        back = new Button();
        back.setText("back");
        back.setOnAction(event -> {
            sLobby = new SLobby(activeUser,primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(title);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}
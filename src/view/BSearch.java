package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BSearch {
    private Scene scene;
    private Button back;
    private BLobby bLobby;
    private Label title;
    private VBox mainBox;
    private HBox backBox;


    public BSearch(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Search");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        back = new Button();
        back.setText("back");
        back.setOnAction(event -> {
            bLobby = new BLobby(activeUser,primaryStage);
            primaryStage.setScene(bLobby.getScene());
        });

        mainBox = new VBox();
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

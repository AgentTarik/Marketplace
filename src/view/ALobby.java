package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ALobby {
    private Scene scene;
    private Button offer, pending;
    private Label title;
    private VBox mainBox;


    public ALobby(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Welcome Assembler");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 45));

        offer = new Button();
        offer.setText("Select Offer");
        offer.setOnAction(event -> {

        });

        pending = new Button();
        pending.setText("Pending Projects");
        pending.setOnAction(event -> {

        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(title,offer,pending);
        scene = new Scene(mainBox);
    }
    public Scene getScene() {
        return scene;
    }
}
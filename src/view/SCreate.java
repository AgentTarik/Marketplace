package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SCreate {
    private Scene scene;
    private Button back,submit;
    private SLobby sLobby;
    private Label title,cateLabel,specLabel,quantLabel,priceLabel;
    private TextField cateField,specField,quantField,priceField;
    private VBox mainBox,createBox;
    private HBox backBox,cateBox,specBox,quantBox,priceBox,submitBox;

    public SCreate(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Create Sell Order");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        cateLabel = new Label();
        cateLabel.setText("Category: ");

        cateField = new TextField();
        cateField.setPromptText("Usuário");

        specLabel = new Label();
        specLabel.setText("specifications: ");

        specField = new TextField();
        specField.setPromptText("Usuário");

        quantLabel = new Label();
        quantLabel.setText("Quantity: ");

        quantField = new TextField();
        quantField.setPromptText("Usuário");

        priceLabel = new Label();
        priceLabel.setText("Price: ");

        priceField = new TextField();
        priceField.setPromptText("Usuário");

        back = new Button();
        back.setText("back");
        back.setOnAction(event -> {
            sLobby = new SLobby(activeUser,primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        submit = new Button("Sign Up");
        submit.setOnAction(event -> {
            });

        mainBox = new VBox();

        cateBox = new HBox();
        cateBox.getChildren().addAll(cateLabel,cateField);
        cateBox.setAlignment(Pos.CENTER);

        specBox = new HBox();
        specBox.getChildren().addAll(specLabel,specField);
        specBox.setAlignment(Pos.CENTER);

        quantBox = new HBox();
        quantBox.getChildren().addAll(quantLabel,quantField);
        quantBox.setAlignment(Pos.CENTER);

        priceBox = new HBox();
        priceBox.getChildren().addAll(priceLabel,priceField);
        priceBox.setAlignment(Pos.CENTER);

        submitBox = new HBox();
        createBox = new VBox();

        createBox.getChildren().addAll(cateBox,specBox,quantBox,priceBox,submitBox);
        createBox.setAlignment(Pos.CENTER);

        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title,createBox);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

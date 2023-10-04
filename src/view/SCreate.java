package view;

import controller.PartsController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private PartsController partsController;
    private Button back,submit;
    private SLobby sLobby;
    private Alert alert;
    private Label title,cateLabel, nameLabel,brandLabel,quantLabel,priceLabel;
    private TextField cateField, nameField,brandField,quantField,priceField;
    private VBox mainBox,createBox;
    private HBox backBox,cateBox, nameBox,brandBox, quantBox,priceBox,submitBox;

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

        nameLabel = new Label();
        nameLabel.setText("Name: ");

        nameField = new TextField();
        nameField.setPromptText("Name");

        brandLabel = new Label();
        brandLabel.setText("Brand:");

        brandField = new TextField();
        brandField.setPromptText("Brand");

        quantLabel = new Label();
        quantLabel.setText("Quantity: ");

        quantField = new TextField();
        quantField.setPromptText("Quantity");

        priceLabel = new Label();
        priceLabel.setText("Price: ");

        priceField = new TextField();
        priceField.setPromptText("Usuário");

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            sLobby = new SLobby(activeUser,primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        submit = new Button("Submit");
        submit.setOnAction(event -> {
            partsController = new PartsController();
            partsController.create(partsController.newID(),
                    0,
                    Integer.parseInt(quantField.getText()),
                    Double.parseDouble(priceField.getText()),
                    nameField.getText(),
                    cateField.getText(),
                    brandField.getText(),
                    activeUser);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Part added successfully ");
            alert.showAndWait();
            });

        mainBox = new VBox();

        cateBox = new HBox();
        cateBox.getChildren().addAll(cateLabel,cateField);
        cateBox.setAlignment(Pos.CENTER);

        nameBox = new HBox();
        nameBox.getChildren().addAll(nameLabel, nameField);
        nameBox.setAlignment(Pos.CENTER);

        brandBox = new HBox();
        brandBox.getChildren().addAll(brandLabel,brandField);
        brandBox.setAlignment(Pos.CENTER);

        quantBox = new HBox();
        quantBox.getChildren().addAll(quantLabel,quantField);
        quantBox.setAlignment(Pos.CENTER);

        priceBox = new HBox();
        priceBox.getChildren().addAll(priceLabel,priceField);
        priceBox.setAlignment(Pos.CENTER);

        submitBox = new HBox();
        submitBox.getChildren().addAll(submit);
        submitBox.setAlignment(Pos.CENTER);

        createBox = new VBox();

        createBox.getChildren().addAll(nameBox,cateBox,brandBox,quantBox,priceBox,submitBox);
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

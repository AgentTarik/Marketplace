package view;

import controller.ComputerController;
import controller.PartsController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BBuild {
    private Scene scene;
    private Button back;
    private BLobby bLobby;
    private Label title, nameLbl;
    private TextField nameTxt;
    private VBox mainBox, buildBox;
    private HBox backBox, nameBox;
    private ComboBox<String> comboBoxMB, comboBoxCPU, comboBoxRAM, comboBoxHD, comboBoxGPU;
    private PartsController partsController;
    private Button buildBtn;


    public BBuild(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {
        title = new Label();
        title.setText("Build PC");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            bLobby = new BLobby(activeUser,primaryStage);
            primaryStage.setScene(bLobby.getScene());
        });

        partsController = new PartsController();

        comboBoxMB = new ComboBox<>();
        comboBoxCPU = new ComboBox<>();
        comboBoxRAM = new ComboBox<>();
        comboBoxHD = new ComboBox<>();
        comboBoxGPU = new ComboBox<>();

        comboBoxMB.getItems().addAll(partsController.readByCategory("mb"));
        comboBoxMB.setValue("Select Mother Board");
        comboBoxMB.setOnAction(event -> {
            comboBoxCPU.setDisable(false);
            comboBoxCPU.getItems().addAll(partsController.readByCategory("cpu",comboBoxMB.getValue()));
        });

        comboBoxCPU.setValue("Select CPU");
        comboBoxCPU.setDisable(true);

        comboBoxRAM.getItems().addAll(partsController.readByCategory("ram"));
        comboBoxRAM.setValue("Select RAM");

        comboBoxHD.getItems().addAll(partsController.readByCategory("hd/ssd"));
        comboBoxHD.setValue("Select HD");

        comboBoxGPU.getItems().addAll(partsController.readByCategory("gpu"));
        comboBoxGPU.setValue("Select GPU");

        nameLbl = new Label("Computer Name: ");
        nameTxt = new TextField();

        ComputerController computerController = new ComputerController();
        buildBtn = new Button("Build Computer");
        buildBtn.setOnAction(event -> {
            String[] name = {comboBoxMB.getValue(), comboBoxCPU.getValue(), comboBoxRAM.getValue(), comboBoxHD.getValue(), comboBoxGPU.getValue()};
            computerController.create(computerController.getNextID(), nameTxt.getText(), 1, computerController.calculatePrice(name), "buyer");
            BBuild bBuild = new BBuild(activeUser, primaryStage);
            primaryStage.setScene(bBuild.getScene());
        });

        nameBox = new HBox(5);
        nameBox.getChildren().addAll(nameLbl, nameTxt);
        nameBox.setAlignment(Pos.CENTER);

        buildBox = new VBox(20);
        buildBox.getChildren().addAll(comboBoxMB, comboBoxCPU, comboBoxRAM, comboBoxHD, comboBoxGPU, nameBox, buildBtn);
        buildBox.setAlignment(Pos.CENTER);

        backBox = new HBox();
        backBox.getChildren().addAll(back);
        backBox.setAlignment(Pos.BASELINE_LEFT);

        mainBox = new VBox(30);
        mainBox.getChildren().addAll(title, buildBox, backBox);
        mainBox.setAlignment(Pos.CENTER);

        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}
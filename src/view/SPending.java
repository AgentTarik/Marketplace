package view;

import controller.PartsController;
import controller.PendingController;
import controller.PurchaseController;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Part;
import model.Pending;

public class SPending {
    private Scene scene;
    private SLobby sLobby;
    private Button back;
    private Label title;
    private VBox mainBox;
    private HBox backBox;
    private PendingController pendingController;
    private TableView table;


    public SPending(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Pending Orders");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            sLobby = new SLobby(activeUser,primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        pendingController = new PendingController();

        table = new TableView();
        table.setItems(FXCollections.observableList(pendingController.getPendings()));

        TableColumn userOwner = new TableColumn<>("UserOwner");
        userOwner.setPrefWidth(200);
        userOwner.setCellValueFactory(new PropertyValueFactory<>("UserOwner"));

        TableColumn buyer = new TableColumn<>("Buyer");
        buyer.setPrefWidth(200);
        buyer.setCellValueFactory(new PropertyValueFactory<>("Buyer"));

        TableColumn partName = new TableColumn<>("PartName");
        partName.setPrefWidth(200);
        partName.setCellValueFactory(new PropertyValueFactory<>("PartName"));

        TableColumn value = new TableColumn<>("Value");
        value.setPrefWidth(200);
        value.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(userOwner,buyer,partName,value);
        table.setMaxWidth(800);

        Button submit = new Button();
        submit.setText("Submit");
        submit.setOnAction(event -> {
            pendingController.delete();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success! Order sent to customer.");
            alert.setHeaderText(null);
            alert.showAndWait();

            SLobby sLobby = new SLobby(activeUser, primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        mainBox = new VBox(30);
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title,table,submit);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

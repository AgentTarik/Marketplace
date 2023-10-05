package view;

import controller.ComputerController;
import controller.PartsController;
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
import model.Computer;
import model.Part;

public class BPCs {
    private Scene scene;
    private ComputerController computerController;
    private PurchaseController purchaseController;
    private Button back, addToCartButton;
    private Alert alert;
    private Computer selectedComputer;
    private BLobby bLobby;
    private Label title;
    private VBox mainBox;
    private HBox backBox;
    private TableView table;


    public BPCs(String activeUser, Stage primaryStage) {
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Computers");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            bLobby = new BLobby(activeUser,primaryStage);
            primaryStage.setScene(bLobby.getScene());
        });

        computerController = new ComputerController();

        table = new TableView();
        table.setItems(FXCollections.observableList(computerController.sellingComputers()));

        TableColumn name = new TableColumn<>("Name");
        name.setPrefWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn quantity = new TableColumn<>("Quantity");
        quantity.setPrefWidth(200);
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        TableColumn value = new TableColumn<>("Value");
        value.setPrefWidth(200);
        value.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(name,quantity,value);
        table.setMaxWidth(600);

        addToCartButton = new Button();
        addToCartButton.setText("Add to Cart");
        addToCartButton.setOnAction(event -> {
            selectedComputer = (Computer) table.getSelectionModel().getSelectedItem();

            if (selectedComputer != null) {
                purchaseController = new PurchaseController();
                purchaseController.create(activeUser,selectedComputer.getName(),"empty",selectedComputer.getValue());
                computerController.update(selectedComputer.getName());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(selectedComputer.getName() + " added to cart");
                alert.showAndWait();
            } else {
                System.out.println("No row selected.");
            }
        });

        mainBox = new VBox(30);
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title,table,addToCartButton);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

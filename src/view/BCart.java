package view;

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

public class BCart {
    private Scene scene;
    private Button back,buyButton;
    private BLobby bLobby;
    private Alert successAlert,failAlert;
    private TableView table;
    private PurchaseController purchaseController;
    private Label title,cartValue;
    private VBox mainBox;
    private HBox backBox,buyBox;


    public BCart(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Cart");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            bLobby = new BLobby(activeUser,primaryStage);
            primaryStage.setScene(bLobby.getScene());
        });

        purchaseController = new PurchaseController();

        table = new TableView();
        table.setItems(FXCollections.observableList(purchaseController.read(activeUser)));

        TableColumn name = new TableColumn<>("ComputerName");
        name.setPrefWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("ComputerName"));

        TableColumn quantity = new TableColumn<>("PartName");
        quantity.setPrefWidth(200);
        quantity.setCellValueFactory(new PropertyValueFactory<>("PartName"));

        TableColumn price = new TableColumn<>("Value");
        price.setPrefWidth(200);
        price.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(name,quantity,price);
        table.setMaxWidth(600);

        cartValue = new Label();
        cartValue.setText("The total value of your cart is: $"+ purchaseController.cartValue(activeUser));
        cartValue.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        buyButton = new Button();
        buyButton.setText("Buy Now");
        buyButton.setOnAction(event -> {
            if (purchaseController.read(activeUser)!=null){
                purchaseController.delete(activeUser);
                successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Thank you for purchasing!");
                successAlert.showAndWait();
            }else{
                failAlert = new Alert(Alert.AlertType.INFORMATION);
                failAlert.setTitle(":c");
                failAlert.setHeaderText(null);
                failAlert.setContentText("Your cart is empty");
                failAlert.showAndWait();
            }
        });


        mainBox = new VBox();
        buyBox = new HBox();
        buyBox.getChildren().addAll(cartValue,buyButton);
        buyBox.setAlignment(Pos.CENTER);
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title,table,buyBox);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

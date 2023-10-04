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
import model.Part;

public class BParts {
    private Scene scene;
    private PartsController partsController;
    private PurchaseController purchaseController;
    private Button back, addToCartButton;
    private Alert alert;
    private BLobby bLobby;
    private Label title;
    private TableView table;
    private VBox mainBox;
    private HBox backBox;
    private Part selectedPart;


    public BParts(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Parts");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        back = new Button();
        back.setText("\u2190");
        back.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: black; -fx-font-size: 30");
        back.setOnAction(event -> {
            bLobby = new BLobby(activeUser,primaryStage);
            primaryStage.setScene(bLobby.getScene());
        });

        partsController = new PartsController();

        table = new TableView();
        table.setItems(FXCollections.observableList(partsController.sellingParts()));

        TableColumn name = new TableColumn<>("Name");
        name.setPrefWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn quantity = new TableColumn<>("Quantity");
        quantity.setPrefWidth(100);
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        TableColumn price = new TableColumn<>("Price");
        price.setPrefWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("Price"));

        TableColumn category = new TableColumn<>("Category");
        category.setPrefWidth(100);
        category.setCellValueFactory(new PropertyValueFactory<>("Category"));

        TableColumn brand = new TableColumn<>("Brand");
        brand.setPrefWidth(100);
        brand.setCellValueFactory(new PropertyValueFactory<>("Brand"));

        table.getColumns().setAll(name,quantity,price,category,brand);


        addToCartButton = new Button();
        addToCartButton.setText("Add to Cart");
        addToCartButton.setOnAction(event -> {
            selectedPart = (Part) table.getSelectionModel().getSelectedItem();

            if (selectedPart != null) {
                purchaseController = new PurchaseController();
                purchaseController.create(activeUser,"empty",selectedPart.getName(),selectedPart.getPrice());
                partsController.update(selectedPart.getName());
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText(selectedPart.getName() + " added to cart");
                alert.showAndWait();
            } else {
                System.out.println("No row selected.");
            }
        });

//        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                if (event.getClickCount() == 2) {
//
//                        int rowIndex = table.getSelectionModel().getSelectedIndex();
//                        TableColumn<?, ?> column = table.getFocusModel().getFocusedCell().getTableColumn();
//                        int colIndex = table.getColumns().indexOf(column);
//
//                        System.out.println(rowIndex+" "+colIndex);
//
//                }
//            }
//        });


        mainBox = new VBox();
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title,table, addToCartButton);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

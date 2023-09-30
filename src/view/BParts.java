package view;

import controller.PartsController;
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

public class BParts {
    private Scene scene;
    private PartsController partsController;
    private Button back;
    private BLobby bLobby;
    private Label title;
    private TableView table;
    private VBox mainBox;
    private HBox backBox;


    public BParts(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {

        title = new Label();
        title.setText("Parts");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        back = new Button();
        back.setText("back");
        back.setOnAction(event -> {
            bLobby = new BLobby(activeUser,primaryStage);
            primaryStage.setScene(bLobby.getScene());
        });

        partsController = new PartsController();

        table = new TableView();
        table.setItems(FXCollections.observableList(partsController.getParts()));

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

        mainBox = new VBox();
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox,title,table);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

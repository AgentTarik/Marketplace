package view;

import controller.ComputerController;
import controller.PartsController;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SOrders {
    private Scene scene;
    private Button back;
    private SLobby sLobby;
    private Label title;
    private VBox mainBox;
    private HBox backBox;
    private TableView table;
    private PartsController partsController;


    public SOrders(String activeUser, Stage primaryStage){
        initComponents(activeUser, primaryStage);
    }

    public void initComponents(String activeUser, Stage primaryStage) {
        title = new Label();
        title.setText("Your Sell Orders");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        back = new Button();
        back.setText("back");
        back.setOnAction(event -> {
            sLobby = new SLobby(activeUser,primaryStage);
            primaryStage.setScene(sLobby.getScene());
        });

        partsController = new PartsController();

        table = new TableView();
        table.setItems(FXCollections.observableList(partsController.read(activeUser)));

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

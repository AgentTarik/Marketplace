package view;

import controller.ProductController;
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
    private ProductController productController;


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

        productController = new ProductController();

        table = new TableView();
        table.setItems(FXCollections.observableList(productController.read(activeUser)));

        TableColumn productId = new TableColumn<>("ID");
        productId.setPrefWidth(100);
        productId.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn productName = new TableColumn<>("Name");
        productName.setPrefWidth(100);
        productName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn productQuantity = new TableColumn<>("Quantity");
        productQuantity.setPrefWidth(100);
        productQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        TableColumn productValue= new TableColumn<>("Value");
        productValue.setPrefWidth(100);
        productValue.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(productId,productName,productQuantity,productValue);

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

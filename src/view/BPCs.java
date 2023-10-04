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

public class BPCs {
    private Scene scene;
    private ComputerController computerController;
    private Button back;
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
        table.setItems(FXCollections.observableList(computerController.getProducts()));

        TableColumn name = new TableColumn<>("Name");
        name.setPrefWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn quantity = new TableColumn<>("Quantity");
        quantity.setPrefWidth(100);
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));

        TableColumn value = new TableColumn<>("Value");
        value.setPrefWidth(100);
        value.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(name,quantity,value);

        mainBox = new VBox();
        backBox = new HBox();
        backBox.getChildren().addAll(back);
        mainBox.getChildren().addAll(backBox, title,table);
        mainBox.setAlignment(Pos.CENTER);
        scene = new Scene(mainBox);
    }

    public Scene getScene() {
        return scene;
    }
}

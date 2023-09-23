package view;

import controller.ComputerController;
import controller.UserController;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Home {

    private Scene scene;
    private Button updateBtn,deleteBtn,creteProductBtn,updateProductBtn,deleteProductBtn;
    private PasswordField newPassword;
    private VBox userBox,productBox;
    private HBox buttonsBox, mainBox;
    private Label userArea,productArea;
    private TableView table;
    private UserController userController;
    private ComputerController productController;
    private CreateProduct createProduct;


    public Home(String activeUser, Stage primaryStage){
        userController = new UserController();
        productController = new ComputerController();
        initComponents(activeUser, primaryStage);
    }
    public void initComponents(String activeUser, Stage primaryStage){
        userArea = new Label("User Area");

        newPassword = new PasswordField();
        newPassword.setPromptText("New Password");

        updateBtn = new Button("Update");
        updateBtn.setOnAction(event -> {
            userController.update(activeUser,newPassword.getText());
        });

        deleteBtn = new Button("Delete");
        deleteBtn.setOnAction(event -> {
            userController.delete(activeUser,newPassword.getText());
        });

        productArea = new Label("Product Area");

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

        TableColumn productValue = new TableColumn<>("Value");
        productValue.setPrefWidth(100);
        productValue.setCellValueFactory(new PropertyValueFactory<>("Value"));

        table.getColumns().setAll(productId,productName,productQuantity,productValue);

        creteProductBtn = new Button("Add Product");
        creteProductBtn.setOnAction(event -> {
            createProduct = new CreateProduct(activeUser);
            primaryStage.setScene(createProduct.getScene());
        });
        updateProductBtn = new Button("Update Product");
        updateProductBtn.setOnAction(event -> {

        });
        deleteProductBtn = new Button("Add Product");
        deleteProductBtn.setOnAction(event -> {

        });

        userBox = new VBox();
        userBox.getChildren().addAll(userArea,newPassword,updateBtn,deleteBtn);

        buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(creteProductBtn,updateProductBtn,deleteProductBtn);

        productBox = new VBox();
        productBox.getChildren().addAll(productArea,table,buttonsBox);

        mainBox = new HBox();
        mainBox.getChildren().addAll(userBox,productBox);
        scene = new Scene(mainBox);
    }

    public Scene getScene(){
        return scene;
    }

}

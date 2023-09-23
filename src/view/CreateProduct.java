package view;


import controller.ComputerController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CreateProduct {

    private Button createBtn;
    private TextField idField,nameField,quantityField,valueField;
    private VBox mainBox;
    private Scene scene;
    private ComputerController productController;

    public CreateProduct(String activeUser) {
        initComponents(activeUser);
    }
    public void initComponents(String activeUser){
        idField = new TextField();
        idField.setPromptText("ID");

        nameField = new TextField();
        nameField.setPromptText("Name");

        quantityField = new TextField();
        quantityField.setPromptText("Qantity");

        valueField = new TextField();
        valueField.setPromptText("Value");

        createBtn = new Button("Register Product");
        createBtn.setOnAction(event -> {
            productController = new ComputerController();
            productController.create(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    Integer.parseInt(quantityField.getText()),
                    Double.parseDouble(valueField.getText()),
                    activeUser);
        });

        mainBox = new VBox();
        mainBox.getChildren().addAll(idField,nameField,quantityField,valueField,createBtn);

        scene = new Scene(mainBox);
    }

    public Scene getScene(){
        return scene;
    }

}

package marketplace;

import controller.UserController;
import view.BBuild;
import view.LoginScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        UserController userController = new UserController();
        userController.read();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);

        LoginScreen loginScreen = new LoginScreen(primaryStage);
        primaryStage.setScene(loginScreen.getScene());


        primaryStage.show();
    }
}
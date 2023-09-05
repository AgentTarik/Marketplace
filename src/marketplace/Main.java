package marketplace;

import controller.UserController;
import view.LoginScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        UserController userController = new UserController();
        userController.read();
        launch(args);
        // test
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(400);
        primaryStage.setWidth(400);
        LoginScreen loginScreen = new LoginScreen(primaryStage);
        primaryStage.setScene(loginScreen.getScene());
        primaryStage.show();
    }
}
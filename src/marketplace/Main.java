package marketplace;

import controller.UserController;
import view.BBuild;
import view.BPCs;
import view.LoginScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {


        UserController userController = new UserController();
        userController.read();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(1080);
        primaryStage.setWidth(1920);

        LoginScreen loginScreen = new LoginScreen(primaryStage);
        primaryStage.setScene(loginScreen.getScene());


        primaryStage.show();
    }
}
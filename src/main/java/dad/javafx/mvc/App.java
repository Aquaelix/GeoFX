package dad.javafx.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private RootController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new RootController();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("GeoFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

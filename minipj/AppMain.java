package minipj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	
	public void start(Stage ps) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene sc = new Scene(root);
		ps.setTitle("사원정보목록");
		ps.setScene(sc);
		ps.setResizable(false);
		ps.show();
		
	}
}

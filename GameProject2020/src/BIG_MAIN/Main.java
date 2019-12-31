package BIG_MAIN;

import NPCHuman.HumanNPC_Debugger;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{


	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {

		Button button = new Button("Click me");

		button.setOnAction(e->{
			HumanNPC_Debugger HNPC = new HumanNPC_Debugger();
			HNPC.showTraits(window);
		});
		Button start = new Button("Start");
		VBox UI = new VBox(button, start);
		Group root = new Group(UI);
		Scene scene = new Scene(root, 720, 560);
		window.setScene(scene);
		window.show();
	}
}

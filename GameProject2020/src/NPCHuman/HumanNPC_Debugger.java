package NPCHuman;

import NPCClient.NPCGui_Title;
import NPCClient.NPCStatsGUI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//public class HumanNPC_Debugger extends Application{
public class HumanNPC_Debugger{


	// Size of the Screen
	int sceneSizeX = 500;
	int sceneSizeY = 500;

	Scene scene4, scene1, scene2, scene3;
	Stage window;
	Button button1, button2, button3, button4;


//	public static void main(String[] args){
//		launch(args);
//	}

//	public void start(Stage primaryStage) throws Exception {
	public void showTraits(Stage primaryStage){
		window = primaryStage;

		NPCHumanTraits temp0 = new NPCHumanTraits_Good();
		NPCHumanTraits temp1 = new NPCHumanTraits_Good();
		NPCHumanTraits temp2 = new NPCHumanTraits_Neutral();
		NPCHumanTraits temp3 = new NPCHumanTraits_Bad();


		Group root1 = setupScene(temp0);
		Group root2 = setupScene(temp1);
		Group root3 = setupScene(temp2);
		Group root4 = setupScene(temp3);

		// Each Scene Object describes each individual scene.
		scene1 = new Scene(root1, sceneSizeX, sceneSizeY);
		scene2 = new Scene(root2, sceneSizeX, sceneSizeY);
		scene3 = new Scene(root3, sceneSizeX, sceneSizeY);
		scene4 = new Scene(root4, sceneSizeX, sceneSizeY);

		scene1.setFill(Color.BROWN);
		scene2.setFill(Color.BROWN);
		scene3.setFill(Color.BROWN);
		scene4.setFill(Color.BROWN);

		window.setTitle("Sample Application");
		window.setScene(scene4);
		window.show();
	}




	/**
	 * create all the basic looks and functionality of the scenes.
	 * @return Group
	 */
	public Group setupScene(NPCHumanTraits trait){

		button1 = new Button("Main Page");
		button2 = new Button("Good Traits");
		button3 = new Button("Neutral Traits");
		button4 = new Button("Bad Traits");

		button1.setOnAction(e->window.setScene(scene1));
		button2.setOnAction(e->window.setScene(scene2));
		button3.setOnAction(e->window.setScene(scene3));
		button4.setOnAction(e->window.setScene(scene4));

		HBox HB = new HBox(button1, button2, button3, button4);

		NPCGui_Title NPC_GUI = new NPCGui_Title();

		NPCStatsGUI NPC_Stats = new NPCStatsGUI(trait);
		NPC_Stats.initStatGrid();
		BorderPane BP = new BorderPane();
		BP.setCenter(NPC_Stats.getStatGrid());

		Group root = new Group(NPC_GUI.createTitleNPCStats(), BP, HB);

		return root;
	}



}

package GUI_Interaction;

import Algorithms.DblLinkedList;
import Algorithms.NPCLoc_MergeSort;
import Algorithms.NPCMap_Jarvis;
import NPCHuman.NPCHumanObject;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NPCInteraction_Controller extends Application{

	private final int sceneSizeX = 1000;
	private final int sceneSizeY = 1000;
	private int NPCNums = 20;
	Circle[] circles;
	Line[] lines;
	Text[] IDS;
	NPCHumanObject[] NPCs;
	Group root;


	@Override
	public void start(Stage window) throws Exception {

		root = new Group();
		NPCs = new NPCHumanObject[NPCNums];
		circles = new Circle[NPCNums];
		lines = new Line[NPCNums];
		IDS = new Text[NPCNums];

		for(int i = 0; i < NPCNums; i++){
			NPCs[i] = new NPCHumanObject(i, sceneSizeX, sceneSizeY);
			IDS[i] = new Text(""+NPCs[i].getId());
			IDS[i].setX(NPCs[i].getPosX()+10);
			IDS[i].setY(NPCs[i].getPosY()-15);
			circles[i] = new MovingCircleObject(NPCs[i]).getCircle();
			root.getChildren().addAll(circles[i], IDS[i]);
		}

		// Print Location of NPC Objects
		// printNPCLocationArray(NPCs);

		// Sort the NPC's by their X coordinate from left to right.
		NPCLoc_MergeSort SortByXInt = new NPCLoc_MergeSort();
		SortByXInt.sort(NPCs, 0, NPCNums-1);

		// printNPCLocationArray(NPCs);

		printConvexTop(NPCs);

		Scene scene = new Scene(root, sceneSizeX, sceneSizeY);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args){
		launch(args);
	}

	/**
	 * Print the convex hull
	 * @param NPC
	 */
	public void printConvexTop(NPCHumanObject[] NPC){
		 NPCMap_Jarvis list = new NPCMap_Jarvis(NPCNums);
		 list.algoTop(NPCs);
		 DblLinkedList head = list.getHead();
		 int count = 1;
		//  System.out.print("Convex Hull: [");
		 while(head.getNext() != null){
			 lines[count-1] = new Line();
			 lines[count-1].setStartX(head.getNPC().getPosX());
			 lines[count-1].setStartY(head.getNPC().getPosY());
			 lines[count-1].setEndX(head.getNext().getNPC().getPosX());
			 lines[count-1].setEndY(head.getNext().getNPC().getPosY());
			 if(count %2 == 0)
				 lines[count-1].setStroke(Color.GOLD);
			 else
				 lines[count-1].setStroke(Color.PURPLE);
			 root.getChildren().add(lines[count-1]);
			 count++;
			 head = head.getNext();
			 // System.out.print(" "+head.getNPC().getId());
		 }
		 // System.out.println(" ]");
	}

	/**
	 * Print Location
	 * @param NPC
	 */
	public void printNPCLocationArray(NPCHumanObject[] NPC){
		System.out.println("BEGIN::");
		for(int i = 0; i < NPCNums; i++){
			System.out.println("ID: " +NPC[i].getId()+ "   x  =  " +NPC[i].getPosX() + "   y = "+NPC[i].getPosY());
		}
		System.out.println("....\n");
	}
}

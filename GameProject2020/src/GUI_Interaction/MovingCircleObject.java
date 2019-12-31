package GUI_Interaction;

import java.util.Random;

import NPCHuman.NPCHumanObject;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MovingCircleObject {

	private Circle circle;
    private double LocX;
    private double LocY;
    private double diam;
    private int id;

    private int circMin = 10;
    private int circDiff = 15;
    private int circMax = circMin + circDiff;
    private int circBoundry = circMax*2;

    private int totalGood = 0;
    private int totalBad = 0;
    private int moralProclivity;

    private NPCHumanObject NPC;

	public MovingCircleObject(NPCHumanObject NPC){
		LocX = NPC.getPosX();
		LocY = NPC.getPosY();
		totalGood = NPC.getHumanTraits_Good().getTotal();
		totalBad = NPC.getHumanTraits_Bad().getTotal();
		moralProclivity = NPC.getMoralProclivity();
		circleRandomizer();
	}

	private void circleRandomizer(){

		// The traits portrayed here will be random until later configured to
		// resemble the NPC traits.
		Random rand = new Random();

		diam = (rand.nextDouble()*circDiff)+circMin;
		circle = new Circle(LocX, LocY, diam);

		// Show NPC's gradations of Moral proclivaty
		if(moralProclivity == 1){
			circle.setFill(Color.BLACK);
		}
		else if(moralProclivity == 2){
			circle.setFill(Color.DARKGRAY);
		}
		else if(moralProclivity == 3){
			circle.setFill(Color.ALICEBLUE);
		}
		else if(moralProclivity == 4){
			circle.setFill(Color.DARKSEAGREEN);
		}
		else if(moralProclivity == 5){
			circle.setFill(Color.GREEN);
		}

	}

	// Diameter pertains to the circle, and can be referenced from the object.
	public double getDiam(){
		return diam;
	}

	public Circle getCircle(){
		return circle;
	}

}

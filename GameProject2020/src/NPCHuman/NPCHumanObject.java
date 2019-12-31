package NPCHuman;

import java.util.Random;
import java.util.Map.Entry;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NPCHumanObject {
	NPCHumanTraits NPC_GT, NPC_BT, NPC_NT; // the three objects containing various
										   // information of each character moral dichotomy.

	private int good, bad, neutral; // total amount of good, bad, and neutral

	private double posX, posY; 		// actual placement on scene
	private int sizeX, sizeY; 		// Max placement on scene

	// Dictates boundary on random creation of object size and placement within the scene.
    private int circMin = 10;
    private int circDiff = 15;
    private int circMax = circMin + circDiff;
    private int circBoundry = circMax*2;

    private int moralProclivity = 0;

	private int id;					// Identification of this object, used for sorting and identifying.



	public NPCHumanObject(int iden, int maxXLoc, int maxYLoc){
		NPC_GT = new NPCHumanTraits_Good();
		NPC_BT = new NPCHumanTraits_Bad();
		NPC_NT = new NPCHumanTraits_Neutral();
		this.id = iden;
		this.sizeX = maxXLoc;
		this.sizeY = maxYLoc;
		placementRandomizer();
	}

	private void placementRandomizer(){

		neutral = NPC_NT.getTotal();
		good = NPC_GT.getTotal();
		bad = NPC_BT.getTotal();


		// Show NPC's gradations of Moral proclivaty
		if(Math.abs(bad - good) < ((good+bad)*0.1)){
			if(Math.abs(bad - good) < ((good+bad)*0.05)){
				moralProclivity = 3;
			}
			else if(good < bad){
				moralProclivity = 2;
			}
			else{
				moralProclivity = 4;
			}
		}
		else if(good < bad){
			moralProclivity = 1;
		}
		else{
			moralProclivity = 5;
		}


		// The original position will be random
		Random rand = new Random();

		posX = rand.nextDouble()*(sizeX-circBoundry)+circMax;
		posY = rand.nextDouble()*(sizeY-circBoundry)+circMax;
	}

	public NPCHumanTraits getHumanTraits_Good(){
		return NPC_GT;
	}
	public NPCHumanTraits getHumanTraits_Bad(){
		return NPC_BT;
	}
	public NPCHumanTraits getHumanTraits_Neutral(){
		return NPC_NT;
	}
	public int getMoralProclivity(){
		return moralProclivity;
	}

	public double getPosX(){
		return posX;
	}

	public double getPosY(){
		return posY;
	}
	public int getId(){
		return id;
	}

}

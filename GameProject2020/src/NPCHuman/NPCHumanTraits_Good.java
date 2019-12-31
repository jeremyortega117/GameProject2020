package NPCHuman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author JPOje
 */
public class NPCHumanTraits_Good extends NPCHumanTraits{

	private int size = 9;
	private int totalGood = 0;

	// Good Traits & Stats
	public Map<String, Integer> NPC_GT;

	public NPCHumanTraits_Good(){

		NPC_GT = new HashMap<String, Integer>();

		//
		NPC_GT.put("joy", 0);
		NPC_GT.put("peace", 0);
		NPC_GT.put("kindness", 0);
		NPC_GT.put("goodness", 0);
		NPC_GT.put("love", 0);
		NPC_GT.put("faithfulness", 0);
		NPC_GT.put("gentleness", 0);
		NPC_GT.put("self_control", 0);
		NPC_GT.put("tolerance", 0);
		traitRandomizer();

	}

	public int getTotal(){
		return totalGood;
	}

	private void traitRandomizer() {
		for (Entry<String, Integer> entry : NPC_GT.entrySet()){
			Random rand = new Random();
			int rand_int1 = rand.nextInt(10);
			totalGood +=rand_int1;
			entry.setValue(rand_int1);
		}
	}

	public int curSize(){
		return size;
	}

	/**
	 * @return HashMap<String, Integer>
	 */
	public Map<String, Integer> getTraits(){
		return NPC_GT;
	}

	/**
	 * @param str
	 * @param newStat
	 */
	public void updateTraits(String str, Integer newStat){
		NPC_GT.replace(str, newStat);
	}

	public void printTraits() {
		System.out.println("Blah");
		int i = 0;
		for (Map.Entry<String, Integer> entry : NPC_GT.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());

		}
	}

	/**
	 *
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTraitNames(){

		ArrayList<String> traits = new ArrayList<>();

       // using keySet() for iteration over keys
       for (String name : NPC_GT.keySet())
           traits.add(name);

		return traits;
	}

	/**
	 *
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getTraitValues(){

		ArrayList<Integer> values = new ArrayList<>();

       // using keySet() for iteration over keys
       for (Integer name : NPC_GT.values())
           values.add(name);

		return values;
	}

	public int getTraitValue(String key){
		return NPC_GT.get(key);
	}


	public void test(){
		System.out.println("Blah");
	}


}

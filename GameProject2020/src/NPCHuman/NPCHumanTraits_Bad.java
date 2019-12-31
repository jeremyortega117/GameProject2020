package NPCHuman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class NPCHumanTraits_Bad extends NPCHumanTraits{

	private int size = 9;
	private int totalBad = 0;

	// Good Traits & Stats
	private static Map<String, Integer> NPC_BT;

	public NPCHumanTraits_Bad(){

		NPC_BT = new HashMap<String, Integer>();

		//
		NPC_BT.put("despair", 0);
		NPC_BT.put("irritation", 0);
		NPC_BT.put("meaness", 0);
		NPC_BT.put("badness", 0);
		NPC_BT.put("hate", 0);
		NPC_BT.put("unfaithfulness", 0);
		NPC_BT.put("harshness", 0);
		NPC_BT.put("indicipline", 0);
		NPC_BT.put("intolerance", 0);
		traitRandomizer();

	}

	public int getTotal(){
		return totalBad;
	}

	// Randomly assert original values of good, bad, and neutral to each object
	private void traitRandomizer() {
		for (Entry<String, Integer> entry : NPC_BT.entrySet()){
			Random rand = new Random();
			int rand_int1 = rand.nextInt(10);
			totalBad += rand_int1;
			entry.setValue(rand_int1);
		}
	}


	public int curSize(){
		return size;
	}


	public Map<String, Integer> getTraits(){
		return NPC_BT;
	}

	/**
	 *
	 * @param str
	 * @param newStat
	 */
	public void updateTraits(String str, Integer newStat){
		NPC_BT.replace(str, newStat);
	}

	public void printTraits() {
		for (Entry<String, Integer> entry : NPC_BT.entrySet())
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
	}


	@Override
	public void test() {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTraitNames(){

		ArrayList<String> traits = new ArrayList<>();

       // using keySet() for iteration over keys
       for (String name : NPC_BT.keySet())
           traits.add(name);

		return traits;
	}


	public int getTraitValue(String key){
		return NPC_BT.get(key);
	}


	/**
	 *
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getTraitValues(){

		ArrayList<Integer> values = new ArrayList<>();

       // using keySet() for iteration over keys
       for (Integer name : NPC_BT.values())
           values.add(name);

		return values;
	}
}

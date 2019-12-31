package NPCHuman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class NPCHumanTraits_Neutral extends NPCHumanTraits{

	private int size = 9;
	private int totalNeutral = 0;

	// Good Traits & Stats
	private static Map<String, Integer> NPC_NT;


	// known as the human spirit or spirit energy, This gives rise to the level and rate of
	// event engagements.

	public NPCHumanTraits_Neutral(){

		NPC_NT = new HashMap<String, Integer>();

		// level of engagement of events and greater events.
		NPC_NT.put("ambition", 0);

		// energy regen from antisocial events.
		NPC_NT.put("Introvert", 0);

		// energy regen from social events
		NPC_NT.put("Extrovert", 0);

		// slowness of energy drain.
		NPC_NT.put("persistance", 0);

		// ability to boost party's energy temporarily to access an event.
		NPC_NT.put("persuasiveness", 0);

		// ability to give those around you energy
		NPC_NT.put("energetic", 0);

		traitRandomizer();

	}

	/**
	 *
	 * @return int
	 */
	public int getTotal(){
		return totalNeutral;
	}


	private void traitRandomizer() {
		for (Entry<String, Integer> entry : NPC_NT.entrySet()){
			Random rand = new Random();
			int rand_int1 = rand.nextInt(10);
			totalNeutral += rand_int1;
			entry.setValue(rand_int1);
		}
	}


	public int curSize(){
		return size;
	}

	/**
	 * @return HashMap<String, Integer>
	 */
	public Map<String, Integer> getTraits() {
		return NPC_NT;
	}

	/**
	 *
	 * @param str
	 * @param newStat
	 */
	public void updateTraits(String str, Integer newStat){
		NPC_NT.replace(str, newStat);
	}

	/**
	 *
	 */
	public void printTraits() {
		for (Entry<String, Integer> entry : NPC_NT.entrySet())
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());

	}

	/**
	 *
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getTraitNames(){

		ArrayList<String> traits = new ArrayList<>();

        // using keySet() for iteration over keys
        for (String name : NPC_NT.keySet())
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
        for (Integer name : NPC_NT.values())
            values.add(name);

		return values;
	}


	@Override
	public void test() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTraitValue(String key) {
		return NPC_NT.get(key);
	}


}

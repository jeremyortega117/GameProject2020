package NPCHuman;

import java.util.ArrayList;
import java.util.Map;



public abstract class NPCHumanTraits {

	public abstract Map<String, Integer> getTraits();
	public abstract void updateTraits(String str, Integer newStat);
	public abstract void printTraits();
	public abstract void test();
	public abstract ArrayList<String> getTraitNames();
	public abstract ArrayList<Integer> getTraitValues();
	public abstract int curSize();
	public abstract int getTotal();
	public abstract int getTraitValue(String key);
}

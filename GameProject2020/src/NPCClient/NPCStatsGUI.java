package NPCClient;

import java.util.ArrayList;
import java.util.Map;

import NPCHuman.NPCHumanTraits;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class NPCStatsGUI {

	int numStats = 10;

	// create an array of rectangles to represent stats of the NPC's
	private Rectangle[] NPCStats;
	private Text[] NPCTextStat;
	private NPCHumanTraits NPC_HT;
	int i;


	public NPCStatsGUI(NPCHumanTraits traits){
		this.NPC_HT = traits;
	}


	public Pane getStatGrid(){

		GridPane gridPane = new GridPane();
		// space out each element of grid to a distance.
		gridPane.setVgap(5);
		gridPane.setHgap(15);

		Map<String, Integer> temp = NPC_HT.getTraits();
		for(int p = 0; p < temp.size(); p++){
			gridPane.add(NPCTextStat[p], 0, p);
			gridPane.add(NPCStats[p], 1, p);
		}
		gridPane.setPadding(new Insets(90, 80, 80, 70));
		gridPane.setAlignment(Pos.CENTER);
		return gridPane;
	}


	public void initStatGrid(){

		NPCStats = new Rectangle[NPC_HT.curSize()];
		NPCTextStat = new Text[NPC_HT.curSize()];

		ArrayList<String> temp = NPC_HT.getTraitNames();
		ArrayList<Integer> intTemp = NPC_HT.getTraitValues();

		i = 0;
	    temp.forEach((action) -> initStatGridHelper_Traits(action));
	    i = 0;
	    intTemp.forEach((values) -> initStatGridHelper_Values(values));

	}

	private void initStatGridHelper_Traits(String name) {
		NPCTextStat[i] = new Text(name);
		i++;
	}

	private void initStatGridHelper_Values(Integer value) {
		int val = (int)value;
		// Create rectangles for graphs.
		Rectangle rec = new Rectangle();
		rec.setX(0);
		rec.setY(0);
		rec.setHeight(30);
		rec.setWidth(50 + (val*15));
		NPCTextStat[i].setTextAlignment(TextAlignment.CENTER);
		NPCTextStat[i].setFont(new Font(25));
		NPCStats[i] = rec;
		i++;
	}
}

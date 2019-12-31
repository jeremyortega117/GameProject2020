package NPCClient;


import javafx.scene.Group;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class NPCGui_Title{

	public Group createTitleNPCStats() {

		// This creates 1 line object and sets the starting x and y and the
		// ending x and y coordinates of the line.
		Line line = new Line();
		  line.setStartX(65.0);
		  line.setStartY(75.0);
		  line.setEndX(450.0);
		  line.setEndY(75.0);
		  line.setStroke(Color.BLACK);

		// This creates an embedded text object to go inside the root's
		// tree.  seting up text's font.
		Text page_title = new Text();
		  page_title.setFont(new Font(35));
		  page_title.setX(75);
		  page_title.setY(65);
		  page_title.setText("NPC Traits");
		  page_title.setStroke(Color.ALICEBLUE);

		// Create glow effect to title
		Glow glow = new Glow();
		  glow.setLevel(0.9);

		// Create Light shinning effect in title
		Light.Point light = new Light.Point();
		  light.setColor(Color.BURLYWOOD);
		  light.setX(70);
		  light.setY(55);
		  light.setZ(45);

		// create the Lighting effect object and put into it the light.
		Lighting lighting = new Lighting();
		  lighting.setLight(light);

		// Add the previously created effects to the title.
		page_title.setEffect(glow);
		page_title.setEffect(lighting);

		// Create the root group objects whose offspring are the
		// elements within the scene.

		Group titleObj = new Group(line, page_title);
		return titleObj;
	}

}

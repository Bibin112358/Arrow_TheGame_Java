import java.util.ArrayList;
import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	//vars declaration
	String title;
	static int window_h=800, window_w=600;
	
	//game vars
	Player player;
	//Enemy[] enemys;
	Move[] collisions;
	Sprite[] sprites;
	GraphicsContext gc;
	
	ArrayList<String> input = new ArrayList<String>();
	
	public void start(Stage s){
		
		//XML
		
		
		//window and canvas
		s.setTitle(title);
		Group root = new Group();
		Scene scene = new Scene(root);
		s.setScene(scene);
		Canvas canvas = new Canvas(window_w, window_h);
		root.getChildren().add(canvas);
		
		//add pressed key to the list
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e){
				String code = e.getCode().toString();
				
				if(!input.contains(code))
					input.add(code);
			}
		});
		
		//remove released key from the list
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e){
				String code = e.getCode().toString();
				input.remove(code);
			}
		});
		
		gc = canvas.getGraphicsContext2D();
		
		//instancing and intit
		player = new Player();
		//Collisions
		collisions = new Move[1];
		collisions[0] = player;
		//Sprites
		sprites = new Sprite[1];
		sprites[0] = player;
		
		
		new AnimationTimer() {
			
			public void handle(long now) {
				
				player.control(input);
				for(int i=0; i<collisions.length; i++){
					collisions[i].update();
				}
				for(int i=0; i<collisions.length; i++){
					collisions[i].collision(sprites);
				}
				gc.clearRect(0, 0, window_w, window_h);
				for(int i=0; i<sprites.length; i++){
					sprites[i].render(gc);
				}
				
			}
		}.start();
		
		s.show();
	}
}

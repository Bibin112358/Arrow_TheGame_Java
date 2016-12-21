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

	//vars
	String title;
	int window_h=800, window_w=600;
	
	//game vars
	Player player;
	Enemy[] enemys;
	Move[] collisions;
	Sprite sprites;
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
		
		//Sprites
		//Collisions
		
		new AnimationTimer() {
			
			public void handle(long now) {
				
				player.control(input);
				sprites[i].update();
				collisions[i].collision(Sprites);
				gc.clearRect(0, 0, window_w, window_h);
				sprites[i].render(gc);
			}
		}.start();
		
		s.show();
	}
}

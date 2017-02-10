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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	//vars declaration
	String title;
	static int window_h=800, window_w=600;
	
	//game vars in level
	Level level;
	GraphicsContext gc;
	
	ArrayList<String> input = new ArrayList<String>();
	Mouse mouse;
	
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
		
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("P");
				mouse = new Mouse(); //mousePos relative to scene
			}
		});
		
		scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e){
				//System.out.println("R");
				mouse.getPos(e.getX(), e.getY());
				mouse.released = true;
				System.out.println(mouse.get());
			}
		});
		
		gc = canvas.getGraphicsContext2D();
		
		level = new LevelTEST();
		Sprite.setLevel(level);
		
		new AnimationTimer() {
			
			public void handle(long now) {
				
				level.player.control(input, mouse);
				for(int i=0; i<level.sprites.size(); i++){
					level.sprites.get(i).update();
				}
				for(int i=0; i<level.collisions.size(); i++){
					level.collisions.get(i).collision(level.sprites);
				}
				level.player.camera();
				gc.clearRect(0, 0, window_w, window_h);
				for(int i=0; i<level.sprites.size(); i++){
					level.sprites.get(i).render(gc);
				}
				//System.out.println(level.sprites.size());
			}
		}.start();
		
		s.show();
	}
}

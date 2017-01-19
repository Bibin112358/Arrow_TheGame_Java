import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player extends Move{

	public Player(double w, double h) {
		// TODO Auto-generated constructor stub
		//all test
		this.h = h;
		this.w = w;
	}
	Color  color = Color.BLUE; //test
	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub
		super.render(gc);
		gc.setFill(color);//test
		gc.fillRect(r_x, r_y, w, h); //test purpose
		
	}
	
	
	@Override
	public void update() {
		double t=10; //maybe for different FPS
		// TODO Auto-generated method stub
		//super.update();
		
		//gravity
		vy = vy + 0.01*t;
		
		x = x + vx*t;
		y = y + vy*t;
		
		
		//possible player tracking camera
		if(Main.window_w < r_x+w){
			world_x = world_x -10;
			System.out.println(world_x);
			System.out.println(x);
			System.out.println(r_x);
		}
	}
	
	//collision?
	@Override
	public void collision(Sprite... sprites) {//test
		// TODO Auto-generated method stub
		//super.collision(sprites);
		color = Color.BLUE;
		for(Sprite spr:sprites){
			if(intersects(spr) && !spr.equals(this)){
				color = Color.RED;
			}
		}
	}
	
	
	//control
	public void control(ArrayList<String> input){
	
		if(input.contains("RIGHT")){
			vx=1;
		}else if(input.contains("LEFT")){
			vx=-1;
		}else{
			vx=0;
		}
		if(input.contains("UP")){
			vy=-1.5;
		}
		
		if(input.contains("R")){
			x=0;y=0; vx=0; vy=0;
		}
	}
}

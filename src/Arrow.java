import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Arrow extends Move {

	//TODO test
	double sx, sy; //coordinates in center of gravity, middle of arrow
	//x and y are tip of the arrow
	double bx, by; //beginning of arrow
	double l=40; //length, frome b(x,y) to (x,y)
	double s=1/3.0; //proportion: b(x,y)-s(x,y)-(x,y)
	boolean hit; //true if hit smh
	Sprite hitobj; //hit object
	double Dx, Dy, Dbx, Dby; //vectors from hit(x,y) to tip(x,y) and beginning b(x,y)
	
	public Arrow(double x, double y,double vx, double vy) {
		this.sx = x;
		this.sy = y;
		this.vx = vx;
		this.vy = vy;
		hit=false;
		h=0;
		w=0;
		level.addCollisions(this);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		//super.update();
		//t different FPS?
		if(!hit){
			vy = vy + g*t;
			
			sx = sx + vx;
			sy = sy + vy;
			
			double k = (Math.sqrt(vy*vy +vx*vx))/l;		
		
			x = sx + vx/k * s;
			y = sy + vy/k * s;
			bx = sx - vx/k * (1-s);
			by = sy - vy/k * (1-s);
		}else{
			x=hitobj.x+Dx;
			y=hitobj.y+Dy;
			bx=hitobj.x+Dbx;
			by=hitobj.y+Dby;
			//rotate?
		}
	}
	
	@Override
	public void render(GraphicsContext gc) {
		super.render(gc);
		//TODO test
		gc.setFill(Color.ORANGE);
		gc.strokeLine(bx, by, x, y);
		//lazy incorrect: (heavy point at front)
		//gc.strokeLine(sx+world_x -2*(x-sx), sy+world_y-2*(y-sy), sx + world_x, sy + world_y);
	}
	
	@Override
	public void collision(ArrayList<Sprite> sprites) {
		// TODO Auto-generated method stub
		//super.collision(sprites);
		if(hit){
			return;
		}
		for(Sprite spr:sprites){
			if(intersects(spr) && !spr.equals(this)){
				if(spr instanceof Brick){
					vy=0;
					vx=0;
					g=0;
					level.collisions.remove(this); //after one hit, shouldn't collide/harm any
					hit=true;
					hitobj = spr;
					Dx = x-hitobj.x;
					Dy = y-hitobj.y;
					Dbx= bx-hitobj.x;
					Dby= by-hitobj.y;
					//rotate?
				}
				if(spr instanceof Target){
					Target t =(Target) spr;
					if((x-spr.x)*(x-spr.x)+(y-spr.y)*(y-spr.y) >= t.r*t.r){
						vx=0;
						vy=0;
					}
				}
			}
		}
	}
	
	@Override
	public void moveCamera(double dx, double dy) {
		// TODO Auto-generated method stub
		super.moveCamera(dx, dy);
		sx = sx - dx;
		sy = sy - dy;
		bx = bx - dx;
		by = by - dy;
	}
}

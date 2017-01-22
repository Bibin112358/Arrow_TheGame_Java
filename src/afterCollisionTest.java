import java.util.Scanner;

import javafx.geometry.Rectangle2D;

class Rect{
	int x1, y1, x2, y2, vx, vy;
	public Rect(int _x1, int _y1, int _x2, int _y2, int vx, int vy) {
		x1 = _x1;
		y1 = _y1;
		x2 = _x2;
		y2 = _y2;
	}
	
	public boolean intersects(Rect r) {
        return r.x1 < x2 && r.y1 < y2 && r.x2 > x1 && r.y2 > y1;
    }
}
public class afterCollisionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rect rect1, rect2;
		int x1, y1, x2, y2, vx, vy;
		Scanner s = new Scanner(System.in);
		x1 = s.nextInt();
		y1 = s.nextInt();
		x2 = s.nextInt();
		y2 = s.nextInt();
		vx = s.nextInt();
		vy = s.nextInt();
		rect1 = new Rect(x1, y1, x2, y2, vx, vy);
		x1 = s.nextInt();
		y1 = s.nextInt();
		x2 = s.nextInt();
		y2 = s.nextInt();
		rect2 = new Rect(x1, y1, x2, y2, 0, 0);
		
		if(rect1.intersects(rect2)){
			int moveX, moveY, ColX, ColY;
			if(vx>0){
				moveX = rect1.x2;
				ColX = rect2.x1;
			}else{
				moveX = rect1.x1;
				ColX = rect2.x2;
			}
			
			if(vy>0){
				moveY = rect1.y2;
				ColY = rect2.y1;
			}else{
				moveY = rect1.y1;
				ColY = rect2.y2;
			}
			
			//(moveX - ColX)/vx;
			//(moveY - ColY)/vy;
		}
	}

}

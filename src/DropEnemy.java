
public class DropEnemy extends Enemy {
	public DropEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 1;
	}
	public void move() {
		super.move();
		vy = vy + (0.1 * GameWorld.stage );
	}
	public void draw(MyFrame f) {
		f.setColor(255, 80, 200);
		f.fillRect(x, y, 40, 40);
	}
}
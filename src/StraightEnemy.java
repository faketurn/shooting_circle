
public class StraightEnemy extends Enemy {
	public StraightEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 2;
		score = 2;
	}
	public void draw(MyFrame f) {
		f.setColor(255, 30, 180);
		f.fillRect(x + 5, y, 20, 30);
	}
}

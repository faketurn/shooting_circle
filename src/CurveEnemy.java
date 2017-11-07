
public class CurveEnemy extends Enemy {
	public CurveEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 6;
		score = 60;
	}
	public void move() {
		super.move();
		int stage = GameWorld.stage;
		if (GameWorld.stage > 5) {
		    stage = 5;
		}
		if (x < GameWorld.player.x) {
			x += stage;
		} else {
			x -= stage;
		}
	}
	public void draw(MyFrame f) {
		f.setColor(255, 190, 180);
		f.fillRect(x, y, 22, 22);
	}
}

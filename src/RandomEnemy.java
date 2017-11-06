
public class RandomEnemy extends Enemy {
	public RandomEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 4;
		score = 3;
	}
	public void move() {
		super.move();
		vx = (Math.random() * 4 * GameWorld.stage) - (2 * GameWorld.stage);
        if (vx > 5) {
            vx = 4;
        }
	}
	public void draw(MyFrame f) {
		f.setColor(255, 50, 150);
		f.fillRect(x, y, 50, 50);
	}
}

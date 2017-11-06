
public class EnemyBase extends Enemy {
	public EnemyBase(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 5 * GameWorld.stage;
		score = 100 * GameWorld.stage;
	}
	public void move() {
		super.move();
		if (x < 100) { vx = GameWorld.stage; }
		if (400 < x) { vx = -GameWorld.stage; }
		if (Math.random() < 0.003) {
			GameWorld.enemies.add(new StraightEnemy(x, y, 0, 1 + GameWorld.stage));
		}
		if (Math.random() < 0.02) {
			GameWorld.enemies.add(new RandomEnemy(x, y, 0, GameWorld.stage));
		}
		if (Math.random() < 0.02) {
			GameWorld.enemies.add(new DropEnemy(x, y, 0, GameWorld.stage));
		}
		if (Math.random() < 0.01) {
			GameWorld.enemies.add(new CurveEnemy(x, y, 0, GameWorld.stage));
		}
	}
	public void draw(MyFrame f) {
		f.setColor(255, 20, 150);
		f.fillOval(x,  y, 40, 40);
	}
}

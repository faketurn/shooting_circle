
public class Character {
	double x;
	double y;
	double vx;
	double vy;
	public Character(double x, double y, double vx, double vy) {
		// コンストラクタ
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	public void move() {
		x += vx;
		y += vy;
	}
	public void draw(MyFrame f) {
		f.setColor(100, 100, 100);
		f.fillRect(x, y, 30, 30);
	}
}

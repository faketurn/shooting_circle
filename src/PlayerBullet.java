
public class PlayerBullet extends Character {
	public PlayerBullet(double x, double y, double vx, double vy) {
// extendsしたCharacterクラスのコンストラクタ呼び出す
		super(x, y, vx, vy);
	}
	public void draw(MyFrame f) {
		f.setColor(255, 255, 255);
		f.fillRect(x + 12, y - 26, 6, 20);
	}
}

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Character implements KeyListener {
	private Boolean pressLeft = false;
	private Boolean pressRight = false;
	public Player(double x, double y, double vx, double vy) {
// extendsしたCharacterクラスのコンストラクタ呼び出す
		super(x, y, vx, vy);
	}
	public void draw(MyFrame f) {
		f.setColor(0, 255, 255);
		f.fillRect(x, y, 30, 30);
	}
	public void shoot() {
		GameWorld.playerBullets.add(new PlayerBullet(x, y, 0, -20));
//		System.out.println("弾の数:" + GameWorld.playerBullets.size());
	}

	private int count;
	public int addInterval() {
		count++;
//		System.out.println(count);
		if (count >= 4) {
			count = 1;
		}
		return count;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			vx = -5;
			pressLeft = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			vx = 5;
			pressRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// スペースキーを押したとき、弾が生み出される
//			GameWorld.playerBullets.add(new PlayerBullet(x, y, 0, -10));
			// 3Way弾
//			GameWorld.playerBullets.add(new PlayerBullet(x, y, 4, -10));
//			GameWorld.playerBullets.add(new PlayerBullet(x, y, -4, -10));
//			System.out.println("弾の数:" + GameWorld.playerBullets.size());
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    System.out.println("Enterキーが入力されました");
		    GameWorld.enterPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (!pressRight) {
				vx = 0;
			}
			pressLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (!pressLeft) {
				vx = 0;
			}
			pressRight = false;
		}
	}

	public void move() {
		super.move();
		// win10では0、370ではなく左右それぞれ8pxの差がある模様
//		if (x < 0) { x = 0; }
//		if (370 < x) { x = 370; }
		if (x < 8) { x = 8; }
		if (462 < x) { x = 462; }
	}
}

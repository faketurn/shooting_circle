import java.util.Vector;

/**
 * GameFrameはさまざまなキャラクタをフレーム上に出現させておく
 * @author syoji
 *
 */

public class GameFrame extends MyFrame {
	public void run() {
//	    使用可能なフォントの表示
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		String[] fs = ge.getAvailableFontFamilyNames();
//		for (String name : fs) {
//			System.out.println(name);
//		}
        // 時機の登場位置
        GameWorld.player = new Player(30, 660, 0, 0);
        // キーボードに反応するよう、イベントリスナー登録
        addKeyListener(GameWorld.player);
        GameWorld.stage = 1;
        GameWorld.score = 0;

		while (true) {
		    GameWorld.player.x = 30;
		    GameWorld.player.y = 660;
    		GameWorld.playerBullets = new Vector<PlayerBullet>();
    		GameWorld.enemies = new Vector<Enemy>();
            GameWorld.enemies.add(new EnemyBase(100, 90, GameWorld.stage, 0));
    		GameWorld.enterPressed = false;

    		while(true) {
    			clear();
    			setColor(255, 255, 255);
    			// 情報表示
                drawString("stage " + GameWorld.stage, 400, 50, 18);
                drawString("enemies " + GameWorld.enemies.size(), 378, 75, 18);
                drawString("score " + GameWorld.score, 25, 60, 34);

                // 自機と敵機表示
    			GameWorld.player.draw(this);
    			GameWorld.player.move();
    			movePlayerBullets(GameWorld.player.addInterval());
    			moveEnemies();
    			checkPlayerAndEnemies();
    			checkPlayerBulletsAndEnemies();
    			System.out.println(GameWorld.enemies.size());
    			if (GameWorld.enemies.size() == 0) {
    				setColor(255, 255, 50);
                    drawString("STAGE CLEAR", 55, 300, 60);
                    setColor(255, 255, 255);
                    fillRect(80, 353, 330, 50);
                    setColor(0, 0, 0);
                    drawString("NEXT STAGE", 95, 390, 40);
                    setColor(0, 0, 0);
                    drawString("⏎", 362, 390, 24);
                    setColor(0, 0, 0);
                    drawString("ENTER", 360, 367, 11);
    				if (GameWorld.enterPressed) {
    				    GameWorld.stage++;
    				    break;
    				}
    			} else if (GameWorld.player.y < 0) {
    				setColor(255, 0, 0);
    				drawString("GAME OVER", 80, 300, 60);
                    setColor(255, 255, 255);
                    fillRect(30, 353, 440, 50);
                    setColor(0, 0, 0);
                    drawString("BACK to STAGE 1", 45, 390, 40);
                    setColor(0, 0, 0);
                    drawString("⏎", 427, 390, 24);
                    setColor(0, 0, 0);
                    drawString("ENTER", 425, 367, 11);
    				if (GameWorld.enterPressed) {
    				    GameWorld.stage = 1;
    				    GameWorld.score = 0;
    				    break;
    				}
    			}
    			sleep(0.03);
    		}
		}
	}
	public void movePlayerBullets(int interval) {
		/**
		 * オートショット+スペースキーでのショット
		 */
		if (interval % 3 == 0) {
			GameWorld.player.shoot();
		}
		int i = 0;
		while (i < GameWorld.playerBullets.size()) {
			PlayerBullet b = GameWorld.playerBullets.get(i);
			b.draw(this);
			b.move();
			if (b.y < 0) {
				GameWorld.playerBullets.remove(i);
			} else {
				i++;
			}
		}
	}
	public void moveEnemies() {
		for (int i = 0; i < GameWorld.enemies.size(); i++){
			Enemy e = GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
		int i = 0;
		while (i < GameWorld.enemies.size()) {
			Enemy e = GameWorld.enemies.get(i);
			if (e.y > 720) {
				GameWorld.enemies.remove(i);
			} else {
				i++;
			}
		}
	}
	public void checkPlayerAndEnemies() {
		for (int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			if (checkHit(GameWorld.player, e, 30)) {
				System.out.println("やられた！");
				GameWorld.player.y = -1000;
			}
		}
	}
	public void checkPlayerBulletsAndEnemies() {
		int i = 0;
		while (i < GameWorld.playerBullets.size()) {
			PlayerBullet b = GameWorld.playerBullets.get(i);
			int j = 0;
			int bulletLife = 1;
			while (j < GameWorld.enemies.size()) {
				Enemy e = GameWorld.enemies.get(j);
				if (checkHit(e, b, 30)) {
					System.out.println("あたった！");
					bulletLife--;
					e.life--;
				}
				if (e.life < 0) {
				    GameWorld.score += e.score;
					GameWorld.enemies.remove(j);
				} else {
					j++;
				}
			}
			if (bulletLife <= 0) {
				GameWorld.playerBullets.remove(i);
			} else {
				i++;
			}
		}
	}
	public boolean checkHit(Character a, Character b, int distance) {
		if (Math.abs(a.x - b.x) <= distance && Math.abs(a.y - b.y) <= distance) {
			return true;
		} else {
			return false;
		}
	}
}

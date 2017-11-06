
public class AutoShootInterval {
	private int count;
	public int add() {
		count++;
//		System.out.println(count);
		if (count >= 4) {
			count = 1;
		}
		return count;
	}
}

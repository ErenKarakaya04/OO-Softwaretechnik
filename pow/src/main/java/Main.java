
public class Main {

	public static void main(String[] args) throws Exception {
		View view = new View();
		SimplePoW pow = new SimplePoW();
		Controller controller = new Controller(pow, view);
		pow.attach(view);
		view.createAndShowGui();

	}
}

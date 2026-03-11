
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private final View view;
	private final SimplePoW pow;

	public Controller(SimplePoW pow, View view) {
		this.view = view;
		this.pow = pow;

		this.view.setStartButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				if (!Controller.this.pow.isMining) {
					Controller.this.pow.message = Controller.this.view.getMessage();
					Controller.this.pow.threadCount = Controller.this.view.getThreadCount();
					Controller.this.pow.difficulty = Controller.this.view.getDifficulty();
					Controller.this.pow.startMining();
                }
			}
		});

		this.view.setStopButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				Controller.this.pow.stopMining();
			}
		});
	}

}

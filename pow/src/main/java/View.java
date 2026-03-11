
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View implements Observer {

	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	JTextField messageField = new JTextField(20);
	JTextField threadCountField = new JTextField(4);
	JTextField difficultyField = new JTextField(4);

	private JLabel hashLabel = new JLabel("No hash found yet...");

	public void createAndShowGui() {
		JFrame frame = new JFrame("PoW Miner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());

		mainPanel.add(startButton);
		mainPanel.add(stopButton);
		mainPanel.add(new JLabel("Message:"));
		mainPanel.add(messageField);
		mainPanel.add(new JLabel("Difficulty:"));
		mainPanel.add(difficultyField);
		mainPanel.add(new JLabel("Thread Count:"));
		mainPanel.add(threadCountField);
		mainPanel.add(new JLabel("Found Nonce+Hash:"));
		mainPanel.add(hashLabel);

		frame.setContentPane(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public void setStartButtonListener(ActionListener listener) {
		this.startButton.addActionListener(listener);
	}

	public void setStopButtonListener(ActionListener listener) {
		this.stopButton.addActionListener(listener);
	}

	public int getDifficulty() {
		return Integer.parseInt(difficultyField.getText());
	}

	public String getMessage() {
		return messageField.getText();
	}

	public int getThreadCount() {
		return Integer.parseInt(threadCountField.getText());
	}

	@Override
	public void update(String result) {
		hashLabel.setText(result);
	}

}

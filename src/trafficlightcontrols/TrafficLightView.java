package trafficlightcontrols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TrafficLightView implements Observer {

    private final TrafficLightModel model;
    private JFrame frame;
    private JButton button;
    private JLabel display;

    public TrafficLightView(TrafficLightModel model) {
        this.model = model;

        this.frame = new JFrame("Ampelsteuerung");
        this.button = new JButton("Drücken");
        this.display = new JLabel("—", SwingConstants.CENTER);

        this.frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Display oben
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.frame.add(display, gbc);

        // Button unten
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.frame.add(button, gbc);

        this.frame.setSize(300, 300);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void addButtonListener(ActionListener listener) {
        button.addActionListener(listener);
    }

    private void renderDisplay(Color state) {
        SwingUtilities.invokeLater(() -> {
            display.setText("Phase: " + state);
        });
    }


    @Override
    public void update(Color state) {
        renderDisplay(state);
    }
}

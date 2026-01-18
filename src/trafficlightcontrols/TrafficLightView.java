package trafficlightcontrols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TrafficLightView implements Observer {

    private final TrafficLightModel model;
    private JFrame frame;
    private JButton button;
    private JPanel trafficLightPanel;

    private java.awt.Color redDisplay;
    private java.awt.Color amberDisplay;
    private java.awt.Color greenDisplay;

    public TrafficLightView(TrafficLightModel model) {
        this.model = model;

        frame = new JFrame("Ampelsteuerung");
        frame.setLayout(new BorderLayout());

        redDisplay = java.awt.Color.RED.darker().darker();
        amberDisplay = java.awt.Color.YELLOW.darker().darker();
        greenDisplay = java.awt.Color.GREEN.darker().darker();

        trafficLightPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Hintergrund
                g.setColor(java.awt.Color.DARK_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());

                // Rot
                g.setColor(redDisplay);
                g.fillOval(50, 20, 80, 80);

                // Gelb
                g.setColor(amberDisplay);
                g.fillOval(50, 120, 80, 80);

                // Grün
                g.setColor(greenDisplay);
                g.fillOval(50, 220, 80, 80);
            }
        };

        trafficLightPanel.setBackground(java.awt.Color.BLACK);

        button = new JButton("Fußgänger drücken");

        frame.add(trafficLightPanel, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.setSize(220, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addButtonListener(ActionListener listener) {
        button.addActionListener(listener);
    }

    // MUSS erhalten bleiben: hier wird die Anzeige "umgeschaltet"
    private void renderDisplay(trafficlightcontrols.Color state) {
        SwingUtilities.invokeLater(() -> {
            // erst alles "aus" (dunkel)
            redDisplay = java.awt.Color.RED.darker().darker();
            amberDisplay = java.awt.Color.YELLOW.darker().darker();
            greenDisplay = java.awt.Color.GREEN.darker().darker();

            // dann abhängig vom Enum "an"
            switch (state) {
                case Red:
                    redDisplay = java.awt.Color.RED;
                    break;
                case RedAmber:
                    redDisplay = java.awt.Color.RED;
                    amberDisplay = java.awt.Color.YELLOW;
                    break;
                case Green:
                    greenDisplay = java.awt.Color.GREEN;
                    break;
                case Amber:
                    amberDisplay = java.awt.Color.YELLOW;
                    break;
            }

            trafficLightPanel.repaint();
        });
    }

    @Override
    public void update(trafficlightcontrols.Color state) {
        renderDisplay(state);
    }
}

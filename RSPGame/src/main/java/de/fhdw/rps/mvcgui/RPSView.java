package de.fhdw.rps.mvcgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RPSView implements Observer{

    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;

    public void createAndShowGui() {
        JFrame frame = new JFrame("OOSE RPS Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3, 1, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));

        // Info Row
        JLabel hpPlayerOneLabel = new JLabel("HP:");
        JLabel infoLabel = new JLabel("OOSE RPS Game");
        JLabel hpPlayerTwoLabel = new JLabel("HP:");

        mainPanel.add(createWrapper(hpPlayerOneLabel));
        mainPanel.add(createWrapper(infoLabel));
        mainPanel.add(createWrapper(hpPlayerTwoLabel));

        // Player Row
        ImageIcon image = new ImageIcon(RPSView.class.getResource("/rock.png"));
        JLabel playerOneLabel = new JLabel(image);
        JLabel playerTwoLabel = new JLabel(image);
        JPanel actionPanel = new JPanel(new GridLayout(2, 1, 0,50));
        JLabel playerOneAction = new JLabel("P1 Action");
        JLabel playerTwoAction = new JLabel("P2 Action");
        actionPanel.add(playerOneAction);
        actionPanel.add(playerTwoAction);

        mainPanel.add(createWrapper(playerOneLabel));
        mainPanel.add(createWrapper(actionPanel));
        mainPanel.add(createWrapper(playerTwoLabel));

        // Button Row
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        mainPanel.add(createWrapper(rockButton));
        mainPanel.add(createWrapper(paperButton));
        mainPanel.add(createWrapper(scissorsButton));

        // Set window
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void setRockButtonEventListener(ActionListener listener) {
        this.rockButton.addActionListener(listener);
    }

    public void setPaperButtonEventListener(ActionListener listener) {
        this.paperButton.addActionListener(listener);
    }

    public void setScissorsButtonEventListener(ActionListener listener) { this.scissorsButton.addActionListener(listener); }

    //Renderfunktion, um nur nötige Elemente neu zu rendern
    private void render(){
        //ToDo
    }
    /**
     * GUI-Specific Code. You can ignore this
     */
    private static JPanel createWrapper(JComponent component) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.add(component);
        return  wrapper;
    }

    @Override
    public void update(){
        this.render();
    }
}
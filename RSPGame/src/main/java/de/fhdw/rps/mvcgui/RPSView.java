package de.fhdw.rps.mvcgui;

import de.fhdw.rps.Move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RPSView implements Observer{

    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;


    public JFrame frame;
    public JPanel mainPanel;
    public JLabel hpPlayerOneLabel;
    public JLabel hpPlayerTwoLabel;
    public JLabel infoLabel;
    public ImageIcon image;
    public JLabel playerOneLabel;
    public JLabel playerTwoLabel;
    public JPanel actionPanel;
    public JLabel playerOneAction;
    public JLabel playerTwoAction;

    private ImageIcon rock = new ImageIcon("src/main/resources/rock.png");
    private ImageIcon paper = new ImageIcon("src/main/resources/paper.png");
    private ImageIcon scissors = new ImageIcon("src/main/resources/scissor.png");

    public RPSView () {
        frame = new JFrame("OOSE RPS Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3, 1, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));

        // Info Row
        hpPlayerOneLabel = new JLabel("HP:");
        infoLabel = new JLabel("OOSE RPS Game");
        hpPlayerTwoLabel = new JLabel("HP:");

        mainPanel.add(createWrapper(hpPlayerOneLabel));
        mainPanel.add(createWrapper(infoLabel));
        mainPanel.add(createWrapper(hpPlayerTwoLabel));

        // Player Row
        playerOneLabel = new JLabel(rock);
        playerTwoLabel = new JLabel(rock);
        actionPanel = new JPanel(new GridLayout(2, 1, 0,50));
        playerOneAction = new JLabel("P1 Action");
        playerTwoAction = new JLabel("P2 Action");
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

    /**
     * GUI-Specific Code. You can ignore this
     */
    private static JPanel createWrapper(JComponent component) {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.add(component);
        return  wrapper;
    }

    private void refreshAction(Move move, JLabel actionLabel) {
        switch(move) {
            case ROCK: actionLabel.setIcon(rock); break;
            case PAPER: actionLabel.setIcon(paper); break;
            case SCISSORS: actionLabel.setIcon(scissors); break;
        }
    }
    @Override
    public void update(int p1Health, int p2Health, Move p1Move, Move p2Move){
        hpPlayerOneLabel.setText("HP: " + p1Health);
        hpPlayerTwoLabel.setText("HP: " + p2Health);
        refreshAction(p1Move, playerOneLabel);
        refreshAction(p2Move, playerTwoLabel);

    }
}
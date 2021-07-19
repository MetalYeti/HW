package JAVA1.HW8;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private BattleMap battleMap;
    private Settings settings;

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);
        setTitle("TicTacToe");

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton button = new JButton("Start new game");
        panel.add(button);

        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);
        settings = new Settings(this);

        button.addActionListener(e -> settings.setVisible(true));
        buttonExit.addActionListener(e -> System.exit(0));


        setVisible(true);
    }

    void startNewGame(int fieldSize, int winLength) {
        battleMap.startNewGame(fieldSize, winLength);
    }
}

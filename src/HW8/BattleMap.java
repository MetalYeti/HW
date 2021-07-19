package HW8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {
    private MainWindow mainWindow;
    private int fieldSize;
    private int winLength;
    private BattleMap map;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;


    public BattleMap(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        map = this;
        setBackground(Color.LIGHT_GRAY);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isInit) {
                    int cellX = e.getX() / cellWidth;
                    int cellY = e.getY() / cellHeight;

                    if (!Logic.isGameFinished) {
                        Logic.humanTurn(cellX, cellY);
                    }
                    if (Logic.isGameFinished) {
                        repaint();
                        JOptionPane.showMessageDialog(map, Logic.winner);
                    }
                    repaint();
                }
            }
        });
    }

    void startNewGame(int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLength = winLength;

        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.GRAY);
        ((Graphics2D) g).setStroke(new BasicStroke(2f));

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, i, j);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, i, j);
                }
            }
        }
        if (Logic.isGameFinished && !Logic.isDraw) {
            drawWinningLine(g, Logic.winningCells);
        }

    }

    private void drawX(Graphics g, int y, int x) {
        g.setColor(Color.BLUE);
        ((Graphics2D) g).setStroke(new BasicStroke(15f));

        int margin = (int) Math.round(cellWidth * 0.15);

        g.drawLine(x * cellWidth + margin, y * cellHeight + margin,
                (x + 1) * cellWidth - margin, (y + 1) * cellHeight - margin);
        g.drawLine((x + 1) * cellWidth - margin, y * cellHeight + margin,
                x * cellWidth + margin, (y + 1) * cellHeight - margin);

    }

    private void drawO(Graphics g, int y, int x) {
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(10f));

        int margin = (int) Math.round(cellWidth * 0.15);

        g.drawOval(x * cellWidth + margin, y * cellHeight + margin, cellWidth - margin * 2, cellHeight - margin * 2);
    }

    private void drawWinningLine(Graphics g, int[][] winningCells) {
        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(10f));

        int deltaX = winningCells[1][0] - winningCells[0][0];
        int deltaY = winningCells[1][1] - winningCells[0][1];

        for (int[] xy : winningCells) {
            if (deltaX == 0) {
                g.drawLine(xy[0] * cellWidth + cellWidth / 2, xy[1] * cellHeight,
                        xy[0] * cellWidth + cellWidth / 2, (xy[1] + 1) * cellHeight);

            } else if (deltaY == 0) {
                g.drawLine(xy[0] * cellWidth, xy[1] * cellHeight + cellHeight / 2,
                        (xy[0] + 1) * cellWidth, xy[1] * cellHeight + cellHeight / 2);

            } else if (deltaX == 1 && deltaY == 1) {
                g.drawLine(xy[0] * cellWidth, xy[1] * cellHeight,
                        (xy[0] + 1) * cellWidth, (xy[1] + 1) * cellHeight);

            } else if (deltaX == 1 && deltaY == -1) {
                g.drawLine(xy[0] * cellWidth, (xy[1] + 1) * cellHeight,
                        (xy[0] + 1) * cellWidth, xy[1] * cellHeight);
            }
        }
    }
}

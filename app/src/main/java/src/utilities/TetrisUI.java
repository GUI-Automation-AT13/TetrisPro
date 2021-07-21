package src.utilities;

import src.shapes.Shape;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import java.util.Timer;

public class TetrisUI extends JFrame implements KeyListener {
    private GameBoard gameBoard = new GameBoard();
    private Game game = new Game();
    private RandomShape randomShape;
    private Shape shape;
    private static final int SIZE_IMAGE = 40;
    private int scaleWidth = gameBoard.getGameBoardWidth();
    private int scaleHeight = gameBoard.getGameBoardHeight();
    private int sizeWindowWidth = scaleWidth * SIZE_IMAGE;
    private int sizeWindowHeight = scaleHeight * SIZE_IMAGE;
    private static final int SPEED = 300;
    private static JLabel[][] labelArray;
    private Timer timer;
    private final GameOver gameOver = new GameOver();
    private static final int SAFE_SPACE = 3;
    private static final int SAFE_ZONE = 8;
    private boolean gameInCourse = true;

    public TetrisUI() { }

    /**
     * Method initialize the graphical interface.
     */
    public void init() {
        timer = new Timer();
        randomShape = new RandomShape();
        setSize(sizeWindowWidth, sizeWindowHeight);
        setTitle("TETRIS");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        labelArray = new JLabel[scaleHeight][scaleWidth];
        setLayout(new GridLayout(scaleHeight, scaleWidth));
        for (int row = 0; row < scaleHeight; row++) {
            for (int col = 0; col < scaleWidth; col++) {
                Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
                JLabel label = new JLabel();
                label.setName("Tetris");
                label.setOpaque(true);
                label.setBackground(Color.black);
                label.setBorder(border);
                labelArray[row][col] = label;
                add(label);
            }
        }
        shape();
        setVisible(true);
        addKeyListener(this);
        start();
    }
    /**
     * Method to initialize and show a shape.
     */
    public void shape() {
        shape = randomShape.getShape(randomShape.randomNumberGenerator());
        updateShape(Color.green);
    }
    /**
     * Refresh the icon of a label where it is our Alien.
     */
    public void printShape() {
        gameBoard.setGameBoardArray(shape);
    }

    /**
     * @Override keyTyped.
     */
    @Override
    public void keyTyped(final KeyEvent e) {
        return;
    }

    /**
     * @Override keyPressed.
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (!game.checkCollision(shape, gameBoard, DirectionType.Right)) {
                    updateShape(Color.black);
                    shape.moveRight();
                    updateShape(Color.green);
                }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!game.checkCollision(shape, gameBoard, DirectionType.Left)) {
                    updateShape(Color.black);
                    shape.moveLeft();
                    updateShape(Color.green);
                }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (!game.checkCollision(shape, gameBoard, DirectionType.Down)) {
                updateShape(Color.black);
                shape.moveDown();
                updateShape(Color.green);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            updateShape(Color.black);
            if (game.checkCollision(shape, gameBoard, DirectionType.Rotate)) {
                shape.rotate();
                shape.rotate();
                shape.rotate();
                updateShape(Color.green);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            lose();
        }
    }

    /**
     * @Override keyReleased.
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        return;
    }

    /**
     * Method to initialize timer.
     */
    public void start() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (!validSpace()) {
                    gameInCourse = false;
                    lose();
                    repaint();
                } else {
                    if (!game.checkCollision(shape, gameBoard, DirectionType.Down)) {
                        updateShape(Color.black);
                        shape.moveDown();
                        updateShape(Color.green);
                    } else {
                        gameBoard.setGameBoardArray(shape);
                        gameBoard.updateLinesOnGameBoard();
                        updateGameboard();
                        shape();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, SPEED);
    }
    /**
     * updates shape in UI.
     */
    public void updateShape(final Color color) {
        int y = shape.getyPosition();
        int x = shape.getxPosition();
        for (int i = 0; i < shape.getContainer().length - shape.getDownRows(); i++) {
            for (int j = shape.getLeftColumns(); j < shape.getContainer()[0].length - shape.getRightColumns(); j++) {
                if (shape.getContainer()[i][j]) {
                    updateColorOfLabel(this.labelArray[i + y][j + x], color);
                }
            }
        }
    }

    /**
     * changes color of the label to other.
     */
    public void updateColorOfLabel(final JLabel label, final Color color) {
        label.setBackground(color);
    }

    /**
     * changes color of the labels of gameboard.
     */
    public void updateGameboard() {
        for (int row = 0; row < scaleHeight; row++) {
            for (int col = 0; col < scaleWidth; col++) {
                if (gameBoard.getGameBoardArray()[row][col]) {
                    labelArray[row][col].setBackground(Color.red);
                } else {
                    labelArray[row][col].setBackground(Color.black);
                }
            }
        }
    }
    /**
     * Calls game over when losing game.
     */
    public void lose() {
        gameOver.showGameOver(this, timer, gameBoard);
    }

    /**
     * Method to check if there is enough space to put the shape.
     */
    private boolean validSpace() {
        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = SAFE_SPACE; j < gameBoard.getGameBoardArray()[i].length - SAFE_SPACE; j++) {
                if (!gameBoard.getGameBoardArray()[i][j]) {
                    count++;
                }
            }
        }
        return count == SAFE_ZONE;
    }
}

package src.utilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

public class GameOver {
    private static final int FONT_SIZE = 70;
    private static final int SCORE_FONT_SIZE = 40;
    private static final int PLAY_AGAIN_FONT_SIZE = 25;
    private static final int X_BOUND = 10;
    private static final int Y_BOUND = 5;
    private static final int WIDTH_BOUND = 500;
    private static final int HEIGHT_BOUND = 100;
    private static final int BUTTON_X_BOUND = 120;
    private static final int BUTTON_Y_BOUND = 300;
    private static final int BUTTON_WIDTH_BOUND = 170;
    private static final int BUTTON_HEIGHT_BOUND = 80;
    private static final int SCORE_X_BOUND = 80;
    private static final int SCORE_Y_BOUND = 400;
    private static final int SCORE_WIDTH_BOUND = 400;
    private static final int SCORE_HEIGHT_BOUND = 100;

    public GameOver() {

    }
    /**
     * Shows game over interface.
     */
    public void showGameOver(final JFrame frame, final Timer timer, GameBoard gameBoard) {
        frame.getContentPane().removeAll();
        frame.getContentPane().setBackground(Color.black);
        JLabel gameOverLabel = new JLabel("Game over");
        JButton playAgain = new JButton("Play Again");
        JLabel scoreLabel = new JLabel();
        scoreLabel.setText("SCORE:" + String.valueOf(gameBoard.getScore()));
        gameOverLabel.setForeground(Color.white);
        gameOverLabel.setFont(new Font("Ink Free", Font.BOLD, FONT_SIZE));
        gameOverLabel.setBounds(X_BOUND, Y_BOUND, WIDTH_BOUND, HEIGHT_BOUND);
        playAgain.setBounds(BUTTON_X_BOUND, BUTTON_Y_BOUND, BUTTON_WIDTH_BOUND, BUTTON_HEIGHT_BOUND);
        playAgain.setBackground(Color.GRAY);
        playAgain.setFont(new Font("Ink Free", Font.BOLD, PLAY_AGAIN_FONT_SIZE) );
        playAgain.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                playAgain(frame, timer);
            }
        });
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(new Font("Ink Free", Font.BOLD, SCORE_FONT_SIZE));
        scoreLabel.setBounds(SCORE_X_BOUND, SCORE_Y_BOUND, SCORE_WIDTH_BOUND, SCORE_HEIGHT_BOUND);
        frame.add(gameOverLabel);
        frame.add(playAgain);
        frame.add(scoreLabel);
    }

    /**
     * @return an Instance of GameBoard to play again
     */
    public TetrisUI playAgain(final JFrame frame, final Timer timer) {
        frame.dispose();
        timer.cancel();
        TetrisUI newGame = new TetrisUI();
        newGame.init();
        return newGame;
    }
}

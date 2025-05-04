import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameWindow extends JFrame implements ActionListener, KeyListener {

    private Timer gameTimer;
    private int playerX = 50;
    private int playerY = 400;
    private int backgroundX = 0;
    private Random random;
    private int num1, num2, answer;
    private JLabel problemLabel;
    private JTextField answerField;
    private JButton submitButton;
    private boolean gameRunning = true;
    private BufferedImage backgroundImage;

    public GameWindow(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setFocusable(true);
        addKeyListener(this);

        random = new Random();
        gameTimer = new Timer(16, this);
        gameTimer.start();

        try {
            backgroundImage = ImageIO.read(new File("src/background.jpg")); // Or use getResource() for JARs
        } catch (IOException e) {
            System.err.println("Error loading background: " + e.getMessage());
            backgroundImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = backgroundImage.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 800, 600);
            g2d.dispose();
        }

        problemLabel = new JLabel();
        answerField = new JTextField(10);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> checkAnswer());

        JPanel minigamePanel = new JPanel();
        minigamePanel.add(problemLabel);
        minigamePanel.add(answerField);
        minigamePanel.add(submitButton);

        add(minigamePanel);

        generateProblem();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, backgroundX, 0, this);
            g.drawImage(backgroundImage, backgroundX + backgroundImage.getWidth(this), 0, this);
        }
        g.fillRect(playerX, playerY, 50, 50); // Draw player
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameTimer && gameRunning) {
            backgroundX -= 5;
            if (backgroundX < -backgroundImage.getWidth(this)) {
                backgroundX = 0;
            }
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle player movement here
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void generateProblem() {
        num1 = random.nextInt(10) + 2;
        num2 = random.nextInt(10) + 2;
        answer = num1 * num2;
        problemLabel.setText(num1 + " x " + num2 + " = ?");
        answerField.setText("");
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(answerField.getText());
            if (userAnswer == answer) {
                gameRunning = true;
            } else {
                generateProblem();
            }
        } catch (NumberFormatException ex) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameWindow("My Game"));
    }
}
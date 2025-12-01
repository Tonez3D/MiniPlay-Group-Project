/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;

import MiniPlay.Model.GameManager;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Crossword for MiniPlay
 *
 * Grid (6 rows x 6 cols):
 * # D A R T H
 * # I D A H O
 * # V O W E D
 * T I N E S #
 * A N I S E #
 * N E S T S #
 *
 * Across:
 * 1  DARTH - Traditional Sith name
 * 6  IDAHO - Its license plates say "Famous potatoes"
 * 7  VOWED - Swore
 * 8  TINES - Pointy bits on a fork
 * 9  ANISE - Biscotti flavoring
 * 10 NESTS - Birds' homes
 *
 * Down:
 * 1  DIVINE - Godly
 * 2  ADONIS - Hottie
 * 3  RAWEST - Least refined
 * 4  THESES - Requirements for some degrees
 * 5  HOD    - Mortar porter
 * 8  TAN    - Beachgoer's goal
 */

public class CrosswordGUI {

    private final JPanel panel;
    private final JTextField[][] cells;
    private final char[][] solution;
    private final boolean[][] isBlack;

    private final JLabel timerLabel;
    private Timer timer;
    private int elapsedSeconds = 0;
    private boolean solved = false;

    private final GameManager manager;

    public CrosswordGUI(GameManager manager) {
        this.manager = manager;

        // Solution grid
        solution = new char[][]{
                {'#','D','A','R','T','H'},
                {'#','I','D','A','H','O'},
                {'#','V','O','W','E','D'},
                {'T','I','N','E','S','#'},
                {'A','N','I','S','E','#'},
                {'N','E','S','T','S','#'}
        };

        // Black squares
        isBlack = new boolean[][]{
                {true,  false, false, false, false, false},
                {true,  false, false, false, false, false},
                {true,  false, false, false, false, false},
                {false, false, false, false, false, true },
                {false, false, false, false, false, true },
                {false, false, false, false, false, true }
        };

        cells = new JTextField[6][6];

        panel = new JPanel(new BorderLayout(20, 20));
        panel.setBackground(UITheme.BG);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ---- Top panel: title + timer ----
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        JLabel title = new JLabel("Mini Crossword");
        title.setFont(new Font("Serif", Font.BOLD, 26));
        title.setForeground(UITheme.ACCENT_DARK);

        timerLabel = new JLabel("Time: 00:00");
        timerLabel.setFont(new Font("Monospaced", Font.BOLD, 18));
        timerLabel.setForeground(UITheme.ACCENT_DARK);

        topPanel.add(title, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);
        panel.add(topPanel, BorderLayout.NORTH);

        // Center: Crossword grid
        JPanel gridPanel = new JPanel(new GridLayout(6, 6, 3, 3));
        gridPanel.setBackground(UITheme.ACCENT);

        DocumentListener listener = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { checkSolved(); }
            @Override public void removeUpdate(DocumentEvent e) { checkSolved(); }
            @Override public void changedUpdate(DocumentEvent e) { checkSolved(); }
        };

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (isBlack[r][c]) {
                    JLabel block = new JLabel();
                    block.setOpaque(true);
                    block.setBackground(Color.BLACK);
                    gridPanel.add(block);
                    cells[r][c] = null;
                } else {
                    JTextField tf = new JTextField();
                    tf.setHorizontalAlignment(JTextField.CENTER);
                    tf.setFont(new Font("SansSerif", Font.BOLD, 22));
                    tf.setBorder(BorderFactory.createLineBorder(UITheme.ACCENT_DARK, 1));
                    tf.setBackground(UITheme.PANEL);
                    tf.setForeground(Color.BLACK);
                    tf.getDocument().addDocumentListener(listener);

                    cells[r][c] = tf;
                    gridPanel.add(tf);
                }
            }
        }

        panel.add(gridPanel, BorderLayout.CENTER);

        // Right panel: clues
        JPanel cluesPanel = new JPanel();
        cluesPanel.setOpaque(false);
        cluesPanel.setLayout(new BoxLayout(cluesPanel, BoxLayout.Y_AXIS));

        JLabel acrossTitle = new JLabel("ACROSS");
        acrossTitle.setFont(new Font("Serif", Font.BOLD, 18));
        acrossTitle.setForeground(UITheme.ACCENT_DARK);
        cluesPanel.add(acrossTitle);
        cluesPanel.add(Box.createVerticalStrut(6));

        cluesPanel.add(makeClue("1  Traditional Sith name"));
        cluesPanel.add(makeClue("6  Its license plates say \"Famous potatoes\""));
        cluesPanel.add(makeClue("7  Swore"));
        cluesPanel.add(makeClue("8  Pointy bits on a fork"));
        cluesPanel.add(makeClue("9  Biscotti flavoring"));
        cluesPanel.add(makeClue("10 Birds' homes"));

        cluesPanel.add(Box.createVerticalStrut(12));

        JLabel downTitle = new JLabel("DOWN");
        downTitle.setFont(new Font("Serif", Font.BOLD, 18));
        downTitle.setForeground(UITheme.ACCENT_DARK);
        cluesPanel.add(downTitle);
        cluesPanel.add(Box.createVerticalStrut(6));

        cluesPanel.add(makeClue("1  Godly"));
        cluesPanel.add(makeClue("2  Hottie"));
        cluesPanel.add(makeClue("3  Least refined"));
        cluesPanel.add(makeClue("4  Requirements for some degrees"));
        cluesPanel.add(makeClue("5  Mortar porter"));
        cluesPanel.add(makeClue("8  Beachgoer's goal"));

        panel.add(cluesPanel, BorderLayout.EAST);

        // Bottom panel: Buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);

        // Back button
        JButton backBtn = new JButton("Back");
        backBtn.setFont(new Font("Serif", Font.BOLD, 16));
        backBtn.setBackground(UITheme.BUTTON);
        backBtn.setForeground(UITheme.BUTTON_TEXT);
        backBtn.addActionListener(e -> {
            timer.stop();
            manager.showMainMenu();
        });
        bottomPanel.add(backBtn);

        // Restart button
        JButton restartBtn = new JButton("Restart");
        restartBtn.setFont(new Font("Serif", Font.BOLD, 16));
        restartBtn.setBackground(UITheme.BUTTON);
        restartBtn.setForeground(UITheme.BUTTON_TEXT);
        restartBtn.addActionListener(e -> restartPuzzle());
        bottomPanel.add(restartBtn);

        // Check button
        JButton checkBtn = new JButton("Check");
        checkBtn.setFont(new Font("Serif", Font.BOLD, 16));
        checkBtn.setBackground(UITheme.BUTTON);
        checkBtn.setForeground(UITheme.BUTTON_TEXT);
        checkBtn.addActionListener(e -> checkAnswers());
        bottomPanel.add(checkBtn);


        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Timer
        timer = new Timer(1000, e -> {
            elapsedSeconds++;
            timerLabel.setText("Time: " + formatTime(elapsedSeconds));
        });
        timer.start();
    }

    // Helper: Create clue label
    private JLabel makeClue(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Serif", Font.PLAIN, 14));
        lbl.setForeground(UITheme.ACCENT_DARK);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }

    // Time formatting
    private String formatTime(int sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }

    // Restart puzzle
    private void restartPuzzle() {
        solved = false;
        elapsedSeconds = 0;
        timerLabel.setText("Time: 00:00");

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (!isBlack[r][c]) {
                    cells[r][c].setText("");
                    cells[r][c].setBackground(UITheme.PANEL);
                }
            }
        }

        timer.restart();
    }

    // Check answers
    private void checkAnswers() {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (!isBlack[r][c]) {
                    JTextField tf = cells[r][c];
                    String t = tf.getText().trim().toUpperCase();

                    if (t.isEmpty()) continue;

                    if (t.charAt(0) == solution[r][c]) {
                        tf.setBackground(new Color(180, 255, 180));
                    } else {
                        tf.setBackground(new Color(255, 180, 180));
                    }
                }
            }
        }
    }


    // Auto-check for completion
    private void checkSolved() {
        if (solved) return;

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                if (isBlack[r][c]) continue;

                String t = cells[r][c].getText().trim().toUpperCase();
                if (t.isEmpty()) return;
                if (t.charAt(0) != solution[r][c]) return;
            }
        }

        solved = true;
        timer.stop();

        JOptionPane.showMessageDialog(
                panel,
                "You solved it in " + formatTime(elapsedSeconds) + "!",
                "Puzzle Complete",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public JPanel getPanel() {
        return panel;
    }
}

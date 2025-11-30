/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import javax.swing.*;
import java.awt.*;

public class MainMenu {

    private JPanel panel;

    public MainMenu(GameManager manager) {

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(UITheme.BG);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ImageIcon rawLogo = new ImageIcon(
                getClass().getResource("/Images/miniplay_logo.png")
        );

        Image scaledImg = rawLogo.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(scaledImg);

        JLabel logoLabel = new JLabel(logo);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel("MiniPlay");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Serif", Font.BOLD, 36));
        title.setForeground(UITheme.ACCENT_DARK);

        JLabel subtitle = new JLabel("Relax • Play • Explore");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setFont(new Font("Serif", Font.PLAIN, 20));
        subtitle.setForeground(UITheme.ACCENT_DARK);

        JButton ticTacToeBtn = styledButton("Play Tic-Tac-Toe");
        JButton crosswordBtn = styledButton("Play Crossword");
        JButton wordSearchBtn = styledButton("Play Word Search");

        ticTacToeBtn.addActionListener(e -> manager.startTicTacToe());
        crosswordBtn.addActionListener(e -> manager.startCrossword());
        wordSearchBtn.addActionListener(e -> manager.startWordSearch());

        panel.add(Box.createVerticalStrut(40));
        panel.add(logoLabel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(title);
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(40));

        panel.add(ticTacToeBtn);
        panel.add(Box.createVerticalStrut(15));
        panel.add(crosswordBtn);
        panel.add(Box.createVerticalStrut(15));
        panel.add(wordSearchBtn);
    }

    private JButton styledButton(String text) {
        JButton b = new JButton(text);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setFont(new Font("Serif", Font.BOLD, 20));
        b.setBackground(UITheme.BUTTON);
        b.setForeground(UITheme.BUTTON_TEXT);
        b.setFocusPainted(false);
        b.setMaximumSize(new Dimension(300, 55));
        b.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        return b;
    }

    public JPanel getPanel() {
        return panel;
    }
}
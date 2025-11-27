package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import javax.swing.*;
import java.awt.*;

/**
 * Simple color-fill demo screen.
 */
public class ColorFillGUI {

    private JPanel panel;

    public ColorFillGUI(GameManager manager) {

        panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Color Fill Demo", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);

        JButton backBtn = new JButton("Back to Main Menu");
        backBtn.addActionListener(e -> manager.showMainMenu());
        panel.add(backBtn, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return panel;
    }
}
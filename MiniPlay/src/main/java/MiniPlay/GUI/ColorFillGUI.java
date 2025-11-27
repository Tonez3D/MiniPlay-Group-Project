/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import javax.swing.*;
import java.awt.*;

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
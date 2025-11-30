/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.GUI;

import MiniPlay.Model.GameManager;
import javax.swing.*;
import java.awt.*;

public class UIStyled {

    public static JButton backButton(String text, GameManager manager) {
        JButton b = new JButton(text);

        b.setFont(new Font("Serif", Font.BOLD, 18));
        b.setBackground(UITheme.BUTTON);
        b.setForeground(UITheme.BUTTON_TEXT);

        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        b.addActionListener(e -> manager.showMainMenu());
        return b;
    }
}

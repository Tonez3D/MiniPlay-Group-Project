/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package MiniPlay.Model.Crossword;

import MiniPlay.Model.GridCell;
import javax.swing.*;
import java.awt.*;

public class CrosswordCell extends GridCell {

    private char letter = ' ';

    public CrosswordCell(int r, int c, Object gameObj) {
        super(r, c, gameObj);
        render();
    }

    @Override
    public void handleClick() {
        String input = JOptionPane.showInputDialog("Enter letter:");
        if (input != null && input.length() == 1) {
            letter = Character.toUpperCase(input.charAt(0));
        }
    }

    @Override
    public void render() {
        this.removeAll();
        JLabel label = new JLabel(String.valueOf(letter), SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label);
        revalidate();
        repaint();
    }
}
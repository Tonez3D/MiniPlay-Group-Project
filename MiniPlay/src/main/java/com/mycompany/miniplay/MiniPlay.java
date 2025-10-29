/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miniplay;

import MiniPlay.GUI.MainMenu;
import MiniPlay.Model.GameManager;
import javax.swing.*;
/**
 *
 * @author cassi
 */
public class MiniPlay {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameManager manager = new GameManager();  // central logic handler
            MainMenu menu = new MainMenu(manager);    // pass it into the GUI
            menu.display();                           // show main menu
        });
    }
}

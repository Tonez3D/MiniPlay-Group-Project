/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.miniplay;

import MiniPlay.GUI.MainMenu;
import javax.swing.*;
/**
 *
 * @author cassi
 */
public class MiniPlay {

    public static void main(String[] args) {
        
        MainMenu maink = new MainMenu();
        SwingUtilities.invokeLater(new Runnable() {
    public void run() {
            maink.display();
        }
          });
    
}

}

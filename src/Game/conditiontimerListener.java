/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author Felix
 */
public class conditiontimerListener implements ActionListener {
    Random Randgen = new Random();
    int rand = Randgen.nextInt(5);
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Randgen.nextInt(100) == Randgen.nextInt(100)){
            if (rand == 5){
                Game.Player.condition -= 5.00;
            }
            else{
                Game.Player.outfit[rand].condition -= 5.00;
            }
        }
        
    }
    
}

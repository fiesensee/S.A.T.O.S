/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Felix
 */
class TimerListener implements ActionListener {

    public static int i = 1;
    static int j = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Game.GameState == 0){
            Interpreter.printout("-----------");
            if (Interpreter.bootstate == 0){
                Interpreter.printSameLine("UserName: ");
                Interpreter.usrbootstop();
            }
            else if (Interpreter.bootstate == 1){
                Interpreter.printSameLine("Password: ");
                Interpreter.pwdbootstop();
                
                
            }
        }
        else if(Game.GameState == 1){
            if (Interpreter.scan) {
                Interpreter.printout(Game.SatField[i].Name);
                if (i == Game.SatField.length - 1) {
                    i = -1;
                    Interpreter.scan = false;
                    Interpreter.scanStop();
                }
            }
            else if(Interpreter.connect){
                Interpreter.printout("successfuly connected");
                Interpreter.printout(Game.SatField[Game.Player.connectTo].response);
                Interpreter.connectStop();
            }
            else if(Interpreter.communicate){
                Interpreter.printout("now communicating with " + Game.SatField[Game.SatField[Game.Player.connectTo].Com].Name);
                Interpreter.printout(Game.SatField[Game.SatField[Game.Player.connectTo].Com].response);
                Interpreter.communicateStop();
            }
            else if(Interpreter.krypto){
                Interpreter.printout("Disconnecting from KryptoSat");
                Interpreter.kryptoStop();
            }
        }
            else if(Game.GameState == 2){
                if(Interpreter.modulescan){
                    Interpreter.printout("--------");
                    Game.Player.outfit[j].moduleDisplay();
                }
                if(j == Game.Player.outfit.length-1){
                    j = -1;
                    Interpreter.statusStop();
                }

            }
            i += 1;
            j += 1;
        
    }
    }

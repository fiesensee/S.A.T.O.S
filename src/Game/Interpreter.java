/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author Felix
 */

public class Interpreter {
    public static Timer DelayTimer = new Timer(1000, new TimerListener());
    public static boolean tryConnect = false;
    public static boolean scan = false;
    public static boolean connect = false;
    public static boolean communicate = false;
    public static boolean krypto = false;
    public static boolean tryCom = false;
    static Random Randgen = new Random();
    public static void read (String Text){
        if (Game.GameState == 1){
            switch (Text) {
                case "scan":
                    scan();
                    break;
                case "connect":
                    connect();
                    break;
                case "disconnect":
                    disconnect();
                    break;
                case "status":
                    status();
                    break;
                case "resetKey":
                    Game.Player.DecryptKey = 0x10;
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "run":
                    run();
                    break;
                default:
                    printout("unknown command");
            }
        }
        else if (Game.GameState == 2){
            switch(Text){
                
                case "status":
                    Game.Player.status();
                    break;
                default:
                    printout("unknown command");
            }
        }
    }
    public static void Con (String Text){
        int i = 1;
        while (i < Game.SatField.length ) {
            if (Text.equals(Game.SatField[i].Name)) {
                if (Game.SatField[i].Type.equals("ComSat")){
                    Game.Player.connected = true;
                    Game.Player.connectTo = Game.SatField[i].ID;
                    printout(Text);
                    connect = true;
                    DelayTimer.setDelay(Randgen.nextInt(5)*100+200);
                    DelayTimer.start();
                }
                else{
                    printout(Text);
                    printout("Satellite only sends: " + Game.undecryptedResponse);

                }
                break;
                    
            }
            i++;
            if (i == Game.SatField.length) {
                printout("no satellite found with this name");
            }
        }
        
        tryConnect = false;
    }
    public static void Com (String Text){
        int i = 1;
        while (i < Game.SatField.length) {
            if (Text.equals(Game.SatField[i].Name)) {
                if ((Game.SatField[i].Type.equals("DataSat"))||(Game.SatField[i].Type.equals("KryptoSat"))){
                    if(Game.Player.DecryptKey == Game.SatField[i].cryptkey){
                        printout(Text);
                        Game.SatField[i].setCom(Game.Player.connectTo);
                        Game.SatField[Game.Player.connectTo].setCom(Game.SatField[i].ID);
                        communicate = true;
                        DelayTimer.setDelay(Randgen.nextInt(5)*100+200);
                        DelayTimer.start();
                    }
                    else
                        printout("Satellite only sends: " + Game.undecryptedResponse);
                    
                    
            }
            else
                printout("not a valid satellite");
                
                break;
            }
            i++;
            if (i == Game.SatField.length) {
                printout("no satellite found with this name");
            }
        }
        
        tryCom = false;
    }
    public static void printout(String Text) {
        GameWindow.Output.append(Text);
        GameWindow.Output.append("\n");
        GameWindow.Output.setCaretPosition(GameWindow.Output.getDocument().getLength() - 1);
    }
    public static void printSameLine(String Text) {
        GameWindow.Output.append(Text);
        GameWindow.Output.append(" ");
        GameWindow.Output.setCaretPosition(GameWindow.Output.getDocument().getLength() - 1);
    }
    public static void scan() {
        scan = true;
        printout("scanning...");
        TimerListener.i = 1;
        if (Game.scanned)
            DelayTimer.setDelay(0);
        else
            DelayTimer.setDelay(1000-(Randgen.nextInt(5)*100));
        DelayTimer.start();
        Game.scanned = true;
    }
    public static void connect() {
        tryConnect = true;
        
        printSameLine("to:");

    }
    public static void disconnect() {
        if (Game.Player.connected) {
            Game.Player.connected = false;
            if (Game.SatField[Game.Player.connectTo].Com > 0){
                Game.SatField[Game.SatField[Game.Player.connectTo].Com].setCom(0);
                Game.SatField[Game.Player.connectTo].setCom(0);
            }
            Game.Player.connectTo = 0;
            printout("disconnected");
        } else {
            printout("wasn't connected to anything");
        }
    }
    public static void status() {
        if (Game.Player.connected) {
            printout("currently connected to " + Game.SatField[Game.Player.connectTo].toString());
            if (Game.SatField[Game.Player.connectTo].Com > 0){
                printout("communicating with "+ Game.SatField[(Game.SatField[Game.Player.connectTo].Com)].Name);
            }
        } else {
            printout("not connected to anything");
        }
    }
    public static void run() {
        if (Game.Player.connected) {
            if (Game.SatField[Game.Player.connectTo].Com > 0)
                Game.SatField[Game.SatField[Game.Player.connectTo].Com].SatFunction();
            else 
                Game.SatField[Game.Player.connectTo].SatFunction();
        } else {
            printout("not connected to any satellite");
        }
    }
    public static void scanStop() {
        DelayTimer.stop();
        scan = false;
        printout("finished scanning");
    }
    
    public static void connectStop(){
        DelayTimer.stop();
        connect = false;
    }
    
    public static void communicateStop(){
        DelayTimer.stop();
        communicate = false;
    }
    
    public static void kryptoStop(){
        DelayTimer.stop();
        krypto = false;
    }
    }


package Game;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.Timer;

public final class Game
{
  //1=Sat,2=Sys,3=Nav,4=Con
  static int GameState = 0;
  static AbsSat[] SatField;
  static String undecryptedResponse = "000101010101111010101011101010111010100011101"; 
  static boolean scanned = false;
  static Ship Player; 
  static Timer conditiontimer = new Timer(10000, new conditiontimerListener());
  static String user = "Admin";
  static String password = "Admin";
  public Game() throws IOException
  {
    JFrame Main = new JFrame("S.A.T.O.S");
    Main.setSize(410, 690);
    GameWindow Game = new GameWindow();
    Main.add(Game);
    Main.setDefaultCloseOperation(3);
    Main.setVisible(true);
    StartGameLvl1();
  }
  
  public void StartGameLvl1() throws IOException{
    Interpreter.boot();
    conditiontimer.start();
    Player = new Ship("The Balls Deep","Player");
    SatField = new AbsSat[6];
    //0 is always null;
    SatField[0] =  null;
    SatField[1] = new ComSat("Dido Communications Sat",1);
    SatField[2] = new DataSat("Buttlord, Pirate of the 7 Spaces",2);
    SatField[3] = new DataSat("CKE-Confidential",3);
    SatField[4] = new KryptoSat("Grey-V2.1",4, 0x0539);
    SatField[5] = new KryptoSat("butts full of secrets",5,0x38F);
    SatField[2].setCryptKey(0x38F);
    SatField[3].setCryptKey(0x0539);
    SatField[1].response = "Class 4 Communication-Sat, use with caution";
    SatField[2].response = "I just want to piss on the mill to hypnotize dolls.";
    SatField[3].response = "really secret stuff";
    SatField[4].response = "Open-Source Grey Decryption";
    SatField[5].response = "Don't steal my secrets";
  }


}


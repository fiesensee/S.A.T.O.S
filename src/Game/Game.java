package Game;

import javax.swing.JFrame;

public class Game
{
  static AbsSat[] SatField;
  static String ComProt = "Default";
  static int DecryptKey = 0x10;
  static boolean connected = false;
  static int connectTo = 0;
  static String undecryptedResponse = "000101010101111010101011101010111010100011101"; 
  static boolean scanned = false;
  public Game()
  {
    JFrame Main = new JFrame("S.A.T.O.S");
    Main.setSize(400, 510);
    Window Game = new Window();
    Main.add(Game);
    Main.setDefaultCloseOperation(3);
    Main.setVisible(true);
    StartGameLvl1();
  }
  
  public static void StartGameLvl1()
  {
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


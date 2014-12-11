package Game;

import javax.swing.JFrame;

public class Game
{
  static AbsSat[] SatField;
  
  public Game()
  {
    JFrame Main = new JFrame("S.A.T.O.S");
    Main.setSize(400, 510);
    Window Game = new Window();
    Main.add(Game);
    Main.setDefaultCloseOperation(3);
    Main.setVisible(true);
    StartGame();
  }
  
  public static void StartGame()
  {
    SatField = new AbsSat[3];
    SatField[0] = new ComSat("ComSat1", 1);
    SatField[1] = new ComSat("ComSat2", 2);
    SatField[2] = new ComSat("ComSatTest", 3);
  }
  
  public static void GameWait(long Time)
  {
    long now = System.currentTimeMillis();
    for (;;)
    {
      if (System.currentTimeMillis() - now >= Time * 1000L) {
        break;
      }
    }
  }
}

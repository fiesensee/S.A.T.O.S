package Game;

public class KryptoSat extends AbsSat{
    int decryptionKey=0x10;
    public KryptoSat(String Name, int ID, int decryptionKey){
        this.Name = Name;
        this.Type = "KryptoSat";
        this.ID = ID;
        this.decryptionKey = decryptionKey;
    }
    @Override
    void SatFunction() {
        //give right encryption key
        Interpreter.printout("generating and setting Encryption Key");
        Game.Player.DecryptKey = this.decryptionKey;
        Interpreter.krypto = true;
        Interpreter.DelayTimer.setDelay(Interpreter.Randgen.nextInt(5)*100+200);
        Interpreter.DelayTimer.start();
        Game.SatField[Game.SatField[Game.Player.connectTo].Com].setCom(0);
        Game.SatField[Game.Player.connectTo].setCom(0);
    }

    @Override
    public String toString() {
        return (this.Name + "-KryptoSat");
    }

   
  
    
}

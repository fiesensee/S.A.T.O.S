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
        Window.printout("generating and setting Encryption Key");
        Game.DecryptKey = this.decryptionKey;
        Window.krypto = true;
        Window.DelayTimer.setDelay(Window.Randgen.nextInt(5)*100+200);
        Window.DelayTimer.start();
        Game.SatField[Game.SatField[Game.connectTo].Com].setCom(0);
        Game.SatField[Game.connectTo].setCom(0);
    }

    @Override
    public String toString() {
        return (this.Name + "-KryptoSat");
    }

   
  
    
}

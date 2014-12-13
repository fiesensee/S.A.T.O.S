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
        Window.printout("Generating Encryption Key");
        Game.EncryptKey = 0x38F;
    }

    @Override
    public String toString() {
        return (this.Name + "-KryptoSat");
    }

   
  
    
}

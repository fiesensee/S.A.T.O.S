package Game;

public abstract class AbsSat
{
  String response = "Default";
  
  int cryptkey = 0x10;
  int Com = 0;
  String Name;
  String Type;
  int ID;
  
  public String getName()
  {
    return this.Name;
  }
  
  public int getID()
  {
    return this.ID;
  }
  public AbsSat getSat(){
      return this;
  }
  public void setCom(int Sat){
        this.Com = Sat;
  }
  abstract void SatFunction();
  public void setCryptKey(int cryptKey){
      this.cryptkey = cryptKey;
  }
  @Override
  public abstract String toString();
}

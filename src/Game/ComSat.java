package Game;

public class ComSat extends AbsSat{
    
    
  public ComSat(String Name, int ID)
  {
    this.Name = Name;
    this.Type = "ComSat";
    this.ID = ID;
  }

    @Override
    void SatFunction() {
        //establish communication
        Window.printSameLine("communicating with:");
        Window.tryCom = true;
    }

    @Override
    public String toString() {
        return (this.Name + "-ComSat");
    }

    

}

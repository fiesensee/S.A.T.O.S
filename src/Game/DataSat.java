package Game;

public class DataSat extends AbsSat{

    public DataSat(String Name, int ID){
        this.Name = Name;
        this.Type = "DataSat";
        this.ID = ID;
    }
    @Override
    void SatFunction() {
        //release data if right encryption key
        
    }

    @Override
    public String toString() {
        return (this.Name + "-DataSat");
    }

  
    
}

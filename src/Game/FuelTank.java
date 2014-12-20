/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Felix
 */
public class FuelTank extends Module{
    double capacity;
    String propFileName = "fueltank.properties";
    public FuelTank(int ID) throws IOException{
        this.ID = ID;
        this.setStats(ID, propFileName);
    }
    @Override
    public void setStats(int ID, String propFileName) throws IOException {
        Properties prop = new Properties();
        

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
                prop.load(inputStream);
        } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        String[] properties = (prop.getProperty("2").split(":"));
        this.Name = properties[0];
        this.capacity = Double.parseDouble(properties[1]);
        this.mass = Integer.parseInt(properties[2]);
    }

    @Override
    public void moduleDisplay() {
        Interpreter.printout(this.Name);
        Interpreter.printout("Max Capacity: "+this.Name+"l");
        Interpreter.printout("Mass: "+this.Name+"t");
    }
    
}

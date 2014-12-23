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
public class habitationmodule extends Module {
    int area;
    int capacity;
    String propFileName = "habitationmodule.properties";
    public habitationmodule(int ID) throws IOException{
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
        String[] properties = (prop.getProperty(""+ID).split(":"));
        this.Name = properties[0];
        this.area = Integer.parseInt(properties[1]);
        this.capacity = Integer.parseInt(properties[2]);
        this.mass = Integer.parseInt(properties[3]);
    }

    @Override
    public void moduleDisplay() {
        Interpreter.printout(this.Name);
        Interpreter.printout("Living Area: "+this.area+"m²");
        Interpreter.printout("Max Capacity: "+this.capacity+"t");
        Interpreter.printout("Mass: "+this.mass+"t");
    }
    
}

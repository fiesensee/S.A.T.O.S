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
public class engine extends Module {
    int specificimpulse;
    String prop = "engine.properties";
    
    public engine(int ID) throws IOException{
        this.ID = ID;
        this.setStats(ID,this.prop);
    }

    @Override
    public void setStats(int ID, String propFileName)throws IOException {
        
        Properties prop = new Properties();
        

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
                prop.load(inputStream);
        } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        String[] properties = (prop.getProperty(""+ID).split(":"));
        
        this.Name = properties[0];
        this.specificimpulse = Integer.parseInt(properties[1]);
        this.mass = Integer.parseInt(properties[2]);

    }

    @Override
    public void moduleDisplay() {
        Interpreter.printout(this.Name);
        Interpreter.printout("ISP: "+this.specificimpulse);
        Interpreter.printout("Mass: "+this.mass);
        
    }


}

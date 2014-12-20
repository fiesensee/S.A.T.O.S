/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.io.IOException;

/**
 *
 * @author Felix
 */
public class Ship {
    String Name;
    String Type;
    int DecryptKey = 0x10;
    boolean connected = false;
    int connectTo = 0;
    engine shipengine;
    FuelTank shiptank;
    loadingbay shiploadingbay;
    habitationmodule shiphabitat;

    public Ship(String Name,String Type) throws IOException{
        this.Name = Name;
        this.Type = Type;
        this.shipengine = new engine(1);
        this.shiptank = new FuelTank(1);
        this.shiploadingbay = new loadingbay(1);
        this.shiphabitat = new habitationmodule(1);
    }
    public void status(){
        Interpreter.printout("Ship"+this.Name);
        Interpreter.printout("Owned by "+this.Type);
        Interpreter.printout("--------");
        this.shipengine.moduleDisplay();
        Interpreter.printout("--------");
        this.shiptank.moduleDisplay();
        Interpreter.printout("--------");
        this.shiploadingbay.moduleDisplay();
        Interpreter.printout("--------");
        this.shiphabitat.moduleDisplay();
        Interpreter.printout("--------");
    }
    
}

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
    String conShip = "";
    int connectTo = 0;
    Double condition = 100.00;
    //1-engine,2-tank,3-loadingbay,4-habitat,5-commandobridge
    Module[] outfit = new Module[5];
    engine shipengine;
    FuelTank shiptank;
    loadingbay shiploadingbay;
    habitationmodule shiphabitat;
    commandobridge commando;

    public Ship(String Name,String Type) throws IOException{
        this.Name = Name;
        this.Type = Type;
        this.shipengine = new engine(1);
        this.shiptank = new FuelTank(1);
        this.shiploadingbay = new loadingbay(1);
        this.shiphabitat = new habitationmodule(1);
        this.commando = new commandobridge(1);
        this.outfit[0] = this.shipengine;
        this.outfit[1] = this.shiptank;
        this.outfit[2] = this.shiploadingbay;
        this.outfit[3] = this.shiphabitat;
        this.outfit[4] = this.commando;
    }
    public void status(){
        int i = 0;
        Interpreter.printout("Ship"+this.Name);
        Interpreter.printout("Owned by "+this.Type);
        Interpreter.modulescan = true;
        Interpreter.DelayTimer.start();
    }
    
}

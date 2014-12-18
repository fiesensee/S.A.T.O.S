/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

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

    public Ship(String Name,String Type){
        this.Name = Name;
        this.Type = Type;
    }

}

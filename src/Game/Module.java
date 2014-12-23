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
public abstract class Module {
    String Name;
    int ID;
    int mass;
    Double condition = 100.00;
    public abstract void setStats(int ID, String propFileName)throws IOException;
    public abstract void moduleDisplay();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objmodels;

/**
 *
 * @author Eagle
 */
public class Account {
    public String AccName;
    public String PW; 

    public String getAccName() {
        return AccName;
    }

    public void setAccName(String AccName) {
        this.AccName = AccName;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public Account(){}
    public Account(String sName, String sPW){
        AccName= sName;
        PW= sPW;
    }
    
}

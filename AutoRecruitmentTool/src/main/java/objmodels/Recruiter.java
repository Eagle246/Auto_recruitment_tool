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
public class Recruiter {
    public String name="";
    public String URL ="";
    public Account oAccount = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Account getoAccount() {
        return oAccount;
    }

    public void setoAccount(Account oAccount) {
        this.oAccount = oAccount;
    }
    
    public Recruiter(){
    }
    public Recruiter(String sName,String sURL, Account oAcc){
        name = sName;
        URL = sURL;
        oAccount = oAcc;
    }
    
    
    
}

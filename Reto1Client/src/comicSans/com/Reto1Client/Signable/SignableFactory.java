/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client.Signable;

/**
 *
 * @author xabig
 */
public class SignableFactory {
    
    public Signable getModel(){
        
        return new SignableImplementation();
    }
    
}

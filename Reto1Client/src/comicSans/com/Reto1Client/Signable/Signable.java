/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Reto1Client.Signable;

import User.User;

/**
 *
 * @author xabig
 */
interface Signable {
    
    public void signIn(User user);
    public void signUp(User user);
    public void logOut(User user);
    
}

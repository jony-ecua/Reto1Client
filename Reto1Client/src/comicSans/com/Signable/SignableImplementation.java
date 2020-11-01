/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comicSans.com.Signable;


import comicSans.com.Reto1Library.MessageReto;
import comicSans.com.Reto1Library.Signable.Signable;
import comicSans.com.Reto1Library.Type;
import comicSans.com.Reto1Library.User.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xabig
 */
public class SignableImplementation implements Signable{
    
    public void signUp(User user){
        MessageReto mes = new MessageReto();
        mes.setUser(user);
        mes.setType(Type.SIGN_UP);

        sendMessage(mes);
    }

    public void signIn(User user) {
        MessageReto mes = new MessageReto();
        mes.setUser(user);
        mes.setType(Type.SIGN_IN);

        sendMessage(mes);
    }

    private void sendMessage(MessageReto mes) {
        final String HOST = "127.0.0.1";
        final int PUERTO = 1300;
        ObjectInputStream in;
        ObjectOutputStream out;

        try {

            Socket sc = new Socket(HOST, PUERTO);

            in = new ObjectInputStream(sc.getInputStream());
            out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject(mes);

            out.close();
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(SignableImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package Helpers;

import java.awt.event.KeyEvent;

/**
 *
 * @author Anderson_dev
 */
public class TeclasAtalho {

    public static boolean TECLA_ENTER(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_ENTER;
    }
    
    public static boolean TECLA_ESC(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_ESCAPE;
    }
    
    public static boolean TECLA_F1(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F1;
    }
    
    public static boolean TECLA_F2(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F2;
    }
    public static boolean TECLA_F3(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F3;
    }
    public static boolean TECLA_F4(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F4;
    }
    public static boolean TECLA_F5(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F5;
    }
    public static boolean TECLA_F6(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F6;
    }
    public static boolean TECLA_F7(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F7;
    }
    public static boolean TECLA_F8(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F8;
    }
    public static boolean TECLA_F9(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F9;
    }
    public static boolean TECLA_F10(java.awt.event.KeyEvent evt) {
        return evt.getKeyCode() == KeyEvent.VK_F10;
    }
    
    
    /*COMBINAÇÕES DE TECLAS*/
    public static boolean CTRL_D(java.awt.event.KeyEvent evt){
        if(evt.getKeyCode() == KeyEvent.VK_D)
            return TECLA_CTRL(evt);
        
        return false;
    }
    
    /*TECLA CTRL*/
    public static boolean TECLA_CTRL(java.awt.event.KeyEvent evt){
         return evt.isControlDown();
    }
    
}

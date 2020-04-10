/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacioncodigobarras;

import Ui.frmIngresos;
import Ui.frmInterfaz;
import Ui.frmLogin;
import javax.swing.UIManager;

/**
 *
 * @author INVENIO122
 */
public class AplicacionCodigoBarras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
        // UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");//aluminium
     // UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");//fast
    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");//negro
          //  UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");//Luna/Luna
           // UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");//acryl
           //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");//liquid
          //  UIManager.setLookAndFeel("joxy.JoxyLookAndFeel");//liquid
        }catch (Exception ex){}
       new frmInterfaz().setVisible(true);
        
    }
}

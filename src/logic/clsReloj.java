
package logic;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Invenio-127
 */
public class clsReloj extends Thread {

    private JLabel lbl;

    public clsReloj(JLabel lbl) {
        this.lbl = lbl;
    }

    public void run() {
        while (true) {
            Date hoy = new Date();
            SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
            lbl.setText(s.format(hoy));

          try {sleep(1000);
            } catch (Exception ex) {
            }
        }
    }
}

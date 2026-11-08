package registroacademico;

import javax.swing.SwingUtilities;
/**
 *
 * @author User
 */
public class MainRegistro {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
    @Override
    public void run() {
        new RegistroAcademico().setVisible(true);
        }
    });
    }
}

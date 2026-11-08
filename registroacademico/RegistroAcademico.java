package registroacademico;
/**
 *
 * @author User
 */
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroAcademico extends JFrame{
private JTextField txtnombre, txtmatricula, txtcarrera;
private JTextField txtpracticas, txtexamenes, txtasig, txtexfinal;
private JTextArea txtresultado;



//interfaz
public RegistroAcademico() {
setTitle("-- Registro Academico --");
setSize(300,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setLayout(null);

JLabel lblNombre = new JLabel("Nombre Completo: ");
lblNombre.setBounds(30, 20, 150, 25);
add(lblNombre);

txtnombre = new JTextField();
txtnombre.setBounds(180, 20, 220, 25);
add(txtnombre);

JLabel lblmatricula = new JLabel("Matricula: ");
lblmatricula.setBounds(30, 55, 150, 25);
add(lblmatricula);

txtmatricula = new JTextField();
txtmatricula.setBounds(180, 55, 220, 25);
add(txtmatricula);

JLabel lblcarrera = new JLabel("Carrera: ");
lblcarrera.setBounds(30, 90, 150, 25);
add(lblcarrera);

txtcarrera = new JTextField();
txtcarrera.setBounds(180, 90, 220, 25);
add(txtcarrera);

JLabel lblpracticas = new JLabel("Practicas(max 40pts): ");
lblpracticas.setBounds(30, 125, 150, 25);
add(lblpracticas);

txtpracticas = new JTextField();
txtpracticas.setBounds(180, 125, 220, 25);
add(txtpracticas);

JLabel lblexamenes = new JLabel("Parciales(max 20pts): ");
lblexamenes.setBounds(30, 160, 150, 25);
add(lblexamenes);

txtexamenes = new JTextField();
txtexamenes.setBounds(180, 160, 220, 25);
add(txtexamenes);

JLabel lblasig = new JLabel("Asignaciones(max 20pts): ");
lblasig.setBounds(30, 195, 150, 25);
add(lblasig);

txtasig = new JTextField();
txtasig.setBounds(180, 195, 220, 25);
add(txtasig);

JLabel lblexfinal = new JLabel("Examen Final(max 20pts): ");
lblexfinal.setBounds(30, 230, 150, 25);
add(lblexfinal);

txtexfinal = new JTextField();
txtexfinal.setBounds(180, 230, 220, 25);
add(txtexfinal);

JButton btncalc = new JButton("Calcular Resultado");
btncalc.setBounds(50, 275, 160, 30);
add(btncalc);

txtresultado = new JTextArea();
txtresultado.setBounds(30, 320, 350, 150);
txtresultado.setEditable(false);
add(txtresultado);

//Extra: boton para limpiar los campos
JButton btnlimpiar = new JButton("Limpiar campos");
btnlimpiar.setBounds(220, 275, 160, 30);
add(btnlimpiar);


//Validacion para evitar dejar campos vacios
btncalc.addActionListener(new ActionListener(){
@Override
public void actionPerformed(ActionEvent e){
try {
if (txtnombre.getText().isEmpty()|| txtmatricula.getText().isEmpty()|| txtcarrera.getText().isEmpty()|| txtpracticas.getText().isEmpty()|| txtexamenes.getText().isEmpty()|| txtasig.getText().isEmpty()|| txtexfinal.getText().isEmpty()) {
JOptionPane.showMessageDialog(null, "Por Favor llene todos los campos", "Error de Validacion", JOptionPane.ERROR_MESSAGE);
return;
}
//conversion calificacion a duoble
double practicas = Double.parseDouble(txtpracticas.getText());
double examenes = Double.parseDouble(txtexamenes.getText());
double asig = Double.parseDouble(txtasig.getText());
double exfinal = Double.parseDouble(txtexfinal.getText());

//Validacion de rangos (Practicas, parciales, asignaciones y examen final)
if (practicas < 0 || practicas > 40 || examenes < 0 || examenes > 20|| asig < 0 || asig > 20 || exfinal < 0 || exfinal > 20) {
JOptionPane.showMessageDialog(null,"Uno o Multiples valores exceden sus rangos, Verifique","Rango Invalido", JOptionPane.WARNING_MESSAGE);
return;
}

//Instancia clase Estudiante

Estudiante estud = new Estudiante(txtnombre.getText(), txtmatricula.getText(), txtcarrera.getText(), practicas, examenes, asig, exfinal);

double total = estud.CalcNota();
String estado = estud.resultado();

//Muestra resultados

txtresultado.setText("-- Reporte Academico --\n" + "\n" + "Estudiante: " + estud.getNombre() + "\n" + "Matricula: " + estud.getMatricula() + "\n" + "Carrera: " + estud.getCarrera() + "\n" + "=========================" + "\n" + "Total Acumulado:" + total + "pts\n" + "Estado: " + estado);
}
catch (NumberFormatException ex) {
JOptionPane.showMessageDialog(null, "Por favor ingrese valor numericos validos en las calificaciones", "Error de formato", JOptionPane.ERROR_MESSAGE);
}
}
});

//Boton para limpiar los campos
btnlimpiar.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e){
txtnombre.setText("");
txtmatricula.setText("");
txtcarrera.setText("");
txtpracticas.setText("");
txtexamenes.setText("");
txtasig.setText("");
txtexfinal.setText("");
txtresultado.setText("");
}
});






}
}

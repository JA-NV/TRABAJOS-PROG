package calculadoraswing;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class MainCALCULADORA extends JFrame {
    
    private Calculadora Calc = new Calculadora();
    private ConversionTemp Temp = new ConversionTemp();
    private RaizExpo RaExp = new RaizExpo();
    
    private JTextField txtpantalla;
    private JTextField txttemp, txtresultemp;
    private JTextField txtbasesubin,txtexp, txtresulraexp;
            
    private double primernum = 0;
    private String operacionpend = "";
    private boolean nuevonum = true;
    
   public MainCALCULADORA(){
       setTitle("Calculadora Matematica");
       setSize(480,680);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setLayout(null);
       
        // parte matematica
       JLabel TituloCalc = new JLabel("Calculadora Matematica");
       setSize(480,570);
       TituloCalc.setBounds(30, 45, 210, 35);
       add(TituloCalc);
       
       //pantalla
       txtpantalla = new JTextField("0");
       txtpantalla.setBounds(30, 45, 210, 35);
       txtpantalla.setHorizontalAlignment(JTextField.RIGHT);
       txtpantalla.setEditable(false);
       add(txtpantalla);
       
       //boton C (Clear)
       JButton clear = new JButton("C");
       clear.setBounds(250, 45, 50, 35);
       add(clear);
       clear.addActionListener(e -> {
       txtpantalla.setText("0");
       primernum = 0;
       operacionpend = "";
       nuevonum = true;
       });
       
       //teclado numerico
       String[] botonesNumeros = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", "."
        };

        int[][] coordenadas = {
            {30, 85}, {90, 85}, {150, 85},
            {30, 125}, {90, 125}, {150, 125},
            {30, 165}, {90, 165}, {150, 165},
            {30, 205}, {90, 205}
        };

        for (int i = 0; i < botonesNumeros.length; i++) {
            JButton btn = new JButton(botonesNumeros[i]);
            btn.setBounds(coordenadas[i][0], coordenadas[i][1], 50, 35);
            add(btn);
            btn.addActionListener(e -> manejarBotonNum(e));
        }
       
       //botones para las operaciones
       JButton div = new JButton("/");
       div.setBounds(210, 85, 50, 35);
       JButton mult = new JButton("*");
       mult.setBounds(210, 125, 50, 35);
       JButton resta = new JButton("-");
       resta.setBounds(210, 165, 50, 35);
       JButton suma = new JButton("+");
       suma.setBounds(210, 205, 50, 35);
       JButton igual = new JButton("=");
       igual.setBounds(150, 205, 50, 35);
       add(div);
       add(mult);
       add(resta);
       add(suma);
       add(igual);
       
       suma.addActionListener(e -> configurarOperacion("+"));
       resta.addActionListener(e -> configurarOperacion("-"));
       mult.addActionListener(e -> configurarOperacion("*"));
       div.addActionListener(e -> configurarOperacion("/"));
       igual.addActionListener(e -> calcularResultadoFinal());
       
       //corversor temperatura
       
       JLabel titulotemp = new JLabel("Conversor Temperatura");
       titulotemp.setBounds(30, 255, 300, 20);
       add(titulotemp);
       
       JLabel temp = new JLabel("Valor: ");
       temp.setBounds(30, 285, 90, 25);
       add(temp);
       
       txttemp = new JTextField();
       txttemp.setBounds(120, 285, 130, 25);
       add(txttemp);
       
       JLabel restemp =new JLabel("resultado: ");
       restemp.setBounds(30, 320, 90, 25);
       add(restemp);
       
       txtresultemp = new JTextField();
       txtresultemp.setBounds(120, 320, 130, 25);
       txtresultemp.setEditable(false);
       add(txtresultemp);
       
       JButton FaACe = new JButton("F → C");
       FaACe.setBounds(270, 283, 150, 30);
       add(FaACe);
       
       JButton CeAFa = new JButton("C → F");
       CeAFa.setBounds(270, 318, 150, 30);
       add(CeAFa);
        
       FaACe.addActionListener(e -> {
       try {
       double f = Double.parseDouble(txttemp.getText());
       double c = Temp.FahrACel(f);
       txtresultemp.setText(String.format("%.2f C", c));
       }
       catch (NumberFormatException ex) {
       JOptionPane.showMessageDialog(this, "Ingrese un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
       }
       });
       
       CeAFa.addActionListener(e -> {
       try {
       double c = Double.parseDouble(txttemp.getText());
       double f = Temp.CelAFahr(c);
       txtresultemp.setText(String.format("%.2f F", f));
       }
       catch (NumberFormatException ex) {
       JOptionPane.showMessageDialog(this, "Ingrese un numero valido", "Error", JOptionPane.ERROR_MESSAGE);
       }
       });
       
       
      //raices y exponentes
      JLabel Tituloraexp = new JLabel("Raices cuadradas y potencias");
      Tituloraexp.setBounds(30, 375, 300, 20);
      add(Tituloraexp);
      
      JLabel lblVal = new JLabel("Valor / Base: ");
      lblVal.setBounds(30, 410, 90, 25);
      add(lblVal);
      
      txtbasesubin = new JTextField();
      txtbasesubin.setBounds(120, 410, 130, 25);
      add(txtbasesubin);
      
      JLabel lblExp = new JLabel("Exponente: ");
      lblExp.setBounds(30, 445, 90, 25);
      add(lblExp);

      txtexp = new JTextField();
      txtexp.setBounds(120, 445, 130, 25);
      add(txtexp);
      
      JLabel lblRaizExp = new JLabel("Resultado: ");
      lblRaizExp.setBounds(30, 480, 90, 25);
      add(lblRaizExp);
      
      txtresulraexp = new JTextField();
      txtresulraexp.setBounds(120, 480, 130, 25);
      txtresulraexp.setEditable(false);
      add(txtresulraexp);
      
      JButton btnRaiz = new JButton("Raiz Cuadrada");
      btnRaiz.setBounds(270, 408, 150, 30);
      add(btnRaiz);
      
      JButton btnExp = new JButton("Exponente");
        btnExp.setBounds(270, 443, 150, 30);
        add(btnExp);
        
  btnRaiz.addActionListener(e -> {
            try {
                double val = Double.parseDouble(txtbasesubin.getText());
                double res = RaExp.Raiz(val);
                txtresulraexp.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Matematico", JOptionPane.ERROR_MESSAGE);
            }
        });
  
  btnExp.addActionListener(e -> {
            try {
                double base = Double.parseDouble(txtbasesubin.getText());
                double exponente = Double.parseDouble(txtexp.getText());
                double res = RaExp.Exp(base, exponente);
                txtresulraexp.setText(String.valueOf(res));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores numericos validos en Base y Exponente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
      
               
    

       
    private void manejarBotonNum(ActionEvent e) {
    String textoBoton = ((JButton) e.getSource()).getText();
    if(nuevonum) {
    txtpantalla.setText(textoBoton);
    nuevonum = false;
    } else {
    txtpantalla.setText(txtpantalla.getText() + textoBoton);
    }
    }
    
    private void configurarOperacion(String op) {
        try {
            primernum = Double.parseDouble(txtpantalla.getText());
            operacionpend = op;
            nuevonum = true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void calcularResultadoFinal() {
        try {
            double segundonum = Double.parseDouble(txtpantalla.getText());
            double resultado = 0;

            switch (operacionpend) {
                case "+": resultado = Calc.suma(primernum, segundonum); break;
                case "-": resultado = Calc.resta(primernum, segundonum); break;
                case "*": resultado = Calc.multip(primernum, segundonum); break;
                case "/": resultado = Calc.dividir(primernum, segundonum); break;
                default: return;
            }

            txtpantalla.setText(String.valueOf(resultado));
            nuevonum = true;
            operacionpend = "";
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error Matematico", JOptionPane.ERROR_MESSAGE);
        }
    }
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainCALCULADORA().setVisible(true);
        });
    }
    
    
}

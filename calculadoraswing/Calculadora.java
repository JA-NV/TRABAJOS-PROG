package calculadoraswing;

/**
 *
 * @author User
 */
public class Calculadora {
   
    //metodos operciones basicas
   public double suma(double a, double b){
   return a + b;
   }
   public double resta(double a, double b) {
   return a + b;
   }
   public double multip(double a, double b){
   return a * b;
   }
   public double dividir(double a, double b) throws ArithmeticException {
   if (b==0){
   throw new ArithmeticException ("Error Matematico");
   }
   return a / b;
   }
   
}

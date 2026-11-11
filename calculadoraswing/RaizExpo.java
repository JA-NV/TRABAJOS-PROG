package calculadoraswing;

/**
 *
 * @author User
 */
public class RaizExpo {
    
    //metodo raiz con excepcion para raices imaginarias
    public double Raiz (double x) throws IllegalArgumentException{
    if (x < 0){
    throw new IllegalArgumentException ("Error Matematico");
    }
    return Math.sqrt(x);
    }
    
    public double Exp(double base, double exp) {
    return Math.pow(base, exp);
    }   
    
}

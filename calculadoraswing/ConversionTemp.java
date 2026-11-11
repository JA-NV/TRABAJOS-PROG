package calculadoraswing;

/**
 *
 * @author User
 */
public class ConversionTemp {
    
    //conversion F a C
   public double FahrACel(double F){
   return (F - 32) * 5/9;
   }
   
   //Conversion C a F
   public double CelAFahr (double C){
   return (C * 9/5) + 32;
   }
    
}

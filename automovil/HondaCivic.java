package automovil;


public class HondaCivic extends AutoMovil {

    public HondaCivic() {
        super();
        System.out.println("Constructor de Honda Civic");
    }

   
    
     public HondaCivic(String Marca, String Modelo, String Color, int Año, boolean encendido) {
        super("Honda", "Civic","", 0,false);
        System.out.println("Constructor de Honda Civic");
    }
    
    
    @Override
    public void Prender(){
         if(super.isEncendido() != false){
        System.out.println("Carro encendido");
        }else{
            System.out.println("Encendiendo carro...");
            super.setEncendido(true);
        }
   }
    
     @Override
    public void Apagar(){
    if(super.isEncendido() != true){
        System.out.println("Carro apagado");
    }else{
        System.out.println("Apagando carro...");
        super.setEncendido(false);
    }
    
    }    
    
    
}

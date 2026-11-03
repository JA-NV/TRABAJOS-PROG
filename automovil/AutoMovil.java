package automovil;

public class AutoMovil{

private String Marca;
private String Modelo;
private String Color;
private int Año;
private boolean encendido;

    public AutoMovil() {
        System.out.println("Constructor de Automovil" );
    }

    public AutoMovil(String Marca, String Modelo, String Color, int Año, boolean encendido) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.Año = Año;
        this.encendido = encendido;
        System.out.println("Constructor de Automovil");
    }

    public String getMarca() {
        return this.Marca;
    }

    public String getModelo() {
        return this.Modelo;
    }

    public String getColor() {
        return Color;
    }

    public int getAño() {
        return Año;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    
    public void Prender(){
          if(encendido != false){
        System.out.println("El carro esta encendido");
        
          }else{
            System.out.println("Prendiendo carro...");
          setEncendido(encendido = true);   
        }
    }
    
    public void Arrancar(){
        System.out.println("Carro arrancando...");
    }
    
     public void Frenar(){
        System.out.println("Carro deteniendo...");
    }    

     public void Apagar(){
    if(encendido != true){
        System.out.println("El carro esta apagado");
    }else{
        System.out.println("Apagando el carro...");
       setEncendido(encendido = false);
    }
    
    }    

    
    
    
   
}

package automovil;


public class MainCARRO {
    public static void main(String[] args) {
        AutoMovil auto = new AutoMovil();
        auto.setMarca("Toyota");
        auto.setModelo("Yaris");
        auto.setAño(2008);
        auto.setColor("Bronce");
        
        System.out.println("Marca: " + auto.getMarca());
        auto.Prender();
        auto.Apagar();
        
        System.out.println("\n -----Honda Civic-----");
        System.out.println("(tengo un civic tengo un civic tengo un civic tengo un civic)");
        System.out.println("   ");
        
        HondaCivic honda = new HondaCivic("","","",0,false);
        
        honda.getModelo();
        honda.setAño(2022);
        honda.setColor("Negro");
        
        System.out.println("Marca: " + honda.getMarca());
        System.out.println("Ano: " + honda.getAño());
        honda.Prender();
        honda.Arrancar();
        honda.Apagar();
        
    }
    
    
    
}

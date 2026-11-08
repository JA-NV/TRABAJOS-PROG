package registroacademico;

/**
 *
 * @author User
 */
public class Estudiante {
    
    //atributos privados
    private String nombre;
    private String matricula;
    private String carrera;
    private double practica;
    private double examenes;
    private double asig;
    private double exfinal;

    //Constructor
    public Estudiante(String nombre, String matricula, String carrera, double practica, double examenes, double asig, double exfinal) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.practica = practica;
        this.examenes = examenes;
        this.asig = asig;
        this.exfinal = exfinal;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPractica() {
        return practica;
    }

    public double getExamenes() {
        return examenes;
    }

    public double getAsig() {
        return asig;
    }

    public double getExfinal() {
        return exfinal;
    }
    
    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPractica(double practica) {
        this.practica = practica;
    }

    public void setExamenes(double examenes) {
        this.examenes = examenes;
    }

    public void setAsig(double asig) {
        this.asig = asig;
    }

    public void setExfinal(double exfinal) {
        this.exfinal = exfinal;
    }
    
    //logica
    public double CalcNota(){
    return this.practica + this.examenes + this.asig + this.exfinal;
    }
    
    public String resultado(){
    double total = CalcNota();
    if(total >= 60){
    return "Aprobado";
    } else {
    return "Reprobado";
    }
    }
    
 
}

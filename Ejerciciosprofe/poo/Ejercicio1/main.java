package poo.Ejercicio1;
public class main {

    public static void main(String[] args) {
        Persona p1 = new Persona("Mateo", 19, 45405281);
        Persona p2 = new Persona("Valentina", 20, 44578321);
        Persona p3 = new Persona("Aldana", 20, 44743911);

        System.out.println(p2);

        System.out.println(p3.dameEdad());

        System.out.println(p1.dameDNI());
        
    }
    
}

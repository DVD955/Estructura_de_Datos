package mx.edu.uttt.poo;
import javax.swing.JOptionPane;
public class TestAlumno {
    public static void main(String[] arg){

        String nombre ="" , colorPiel = "";
        int edad = 0;
        char sexo = '\0';

        Alumno a1 = new Alumno();
         nombre = JOptionPane.showInputDialog("Introduce el Nombre ");
         edad = Integer.parseInt(JOptionPane.showInputDialog("Inrroduce la Edad "));
         sexo = JOptionPane.showInputDialog("Introduce el sexo h/m").charAt(0);
         colorPiel = JOptionPane.showInputDialog("Introduce el Colo de Piel  {Blanco, Negro}");

        a1.setNombre(nombre);
        a1.setEdad(edad);
        a1.setSexo(sexo);
        a1.setColorPiel(colorPiel);

        String salida = "Resultado: \n" + "Nombre: " + a1.getNombre() + "\nEdad " +a1.getEdad() + "\nSexo" +a1.getSexo() + "\nColo de Piel " +a1.getColorPiel();

        JOptionPane.showMessageDialog(null, salida);
        JOptionPane.showMessageDialog(null, "Resultado \n" + a1);
    }
}



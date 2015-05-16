package pgn.examenMarzo.concesionarioCoches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/** 
 * 
 * @author Juan  Antonio Cubero Lopez
 * @version 1.0.0
 * */
public class Concesionario implements Serializable{
	private ArrayList<Coches> listaCoches;
	File file = new File("fichero1");
	/** constructor del concesionario*/
	public Concesionario(){
		listaCoches = new ArrayList<Coches>();
	}
	/** metodo que controla la adicion de coches a la lista
	 * @param String matricula
	 * @param String modelo
	 * @param string color
	 * @return no se ha podido añadir el coche
	 * @return se ha añadido el coche*/
	public String altaCoches(String matricula, Modelo modelo,Color color){
		 Coches coche = Coches.instanciarCoches(matricula, modelo, color);
		 if (coche == null || comprobarMatricula(coche.getMatricula())) {
			return "no se ha podido añadir el coche";
		}
		 listaCoches.add(coche);
		 return "se ha añadido el coche";
	}
	/** metodo que controla que no haya matriculas repetidas
	 * @param String matriculas
	 * @return true
	 * @return false
	 */
	private boolean comprobarMatricula(String matricula) {
		// TODO Auto-generated method stub
		for (Object coche : listaCoches.toArray()) {
			if (((Coches) coche).getMatricula().equals(matricula)) {
				return true;
			}
			
			
		}
		return false;
	}
	/** metodo que controla la eliminacion de coches de la lista 
	 * @param String matricula
	 * @return se ha eliminado el coche
	 * @return no se ha podido eliminar*/
	public String eliminarCoche(String matricula){
		for (Coches coche : listaCoches) {
			if ( coche.getMatricula().equals(matricula)) {
				listaCoches.remove(coche);
				return "se ha eliminado el coche";
			}
			
			
		}
		return "no se ha podido eliminar";
	}
	/** muestra un coche que coincida con la matricula pasada por parametro
	 * @param String matricula
	 * @return coche.toString()
	 * @return el coche no existe*/
	public String mostrarCoche(String matricula){
		for (Coches coche : listaCoches) {
			if ( coche.getMatricula().equals(matricula)) {
				return coche.toString();
			}
		}
		return "el coche no existe";
	}
	/** toString de concesionario
	 * @return string*/
	public String toString(){
		String string = "Concesionario IES granCapitan [";
		for (Object coche : listaCoches.toArray()) {
			string += ((Coches) coche).toString() + "\n";		
		}
		string += "]";
		return string;
	}
	/** devuelve una cadena de coches de la lista que son del color indicado por parametro
	 * @param String color
	 * @return string*/
	public String mostrarCochesColor(Color color){
		String string = "[";
		for (Coches coche : listaCoches) {
			
			if( coche.getColor()== color)
				string  += coche + "\n";
		}
		string += "]";
		return string;
	}
	/** te devuelve el numero de coches de la lista
	 * @return listacoches.size()*/
	public int numerosDeCoches(){
		return listaCoches.size();
	}
	
		
}
	
		
	



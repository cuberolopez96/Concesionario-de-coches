package pgn.examenMarzo.concesionarioCoches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pgn.examenMarzo.utiles.Menu;
import pgn.examenMarzo.utiles.Teclado;
/** 
 * 
 * @author Juan Antonio Cubero Lopez
 * @version 1.0.0
 * */
public class TestConcesionario {
	static Concesionario concesionario = new Concesionario();

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int opcion;
		Menu menu = new Menu("Menu del concesionario. elija una opcion:",new String[]{"Alta Coche", "Baja Coche","Mostrar el Coche", "Mostrar el Concesionario","Contar coches del concesionario","Mostrar Coches de un Color","guardar","abrir","salir"});
		do {
			opcion = pedirOpcion( menu.gestionar(), 9);
			try {
				realizarOpcion(opcion);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}catch(FileNotFoundException i){
				System.out.println(i.getMessage());
			}catch(IOException o){
				System.out.println(o.getMessage());
			}
		} while (opcion != 9);
	}
	/** realiza las diferentes opciones elegidas por el usuario en el menu
	 * @param int Opcion
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException */
	private static void realizarOpcion(int opcion) throws FileNotFoundException, IOException, ClassNotFoundException {
		switch(opcion){
		case 1:
			System.out.println(concesionario.altaCoches(Teclado.leerCadena("deme la matricula"), pedirModelo(), pedirColor()));
			break;
		case 2:
			System.out.println(concesionario.eliminarCoche(Teclado.leerCadena("deme la matricula")));
			break;
		case 3:
			System.out.println(concesionario.mostrarCoche(Teclado.leerCadena("deme la Matricula")));
			break;
		case 4:
			System.out.println(concesionario.toString());
			break;
		case 5:
			System.out.println(concesionario.numerosDeCoches() + " coches");
			break;
		case 6:
			System.out.println(concesionario.mostrarCochesColor(pedirColor()));
			break;
		case 7:
			Fichero.guardarComo(concesionario, Teclado.leerCadena("deme el nombre del fichero"));
			break;
		case 8:
			System.out.println(Fichero.abrir(Teclado.leerCadena("deme el nombre del fichero")));
			break;
		}
		
		
	}
	
	
	/** metodo que devuelve una cadena que corresponde a un color elegido por menu
	 * @return Color.getColor(Opcion)*/

	private static Color pedirColor() {
		// TODO Auto-generated method stub
		Menu menuColor = new Menu("lista de colores", Color.toArray());
		System.out.println("elija un color");
		int opcion = pedirOpcion(menuColor.gestionar(), Color.toArray().length);
		return Color.getColor(opcion);
	}
	/**metodo que devuelve un String que corresponde con un Modelo elegido por menu
	 * @return Modelo.getModelo(opcion) */
	private static Modelo pedirModelo() {
		// TODO Auto-generated method stub
		Menu menuModelo = new Menu("lista de modelos",Modelo.toArray());
		System.out.println("elija un modelo");
		int opcion = pedirOpcion( menuModelo.gestionar(), Modelo.toArray().length);
		return Modelo.getModelo(opcion);
	}
	/**Metodo que devuelve un entero que corresponde con una opcion
	 *  @param gestionar
	 *  @param max
	 *  @return opcion*/
	private static int pedirOpcion(
			int gestionar, int max) {
		// TODO Auto-generated method stub
		int opcion;
		do {
			opcion = gestionar;
			if(gestionar > max )
				System.out.println("introduce un numero entre 1 y " + max);
		} while (gestionar < 1 || gestionar > max);
		return opcion;
	}

}

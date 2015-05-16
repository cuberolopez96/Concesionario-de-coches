package concesionario;

import excepciones.CocheNoExisteException;
import excepciones.CocheYaExisteException;
import excepciones.MatriculaNoValidaException;
import utiles.Menu;
import utiles.Teclado;
/** 
 * 
 * @author Juan Antonio Cubero Lopez
 * @version 1.0.0
 * */
public class TestConcesionario {
	static Concesionario concesionario = new Concesionario();
		/**
	 * @param args
	 * @throws CocheNoExisteException 
	 * @throws CocheYaExisteException 
	 */
	public static void main(String[] args) throws CocheNoExisteException, CocheYaExisteException {
		// TODO Auto-generated method stub
		int opcion = 0;
		

		/**
		* Modificacion realizada por Jaime Herrerias
		*/
		System.out.println("Este concesionario es regulero");
		


		Menu menu = new Menu("Menu del concesionario. elija una opcion:",new String[]{"Alta Coche", "Baja Coche","Mostrar el Coche", "Mostrar el Concesionario","Contar coches del concesionario","Mostrar Coches de un Color","salir"});
		do {
			
			try {
				opcion = pedirOpcion( menu.gestionarMenu(), 7);
				realizarOpcion(opcion);
			} catch (CocheNoExisteException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}catch (CocheYaExisteException a) {
				System.out.println(a.getMessage());
			}catch (MatriculaNoValidaException o) {
				System.out.println(o.getMessage());
			}
		} while (opcion != 7);
	}
	/** realiza las diferentes opciones elegidas por el usuario en el menu
	 * @param int Opcion
	 * @throws CocheNoExisteException 
	 * @throws CocheYaExisteException 
	 * @throws MatriculaNoValidaException */
	private static void realizarOpcion(int opcion) throws CocheNoExisteException, CocheYaExisteException, MatriculaNoValidaException {
		switch(opcion){
		case 1:
			System.out.println(concesionario.altaCoches( pedirModelo(), pedirColor(),Teclado.leerCadena("deme la matricula")));
			break;
		case 2:
			System.out.println(concesionario.bajaCoches(Teclado.leerCadena("deme la matricula")));
			break;
		case 3:
			System.out.println(concesionario.mostrarCoche(Teclado.leerCadena("deme la Matricula")));
			break;
		case 4:
			System.out.println(concesionario.toString());
			break;
		case 5:
			System.out.println(concesionario.contarCoches() + " coches");
			break;
		case 6:
			System.out.println(concesionario.mostrarCochesColor(pedirColor()));
			break;
		}
		
	}
	/** metodo que devuelve una cadena que corresponde a un color elegido por menu
	 * @return Color.getColor(Opcion)*/

	private static Color pedirColor() {
		// TODO Auto-generated method stub
		Menu menuColor = new Menu("lista de colores", Color.toArray());
		System.out.println("elija un color");
		int opcion = pedirOpcion(menuColor.gestionarMenu(), Color.toArray().length);
		return Color.getColor(opcion);
	}
	/**metodo que devuelve un String que corresponde con un Modelo elegido por menu
	 * @return Modelo.getModelo(opcion) */
	private static Modelo pedirModelo() {
		// TODO Auto-generated method stub
		Menu menuModelo = new Menu("lista de modelos",Modelo.toArray());
		System.out.println("elija un modelo");
		int opcion = pedirOpcion( menuModelo.gestionarMenu(), Modelo.toArray().length);
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

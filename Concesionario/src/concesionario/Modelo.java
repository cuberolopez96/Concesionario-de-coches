/**
 * 
 */
package concesionario;

/**
 * @author Juan Antonio Cubero Lopez
 * @version 1.0.0
 *
 */
public enum Modelo {
	SERIE1,
	SERIE2,
	SERIE3,
	SERIE5,
	CORDOBA,
	IBIZA,
	TOLEDO;
	
	private String nombre;
	private int valor;
	/** constructor de Modelos*/

	public static Modelo getModelo(int valor){
		for (Modelo modelo : Modelo.values()) {
			if (modelo.ordinal() == valor) {
				return modelo;
			}
			
		}
		return null;
	}
	/** getter de nombre
	 * @return nombre */
//	
	public static String[] toArray(){
		String[] array = new String[7];
		int i = 0;
		for (Modelo modelo : Modelo.values()) {
			array[i] = modelo.name();
			i++;
		}
		
		return array;
	}
}

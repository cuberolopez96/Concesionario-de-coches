package pgn.examenMarzo.concesionarioCoches;
/** 
 * 
 * @author  Juan Antonio Cubero Lopez;
 * @version 1.0.0
 * */
public enum CopyOfColor {
	PLATA("plata",1),
	ROJO("rojo",2),
	AZUL("azul",3);
	private String nombre;
	private int valor;
	/** constructor de color*/
	CopyOfColor(String nombre,int valor){
		setNombre(nombre);
		setValor(valor);
	}
	/** metodo que en funcion de un valor pasado por par&aacute;metro 
	 * devuelve el nombre de uno de los colores
	 * @param int valor
	 * @return color.getNombre
	 * @return null*/
	public static String getColor(int valor){
		for (CopyOfColor color : CopyOfColor.values()) {
			if (color.getValor() == valor) {
				return color.getNombre();
			}
		}
		return null;
	}
	/** getter de valor
	 * @return valor*/
	public int  getValor(){
		return valor;
	}
	/** getter de nombre
	 * @return nombre*/
	public String getNombre() {
		return nombre;
	}
	/**setter de nombre
	 * @param String nombre */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/** setter de valor
	 * @param int valor*/
	private void setValor(int valor) {
		this.valor = valor;
	}
	public static String[] toArray(){
		String[] array = new String[3];
		int i = 0;
		for (CopyOfColor color : CopyOfColor.values()) {
			array[i] = color.getNombre();
			i++;
		}
		
		return array;
	}

}

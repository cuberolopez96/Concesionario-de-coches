package pgn.examenMarzo.concesionarioCoches;

import java.io.Serializable;
import java.util.regex.Pattern;

/** 
 * 
 * @author Juan Antonio Cubero Lopez
 * @version 1.0.0
 * */
public class Coches implements Serializable{
	private String matricula;
	private Modelo modelo;
	private Color color;
	static Pattern pMatricula = Pattern.compile("((\\d\\d\\d\\d))-?[B-Z]{3}$");
	/**constructor de coches */
	private Coches(String matricula,Modelo modelo,Color color){
		setMatricula(matricula);
		setModelo(modelo);
		setColor(color);
	}
	/** este metodo se encarga de controlar la instanciacion de coches 
	 * de manera que si se introduce un dato erroneo devuelve null
	 * @param String matricula
	 * @param String modelo
	 * @param String color
	 * @return new Coches
	 * @return null*/
	public static Coches instanciarCoches(String matricula,Modelo modelo,Color color){
		if(pMatricula.matcher(matricula).matches()&& modelo != null && color != null){
			return new Coches(matricula, modelo, color);
		}
		return null;
	}
	/** getter de matricula
	 * @return matricula*/
	public String getMatricula() {
		return matricula;
	}
	/**setter de matricula
	 * @param String matricula */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**getter de modelo
	 * @return modelo */
	public Modelo getModelo() {
		return modelo;
	}
	/**setter de modelo 
	 * @param String modelo*/
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	/** getter de color
	 * @return color*/
	public Color getColor() {
		return color;
	}
	/**setter de color
	 * @param String color */
	public void setColor(Color color) {
		this.color = color;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coches [matricula=" + matricula + ", modelo=" + modelo
				+ ", color=" + color +   "]";
	}
	

}

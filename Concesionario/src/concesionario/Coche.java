package concesionario;

import java.util.regex.Pattern;

import excepciones.CocheNoExisteException;
import excepciones.MatriculaNoValidaException;

public class Coche {
	private Modelo modelo;
	private Color color;
	private static String matricula;
	private Pattern p = Pattern.compile("^[0-9]{4}[B-Z]{3}$");
	public Color getColor() {
		return color;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setMatricula(String matricula) throws MatriculaNoValidaException{
		
		if (p.matcher(matricula).matches()) {
			this.matricula = matricula;
		}else{
			this.matricula = null;
			throw new MatriculaNoValidaException("matricula no valida");
		}
	}
	
	private Coche(Modelo modelo, Color color, String matricula) throws MatriculaNoValidaException {
		setModelo(modelo);
		setColor(color);
		setMatricula(matricula);
	}
	public static Coche instanciarCoche(Modelo modelo,Color color,String Matricula) throws CocheNoExisteException, MatriculaNoValidaException{
		Coche coche = new Coche(modelo, color, Matricula);
		if(matricula == null || modelo == null || color == null)
			throw new CocheNoExisteException("los datos no son validos");
		return coche;
	}
	public String getMatricula() {
		return matricula;
	}
	@Override
	public String toString() {
		return "coches [modelo=" + modelo + ", color=" + color + ", matricula="
				+ matricula + "]";
	}
	
}

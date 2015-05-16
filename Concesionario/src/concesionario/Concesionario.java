package concesionario;

import java.util.ArrayList;
import java.util.regex.Pattern;

import excepciones.CocheNoExisteException;
import excepciones.CocheYaExisteException;
import excepciones.MatriculaNoValidaException;

public class Concesionario {
	private ArrayList<Coche> listaCoches;

	public Concesionario() {
		super();
		listaCoches = new ArrayList<Coche>();  ;
	}
	public String altaCoches(Modelo modelo,Color color,String Matricula) throws  CocheYaExisteException, CocheNoExisteException, MatriculaNoValidaException{
		Coche coche = Coche.instanciarCoche(modelo, color, Matricula);
		if (listaCoches.contains(coche)) {
			throw new CocheYaExisteException("este coche ya existe , no se volvera a añadir");
		}
		listaCoches.add(coche);
		return "el coche ha sido añadido";
		
	}
	public String bajaCoches(String Matricula) throws CocheNoExisteException{

		if (!listaCoches.remove(comprobarMatricula( Matricula))==false) {
			throw new CocheNoExisteException("el coche no ha sido eliminado");
		}
		return "el coche ha sido eliminado";
	}
	private Coche comprobarMatricula(String matricula) throws CocheNoExisteException {
		for (Coche coche : listaCoches) {
			if (matricula.equals(coche.getMatricula())) {
				return coche;
			}
		}
		throw new CocheNoExisteException("no se ha encontrado el coche");
	}
	public String mostrarCoche(String matricula) throws CocheNoExisteException{
		return comprobarMatricula(matricula).toString();
	}
	@Override
	public String toString() {
		String string = "";
		for (Coche coche : listaCoches) {
			string += coche.toString() + "\n";
		}
		return string;
	}
	public int contarCoches(){
		return listaCoches.size();
	}
	public String mostrarCochesColor(Color Color){
		String string = "";
		for (Coche coche : listaCoches) {
			if (Color == coche.getColor()) {
				string += coche.toString() + "\n";
			}
		}
		return string;
	}
	
	
	
}

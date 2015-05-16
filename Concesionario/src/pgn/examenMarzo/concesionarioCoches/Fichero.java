package pgn.examenMarzo.concesionarioCoches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pgn.examenMarzo.utiles.Teclado;

public class Fichero {
	private static void guardar(Concesionario concesionario,String name) throws FileNotFoundException, IOException{
		File archivo = new File(name);
		try(ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(archivo))){
			save.writeObject(concesionario);
		}catch(FileNotFoundException e){
			System.out.println("error");
		}catch(IOException i){
			System.out.println("error");
		}
	}
	public static Concesionario abrir(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException{
		File archivo  = new File(nombre);
		if (archivo.exists()) {
			ObjectInputStream open = new ObjectInputStream(new FileInputStream(
					archivo));
			return (Concesionario) open.readObject();
		}else{
			return null;
		}
		
	}
	public static void guardarComo(Concesionario concesionario, String name) throws FileNotFoundException, IOException{
		File archivo = new File(name);
		if(archivo.exists()){
			if(deseaSobreescribir())
				guardar(concesionario,name);
			else
				return;
		}else{
			guardar(concesionario,name);
		}
			
		
	}
	private static boolean deseaSobreescribir() {
		// TODO Auto-generated method stub
		char caracter;
		do {
			caracter = Teclado
					.leerCaracter("¿desea Sobreescribir los datos?(s/n)");
		} while (caracter != 's' && caracter != 'S' && caracter != 'n' && caracter == 'N');
		if(caracter == 's' && caracter == 'S')
			return true;
		else
			return false;
	}
	
}

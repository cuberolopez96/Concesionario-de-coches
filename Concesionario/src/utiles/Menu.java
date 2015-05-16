package utiles;
import utiles.OpcionException;
/**
 * 
 * @author Juan Antonio Cubero Lopez.
 * @version 1.0
 *
 */
public class Menu {
	
	private String [] menu;
	private String titulo;
	/**
	 * Constructor de menu y pasao argumentos
	 * @param titulo
	 * @param menu
	 */
	public Menu(String titulo, String[]menu){
		setTitulo(titulo);
		setMenu(menu);
	}
	
	/** Un método mostrar() que muestre el menú, añadiéndole a cada elemento del menú un número, comenzando por 1. 
	 * muestra  el menu.
	 */
	
	private void mostrar(){
		System.out.println(getTitulo());
		for (int i = 0; i < menu.length; i++) {
			System.out.println("("+(i+1)+") "+ menu[i]);
			
		}
	}
	/**
	 * Recogemos la opción valida del menu, si no es valida devuelve una excepcion 
	 * @return el numero valido de opcion
	 * @throws OpcionException
	 */
	private int recogerOpcionValida() throws OpcionException{
		int opcion=Teclado.leerEntero("Dame una opcion valida para el menu (1-"+menu.length+"):");
			
		if(opcion<1 || opcion > menu.length ){
			throw new OpcionException();
		}
		return opcion;
	}
	
	/**
	 * Un método gestionar() que gestione el menú. Gestionar un menú consiste en mostrarlo y recoger la opción válida del menú.
	 * @return devuelve la opción para cualquier metodo.
	 */
	
	public int gestionarMenu(){
		int opcion=-1;
		do{
			mostrar();
			try {
				opcion=recogerOpcionValida();
			} catch (OpcionException e) {
				System.out.println("Error la opcion debe de estar entre (1-"+menu.length+"):");
			}
		}while(opcion==-1);
		
			
		
		
		return opcion;
		
	}
	/**
	 * 
	 * @return ddevuelve el menu
	 */
	public String[] getMenu() {
		return menu;
	}
	
	/**
	 * Título del menú. Se mostrará al principio del menú.
	 * @param menu
	 */
	
	public void setMenu(String[] menu) {
		this.menu = menu;
	}
	/**
	 * 
	 * @return devuelve el titulo del menu.
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * 
	 * @param titulo devuelve el titulo del menu.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	

}

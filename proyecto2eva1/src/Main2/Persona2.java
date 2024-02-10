package Main2;

/**
 * Clase persona. 
 * @author cayet
 */
public class Persona2 {

	private String nombre;
	private int puntuacion;
	
	/**
	 * Este metodo obtiene el nombre de la persona.
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Este método establece el nombre de la persona
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este metodo obtiene la puntuacion de la persona
	 * @param puntuacion
	 */
	public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
	
	/**
	 * Este método establece el nombre de la persona. 
	 * @return
	 */
	public int getPuntuacion() {
        return this.puntuacion;
    }
	

}

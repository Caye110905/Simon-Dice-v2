package Main2;

import java.util.Scanner;
import java.util.Random;

	/**
	 * Simon dice, trabajo 2ª Evaluación
	 * 
	 * @author cayet
	 */
	public class Engine2 {

	/**
	 * Empezamos haciendo un enum con los colores que se van a utilizar para jugar
	 * al Simon dice.
	 */
	enum tColores1 {
		Rojo, Verde, Azul, Dorado, Blanco, Marron, Naranja
	}
	enum tModo {
		Facil, Dificil
	}

	/**
	 * Array donde se fija el numero maximo de secuencia de colores.
	 */
	private int MAX_COLORES_SEQ = 4;
	private int MAX_COLORES_SEQ1 = 7;
	private int ayuda = 3;
	private int salida = 0;
	private Persona2 persona1 = new Persona2();
	private tColores1[] secuenciaColores1 = new tColores1[15];
	
	public void separador() {
		System.out.println("------------------------------------------------------------");
	}

	/**
	 * Este método lo utilizamos para saber cual es la primera letra de cada color
	 * para identificarlos y, asi, nos devuelve cualquiera de los 4 colores puestos
	 * anteriormente en el enum tColores.
	 * 
	 * @param _color representa el caracter del color introducido por el usuario.
	 * @return
	 */
	public tColores1 charToColor(char _color, tColores1 color) {
		tColores1 colores = null;
		char letraColores = Character.toLowerCase(_color);
		
		switch (letraColores) {
		case 'r':
			colores = tColores1.Rojo;
			break;
		case 'v':
			colores = tColores1.Verde;
			break;
		case 'a':
			colores = tColores1.Azul;
			break;
		case 'd':
			colores = tColores1.Dorado;
			break;
		case 'b':
			colores = tColores1.Blanco;
			break;
		case 'm':
			colores = tColores1.Marron;
			break;
		case 'n':
			colores = tColores1.Naranja;
			break;
		case 'x':
			break;
		}
		return colores;
	}
	

	/**
	 * Método para dar un número y nos devuelve cualquiera de los 4 colores puestos
	 * anteriormente en el enum tColores.
	 * 
	 * @param _numero representa el número entero.
	 * @return
	 */
	public tColores1 intToColor(int _numero) {
		tColores1 posicion = null;
		switch (_numero) {
		case 0:
			posicion = tColores1.Rojo;
			break;
		case 1:
			posicion = tColores1.Azul;
			break;
		case 2:
			posicion = tColores1.Verde;
			break;
		case 3:
			posicion = tColores1.Dorado;
			break;
		case 4:
			posicion = tColores1.Blanco;
			break;
		case 5:
			posicion= tColores1.Marron;
			break;
		case 6:
			posicion = tColores1.Naranja;
			break;
		}
		return posicion;
	}
	
	
	/**
	 * Este método genera una secuencia con numeros random o aleatorios.
	 * 
	 * @param _numColores representa el número de colores que tiene el tipo
	 *                    enumerado tColores.
	 */
	public void generarSecuencia(int _numColores) {
			for (int i = 0; i < secuenciaColores1.length; i++) {
				Random random = new Random();
				int aleatorio = random.nextInt(0, _numColores);
				secuenciaColores1[i] = intToColor(aleatorio);
			}
	}

	/**
	 * Este método comprueba si el jugador ha acertado o ha fallado el color.
	 * 
	 * @param _index índice que el color ocupa dentro del array secuenciaColores.
	 * @param _color color introducido por el usuario.
	 * @return
	 */
	public boolean comprobarColor1(int _index, tColores1 _color) {
		return secuenciaColores1[_index] == _color;

	}
	
	/**
	 * Este método muestra la secuencia por pantalla y, así, el jugador pueda
	 * memorizarlo.
	 * @param _numero número de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero) {
			for (int i = 0; i < _numero; i++) {
				System.out.println(secuenciaColores1[i] + " ");
			}
	}
	
	public boolean usarAyuda(int _index) {
		if (ayuda > 0) {
			ayuda --;
			System.out.println( "Introduce el " + secuenciaColores1[_index] + " y te quedan " + this.ayuda + " ayudas");
			return true;
		}else {
			System.out.println("No te quedan mas ayudas");
			return false;
		}
	}
	
	/**
	 * Este es el menú de inicio para jugar.
	 */
	public void menu() {
		separador();
		System.out.println("1- Salir \n2- Jugar en modo fácil \n3- Jugar en modo difícil");
		separador();
	}

	/**
	 * Este es el inicio del juego donde te saludan, tienes que poner tu nombre y
	 * pulsar ENTER para empezar a jugar.
	 */
	public int start() {
		separador();
		System.out.println("Welcome to Simon Dice!");
		System.out.println("What is your name? ");
		separador();
		Scanner scanner = new Scanner(System.in);
		String persona = scanner.nextLine();
		persona1.setNombre(persona);
		System.out.println("Hello " + persona1.getNombre() + ", press ENTER to start playing");
		Scanner scanner1 = new Scanner(System.in);
		scanner1.nextLine();
		persona1.setPuntuacion(0);
		tModo modo = null;
		int _numColores = 0;
		menu();
		Scanner sc1 = new Scanner(System.in);
		int menu = sc1.nextInt();
		switch (menu) {
		case 1:
			System.out.println("Salistes del juego");
			System.exit(0);	
			break;
		case 2:
			System.out.println("Empieza el modo facil");
			modo = tModo.Facil;
			_numColores = MAX_COLORES_SEQ;
			break;
		case 3:
			System.out.println("Empieza el modo dificil");
			modo = tModo.Dificil;
			_numColores = MAX_COLORES_SEQ1;
			break;
		default:
			System.out.println("Número no disponible");
			System.exit(0);
		}
		return _numColores;
	}
	
	/**
	 * Control del juego.
	 */
	public void play() {
		int _numColores = start();
		generarSecuencia(_numColores);
		for (int i = 0; i < 20; i++) {
			int k = 0;
			System.out.println("Pulsa ENTER para empezar a jugar");
			new Scanner(System.in).nextLine();
			for(int j = 0; j < 30; j++) {
				System.out.println();
			}
			mostrarSecuencia(3 + i);
			System.out.println();
			
			int numerosecuencia = i + 1;
			
			System.out.println("Presiona Enter cuando memorices la secuencia " + numerosecuencia);
			new Scanner(System.in).nextLine();
			
			for (int n = 0; n < 30; n++) {
				System.out.println();
			}
			
			System.out.println("¿Cuál era la secuencia de colores?");
				while(k < (3 + i)) {
					System.out.println("Introduce el color en la posición " + (k + 1) + ": ");
					System.out.println("Si quieres usar ayuda pulsa x (solo para modo dificil)");
					Scanner s = new Scanner(System.in);
					char secuenciaUsuario = new Scanner(System.in).next().charAt(0);
					tColores1 colorEscogido = charToColor(secuenciaUsuario,secuenciaColores1[k]);
					if(secuenciaUsuario == 'x' && _numColores == MAX_COLORES_SEQ1){
						if(usarAyuda(k)) {
							persona1.setPuntuacion(persona1.getPuntuacion() - 10);
							if(persona1.getPuntuacion() < 0) {
								persona1.setPuntuacion(-2);
							}
						}
						secuenciaUsuario = s.next().charAt(0);
						colorEscogido = charToColor(secuenciaUsuario,secuenciaColores1[k]);
					}
					
					if (comprobarColor1(k, colorEscogido)) {
						System.out.println("Correcto, bien hecho");
						persona1.setPuntuacion(persona1.getPuntuacion() + 2);
						System.out.println("Tu puntuacion es " + persona1.getPuntuacion());
					} else {
						System.out.println("Incorrecto, fin del juego");
						salida = 1;
						k = 3 + i;
					}
					k++;
				}
				persona1.setPuntuacion(persona1.getPuntuacion() + 5);
			if(salida == 1) {
				System.exit(0);
			}
	
			if (i == 12 - 3 && _numColores == MAX_COLORES_SEQ) {
				System.out.println("Has ganado, terminaste el juego");
				persona1.setPuntuacion(persona1.getPuntuacion() + 40);
				System.out.println("Tu puntuacion final ha sido " + persona1.getPuntuacion());
				menu();
			}
			if (i == 15 - 3 && _numColores == MAX_COLORES_SEQ1) {
				System.out.println("Has ganado, terminaste el juego");
				persona1.setPuntuacion(persona1.getPuntuacion() + 40);
				System.out.println("Tu puntuacion final ha sido " + (persona1.getPuntuacion())*2);
				menu();
			}
      }
   }
}
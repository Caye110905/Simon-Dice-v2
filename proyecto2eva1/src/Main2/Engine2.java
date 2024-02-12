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

	/**
	 * Array donde se fija el numero maximo de secuencia de colores.
	 */
	private int MAX_COLORES_SEQ = 4;
	private int MAX_COLORES_SEQ1 = 7;
	private tColores1[] secuenciaColores = new tColores1[12];
	private tColores1[] secuenciaColores1 = new tColores1[15];

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
			System.out.println("El siguiente color es " + color);
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
	public void generarSecuencia(int _numColores, int menu) {
		if(menu == 2) {
			for (int i = 0; i < secuenciaColores.length; i++) {
				Random random = new Random();
				int aleatorio = random.nextInt(0, 4);
				secuenciaColores[i] = intToColor(aleatorio);
			} 	
		}else if(menu == 3) {
			for (int i = 0; i < secuenciaColores1.length; i++) {
				Random random = new Random();
				int aleatorio = random.nextInt(0, 7);
				secuenciaColores1[i] = intToColor(aleatorio);
			} 	
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
	public boolean comprobarColor(int _index, tColores1 _color) {
		return secuenciaColores[_index] == _color;

	}

	
	/**
	 * Este método muestra la secuencia por pantalla y, así, el jugador pueda
	 * memorizarlo.
	 * @param _numero número de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero, int modo) {
		if(modo == 3) {
			for (int i = 0; i < _numero; i++) {
				System.out.println(secuenciaColores1[i] + " ");
			}
		}else if(modo == 2) {
			for (int i = 0; i < _numero; i++) {
				System.out.println(secuenciaColores[i] + " ");
			}	
		}
	}

	/**
	 * Este es el menú de inicio para jugar.
	 */
	public int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1- Salir \n2- Jugar en modo fácil \n3- Jugar en modo difícil");
		Scanner sc1 = new Scanner(System.in);
		int menu = sc1.nextInt();
		if (menu == 2) {
			System.out.println("Empieza el modo facil");
		} else if (menu == 1) {
			System.out.println("Salistes del juego");
			System.exit(0);	
		} else if (menu == 3) {
			System.out.println("Empieza el modo dificil");
		}else {
			System.out.println("Número no disponible");
			System.exit(0);		
		}
		return menu;
	}

	/**
	 * Este es el inicio del juego donde te saludan, tienes que poner tu nombre y
	 * pulsar ENTER para empezar a jugar.
	 */
	public void start() {
		System.out.println("Welcome to Simon Dice!");
		System.out.println("What is your name? ");
		Scanner scanner = new Scanner(System.in);
		String persona = scanner.nextLine();
		System.out.println("Hello " + persona + ", press ENTER to start playing");
		play();
	}

	/**
	 * Control del juego.
	 */
	public void play() {
	    int ayuda = 3;
		int salida = 0;
		int puntuacion = 0;
		int puntuacionFinal = 0;
		int modo = menu();
		generarSecuencia(15, modo);
		for (int i = 0; i < 20; i++) {
			int k = 0;
			System.out.println("Pulsa ENTER para empezar a jugar");
			new Scanner(System.in).nextLine();
			for(int j = 0; j < 30; j++) {
				System.out.println();
			}
			mostrarSecuencia(3 + i, modo);
			System.out.println();
			
			int numerosecuencia = i + 1;
			
			System.out.println("Presiona Enter cuando memorices la secuencia " + numerosecuencia);
			new Scanner(System.in).nextLine();
			
			for (int n = 0; n < 30; n++) {
				System.out.println();
			}
			
			System.out.println("¿Cuál era la secuencia de colores?");
			if(modo == 2) {
				while(k < (3 + i)) {
					System.out.println("Introduce el color en la posición " + (k + 1) + ": ");
					char secuenciaUsuario = new Scanner(System.in).next().charAt(0);
					tColores1 colorEscogido = charToColor(secuenciaUsuario,secuenciaColores[k]);
					if (comprobarColor(k, colorEscogido)) {
						System.out.println("Correcto, bien hecho");
						puntuacion = puntuacion + 2;
						System.out.println("Tu puntuacion es " + puntuacion);
					} else {
						System.out.println("Incorrecto, fin del juego");
						salida = 1;
						k = 3 + i;	
					}
					k++;
				}
			}else if(modo == 3) {
				while(k < (3 + i)) {
					System.out.println("Introduce el color en la posición " + (k + 1) + ": ");
					char secuenciaUsuario = new Scanner(System.in).next().charAt(0);
					if(ayuda == 0 && secuenciaUsuario == 'x') {
						System.out.println("no te quedan ayudas, juegatela");
						secuenciaUsuario = new Scanner(System.in).next().charAt(0);
					}
					tColores1 colorEscogido = charToColor(secuenciaUsuario,secuenciaColores1[k]);
					if(secuenciaUsuario == 'x') {
						ayuda = ayuda - 1;
						puntuacion = puntuacion - 10;
					}
					if (comprobarColor1(k, colorEscogido) || secuenciaUsuario == 'x') {
						System.out.println("Correcto, bien hecho");
						puntuacion = puntuacion + 2;
						System.out.println("Tu puntuacion es " + puntuacion);
					} else {
						System.out.println("Incorrecto, fin del juego");
						salida = 1;
						k = 3 + i;
					}
					k++;
				}
			}
			if(salida == 1) {
				System.exit(0);
			}
	
			if (i == 12 - 3 && modo == 2) {
				System.out.println("Has ganado, terminaste el juego");
				puntuacion = puntuacion + 40;
				puntuacionFinal = puntuacion;
				menu();
			}
			if (i == 15 - 3 && modo == 3) {
				System.out.println("Has ganado, terminaste el juego");
				puntuacion = puntuacion + 40;
				puntuacionFinal = puntuacionFinal * 2;
				puntuacionFinal = puntuacion;
				if(puntuacionFinal < 0) {
					puntuacionFinal = 0;
				}
				menu();
			}
			
      }
   }
}
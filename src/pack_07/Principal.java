package pack_07;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre:");
		String nombre = sc.nextLine();
		System.out.println("Introduce apellido:");
		String apellido = sc.nextLine();
		System.out.println("Introduce fecha nacimiento (dd/mm/aaaa):");
		String fecha = sc.nextLine();

		FrecuenciasCardiacas persona = new FrecuenciasCardiacas(nombre, apellido, fecha);
		System.out.println(persona);
		System.out.println("Edad: " + persona.getEdad());
		System.out.println("Frecuencia máxima: " + persona.getFrecuenciaMaxima());
		System.out.println("Frecuencia esperada: " + persona.getFrecuenciaEsperada());
	}

}

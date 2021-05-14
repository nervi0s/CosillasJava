package pack_23;

public class EnumTest {

	public static void main(String[] args) {

		DIAS_SEMANA dia = DIAS_SEMANA.LUNES;
		System.out.println(dia); // Devuelve el valor asignado a la variable dia
		System.out.println(dia.name()); // Devuelve el valor asignado a la variable dia

		// Obtenemos el listado de valores finales del enum de tipo DIAS_SEMANA
		DIAS_SEMANA[] contenidoDelEnum = DIAS_SEMANA.values();

		System.out.println("-------");

		for (DIAS_SEMANA diaIterador : contenidoDelEnum) {
			System.out.println(diaIterador.name() + ": " + diaIterador.getFraseReprentativa() );
		}
	}

}

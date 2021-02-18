package pack_07;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FrecuenciasCardiacas {
	private String nombre;
	private String apellido;
	private LocalDate nacimiento;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");

	public FrecuenciasCardiacas(String nombre, String apellido, String fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacimiento = LocalDate.parse(fechaNacimiento, dtf);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getEdad() {
		LocalDate today = LocalDate.now();
		Period periodUntilToday = nacimiento.until(today);

		return periodUntilToday.getYears();
	}

	public int getFrecuenciaMaxima() {
		return 220 - getEdad();
	}

	public String getFrecuenciaEsperada() {
		return (int) (0.5 * getFrecuenciaMaxima()) + " - " + (int) (0.85 * getFrecuenciaMaxima());
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nApelido: " + apellido + "\nNacimiento: " + nacimiento;
	}

}

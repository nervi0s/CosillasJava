package pack_23;

public enum DIAS_SEMANA {

	LUNES(1, "que pereza"), MARTES(2, "menos pereza"), MIERCOLES(3, "así asá"), JUEVES(4, "ya queda nada"),
	VIERNES(5, "viernes!!"), SABADO(6, "bieen"), DOMINGO(7, "ya se acaba :(");

	private final int num_reprentativo;
	private final String frase_reprentativa;

	private DIAS_SEMANA(int num_reprentativo, String frase_reprentativa) {
		this.num_reprentativo = num_reprentativo;
		this.frase_reprentativa = frase_reprentativa;
	}

	public String getFraseReprentativa() {
		return frase_reprentativa;
	}
	public int getNumeroReprentativo() {
		return num_reprentativo;
	}

}

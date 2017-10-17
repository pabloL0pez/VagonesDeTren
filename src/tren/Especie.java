package tren;

public class Especie implements Comparable<Especie>{

	private String especie;
	private int agresividad;
	private int cantidad;
	
	public Especie(String especie, int agresividad, int cantidad) {
		this.especie = especie;
		this.agresividad = agresividad;
		this.cantidad = cantidad;
	}

	public String getEspecie() {
		return especie;
	}

	public int getAgresividad() {
		return agresividad;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	@Override
	public String toString() {
		return "[especie=" + especie + ", agresividad=" + agresividad + ", cantidad=" + cantidad + "]";
	}

	@Override
	public int compareTo(Especie especie) {
		return especie.getAgresividad() - this.getAgresividad();
	}
}

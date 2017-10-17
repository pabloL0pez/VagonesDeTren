package tren;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * No si está bien porque no uso la cantidad de animales de una especie para nada.
 */

public class Tren {

	private int cantEspecies = 0;
	private int nivelAgresividadMaxima = 0;
	private ArrayList<Especie> especies = new ArrayList<Especie>();
	
	private int cantVagones = 0;
	private int nivelAgresividadAcumulado = 0;
	
	public Tren(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		
		this.cantEspecies = scan.nextInt();
		this.nivelAgresividadMaxima= scan.nextInt();
		
		String especie;
		int agresividad;
		int cantidad;
		
		for (int i = 0 ; i < cantEspecies ; i++) {
			especie = scan.next();
			agresividad = scan.nextInt();
			cantidad = scan.nextInt();
			this.especies.add(new Especie(especie, agresividad, cantidad));
		}
		
		scan.close();
	}
	
	public void resolver() throws IOException {
		ordenarEspeciesPorAgresividad();
		separarEspecies();
		escribirSolucion();
	}
	
	private void ordenarEspeciesPorAgresividad() {
		Collections.sort(this.especies);
	}

	private void separarEspecies() {
		int nivelAgresividadAnterior = 0;
		int nivelAgresividadActual = 0;
		
		for (int i = 0 ; i < this.cantEspecies ; i++) {
			for (int j = i + 1 ; j < this.cantEspecies ; j++) {
				nivelAgresividadActual = this.especies.get(i).getAgresividad() - this.especies.get(j).getAgresividad();
				if ((nivelAgresividadAcumulado + nivelAgresividadActual) <= this.nivelAgresividadMaxima ) {
					nivelAgresividadAnterior = nivelAgresividadActual;
					if (j == (this.cantEspecies - 1)) {
						i = j; // Si llegue al final con j, corto i.
					}
				} else {
					i = j-1;
					j = this.cantEspecies; // Corto j.
					this.nivelAgresividadAcumulado += nivelAgresividadAnterior;
					this.cantVagones++;
					nivelAgresividadAnterior = 0;
				}
			}
		}
		
		this.nivelAgresividadAcumulado += nivelAgresividadAnterior;
		this.cantVagones++;
	}
	
	private void escribirSolucion() throws IOException {
		FileWriter file = new FileWriter("vagones.out");
		BufferedWriter buffer = new BufferedWriter(file);
		buffer.write(this.cantVagones + " " + this.nivelAgresividadAcumulado);
		buffer.close();
	}
	
	public void mostrarEspecies() {
		for (Especie esp : this.especies) {
			System.out.println(esp);
		}
	}
}

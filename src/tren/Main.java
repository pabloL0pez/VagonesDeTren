package tren;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			Tren tren = new Tren("vagones.in");
			//generarCasoFatiga();
			tren.resolver();
			//tren.mostrarEspecies();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void generarCasoFatiga() throws IOException {
		char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		String[] words = new String[100];
		String word;
		int cont = 0;
		
		FileWriter file = new FileWriter("vagones_fatiga.in");
		BufferedWriter buffer = new BufferedWriter(file);
		
		for (int i = 0 ; i < abecedario.length ; i++) {
			for (int j = 0 ; j < abecedario.length ; j++) {
				if (cont == 100) {
					break;
				}
				word = abecedario[i] + "" + abecedario[j];
				words[cont] = word;
				cont++;
			}
			if (cont == 100) {
				break;
			}
		}
		
		cont = 2;
		buffer.write(10000 + " " + 0);
		buffer.newLine();
		
		for (int i = 0 ; i < words.length ; i++) {
			for (int j = 0 ; j < words.length ; j++) {
				buffer.write(words[i] + words[j] + " " + cont + " " + 1);
				buffer.newLine();
				cont += 2;
			}
		}
		
		buffer.close();
	}
}

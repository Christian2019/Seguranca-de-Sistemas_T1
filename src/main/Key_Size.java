package main;

import java.util.ArrayList;

public class Key_Size {
	// Índice coincidência de portugues e ingles
	static double ic_portugues = 0.072723;
	static double ic_ingles = 0.065;

	// Retorna o tamanho da chave
	public static int discover_Key_Size(double ic_lingua) {
		String text = Game.texto;
		// Testa chaves de tamanho 1 ate 100
		for (int i = 0; i < 100; i++) {
			System.out.println("Chave de tamanho: " + (i + 1));

			// Divide o texto em substrings de acordo com o tamanho de chave testado
			for (int j = 0; j < i + 1; j++) {
				String teste = "";

				for (int k = j; k < text.length(); k += i + 1) {
					teste += text.substring(k, k + 1);
				}
				// Calcula o IC para cada substring
				double ic = indice_coincidencia(teste);
				System.out.println("IC: " + ic);
				// Caso o IC ds substring esteja em um intervalo proximo ao IC da lingua, o
				// tamanho da chave foi encontrdo e é retornado
				if (ic > (ic_lingua - 0.01) && ic < (ic_lingua + 0.01)) {
					System.out.println("Chave encontrada! Seu tamanho: " + (i + 1));
					System.out.println();
					return (i + 1);
				}
			}

		}
		return 0;
	}

//Retorna o ic de uma string
	static double indice_coincidencia(String text) {

		ArrayList<AlphabetValue> ocorrencias = ocorrencias(text);

		double ic = 0;

		for (int i = 0; i < ocorrencias.size(); i++) {
			int value = ocorrencias.get(i).value;
			ic += value * (value - 1);

		}
		ic /= text.length() * (text.length() - 1);

		return ic;

	}

	// Retorna uma lista com as frequencias de cada letra dado um texto
	public static ArrayList<AlphabetValue> ocorrencias(String text) {
		ArrayList<AlphabetValue> ocorrencias = new ArrayList<AlphabetValue>();
		// Cria uma lista com todas as letras do alfabeto e set o valor delas para 0,
		// aqui o value sera usado como o numero de ocorrencias na String
		for (int i = 0; i < AlphabetValue.alphabetvalues.size(); i++) {
			AlphabetValue a = new AlphabetValue(AlphabetValue.alphabetvalues.get(i).letter,
					AlphabetValue.alphabetvalues.get(i).value);
			ocorrencias.add(a);
			ocorrencias.get(i).value = 0;
		}
		// Determina o numero de ocorrencias de cada letra na String
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < ocorrencias.size(); j++) {
				if (ocorrencias.get(j).letter.equals(text.substring(i, i + 1))) {
					ocorrencias.get(j).value++;
				}
			}
		}

		return ocorrencias;
	}

}

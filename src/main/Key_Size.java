package main;

import java.util.ArrayList;

public class Key_Size {

	double ic_portugues = 0.072723;

	public static void discover_Key_Size() {
		indice_coincidencia("abacaxi");
	}

	static double indice_coincidencia(String text) {
		ArrayList<AlphabetValue> ocorrencias = new ArrayList<AlphabetValue>();
		// Cria uma lista com todas as letras do alfabeto e set o valor delas para 0,
		// aqui o value sera usado como o numero de ocorrencias na String enviada
		for (int i = 0; i < AlphabetValue.alphabetvalues.size(); i++) {
			ocorrencias.add(AlphabetValue.alphabetvalues.get(i));
			ocorrencias.get(i).value = 0;
		}
		// Determina o numero de ocorrencias de cada letra na String enviada
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < ocorrencias.size(); j++) {
				if (ocorrencias.get(j).letter.equals(text.substring(i, i + 1))) {
					ocorrencias.get(j).value++;
				}
			}
		}

		System.out.println(ocorrencias);
		return 0;
	}
}

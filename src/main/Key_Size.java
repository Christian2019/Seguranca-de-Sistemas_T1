package main;

import java.util.ArrayList;

public class Key_Size {

	static double ic_portugues = 0.072723;

	public static int discover_Key_Size() {
		String text = Game.texto;
		for (int i = 0; i < 10; i++) {
			System.out.println("Chave de tamanho: " + (i+1));
			for (int j = 0; j < i + 1; j++) {
				String teste = "";
				for (int k = j; k < text.length(); k += i + 1) {
					teste += text.substring(k, k + 1);
				}

				double ic = indice_coincidencia(teste);
				System.out.println("IC: " + ic);
				if (ic > (ic_portugues - 0.003) && ic < (ic_portugues + 0.003)) {
					System.out.println("Chave de tamanho: " + (i+1));
					return (i+1);
				}
			}

		}
		return 0;
	}

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

	public static ArrayList<AlphabetValue> ocorrencias(String text) {
		ArrayList<AlphabetValue> ocorrencias = new ArrayList<AlphabetValue>();
		// Cria uma lista com todas as letras do alfabeto e set o valor delas para 0,
		// aqui o value sera usado como o numero de ocorrencias na String enviada
		for (int i = 0; i < AlphabetValue.alphabetvalues.size(); i++) {
			AlphabetValue a = new AlphabetValue (AlphabetValue.alphabetvalues.get(i).letter,AlphabetValue.alphabetvalues.get(i).value);
			ocorrencias.add(a);
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

		// System.out.println(ocorrencias);
		return ocorrencias;
	}

}

package main;

import java.util.ArrayList;

public class Key {
	public static ArrayList<String> keys = new ArrayList<String>();
	public static String key = "";
	public static String key2 = "";

	// Encontra a key que considera "a" como letra de maior frequencia e a key2 que
	// considera "e"
	// como a letra de maior frequencia. Tambem cria um Array com todas as
	// combinacoes possiveis entre as 2 keys.
	public static void dicovery_key(int key_size) {

		String text = Game.texto;
		ArrayList<String> colunas = new ArrayList<String>();
		// Divide o texto em n colunas, sendo n igual ao tamanho da chave
		for (int i = 0; i < key_size; i++) {
			String coluna = "";
			for (int j = i; j < text.length(); j += key_size) {
				coluna += text.substring(j, j + 1);
			}
			colunas.add(coluna);
		}

		// Para cada uma das colunas verifica a letra de maior frequencia
		for (int i = 0; i < colunas.size(); i++) {
			ArrayList<AlphabetValue> ocorrencias = new ArrayList<AlphabetValue>();
			ocorrencias = Key_Size.ocorrencias(colunas.get(i));
			String letra_de_maior_frequencia = mf(ocorrencias);
			// Se o texto estiver em portugues grava em key a letra de maior frequencia
			// considerando "a" como a letra de maior frequencia da lingua.
			// Em key2 grava a letra de maior frequencia
			// considerando "e" como a letra de maior frequencia da lingua
			if (Game.ic_escolhido == Key_Size.ic_portugues) {
				// a letra da chave correspondente a coluna = letra de maior frequencia - letra
				// de maior frequencia da lingua
				key += letra_de_maior_frequencia;
				key2 += AlphabetValue.get_Letter(AlphabetValue.get_Value(letra_de_maior_frequencia) - 4);
			} else {
				// Se o texto esta em ingles grava em key a letra de maior frequencia
				// considerando "e" como a letra de maior frequencia da lingua
				key += AlphabetValue.get_Letter(AlphabetValue.get_Value(letra_de_maior_frequencia) - 4);
			}

		}

		System.out.println("Chave 1: " + key);
		System.out.println("Chave 2: " + key2);

		allkeyCombinations(key_size);
	}

	// Grava todas as combinacoes das chaves na lista keys
	private static void allkeyCombinations(int key_size) {
		for (int i = 0; i < Math.pow(2, key_size); i++) {
			String binary = Integer.toBinaryString(i);
			while (binary.length() < key_size) {
				String a = "0";
				a += binary;
				binary = a;
			}

			String new_key = "";
			for (int j = 0; j < binary.length(); j++) {
				if (binary.substring(j, j + 1).equals("0")) {
					new_key += key.substring(j, j + 1);

				} else {
					new_key += key2.substring(j, j + 1);
				}
			}
			keys.add(new_key);
		}
		System.out.println("Todas as chaves possiveis: " + keys);
		System.out.println();
	}

	//Retorna a letra de maior frequencia
	private static String mf(ArrayList<AlphabetValue> ocorrencias) {
		int frequencia = 0;
		String letra = "";
		for (int i = 0; i < ocorrencias.size(); i++) {
			if (ocorrencias.get(i).value > frequencia) {
				frequencia = ocorrencias.get(i).value;
				letra = ocorrencias.get(i).letter;
			}
		}

		return letra;
	}

}

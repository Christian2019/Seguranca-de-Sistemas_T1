package main;

import java.util.ArrayList;

public class Decipher {
	// Decifra o texto cifrado
	public static void decifrar() {
		String key;
		// Se a lingua for inglesa a chave ja esta pronta para decifrar
		if (Game.ic_escolhido == Key_Size.ic_ingles) {
			key = Key.key;
			dec(key);
		} else {
			// Caso seja portugues, decifra todos os textos com todas as combinacoes das chaves.
			// Depois pega a frequencia de k + w + y de cada um dos textos decifrados. O texto que
			// resultou em menor frequencia sera o texto correto, e portanto usou a chave correta
			int menor = 0;
			int cont_menor = Game.texto.length();
			for (int i = 0; i < Key.keys.size(); i++) {
				key = Key.keys.get(i);
				// Decifra o texto usando a chave enviada por parametro
				String resposta = dec(key);
				// Calcula a frequencia de k+w+y
				int cont_chars = kwy(resposta);
				if (cont_chars < cont_menor) {
					cont_menor = cont_chars;
					menor = i;
				}
			}
			// Imprime a chave correta
			System.out.println("Chave correta: " + Key.keys.get(menor));
			// Imprime os 100 primeiros caracters do texto decifrado
			System.out.println(
					"100 primeiros caracteres do texto original: " + dec(Key.keys.get(menor)).substring(0, 100));
		}

	}

	//Retorna a frequencia de k+w+y de uma String
	public static int kwy(String resposta) {
		int cont = 0;
		ArrayList<AlphabetValue> frequencias = Key_Size.ocorrencias(resposta);

		for (int i = 0; i < frequencias.size(); i++) {
			if (frequencias.get(i).letter.equals("k")) {
				cont += frequencias.get(i).value;
			} else if (frequencias.get(i).letter.equals("w")) {
				cont += frequencias.get(i).value;
			} else if (frequencias.get(i).letter.equals("y")) {
				cont += frequencias.get(i).value;
			}
		}

		return cont;
	}

	//Decifra o texto cifrado usando uma chave como parametro
	public static String dec(String key) {
		String text = Game.texto;
		String resposta = "";
		int key_position = -1;
		for (int i = 0; i < text.length(); i++) {
			key_position++;
			if (key_position > key.length() - 1) {
				key_position = 0;
			}
			String letra_cifrada = text.substring(i, i + 1);
			String letra_chave = key.substring(key_position, key_position + 1);
			int lcif = AlphabetValue.get_Value(letra_cifrada);
			int lcha = AlphabetValue.get_Value(letra_chave);
			int lmensagem = lcif - lcha;

			if (lmensagem < 0) {
				lmensagem = 26 + lmensagem;
			}

			String letra_mensagem = AlphabetValue.get_Letter(lmensagem);
			resposta += letra_mensagem;

		}

		return resposta;
	}
}

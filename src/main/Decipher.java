package main;

import java.util.ArrayList;

public class Decipher {

	public static void decifrar() {

		String key;
		// String key = "meunome";
		if (Game.ic_escolhido == Key_Size.ic_ingles) {
			key = Key.key;
			dec(key);
		} else {
			int menor = 0;
			int cont_menor = Game.texto.length();
			for (int i = 0; i < Key.keys.size(); i++) {
				key = Key.keys.get(i);
				String resposta = dec(key);
				int cont_chars = kwy(resposta);
				if (cont_chars < cont_menor) {
					cont_menor = cont_chars;
					menor=i;
				}

			}
			System.out.println(Key.keys.get(menor));
			System.out.println(dec(Key.keys.get(menor)).substring(0, 100));
		}

	}

	public static int kwy(String resposta) {
		int cont=0;
		ArrayList<AlphabetValue> frequencias = Key_Size.ocorrencias(resposta);

		for (int i = 0; i < frequencias.size(); i++) {
			if (frequencias.get(i).letter.equals("k")) {
				cont+=frequencias.get(i).value;
			}else if (frequencias.get(i).letter.equals("w")) {
				cont+=frequencias.get(i).value;
			}else if (frequencias.get(i).letter.equals("y")) {
				cont+=frequencias.get(i).value;
			}
		}

		return cont;
	}

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

		// System.out.println(resposta.substring(0,100));
		return resposta;
	}
}

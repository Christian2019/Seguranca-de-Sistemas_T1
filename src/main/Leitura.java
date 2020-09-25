package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Leitura {
	//Le um txt e grava o conteudo da primeira linha na String texto da classe Game
	public static void load(String path) {

		int cont_line = 1;
		InputStream is = Leitura.class.getResourceAsStream(path);
		String singleLine = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			try {
				while ((singleLine = reader.readLine()) != null) {
					String texto = singleLine;
					Game.texto = texto;
					cont_line++;
					return;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}

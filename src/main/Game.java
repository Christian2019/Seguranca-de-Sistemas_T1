package main;

// Author: Christian Schmidt

public class Game {
	//Texto cifrado	
	public static String texto;
	
	//índice coincidência da língua escolhida
	public static double ic_escolhido;

	public static void main(String[] args) {
		// ic recebe a ic da lingua portuguesa
		ic_escolhido = Key_Size.ic_portugues;
		
		// Cria um array das letras do alfabeta e seus respectivos valores ex: a=0 b=1 c=2....
		AlphabetValue.start();

		// Le o texto cifrado "Arquivo cifrado (plaintext em Português)" e armazena na String texto
		Leitura.load("/entrada.txt");
		
		// Descobre o tamanho da chave
		int key_size = Key_Size.discover_Key_Size(ic_escolhido);

		// Descobre a chave
		Key.dicovery_key(key_size);
		
		// Decifra
		Decipher.decifrar();
	}

}

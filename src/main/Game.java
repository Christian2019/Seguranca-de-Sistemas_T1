package main;
// Name: Christian Schmidt
public class Game {
public static String texto;
	public static void main(String[] args) {
		//Cria um alfabeto com o valor de cada letra
		AlphabetValue.start();
		
		//Le o texto cifrado e armazena na variavel texto
		Leitura.load("/entrada.txt");
		
	//	Leitura.load("/teste.txt");
		//Descobre o tamanho da chave
		int key_size=Key_Size.discover_Key_Size();
	
		//Descobre a chave
		Key.dicovery_key(key_size);
		//Decifra
		Decipher.decifrar();
	
		//Cria um txt com a resposta e printa na tela a resposta
	}

}

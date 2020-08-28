package main;
// Name: Christian Schmidt
public class Game {
public static String texto;
	public static void main(String[] args) {
		//Cria um alfabeto com o valor de cada letra
		AlphabetValue.start();
		//Le o texto cifrado e armazena na variavel texto
		Leitura.load("/entrada.txt");
		//Descobre o tamanho da chave
		Key_Size.discover_Key_Size();
		//Descobre a chave
		//Cria um txt com a respota e printa na tela a resposta
	}

}

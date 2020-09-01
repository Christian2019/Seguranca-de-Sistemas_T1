package main;
// Name: Christian Schmidt
public class Game {
public static String texto;
public static double ic_escolhido;
	public static void main(String[] args) {
		ic_escolhido = Key_Size.ic_portugues;
	//	ic_escolhido = Key_Size.ic_ingles;
		//Cria um alfabeto com o valor de cada letra
		AlphabetValue.start();
		
		//Le o texto cifrado e armazena na variavel texto
		Leitura.load("/entrada.txt");
	//	Leitura.load("/ingles.txt");
//		Leitura.load("/teste.txt");
		//Cifador (para testes)
		System.out.println(Key_Size.ocorrencias(texto));
//		texto=Cipher.cifrar(texto,"xyzhahae");
		
	//	System.out.println(texto);
		//Descobre o tamanho da chave
		int key_size=Key_Size.discover_Key_Size(ic_escolhido);
	
		//Descobre a chave
		Key.dicovery_key(key_size);
		//Decifra
		Decipher.decifrar();
	
		//Cria um txt com a resposta e printa na tela a resposta
	}

}

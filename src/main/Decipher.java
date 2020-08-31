package main;

public class Decipher {

	public static void decifrar() {
		String text=Game.texto;
		String key = Key.key;
	//	String key = "meunome";
		String resposta="";
		int key_position=-1;
		for (int i=0;i<text.length();i++) {
			key_position++;
			if (key_position>key.length()-1) {
				key_position=0;
			}
			String letra_cifrada = text.substring(i, i+1);
			String letra_chave = key.substring(key_position,key_position+1);
			int lcif= AlphabetValue.get_Value(letra_cifrada);
			int lcha= AlphabetValue.get_Value(letra_chave);
			int lmensagem = lcif-lcha;
			
			
			
			if (lmensagem<0) {
				lmensagem = 26+lmensagem;
			}
			
			String letra_mensagem =  AlphabetValue.get_Letter(lmensagem);
			resposta+=letra_mensagem;
			
		}
		
		System.out.println(resposta.substring(0,100));
		
		
	}

}

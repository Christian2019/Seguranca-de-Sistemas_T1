package main;

public class Cipher {

	public static String cifrar(String text, String key) {
		String texto_cifrado="";
		int key_position=0;
		for (int i=0;i<text.length();i++) {
			if (key_position>(key.length()-1)) {
				key_position=0;
			}
			int key_value=AlphabetValue.get_Value(key.substring(key_position, key_position+1));
			int text_value = AlphabetValue.get_Value(text.substring(i, i+1));
			int cifra_value= key_value+text_value;
			if (cifra_value>25) {
				cifra_value-=26;
			}
			texto_cifrado+=AlphabetValue.get_Letter(cifra_value);
			
			
			key_position++;
		}
		
		
		
		return texto_cifrado;
	}
	
}

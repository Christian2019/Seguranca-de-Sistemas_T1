package main;

import java.util.ArrayList;

public class Key {
public static String key="";
	public static void dicovery_key(int key_size) {
	
		String text = Game.texto;
		ArrayList<String> colunas = new ArrayList<String>();
		for (int i = 0; i < key_size; i++) {
			String coluna = "";
			for (int j = i; j < text.length(); j += key_size) {
				coluna += text.substring(j, j + 1);
			}
			colunas.add(coluna);
		}
		System.out.println(colunas);
		// Como a letra de maior frequencia na lingua portuguesa é o a e ele tem valor
		// 0, a letra de maior frequencia de cada coluna é igual a letra da chave
		// correspondente
		for (int i=0;i<colunas.size();i++) {
			ArrayList<AlphabetValue> ocorrencias= new ArrayList<AlphabetValue>();
			ocorrencias = Key_Size.ocorrencias(colunas.get(i));
			String letra_de_maior_frequencia= mf(ocorrencias);
			if (Game.ic_escolhido==Key_Size.ic_portugues) {
			key+=letra_de_maior_frequencia;
			
			}else {
				key+=AlphabetValue.get_Letter(AlphabetValue.get_Value(letra_de_maior_frequencia)-4);
			}
			System.out.println(ocorrencias);
		}
		System.out.println(key);
	}
	private static String mf(ArrayList<AlphabetValue> ocorrencias) {
		int frequencia =0;
		String letra="";
		for (int i=0;i<ocorrencias.size();i++) {
			if(ocorrencias.get(i).value>frequencia) {
				frequencia=ocorrencias.get(i).value;
				letra = ocorrencias.get(i).letter;
				}
		}
		
		return letra;
	}

}

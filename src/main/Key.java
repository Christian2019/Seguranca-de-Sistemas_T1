package main;

import java.util.ArrayList;

public class Key {
public static ArrayList<String> keys= new ArrayList<String>();
public static String key="";
public static String key2="";

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
		//System.out.println(colunas);
		
		for (int i=0;i<colunas.size();i++) {
			ArrayList<AlphabetValue> ocorrencias= new ArrayList<AlphabetValue>();
			ocorrencias = Key_Size.ocorrencias(colunas.get(i));
			String letra_de_maior_frequencia= mf(ocorrencias);
			if (Game.ic_escolhido==Key_Size.ic_portugues) {
			key+=letra_de_maior_frequencia;
			key2+=AlphabetValue.get_Letter(AlphabetValue.get_Value(letra_de_maior_frequencia)-4);
			}else {
				key+=AlphabetValue.get_Letter(AlphabetValue.get_Value(letra_de_maior_frequencia)-4);
			}
			System.out.println(ocorrencias);
		}
		
		System.out.println(key);
		System.out.println(key2);
		allkeyCombinations(key_size);
	}
	private static void allkeyCombinations(int key_size) {
		for (int i=0;i<Math.pow(2, key_size);i++) {
			String binary = Integer.toBinaryString(i);
			while (binary.length()<key_size) {
				String a="0";
				a+=binary;
				binary=a;
			}
			
			String new_key="";
			for (int j=0;j<binary.length();j++) {
				if (binary.substring(j, j+1).equals("0")) {
					new_key+=key.substring(j,j+1);
									
				}
				else {
					new_key+=key2.substring(j,j+1);
				}
			}
			keys.add(new_key);
		}
		System.out.println(keys);
		
		
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

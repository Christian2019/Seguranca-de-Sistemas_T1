package main;

import java.util.ArrayList;

public class AlphabetValue {
	public String letter;
	public int value;
	public static ArrayList<AlphabetValue> alphabetvalues= new ArrayList<AlphabetValue>();

	@Override
	public String toString() {
		return "AlphabetValue [letter=" + letter + ", value=" + value + "]\n";
	}

	public AlphabetValue(String letter, int value) {
		this.letter = letter;
		this.value = value;

	}

	public static void start() {
		AlphabetValue a = new AlphabetValue("a", 0);
		alphabetvalues.add(a);
		AlphabetValue b = new AlphabetValue("b", 1);
		alphabetvalues.add(b);
		AlphabetValue c = new AlphabetValue("c", 2);
		alphabetvalues.add(c);
		AlphabetValue d = new AlphabetValue("d", 3);
		alphabetvalues.add(d);
		AlphabetValue e = new AlphabetValue("e", 4);
		alphabetvalues.add(e);
		AlphabetValue f = new AlphabetValue("f", 5);
		alphabetvalues.add(f);
		AlphabetValue g = new AlphabetValue("g", 6);
		alphabetvalues.add(g);
		AlphabetValue h = new AlphabetValue("h", 7);
		alphabetvalues.add(h);
		AlphabetValue i = new AlphabetValue("i", 8);
		alphabetvalues.add(i);
		AlphabetValue j = new AlphabetValue("j", 9);
		alphabetvalues.add(j);
		AlphabetValue k = new AlphabetValue("k", 10);
		alphabetvalues.add(k);
		AlphabetValue l = new AlphabetValue("l", 11);
		alphabetvalues.add(l);
		AlphabetValue m = new AlphabetValue("m", 12);
		alphabetvalues.add(m);
		AlphabetValue n = new AlphabetValue("n", 13);
		alphabetvalues.add(n);
		AlphabetValue o = new AlphabetValue("o", 14);
		alphabetvalues.add(o);
		AlphabetValue p = new AlphabetValue("p", 15);
		alphabetvalues.add(p);
		AlphabetValue q = new AlphabetValue("q", 16);
		alphabetvalues.add(q);
		AlphabetValue r = new AlphabetValue("r", 17);
		alphabetvalues.add(r);
		AlphabetValue s = new AlphabetValue("s", 18);
		alphabetvalues.add(s);
		AlphabetValue t = new AlphabetValue("t", 19);
		alphabetvalues.add(t);
		AlphabetValue u = new AlphabetValue("u", 20);
		alphabetvalues.add(u);
		AlphabetValue v = new AlphabetValue("v", 21);
		alphabetvalues.add(v);
		AlphabetValue w = new AlphabetValue("w", 22);
		alphabetvalues.add(w);
		AlphabetValue x = new AlphabetValue("x", 23);
		alphabetvalues.add(x);
		AlphabetValue y = new AlphabetValue("y", 24);
		alphabetvalues.add(y);
		AlphabetValue z = new AlphabetValue("z", 25);
		alphabetvalues.add(z);

	}

	public static int get_Value(String l) {
		for (int i = 0; i < alphabetvalues.size(); i++) {
			if (alphabetvalues.get(i).letter.equals(l)) {
				
				return alphabetvalues.get(i).value;
			}
		}
		System.out.println("Letra não encontrada!");
		return -1;
	}

	public static String get_Letter(int value) {
		for (int i = 0; i < alphabetvalues.size(); i++) {
			if (alphabetvalues.get(i).value==value) {
				return alphabetvalues.get(i).letter;
			}
		}
	//	System.out.println("Valor não encontrado!");
		
		return "";
	}
}

package app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TranslateService {
	
	private static final Map<String, String> table = new HashMap<String, String>();
	static {
		//LLeno el mapa table con los valores morse
		table.put(".-", "A");
		table.put("-...", "B");
		table.put("-.-.", "C");
		table.put("-..", "D");
		table.put(".", "E");
		table.put("..-.", "F");
		table.put("--.", "G");
		table.put("....", "H");
		table.put("..", "I");
		table.put(".---", "J");
		table.put("-.-", "K");
		table.put(".-..", "L");
		table.put("--", "M");
		table.put("-.", "N");
		table.put("---", "O");
		table.put(".--.", "P");
		table.put("--.-", "Q");
		table.put(".-.", "R");
		table.put("...", "S");
		table.put("-", "T");
		table.put("..-", "U");
		table.put("...-", "V");
		table.put(".--", "W");
		table.put("-..-", "X");
		table.put("-.--", "Y");
		table.put("--..", "Z");
		table.put("-----", "0");
		table.put(".----", "1");
		table.put("..---", "2");
		table.put("...--", "3");
		table.put("....-", "4");
		table.put(".....", "5");
		table.put("-....", "6");
		table.put("--...", "7");
		table.put("---..", "8");
		table.put("----.", "9");
		table.put(".-.-.-", ".");
	}
	
	public String translate2Human(String morse) {
			
		//Chequeo si hay clave morse
		if(morse != null && morse.length() > 0) {
			
			//Separo el string morse en cada espacio para guardar en el array
			String[] morseArray = morse.split("\\s");
			StringBuilder ascii = new StringBuilder();
			
			//itero entre cada codigo morse del array
			for(int i = 0; i < morseArray.length; i++) {
				
				//obtengo el valor mediante la clave del mapa table
				if(morseArray[i].equals(" ") || morseArray[i].equals(""))
					ascii.append(" ");
				else if(morseArray[i].equals(".-.-.-")) {
					ascii.append(table.get(morseArray[i]));
					return String.valueOf(ascii);
				}
				else
					ascii.append(table.get(morseArray[i]));
				
			}
			
			//convierto el stringbuilder a string y lo retorno
			return String.valueOf(ascii);
			
		} else {
			
			return "There is no morse code to translate.";
		}
	}
		
		
	public String translate2Morse(String ascii) {
		
		ascii.trim();
		
		//Chequeo si hay texto a convertir
		if(ascii != null && ascii.length() > 0) {
		
			//Transformo la string a upper y separo en cada caracter en el array
			//(?!^) negative lookahead regex
			String[] asciiArray = ascii.toUpperCase().split("(?!^)");
			StringBuilder morse = new StringBuilder();
			
			//itero cada letra ascii del array
			for(int i = 0; i < asciiArray.length; i++) {
				
				//obtengo la key mediante el valor del mapa table con la funcion getKeyFromValue
				if(asciiArray[i].equals(" ") || asciiArray[i].equals(""))
					morse.append("  ");
				else
					morse.append(getKeyFromValue(asciiArray[i]) + " ");
				
			}
			
			return String.valueOf(morse);
			
		} else {
			
			return "There is no text to transform to morse.";
		}
	}
	
	
	private Object getKeyFromValue(Object value) {
		
		//para cada key del mapa table
		for(Object k : table.keySet()) {
			
			//comparo si es igual al valor que estoy buscando y retorno la key
			if(table.get(k).equals(value))
				return k;
		}
		
		return null;
	}
}



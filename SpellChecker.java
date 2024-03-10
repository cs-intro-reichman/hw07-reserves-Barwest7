
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		String lowerCased1 = word1.toLowerCase();
		String lowerCased2 = word2.toLowerCase();

		// Base case word 2 is empty
		if (word2.length() == 0)
			return word1.length();

		// Base case word 1 is empty
		else if (word1.length() == 0)
			return word2.length();

		// Both first cahrs equal:
		else if (lowerCased1.charAt(0) == lowerCased2.charAt(0))
			return levenshtein(tail(lowerCased1), tail(lowerCased2));

		else 
			return 1 + Math.min(levenshtein(tail(lowerCased1), lowerCased2), Math.min(levenshtein(lowerCased1, tail(lowerCased2)), levenshtein(tail(lowerCased1), tail(lowerCased2))));

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		for (int i=0; i<3000; i++) {
			dictionary[i] = in.readString();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int minDistance = 999;
		String newWord = "";
		for (int i=0; i<3000; i++) {
			if (levenshtein(word, dictionary[i]) < minDistance) {
				minDistance = levenshtein(word, dictionary[i]);
				newWord = dictionary[i];
			}
		}

		if (minDistance > threshold)
			return word;

		return newWord;
	}

}

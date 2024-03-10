

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here
		for (int i=0; i<3000; i++) {
			if (dictionary[i].equals(word))
				return true;
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Make the entire string lowercase
		String lowerCased = hashtag.toLowerCase();

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			if (existInDictionary(lowerCased.substring(0, i), dictionary)) {
				System.out.println(lowerCased.substring(0, i));
				breakHashTag(hashtag.substring(i, N), dictionary);
			}
        }
    }

}

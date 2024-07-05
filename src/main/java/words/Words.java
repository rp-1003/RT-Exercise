package words;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Words {
	public static List<String> getUniqueWordsFromSentence(String sentence) {
		
		String[] words = sentence.split("[\\s\\p{Punct}]+");
		Set<String> uniqueWords = new HashSet<>();
		for (String word : words) {
			uniqueWords.add(word.toLowerCase());
		}
		List<String> result = new ArrayList<>(uniqueWords);
		return result;
	}
}

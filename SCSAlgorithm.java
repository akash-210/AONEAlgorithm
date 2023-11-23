import java.util.HashMap;
/**
 *
 * @author Akash
 */
public class SCSAlgorithm  extends TextSample  {

	public static void main(String... arrays) { 
		String parag=readFile("largetxt5.txt");
		String find="dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5";
		long start=System.currentTimeMillis();
		int frequency = startSCS(find,parag); 
	    System.out.println("Frequency of the pattern: " + frequency);
	    System.out.println(System.currentTimeMillis() - start+" Millis");
	}
	
	private static int startSCS(String toFind, String paragraph) {
		char[] charArray = toFind.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<>();
		int y = 0;
		for (Character character : charArray) {
			charMap.put(character, y++);
		}
		int toFindLen = toFind.length();
		int toFindCharLen = toFindLen-1;
		int paraLen = paragraph.length();
		boolean pass=true;
		int j = 0;
		int count = 0;
		for (int i = 0; i < paraLen;) {
			Integer ln = 0;
			if ( pass && (ln = charMap.get(paragraph.charAt(i))) != null || paragraph.charAt(i)==charArray[j]) {
				if (j == toFindCharLen) {
					count++;
					j = 0;
					i += toFindLen;
					pass=true;
				} else if (pass) {
					if(i - ln > 0 ) {
						i -= ln ;
					}else {
						i =0 ;
					}
					pass=false;
				}else {
					j++;
					i++;
				}
			} else {
				i += toFindLen;
				j = 0;
				pass=true;
			}
		}
		return count;
	}
}
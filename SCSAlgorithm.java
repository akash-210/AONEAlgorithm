import java.util.HashMap;
/**
 *
 * @author Akash
 */
public class SCSAlgorithm   extends TextSample  {

	public static void main(String... arrays) { 
		String find="akashvismynamewhatisyournametellmeyourname";
		long start=System.currentTimeMillis();
		System.out.println(startSCS(find,readFile("largetxt.txt")));
	    System.out.println(System.currentTimeMillis() - start+" Millis");
	}
	
	private static int startSCS(String toFind, String paragraph) {
		char[] charArray = toFind.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<>();
		int y = 0;
		for (Character character : charArray) {
			charMap.put(character, y++);
		}
		int findLength = toFind.length();
		int findCharLen = toFind.length()-1;
		int paragraphLength = paragraph.length();
		boolean pass=true;
		int j = 0;
		int count = 0;
		for (int i = 0; i < paragraphLength;) {
			Integer ln = 0;
			if ( pass && (ln = charMap.get(paragraph.charAt(i))) != null || paragraph.charAt(i)==charArray[j]) {
				if (j == findCharLen) {
					count++;
					j = 0;
					i = i + findLength;
					pass=true;
				} else if (pass) {
					if(i - ln > 0 ) {
						i = i - ln ;
					}else {
						i =0 ;
					}
					pass=false;
				}else {
					j++;
					++i;
				}
			} else {
				i = i + findLength;
				j = 0;
				pass=true;
			}
		}
		return count;
	}
}
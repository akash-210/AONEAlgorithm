import java.util.HashMap;
//akash
public class SCSAlgorithm extends TextSample {

	public static void main(String... arrays) { 
		String find="dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5";
		long start=System.currentTimeMillis();
		System.out.println(findAllStringFromParagraphGEN2(find,txtsample));
		System.out.println(System.currentTimeMillis()-start+" Millis");
	}
	// it is to find for long char in fast phase if "name" is to find it will check
	// first char(0)
	// if not it will add i+name.lenth skipppping its between because

	private static int findAllStringFromParagraphGEN2(String toFind, String paragraph) {
		char[] charArray = toFind.toCharArray();
		HashMap<Character, Integer> toFindInChar = new HashMap<>();
		int y = 0;
		for (Character character : charArray) {
			toFindInChar.put(character, y++);
		}
		int findarraylength = toFind.length() - 1;
		int paragraphLength = paragraph.length();
		int found = 0;
		int j = 0;
		boolean pass=true;;
		for (int i = 0; i < paragraphLength; i++) {
			Integer lm = 0;
			if ((lm = toFindInChar.get(paragraph.charAt(i))) != null) {
				if (j == findarraylength) {
					found++;
					j = 0;
					pass=true;
				} else if (i - lm  > 0&&pass) {
					i = i - lm ;
					pass=false;
					j++;
				}else {
					j++;	
				}
			} else {
				i = i + findarraylength;
				j = 0;
				pass=true;
			}
		}
		return found;
	}
}

import java.util.HashMap;
/**
 *
 * @author Akash
 */
public class SCSAlgorithm extends TextSample {

	public static void main(String... arrays) { 
		String find="dXDQ5TgeH8liyxqwEQeDsbfY7Khe0TXhb9ZY9kHmyYYyLRLqN5";
		long start=System.currentTimeMillis();
		System.out.println(startSCS(find,txtsample));
		System.out.println(System.currentTimeMillis()-start+" Millis");
	}
	// it is to find for long char in fast phase if "name" is to find it will check
	// first char(0)
	// if not it will add i+name.lenth skipppping its between because

	private static int startSCS(String toFind, String paragraph) {
		char[] charArray = toFind.toCharArray();
		HashMap<Character, Integer> toFindInChar = new HashMap<>();
		int y = 0;
		for (Character character : charArray) {//it will override duplicate key with last duplicate key;
			//example akash => aksh
			//        01234    2134
			toFindInChar.put(character, y++);
		}
		int findarraylength = toFind.length() - 1;
		int paragraphLength = paragraph.length();
		int found = 0;
		int j = 0;
		boolean pass=true;
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

/*
 Line no:45
 If a character is not present in the map, it returns false;
 in that case, I do not set i + findarraylength+1 . 
 The logic can be setting full search string length 
 to i to skip some character without missing any element {ex: "name" length=4 }
 but  We usually set i = i + findarraylength; {ex: "name" length-1 =3 } 
 because since the for loop by default increases one value at a time, 
 we typically get length=4 which is the same length of search element .
 [ example "name" as string to search{which is search element} in paragraph "my name is akash" ].
*/

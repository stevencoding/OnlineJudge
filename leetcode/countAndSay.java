public class Solution {    public String countAndSay(int n) {

    // Start typing your Java solution below

    // DO NOT write main() function

    String result = "";

    if (n == 0) return result;

    result = "1";

    String buffer;

    while (--n != 0) {

	buffer = "";

	int len = result.length();

	for (int i = 0; i < len; i++) {

	    int count = 1;

	    while (i + 1 < len && result.charAt(i + 1) == result.charAt(i)) {

		count++;

		i++;

	    }

	    buffer += Integer.toString(count) + result.charAt(i);

	}

	result = buffer;

    }

    return result;

       

}

}


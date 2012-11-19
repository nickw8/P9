package cs1410;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CCDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {

	String[] input1 = { "aba", "a", "bc" };
	Set<String> test1 = new HashSet<String>();
	for (String e : input1)
	    test1.add(e);
	String[] input2 = { "aba", "a" };
	Set<String> results1 = new HashSet<String>();
	for (String e : input2)
	    results1.add(e);
	System.out.println(test1);
	System.out.println("Running palindrome...");
	System.out.println("Expected Results: " + results1);
	System.out.println("Results: " + palindromes(test1));
	System.out.println("Did it work: "
		+ results1.equals(palindromes(test1)));
	System.out.println();

	String[] input3 = { "xyz", "x", "y", "yz" };
	Set<String> test2 = new HashSet<String>();
	for (String e : input3)
	    test2.add(e);
	Map<String, Integer> results2 = new HashMap<String, Integer>();
	results2.put("x", 1);
	results2.put("y", 2);
	results2.put("yz", 1);
	System.out.println(test2);
	System.out.println("Running substringCount...");
	System.out.println("Results: " + substringCount(test2));
	System.out.println("Expected Results: " + results2);
	System.out.println("Did it work: "
		+ results2.equals(substringCount(test2)));
	System.out.println();

	String[] input4 = { "a", "ab", "xy", "xyz" };
	Set<String> test3 = new HashSet<String>();
	for (String e : input4)
	    test3.add(e);
	List<String> results3a = new ArrayList<String>();
	for (String e : input4)
	    results3a.add(e);
	String[] input5 = { "a", "xy", "ab", "xyz" };
	List<String> results3b = new ArrayList<String>();
	for (String e : input5)
	    results3b.add(e);
	System.out.println(test3);
	System.out.println("Running sortByLength...");
	System.out.println("Expected Results: " + results3a + " or "
		+ results3b);
	System.out.println("Results: " + sortByLength(test3));
	System.out.println("Did it work: "
		+ (results3a.equals(sortByLength(test3)) || results3b
			.equals(sortByLength(test3))));
	System.out.println();

    }

    /**
     * Returns the set containing every string from allStrings that is a
     * palindrome. For example, if allStrings is [aba, a, bc], the method should
     * return [aba, a].
     */
    public static Set<String> palindromes(Set<String> allStrings) {
	Set<String> results = new HashSet<String>();
	for (String e : allStrings) {
	    if (palindrome(e)) {
		results.add(e);
	    }
	}
	return results;
    }

    /**
     * Takes a string and returns true if it's a palindrome
     */
    private static boolean palindrome(String e) {
	return (e.equals(stringReverse(e)));
    }

    /**
     * Reverses order of characters in String s
     */
    private static String stringReverse(String s) {
	if (s.length() <= 1) {
	    return s;
	}
	return stringReverse(s.substring(1, s.length())) + s.charAt(0);
    }

    /**
     * The return value maps each string s in allStrings to the number of other
     * strings from allStrings of which s is a substring. For example, if
     * allStrings is [xyz, x, y, yz], the method should return {x=1, y=2, yz=1}.
     */
    public static Map<String, Integer> substringCount(Set<String> allStrings) {
	Map<String, Integer> results = new HashMap<String, Integer>();
	for (String e : allStrings) {
	    for (String j : allStrings) {
		if (!j.equals(e)) {
		    if (j.contains(e)) {
			if (results.containsKey(e)) {
			    int count = results.get(e) + 1;
			    results.put(e, count);
			} else {
			    results.put(e, 1);
			}

		    }
		}

	    }
	}

	return results;
    }

    /**
     * Returns a list containing the strings from allStrings, arranged in order
     * of increasing length. The relative ordering of two equal-length strings
     * does not matter. For example, if allStrings is [xyz, ab, a, xy], the
     * method should return [a, ab, xy, xyz] or [a, xy, ab, xyz].
     */
    public static List<String> sortByLength(Set<String> allStrings) {
	List<String> results = new ArrayList<String>();
	for (String e : allStrings) {
	    results.add(e);
	}
	Collections.sort(results, new ByLength());

	return results;
    }

}

class ByLength implements Comparator<String> {

    @Override
    public int compare(String x, String y) {
	if (x.length() > y.length()) {
	    return 1;
	} else if (x.length() < y.length()) {
	    return -1;
	} else {
	    return 0;
	}
    }

}

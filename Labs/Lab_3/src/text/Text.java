/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: ADT Lab
 */

package text;

public interface Text
        
{
    /**
     * @return - the length of the Text
     */

    int length();

    /**
     * @param idx - index of the character in the Text Object
     * @return - returns a character
     */

    char get(int idx);

    /**
     * @param start - start of the array
     * @param end - end of the array
     * @return - returns the array YIPPEE
     */

    Text selection(int start, int end);

    /**
     * We look for a text in another text
     * @param t search query
     * @return  returns the index of where we found it, otherwise return -1
     */

    int search(Text t);

    /**
     * @param t second string
     * @return our text and the Text t combined into one single text
     */

    Text concat(Text t);

    /**
     * Compares the letter after the last matching to see which one higher on the alphabetical order
     * @param t  the second text
     * @return either -1, 0, 1 depending on the result of the comparison
     */

    int compareTo(Text t);

    /**
     * Checks if the 2 text are the same text!!!
     * @param t the other woman
     * @return true if the 2 text are the same otherwise false
     */

    boolean equals(Text t);

    /**
     * Finds out how long the common selection and makes a new text for the common selection (I have no clue what this does)
     * @param t second string
     * @return a new instance of Text
     */

    Text common(Text t);

    /**
     * Makes our char[] data into a string
     * @return a string made by a char array
     */

    String toString();

    /**
     * @return the char[] data of Text
     */

    char[] toCharArray();
}
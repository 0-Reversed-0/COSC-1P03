/**
 * Assignment 1: Word Search
 * Course: COSC 1P03
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 */

import BasicIO.*; // needed for the ASCIIDataFile Object

public class Main   
{

    ASCIIDataFile copier = new ASCIIDataFile("wordsearch.dat"); // I used the ASCIIDataFile object from the Brock.jar package since I learned how to use it from COSC 1P02 which made reading the .dat file a lot easier
    char[][] keyword = new char[21][]; // The keyword array is just the words needed to be found in the word grid
    char[][] reversed = new char[21][]; // This is the exact same thing as the keyword array but each keyword spelled backwards. I need this, so I could avoid making 8 methods for direction and instead make 4 plus a method that searches through the word grid with the reversed char array.
    char[][] board = new char[25][25]; // This is just the 25 x 25 word grid
    char[][] output = new char[25][25]; // This is the result of each word isolated from the grid
    int found = 0; // a simple counter to find out when each word is found

    public Main()
    {                                                                // Steps I made to solve this code:
        keywords();                                                  // 1) I need to first get the 'copier' object to read needed to be found and put them into the keyword array
        reverseKeywords();                                           // 2) then just fill out the reversed array to get the spelt backwards words
        wordBoard();                                                 // 3) initialize the word grid
        initialOutput();                                             // 4) initialize output as empty spaces rather than null
        search();                                                    // 5) start with the main search where it searches for the correctly spelt words
        reverseSearch();                                             // 6) then just a second search where it searches for the backward spelt words
        System.out.println("Found: " + found + " words! YIPPEE");    // 7) show how many words are found
        printOutput();                                               // 8) print out the final resultant of every found word


        copier.close();
    }

    /**
     * This search method is put in place to go through the keywords and implement the 4 directions of the search!
     */

    void search()
    {
        for (int i = 0; i < keyword.length; i++)  //loops through each keyword and implements all direction to find the keyword
        {
            horizontalSearch(keyword[i]);
            verticalSearch(keyword[i]);
            diagonalSearch(keyword[i]);      // diagonalSearch searches through the word grid like a linear line (i.e y = x) that cut through each value
            antiDiagonalSearch(keyword[i]);  // antiDiagonalSearch searches through the word grid like a negative linear line (i.e. y = -x)
        }
    }

    /**
     * The reverse search is used to find the words that are spelled backwards using the same search methods
     */

    void reverseSearch()
    {
        for (int i = 0; i < reversed.length; i++) // loops through each spelt backwards keyword and implements all the directions
        {
            horizontalSearch(reversed[i]);
            verticalSearch(reversed[i]);
            diagonalSearch(reversed[i]);
            antiDiagonalSearch(reversed[i]);
        }
    }

    /**
     * The horizontal search method just finds each matching letter of a keyword and puts it into output on the x-axis / horizontal plane
     */

    void horizontalSearch(char[] letter) // the char[] letter param is a placeholder for keyword[i]
    {

        for (int i = 0; i < board.length; i++)
        {
            int idx = 0; // idx is the index for how many letters have been gone through

            for (int j = 0; j < board[0].length; j++)
            { // search for letter[0] then check letter[0+1] then check for letter [0+2]... then if index is completed then store in array

                if (letter[idx] == board[i][j]) // if keyword[index] is the same as the current board coordinate then continue
                {
                    if (idx < letter.length - 1) // this is just to make sure index stays in bounds
                    {
                        idx++;
                    }

                    if (idx == letter.length - 1) // if the index is completed then the word is found since the index can only increment after finding each letter
                    {
                        found++; // one word would be found now. YAY!!!
                        for (int h = 0; h < letter.length; h++) // loops through every letter of the keyword
                        {
                            output[i][(j - letter.length + 2) + h] = letter[h]; // now all it needs to do is put the keyword into the correct spot via starting from the first letter and incrementing till the last and store the keywords letter also for some reason I have to add +2 otherwise it goes 2 back from its original position
                        }
                        return; // this is to ensure that once the keyword is stored it does not continue i.e. exit when the word is found
                    }

                } else if (letter[idx] != board[i][j]) // if the keyword's letter does not match the word grid letter then reset the index
                {
                    idx = 0;
                }

            }

        }

    }
    
    /**
     * The vertical search method was made to find every character in the y-axis / vertical plane
     */

    void verticalSearch(char[] letter)
    {
        for (int i = 0; i < board.length; i++) // this method does everything the same way the horizontal search does but just puts the found words on the y-axis
        {
            int idx = 0;

            for (int j = 0; j < board[0].length; j++)
            { // search for letter[0] then check letter[0+1] then check for letter [0+2]... then if index is completed then store in array
                if (letter[idx] == board[j][i])
                {

                    if (idx < letter.length - 1)
                    {
                        idx++;
                    }

                    if (idx == letter.length - 1)
                    {
                        found++;
                        for (int h = 0; h < letter.length; h++)
                        {
                            output[(j - letter.length + 2) + h][i] = letter[h]; // j and h are incrementing in the inner for loop, so we put j and h in the row index
                        }
                        return;
                    }

                } else if (letter[idx] != board[j][i])
                {
                    idx = 0;
                }
            }
        }
    }


    /**
     * The diagonal search method searches for words along the positive diagonal (y = x)
     */

    void diagonalSearch(char[] letter)
    {
        for (int i = 0; i <= board.length - letter.length; i++) // loop through rows, ensuring space for the word
        {
            for (int j = 0; j <= board[0].length - letter.length; j++) // loop through columns, ensuring space for the word
            {
                int idx = 0; // index to track how many characters have been matched

                while (idx < letter.length && letter[idx] == board[i + idx][j + idx]) // move diagonally from (i, j) to (i+1, j+1)
                {
                    idx++; // increment index if characters match
                }

                if (idx == letter.length) // if entire word is found along the diagonal
                {
                    found++; // increase found words count
                    for (int h = 0; h < letter.length; h++) // loop to store found word in output array
                    {
                        output[i + h][j + h] = letter[h]; // takes x and y and adds an increasing variable to make it go down diagonally rather up/down or left/right and prints it directly
                    }
                    return; // exit once word is found
                }
            }
        }
    }

    /**
     * The anti-diagonal search method searches for words along the negative diagonal (y = -x)
     */

    void antiDiagonalSearch(char[] letter)
    {
        for (int i = 0; i <= board.length - letter.length; i++)
        {
            for (int j = letter.length - 1; j < board[0].length; j++)
            {
                int idx = 0;

                while (idx < letter.length && letter[idx] == board[i + idx][j - idx]) // move diagonally from (i, j) to (i+1, j-1) increment index if characters match
                {
                    idx++;
                }

                if (idx == letter.length) // if entire word is found along the anti-diagonal
                {
                    found++; // increase found words count
                    for (int h = 0; h < letter.length; h++) // loop to store found word in output array
                    {
                        output[i + h][j - h] = letter[h]; // simply prints the word directly into output file
                    }
                    return; // exit once word is found
                }
            }
        }
    }


//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    /**
     * The method wordBoard fills the 25x25 board using an ASCII Datafile object and the .toCharArray method this helps to start the search easily
     */

    void wordBoard()
    {
        for (int y = 0; y < board[0].length; y++)
        {
            String line = copier.readLine(); // reads the line
            char[] a = line.toCharArray(); // I found .toCharArray from https://www.geeksforgeeks.org/java-string-tochararray-example/ it helps me easily convert from string to char via making a string object into a char array

            for (int x = 0; x < board.length; x++)
            {
                board[y][x] = a[x]; //simply adds each letter from the string of random chars to the word grid array
            }
        }
    }

    /**
     * The keywords method is used to read the keyword of the data file and convert the strings into upper case letter
     */

    void keywords()
    {
        for (int i = 0; i < keyword.length; i++)
        {
            String word = copier.readString().toUpperCase(); // I found .toUpperCase from https://www.tutorialspoint.com/java/lang/character_touppercase.htm this essentially reads the string then immediately turns the string to all caps.

            keyword[i] = word.toCharArray(); // converts the all upper case string into a char array
        }
    }

    /**
     * I made this method just to fill the reversed variable so that I could search for the words spelled backwards later on
     */

    void reverseKeywords()
    {
        for (int i = 0; i < keyword.length; i++) // goes through every already capitalized keyword (makes it easier since now I just need to capitalize one keyword array)
        {
            int L = keyword[i].length;
            reversed[i] = new char[L]; // gives the row the same length as the keyword array and adds it to the ragged array row

            for (int j = 0; j < L; j++)
            {
                reversed[i][j] = keyword[i][L - j - 1]; // essentially takes the last letter via keyword.length then slow goes down till the last letter from J decreasing
            }
        }
    }


    /**
     * I have this method because I want to see the empty space as just a space and not null or whatever else
     */

    void initialOutput()
    {
        for (int i = 0; i < output.length; i++)
            for (int j = 0; j < output.length; j++) // didn't really need to use output[0] since well it's a square
                output[i][j] = ' '; //makes every space in the array an empty space

    }

    /**
     * Simply just prints the output in the terminal
     */

    void printOutput()
    {
        for (int i = 0; i < output.length; i++)
        {
            for (int j = 0; j < output.length; j++) // didn't really need to use output[0] since well again it's a square
            {
                System.out.print(output[i][j] + " "); // just prints out each row while keeping it evenly spaced to make it easy to read
            }
            System.out.println(); // prints the next row on the next line
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }

}
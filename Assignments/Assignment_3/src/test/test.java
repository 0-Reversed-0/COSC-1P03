package test;

import String.*;

/**
 * Author: Arhum Ahmed Khan.
 * Student ID: 8074114.
 * Course: COSC 1P03.
 * Title: DIY String Object.
 */

public class test
{

    private static char[] shortT = {'H', 'i', '!'};
    private static char[] longG = {' ', 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
    private static char[] emptyY = {};
    private static myStringT shortString = new myStringT(shortT); // Tester string 1 for short arrays
    private static myStringT longString = new myStringT(longG); // Tester string 2 for longer arrays
    private static myStringT emptyString = new myStringT(emptyY); // Tester string 3 for empty arrays
    private static StringTIterator iterator = new StringTIterator(longString); // sole use is for testing the iterator

    /*
    I approached Testing via testing about 3 cases:
    Test 1: Does the method do what we want it to do?
    Test 2: Does the method work with empty strings or not?
    Test 3: Does the method handle exceptions correctly?

    I used these cases for almost every single method in myStringT
    IMPORTANT NOTE: most the code is copy and paste for formatting reasons. The actual test code is in between the test question string and sout(); Hope this makes marking easier!
     */

    // I am so sorry for the 500 lines of codes you have to read through I tried to keep the important stuff in obvious places :(

    public test() // comment out/in whichever one(s) you want to test! Or go crazy and test them all at once?!?!
    {
        concatTest();
        beforeTest();
        afterTest();
        lengthTest();
        cloneTest();
        chatAtTest();
        toArrayTest();
        substringTest();
        countLettersTest();
        reverseTest();
        printTest();
        iteratorTest();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Here I test the limits of concat where I test if it can first combine strings like I want it to do,
     * then I test whether it can combine an empty array with a filled out one,
     * finally I test if it can combine 2 empty arrays together.
     * In my testings I found that the .toArray method did not function how it was supposed since I put stringGiven[i] = copy[i]; instead of the opposite
     * I also found that my array index previously went from stringGiven to (total - secondString) which would leave out a few letters, so I replaced it with (total - stringGiven)
     */

    private static void concatTest()
    {
        System.out.println("ConCat Method Testings: ");
        System.out.println();

        System.out.println("Test 1: Both Strings are non-empty: ");
        System.out.println();

        char[] tester1 = shortString.ConCat(longString).ToArray(); // since ConCat returns an object then it would be a good idea to convert it to char array before printing it

        System.out.println(tester1);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: Does it work if one is empty?: ");
        System.out.println();

        char[] tester2 = shortString.ConCat(emptyString).ToArray();

        System.out.println(tester2);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 3: If both are empty?: ");
        System.out.println();

        char[] tester3 = emptyString.ConCat(emptyString).ToArray();

        System.out.print(tester3);
        System.out.println("Works.");
        System.out.println();

    }

    /**
     * In this method I first test it functionality and making sure it works the way it should work,
     * afterward I check if empty arrays would work with this method,
     * lastly I just check for how it would respond to index out of bounds. (check if exception works)
     * No fixes were made after tests were conducted.
     */

    private static void beforeTest()
    {
        System.out.println("Before Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does it work like its supposed to?:");
        System.out.println();

        char[] tester1 = longString.Before(4).ToArray(); // IMPORTANT NOTE: Please remember that my char array for 'longString' STARTS WITH AN EMPTY SPACE MY CODE WORKS!!!!!!
        //since this is inclusive and the end index is 4 it should print out ' ', 'H', 'E', 'L', 'L' (this was a coincidence... or was it???)

        System.out.println(tester1);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it work on an empty string?: ");
        System.out.println();

        try
        {
            char[] tester2 = emptyString.Before(0).ToArray();
            System.out.println("Somehow does work???");
        } catch (StringTException exception)
        {
            System.out.println("It does not work with empty strings :(");
            System.out.println("But honestly what did you expect; there is literally nothing to index. ");
        }

        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// im a test comment
        System.out.println("Test 3: does the exception work when index is out of bounds?: ");
        System.out.println();

        try
        {
            char[] tester3 = emptyString.Before(1000).ToArray();
            System.out.println("if it does not catch any error then my method has some serious issues.");
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
        }

        System.out.println();
    }

    /**
     * This method is the same as the before method tester, but instead it excludes the index's position in the final resultant.
     * I first test if it works,
     * then I check for how it reacts with an empty string,
     * finally I check if my exception works.
     * No fixes made.
     */

    private static void afterTest()
    {
        System.out.println("After Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does the method worky or no worky?: ");
        System.out.println();

        char[] tester1 = longString.After(7).ToArray(); // 7th index i ' ' and since this is an exclusive function it would just print World

        System.out.println(tester1);
        System.out.println("It worky.");
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does an empty string make this method angry or not?: ");
        System.out.println();

        try
        {
            char[] tester2 = emptyString.After(0).ToArray();
        } catch (StringTException exception)
        {
            System.out.println("After method obviously does not work with an empty class since no index available.");
        }

        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 3: does my exception work????: ");
        System.out.println();

        try
        {
            char[] tester3 = emptyString.After(1000).ToArray();
            System.out.println("If this message appears my method is messed up.");
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
            System.out.println("My exception works");
        }

        System.out.println();
    }

    /**
     * Here I just try to test if it works for both case.
     * First I try to test if it returns the length or not,
     * then I just check if it works for empty arrays.
     * No fixes made, obviously.
     */

    private static void lengthTest()
    {
        System.out.println("Length Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does it return the length of the string?: ");
        System.out.println();

        int tester1 = shortString.Length();
        int tester2 = longString.Length();

        System.out.println(tester1);
        System.out.println(tester2);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it work with empty strings?: ");
        System.out.println();

        try
        {
            int tester3 = emptyString.Length();
            System.out.println(tester3);
        } catch (StringTException exception)
        {
            System.out.println("It cannot work with empty strings.");
        }

        System.out.println();
    }

    /**
     * Here I test clone in 3 ways.
     * First I make sure there's no exceptions from the method whatsoever,
     * then I check if the method works as intended for a full and empty string/array.
     * No fixes made.
     */

    private static void cloneTest()
    {
        System.out.println("Clone Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does the method give any exception straight off the bat?: ");
        System.out.println();

        try
        {
            longString.Clone();
            emptyString.Clone(); //also just going to test if it works with an empty array

            System.out.println("No errors found.");
        } catch (StringTException exception)
        {
            System.out.println("Cloning don't work.");
        }

        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it function as intended?: ");
        System.out.println();

        StringT tester1 = shortString.Clone();

        char[] tester2 = tester1.ToArray();

        System.out.println(tester2);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 3: does it work for empty strings as intended?: ");
        System.out.println();

        try
        {
            StringT tester3 = emptyString.Clone();
            char[] tester4 = tester3.ToArray();
            System.out.print(tester4);
            System.out.println("WORKSS!!!!!");
        } catch (StringTException exception)
        {
            System.out.println("Cannot work with empty strings due to: " + exception.getMessage());
        }

        System.out.println();
    }

    /**
     * Here I test if it works normally with no special case in place,
     * then I check if it works for empty strings,
     * finally, I check for invalid indexes.
     * No fixes made.
     */

    private static void chatAtTest()
    {
        System.out.println("Test 1: does it work for a normal case?(i.e. no empty/invalid index): ");
        System.out.println();

        char tester1 = longString.CharAt(4); // it should print out l

        System.out.println(tester1);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it work for empty strings?");
        System.out.println();

        try
        {
            char tester2 = emptyString.CharAt(0);
            System.out.print(tester2);
            System.out.println("Works for empty strings.");
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
            System.out.println("Cannot work for empty strings because no index to begin with.");
        }

        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 3: does my exception work with a outrageous index given?: ");
        System.out.println();

        try
        {
            char tester3 = shortString.CharAt(100000);
            System.out.println(tester3);
            System.out.println("Did not pick up the exception somehow???");
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
            System.out.println("Obviously if you put a crazy index for my small string it wouldn't be a valid index.");
        }

        System.out.println();
    }

    /**
     * Here I test if it works and if it works for empty strings because honestly doesn't have any other cases
     * No fixes added
     */

    private static void toArrayTest()
    {
        System.out.println("ToArray Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does it work as intended?");
        System.out.println();

        char[] tester1 = longString.ToArray();

        System.out.println(tester1);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it work with empty strings?");
        System.out.println();

        char[] tester2 = emptyString.ToArray();

        try
        {
            System.out.print(tester2);
            System.out.println("Works.");
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
        }

        System.out.println();
    }

    /**
     * Here I test all the cases that SubString may face.
     * I first tested for if it worked or not because you never know,
     * then I checked if it can work for empty strings,
     * lastly I see how it handles wildly off indexes.
     * Fixes I added: Fixed the indexing issue with SubString where it would be out of bounds for Test 1 (I accidentally did k <= j rather than just k < j).
     */

    private static void substringTest()
    {
        System.out.println("SubString Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does it worky?");
        System.out.println();

        StringT tester1 = longString.SubString(1, 12); //here I wanted to get rid of the space, so I did so :)
        System.out.println(tester1.ToArray()); // yes I only now just remembered that I do not need to make whole new char array then print it
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it work with empty strings?: ");
        System.out.println();

        try
        {
            StringT tester2 = emptyString.SubString(0, 0);
            System.out.println(tester2.ToArray());
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
            System.out.println("It does not work for empty strings since they have no indexes");
        }

        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 3: how does it react to invalid indexes? (praying my propositional logic works out): ");
        System.out.println();

        try
        {
            StringT tester3 = shortString.SubString(200, 50); // this fails 2 of 4 conditions that being i cannot be greater than and/or equal to j and j cannot be greater than the strings length
            System.out.println(tester3.ToArray());
        } catch (StringTException exception)
        {
            System.out.println(exception.getMessage());
        }

        System.out.println();
    }

    /**
     * This is my custom method that I added.
     * Here I only test if it can count the letters no spaces,
     * then I test if it works on empty strings.
     * No fixes made.
     */

    private static void countLettersTest()
    {
        System.out.println("CountLetters Method Testings: ");
        System.out.println();

        System.out.println("Test 1: does it work as intended?: ");
        System.out.println();

        System.out.println(longString.CountLetters()); // THIS SHOULD OUTPUT 10 since it ONLY counts every letter not including spaces
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does it work for empty strings");
        System.out.println();

        try
        {
            System.out.println(emptyString.CountLetters()); // expected output to be 0 if it does not give an exception
            System.out.println("Works on empty strings!?!?");
        } catch (StringTException exception)
        {
            System.out.println("Does not work for empty strings");
        }

        System.out.println();
    }

    /**
     * Here I test another of my customised methods that prints the string out backwards.
     * First I will see if it works as intended,
     * then check if works on empty strings.
     * No fixes added.
     */

    private static void reverseTest()
    {
        System.out.println("Reverse Method Testings: ");
        System.out.println();

        System.out.println("Test 1: worky or no worky?");
        System.out.println();

        StringT tester1 = longString.Reverse();
        System.out.println(tester1.ToArray()); // Works perfectly good job me :)
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does an empty string work for it?");

        StringT tester2 = emptyString.Reverse();
        System.out.println(tester2.ToArray());
        System.out.println("worky.");

        System.out.println();
    }

    /**
     * I added a Print method for obvious reasons since it is the main use of the Strings to begin with and the first thing we do with strings for 99.999% of java coders.
     * I will have one test to check if it does what it needs to do.
     * No fixes made.
     */

    private static void printTest()
    {
        System.out.println("Print Method Testings:");
        System.out.println();

        System.out.println("Test: Does the print method work or nah?");
        System.out.println();

        shortString.Print(); // should just print Hi! and no I am not testing for empty strings since if it works for this, then it works for all cases (unless the null char array got pass the constructor somehow).

        System.out.println();
        System.out.println();
    }

    /**
     * Here I finally test the iterator and see if its hasNext and next function works for both the traditional while loop and for a for each loop!
     * Fixes made: I fixed the hasNext method in the iterator to have the condition idx >= input.length() since it was hitting out of bounds exceptions for that reason.
     */

    private static void iteratorTest()
    {
        System.out.println("Iterator Testings:");
        System.out.println();

        System.out.println("Test 1: does the hasNext and next function work for while loops?: ");
        System.out.println();


        while (iterator.hasNext())
        {
            System.out.print(iterator.next());
        }

        System.out.println();
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Test 2: does the same work when we talk about for each loops?: ");
        System.out.println();

        char[] tester = longString.ToArray();
        int idx = 0;

        for(char test : tester)
        {
            System.out.print(test);
        }

        System.out.println();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args)
    {
        new test();
    }
}

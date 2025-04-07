package Part_1;
import BasicIO.*;
import Media.*;
import static java.lang.Math.*;

/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: SNOWWWW!!!! - Assignment 5
 */

///  I did as the instructions told me to do and made a snowflake by messing with the already given code from Week 8!

public class Snowflake {


    private BasicForm  display;  // to display turtle
    private Turtle     yertle;   // the turtle


    /**
     * The constructor uses the koch method to draw the snowflake as a triangle
     * with each side being a Koch curve of order 3.
     */

    public Snowflake ( ) {

        yertle = new Turtle(0);
        display = new BasicForm();
        buildForm();
        display.show();
        yertle.penDown();


        for ( int i=1 ; i<=6 ; i++ ) {
            koch(3,100);
            yertle.right(2*Math.PI/3);
        }

        yertle.penUp();
        display.accept();
        display.close();

    }; // draw


    /**
     * This method draws a Koch curve of specified order and length.
     */

    private void koch ( int order, double len ) {

        if ( order == 0 ) {
            yertle.forward(len);
        }
        else {
            koch(order-1,len/3);
            yertle.left(PI/7); // messed with this angle
            koch(order-1,len/3);
            yertle.right(2*PI/4); //with this one
            koch(order-1,len/3);
            yertle.left(PI/2); // and this one
            koch(order-1,len/3);
        };

    }; // koch

    /**
     * This method builds the form for the display.
     */

    private void buildForm ( ) {

        display.addCanvas("draw",200,200,10,10);
        display.placeTurtle("draw",yertle);

    };  // buildForm


    public static void main ( String[] args ) { Snowflake s = new Snowflake(); };


}
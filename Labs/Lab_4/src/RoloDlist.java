


/**
 * @(#)RoloDlist.java
 * @author
 * @version 1.00 2010/2/24
 */

import BasicIO.*;

public class RoloDlist implements Rolodex
{

    protected node theList, tail;
    protected node current;


    public RoloDlist()
    {
        Contact aContact;
        node ptr;
        aContact = new Contact("dummy", "zzzzzzzzzzzzzzzzz", "dummy", "dummy");
        theList = new node(null, aContact, null);
        aContact = new Contact("dummy", "A", "dummy", "dummy");
        ptr = new node(null, aContact, theList);
        theList.prev = ptr;
        theList = ptr;
        tail = theList.next;
        current = null;
    }

    public void Add(Contact c)
    {//Adds contact to the structure
        node ptr, qtr;
        ptr = theList;

        //System.out.println(c.last + " " + ptr.c.getLast());

        while (c.last.compareToIgnoreCase(ptr.c.getLast()) > 0)
        {
            ptr = ptr.next;
        }
        //System.out.println(c.last + " " + ptr.c.getLast());
        qtr = new node(ptr.prev, c, ptr);
        qtr.prev.next = qtr;
        ptr.prev = qtr;
        current = qtr;
    }


    public void Remove()
    {    //Removes contact from the structure

    }

    public Contact Up()
    {//Returns the next contact in the structure
        if (current.next == tail)
        {
            current = theList.next;
        } else
        {
            current = current.next;
        }
        return current.c; //dummy code Remove when implementing
    }

    public Contact Down()
    {//Returns the previous contact in the structure

        if (current.prev == theList)
        {
            current = tail;
        } else
        {
            current = current.prev;
        }


        return current.c; //dummy code Remove when implementing
    }

    public void List(ASCIIDisplayer out)
    {  //Lists the entire rolodex to the ascii

        node temp = theList.next;
        while (temp.next != null)
        {
            out.writeLine(temp.c.getFirst() + " " + temp.c.getLast() + " " + temp.c.getAddress() + " " + temp.c.getPhoneNum());
            temp = temp.next;
        }


    }


    public Contact GetCurrent()
    {
        return current.c;
    }


    public Contact Find(String name)
    { //find a char string which matches the last name


        

        return new Contact();    //dummy code Remove when inplementing
    }  //Finds the contact name in the structure and returns
    //that contact.
}
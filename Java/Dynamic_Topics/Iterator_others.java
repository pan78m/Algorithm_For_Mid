package Dynamic_Topics;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.ListIterator;

public class Iterator_others {
   
    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<String>();

        //Add Element in the list
        al.add("A");
        al.add("C");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
         //Normally print all the element of array list
         System.out.println(al+" "); 
 
        //use iterator display this content
        System.out.println("Orginal content of a1: ");
       
        Iterator<String> itr=al.iterator();
        while (itr.hasNext()) {
            String element=itr.next();
            System.out.print(element+" ");
        }
        System.out.println();

        //modifying objects being iterated
        ListIterator<String> litr=al.listIterator();
        while (litr.hasNext()) {
            String element=litr.next();
            litr.set(element+" +");
        }
        System.out.println("Modify content of al: ");
         itr=al.iterator();
        while (itr.hasNext()) {
            String element=itr.next();
         System.out.print(element+" ");
        }
        System.out.println();
        // display backward list
        while (litr.hasPrevious()) {
            String element=litr.previous();
            System.out.print(element+" ");
        }
        System.out.println();
    }
}

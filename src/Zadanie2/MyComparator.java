package Zadanie2;

import java.util.Comparator;

/**
 *
 * @author Kamil Zemczak
 */
public class MyComparator implements Comparator<Osoba>{

    @Override
    public int compare(Osoba p1, Osoba p2) {
        return (p1.getNazwisko()+p1.getImie()).compareToIgnoreCase((p2.getNazwisko()+p2.getImie()));
    }
    
}
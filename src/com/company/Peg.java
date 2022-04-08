package com.company;

import java.util.Arrays;

public class Peg {
    private int pegNum;
    private int numDiscs;  // The total number of discs in the current game.
    private int[] discs;   // array of discs - bottom disc is in position 0
    // the discs are integers which represent their size
    private int count;     // the number of discs currently on the peg.

    public Peg(int peg, int num) {
        pegNum = peg;
        numDiscs = num;
        discs = new int[num];
        count = 0;
    }

    public int getPegNum() {
        return pegNum;
    }

    public String toString() {
        String s = "Peg " + pegNum;
        return s;
    }

    public boolean addDisc(int whichOne) {
        if (count == 0 || discs[count - 1] > whichOne) {
            discs[count] = whichOne;
            count += 1;
            return true;
        }

        System.out.println("False");
        return false;
    }

    public int popDisc() {
        count -= 1;
        int a = discs[count];
        discs[count] = 0;
        return a;
    }

    public boolean moveTopDisc(Peg newPeg)
    {
        int disc = popDisc();
        if (newPeg.addDisc(disc))
        {
            System.out.println("Moving disc " + disc + " from peg " + pegNum + " to peg " + newPeg.getPegNum());
            return true;
        }
        else{
            System.out.println("Bad Move");
            return false;
        }
    }
    public static void main(String [] arg) {
        Peg p1 = new Peg(1,5);
        p1.addDisc(3);
        System.out.println(Arrays.toString(p1.discs));
        p1.addDisc(2);
        System.out.println(Arrays.toString(p1.discs));
        p1.addDisc(4);
        System.out.println(Arrays.toString(p1.discs));
        p1.popDisc();
        System.out.println(Arrays.toString(p1.discs));
    }


}
/**
 [3, 0, 0, 0, 0]
 [3, 2, 0, 0, 0]
 Can't do that
 [3, 2, 0, 0, 0]
 [3, 0, 0, 0, 0]
 **/

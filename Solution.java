import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface OnlineAccount {
    int basePrice = 120;
    int regularMoviePrice = 45;
    int exclusiveMoviePrice = 80;
}

class Account implements OnlineAccount {
    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;

    public Account(String owner, int regMovies, int exclMovies) {
        this.ownerName = owner;
        this.noOfRegularMovies = regMovies;
        this.noOfExclusiveMovies = exclMovies;
    }

    public int monthlyCost() {
        return basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice;
    }

    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + this.monthlyCost() + " USD.";
    }
}

class Sortbymontlycost implements Comparator<Account> {
    // Used for sorting in ascending order of
    // montly cost
    public int compare(Account a, Account b) {
        return a.monthlyCost() - b.monthlyCost();
    }
}

public class Solution {
    public static void main(String[] args) {

        // System.out.println("prova");

        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();
        int t = Integer.parseInt(sub);
        ArrayList<Account> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String[] input = sc.nextLine().split(" ");
            list.add(new Account(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
            // System.out.println("i = " + i);
        }
        Collections.sort(list, new Sortbymontlycost());
        System.out.println("Most valuable account details:");
        System.out.println(list.get(list.size() - 1));
        // System.out.println(list);
        // System.out.println(list.get(0));
    }
}
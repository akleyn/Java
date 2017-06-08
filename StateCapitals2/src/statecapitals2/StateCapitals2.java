/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author softwareguild
 */
public class StateCapitals2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter minimum population size for the cities: ");
        int size = userInput.nextInt();

        Map<String, Capital> map = new HashMap<>();

        Capital c1 = new Capital("Alabama", "Montgomery", 205764, 155.4);
        Capital c2 = new Capital("Alaska", "Juneau", 31275, 2716.7);
        Capital c3 = new Capital("Arizona", "Phoenix", 1445632, 474.9);
        Capital c4 = new Capital("Arkansas", "Little Rock", 193524, 116.2);
        Capital c5 = new Capital("California", "Sacramento", 466488, 97.2);
        Capital c6 = new Capital("Colorado", "Denver", 600158, 153.4);
        Capital c7 = new Capital("Connecticut", "Hartford", 124775, 17.3);
        Capital c8 = new Capital("Delaware", "Dover", 36047, 22.4);
        Capital c9 = new Capital("Florida", "Tallahasee", 181412, 95.7);
        Capital c10 = new Capital("Georgia", "Atlanta", 420003, 131.7);
        Capital c11 = new Capital("Hawaii", "Honolulu", 337256, 85.7);
        Capital c12 = new Capital("Idaho", "Boise", 205671, 63.8);
        Capital c13 = new Capital("Illinois", "Springfield", 116250, 54.0);
        Capital c14 = new Capital("Indiana", "Indianapolis", 829718, 361.5);
        Capital c15 = new Capital("Iowa", "Des Moines", 203433, 75.8);
        Capital c16 = new Capital("Kansas", "Topeka", 127473, 56.0);
        Capital c17 = new Capital("Kentucky", "Frankfort", 25527, 14.7);
        Capital c18 = new Capital("Louisiana", "Baton Rouge", 229553, 76.8);
        Capital c19 = new Capital("Maine", "Augusta", 19136, 55.4);
        Capital c20 = new Capital("Maryland", "Annapolis", 38394, 6.73);
        Capital c21 = new Capital("Massachusetts", "Boston", 617594, 48.4);
        Capital c22 = new Capital("Michigan", "Lansing", 114297, 35.0);
        Capital c23 = new Capital("Minnesota", "St. Paul", 285068, 52.8);
        Capital c24 = new Capital("Mississippi", "Jackson", 173514, 104.9);
        Capital c25 = new Capital("Missouri", "Jefferson City", 43079, 27.3);
        Capital c26 = new Capital("Montana", "Helena", 28190, 14.0);
        Capital c27 = new Capital("Nebraska", "Lincoln", 258379, 74.6);
        Capital c28 = new Capital("Nevada", "Carson City", 55274, 143.4);
        Capital c29 = new Capital("New Hampshire", "Concord", 42695, 64.3);
        Capital c30 = new Capital("New Jersey", "Trenton", 84913, 7.66);
        Capital c31 = new Capital("New Mexico", "Santa Fe", 75764, 37.3);
        Capital c32 = new Capital("New York", "Albany", 97856, 21.4);
        Capital c33 = new Capital("North Carolina", "Raleigh", 403892, 114.6);
        Capital c34 = new Capital("North Dakota", "Bismarck", 61272, 26.9);
        Capital c35 = new Capital("Ohio", "Columbus", 822553, 210.3);
        Capital c36 = new Capital("Oklahoma", "Oklahoma City", 580000, 607.0);
        Capital c37 = new Capital("Oregon", "Salem", 154637, 45.7);
        Capital c38 = new Capital("Pennsylvania", "Harrisburg", 49528, 8.11);
        Capital c39 = new Capital("Rhode Island", "Providence", 178042, 18.5);
        Capital c40 = new Capital("South Carolina", "Columbia", 131686, 125.2);
        Capital c41 = new Capital("South Dakota", "Pierre", 13646, 13.0);
        Capital c42 = new Capital("Tennessee", "Nashville", 635710, 473.3);
        Capital c43 = new Capital("Texas", "Austin", 790390, 251.5);
        Capital c44 = new Capital("Utah", "Salt Lake City", 186440, 109.1);
        Capital c45 = new Capital("Vermont", "Montpelier", 7855, 10.2);
        Capital c46 = new Capital("Virginia", "Richmond", 204214, 60.1);
        Capital c47 = new Capital("Washington", "Olympia", 46478, 16.7);
        Capital c48 = new Capital("West Virginia", "Charleston", 51400, 31.6);
        Capital c49 = new Capital("Wisconsin", "Madison", 233209, 68.7);
        Capital c50 = new Capital("Wyoming", "Cheyenne", 59466, 21.1);

        map.put(c1.getKey(), c1);
        map.put(c2.getKey(), c2);
        map.put(c3.getKey(), c3);
        map.put(c4.getKey(), c4);
        map.put(c5.getKey(), c5);
        map.put(c6.getKey(), c6);
        map.put(c7.getKey(), c7);
        map.put(c8.getKey(), c8);
        map.put(c9.getKey(), c9);
        map.put(c10.getKey(), c10);
        map.put(c11.getKey(), c11);
        map.put(c12.getKey(), c12);
        map.put(c13.getKey(), c13);
        map.put(c14.getKey(), c14);
        map.put(c15.getKey(), c15);
        map.put(c16.getKey(), c16);
        map.put(c17.getKey(), c17);
        map.put(c18.getKey(), c18);
        map.put(c19.getKey(), c19);
        map.put(c20.getKey(), c20);
        map.put(c21.getKey(), c21);
        map.put(c22.getKey(), c22);
        map.put(c23.getKey(), c23);
        map.put(c24.getKey(), c24);
        map.put(c25.getKey(), c25);
        map.put(c26.getKey(), c26);
        map.put(c27.getKey(), c27);
        map.put(c28.getKey(), c28);
        map.put(c29.getKey(), c29);
        map.put(c30.getKey(), c30);
        map.put(c31.getKey(), c31);
        map.put(c32.getKey(), c32);
        map.put(c33.getKey(), c33);
        map.put(c34.getKey(), c34);
        map.put(c35.getKey(), c35);
        map.put(c36.getKey(), c36);
        map.put(c37.getKey(), c37);
        map.put(c38.getKey(), c38);
        map.put(c39.getKey(), c39);
        map.put(c40.getKey(), c40);
        map.put(c41.getKey(), c41);
        map.put(c42.getKey(), c42);
        map.put(c43.getKey(), c43);
        map.put(c44.getKey(), c44);
        map.put(c45.getKey(), c45);
        map.put(c46.getKey(), c46);
        map.put(c47.getKey(), c47);
        map.put(c48.getKey(), c48);
        map.put(c49.getKey(), c49);
        map.put(c50.getKey(), c50);

        Set<String> keySet = map.keySet();

        System.out.println("STATES");
        System.out.println("=====");
        for (String currentKey : keySet) {

            System.out.println(currentKey);
        }

        System.out.println();
        System.out.println("CAPITALS");
        System.out.println("=====");
        for (String currentKey : keySet) {
            Capital capital = map.get(currentKey);

            System.out.println(capital.getCapital());
        }
        System.out.println();
        System.out.println("STATE/CAPITAL PAIRS");
        System.out.println("=====");
        for (String currentKey : keySet) {
            Capital capital = map.get(currentKey);
            System.out.println("The capital of " + currentKey + " is " + capital.getCapital() + " with population of " + capital.getPopulation() + " and size of " + capital.getMiles() + " square miles.");

        }
        System.out.println();
        System.out.println("Cities with populations over " + size + ": ");
        System.out.println("=====");
        for (String currentKey : keySet){
            Capital capital = map.get(currentKey);
            
            if(capital.getPopulation() >= size){
                System.out.println("The capital of " + currentKey + " is " + capital.getCapital() + " with population of " + capital.getPopulation() + " and size of " + capital.getMiles() + " square miles.");
            }
        }

    }
}

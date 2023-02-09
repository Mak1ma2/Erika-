/* 
 * spell-checker class because I'm a simp :/ 
 * 
 * key notes 
 * - only one private variable a hashset named w
 * - only one method "check" with parameter one string to compare it to 
 *      - if 
 */

import java.util.HashSet; 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays; 

public class spell_checker{ 

    private static HashSet<String> W = new HashSet<>(); 

    /* 
     * if W contains s then return a list containing only s 
     * 
     * if W doesn't contain s then return a list that gets close to s 
     *  - swapping adjacent characters 
     *  - inserting a single character in between two adjacent characters in a word 
     *  - deleting a single character from a word 
     *  - replacing a character in a word with another character 
     * 
     * maximum amount of characters a string can have is n + 1 (inserting between 2 adjacent char)
     * minimum amount of characters a string can have is n - 1 (delete or replace <-- possibly both(?)) 
     * 
     * we essentially need a minimum of n - 1 
     * 
     * if a word has a length of 7 then n - 2 is reasonable, anything less than that the word doesn't look good enough 
     *  
     * reminder that hermans hate continue and break :// 
     */
    private static String[] check(String s){
        s = s.toLowerCase(); 
        String[]result; 
        ArrayList<String> temp = new ArrayList<>(); 
        ArrayList<Character> s_char = new ArrayList<>(); 
        ArrayList<Character> b_char = new ArrayList<>(); 
        char[] s_char_temp = s.toCharArray(); 
        int n = s.length();  
        for(char c : s_char_temp){ 
            s_char.add(c); 
        }
        if(W.contains(s)){ 
            for(String a: W){ 
                a.toLowerCase(); 
                if(a.equals(s)){ 
                    temp.add(a); 
                }
            }
            result = temp.toArray(new String[0]); 
            return result; 
        }
        for(String b : W){ 
            b = b.toLowerCase(); 
            char[] b_char_temp = b.toCharArray();
            for(char d : b_char_temp){ 
                b_char.add(d); 
            }
            System.out.println("size: " + b_char.size()); 
            int count = 0; 
            for(char e : s_char){ 
                if(b_char.contains(e)){ 
                    count++; 
                }
            }
            System.out.println(count); 
            if(b.length() < 7 && (count >= n-1 && count <= n + 1)){ 
                temp.add(b); 
            }
            else if(b.length() >= 7 && (count >= n - 2 && count <= n + 1)){ 
                temp.add(b); 
            } 
            b_char.clear(); 
        }
        result = temp.toArray(new String[0]); 
        return result; 
    }
    public static void main(String[]args){  
        W.add("subtract"); 
        W.add("Subtrac"); 
        W.add("poop"); 
        System.out.println(W.toString()); 
        System.out.println(Arrays.toString(check("subtract"))); 
        W.remove("subtract"); 
        W.remove("Subtrac"); 
        W.remove("poop"); 
        W.add("subtrac"); 
        W.add("subbtract"); 
        W.add("sabtrac"); 
        System.out.println(W.toString()); 
        System.out.println(Arrays.toString(check("subtract"))); 
        W.remove("subtrac"); 
        W.remove("subbtract"); 
        W.remove("sabtrac"); 
        W.add("doo"); 
        W.add("doord"); 
        W.add("doom"); 
        W.add("do"); 
        System.out.println(Arrays.toString(check("door"))); 
    }
}
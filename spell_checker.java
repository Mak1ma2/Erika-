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

public class spell_checker{ 

    private static Hashset<String> W = new HashSet<>(); 

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
        ArrayLiSt<Character> s_char = new ArrayList<>(); 
        ArrayList<Character> b_char = new ArrayList<>(); 
        Char[] s_char_temp = s.toCharArray(); 
        Set_toLowerCase(); 
        for(char c : s_char_temp){ 
            s_char.add(a); 
        }
        if(W.contains(s)){ 
            for(String a: W){ 
                a.toLowerCase(); 
                if(a.equals(s)){ 
                    temp.add(a); 
                }
            }
            result = temp.toArray(); 
            return result; 
        }
        for(String b : W){ 
            b = b.toLowerCase(); 
            Char[] b_char_temp = b.toCharArray();
            for(char d : b_char_temp){ 
                b_char.add(d); 
            }
            int count = 0; 
            for(char e : b_char){ 
                if(b_char.contains(e)){ 
                    count++; 
                }
            }
            if(b.length < 7 && (count >= n-1 && count <= n + 1)){ 
                temp.add(b); 
            }
            else if(b.length >= 7 && (count >= n - 2 && coutn <= n + 1)){ 
                temp.add(b); 
            }
        }
        result = temp.toArray(); 
        return result; 
    }

    private static void Set_toLowerCase(){ 
        for(String a: W){ 
            W.remove(a); 
            a = a.toLowerCase(); 
            W.add(a); 
        }
    }
    public static void main(String[]args){  
        W.add("Subtract"); 
        /*
        W.add("Subtrac"); 
        W.add("poop"); 
        System.out.println(check("subtract")); 
        W.remove("Subtract"); 
        W.remove("Subtrac"); 
        W.remove("poop"); 
        W.add("Subtrac"); 
        W.add("Subbtract"); 
        W.add("Sabtrac"); 
        System.out.println(check("subtract")); 
        W.remove("Subtrac"); 
        W.remove("Subbtract"); 
        W.remove("Sabtrac"); 
        W.add("doo"); 
        W.add("doord"); 
        W.add("doom"); 
        W.add("do"); 
        System.out.println(check("door")); 
        */
    }
}
/* 
 * 69-70 because I'm a simp 2.0 and I'm apparently getting paid more to help college students than high school seniors ERIKA I WANT FREE GONG CHA ON SAT :// 
 * 
 * basically we're creating a polynomial hash code algorithm for strings calling them parameters a and see how many times they collide with each other 
 * 
 * create a text file at the end to test these hash codes on the internet :/ 
 */

import java.util.HashMap; 

public class compare{
    
    /* 
     * basic algorithm is H(s1, s2, ..., s3) = s1p^k-1 + s2p^k-2 + ... + skp^0 where sn represents the number  mod M 
     * 
     * capital letters are in range of 65 - 90 inclusive 
     * lowercase letters are in range of 97 - 122 inclusive 
     */
    static int hashcode(String a, int m){ 
        int code = 0;
        char[] arr = a.toCharArray(); 
        for(int i = 0, j = arr.length - 1; i < arr.length; i++){ 
            int s = (int)arr[i];
            if(s > 64 && s < 91){ 
                s -= 64; 
            }  
            else if(s > 96 && s < 123){ 
                s -= 96; 
            }
            else{ 
                System.out.println("that is not an ascii value..."); 
            }
            code += ((int)arr[i] * Math.pow(26, j - 1)) % m; 
            j--;  
        }
        return code; 
    }

    /* 
     * treat this similarly to a machine learning because we're basically doing a mini version of machine learning :D 
     * 1. gather data 
     * 2. test the data 
     * 3. compare the data for accuracy <-- don't do this usually this happens in ML but we're not doing ML techincally 
     */
    static int collision(String[]arr){ 
        HashMap<Integer, Integer> result = new HashMap<>(); // directions never said we can't use a hashmap for anything not int related :// 
        int count = 0; 
        int[] hashmap = new int[arr.length];  
        for(int i=0; i < hashmap.length ;i++){ 
            hashmap[i] = hashcode(arr[i], arr.length); 
        }
        for(int i : hashmap){ // inspiration from leetcode's two sum problem that you should check out -> helps with diff between arrays and hashmaps
            if(result.containsKey(i)){ 
                count++; 
            }
            else{ 
                result.put(i, 1); 
            }
        }
        return count; 
    }

    public static void main(String[] args){ 
        // set of strings pulled from https://youtu.be/KyUTuwz_b7Q 
        String[] arr = {"Bea", "Tim", "Len", "Moe", "Mia", "Zoe", "Sue", "Lou", "Rae", "Max", "Tod"}; 
        System.out.println(collision(arr)); 
    }

}
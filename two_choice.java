import java.util.HashMap;
import java.util.ArrayList;

/* 
 * personal notes: 
 * 
 * arraylist -> checks string for amount of collisions if we add the string 
 * 
 * 
 * visual: this is an arraylist, everytime we "add" an element we're adding a linkedlist with a head node set to the string <-- after checking it's hash code which gives us an index 
 * [] -> Jessica 
 * []
 * [] -> Lisa -> Robert 
 * [] -> Regina -> David -> Blob  
 * [] 
 * [] -> Erika 
 * 
 */

public class two_choice{ 
    static ArrayList<LinkedList> list = new ArrayList<>(); 
    static ArrayList<LinkedList> test = new ArrayList<>(); 

    static int hashing1(String a){ 
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
            code += ((int)arr[i] * Math.pow(26, j - 1)) % 10; 
            j--;  
        }
        return code; 
    }

    static int hashing2(String a){ 
        int hash =0; 
        int R = 31; 
        for(int i= 0; i < a.length(); i++){ 
            hash += (R* hash + a.charAt(i)) % 10; 
        }
        return hash; 
    }

    static int collision(LinkedList a){ 
        if(a.head != null){ 
            return a.size(); 
        }
        return 0; 
    }

    static void add(String s){ 
        int index1 = hashing1(s); 
        int index2 = hashing2(s); 
        for(int i = list.size(); i < index1 + 1 || i < index2 + 1; i++){ 
            LinkedList temp2 = new LinkedList(); 
            list.add(temp2); 
        }
        int index = collision(list.get(index1)) < collision(list.get(index2)) ? index1 : index2; 
        if(list.get(index).head != null){ 
            list.get(index).add(s); 
        }
        else{ 
            LinkedList temp = new LinkedList(); 
            temp.add(s); 
            list.set(index, temp); 
        }
    }

    static void test_add(String s){ 
        int index = hashing1(s); 
        for(int i = test.size() ; i < index + 1; i++){ 
            LinkedList temp = new LinkedList(); 
            test.add(temp); 
        }
        if(test.get(index).head != null){ 
            test.get(index).add(s); 
        }
        else{ 
            LinkedList temp2 = new LinkedList(); 
            temp2.add(s); 
            test.set(index, temp2); 
        }
    }

    

    // "Bea", "Tim", "Len", "Moe", "Mia", "Zoe", "Sue", "Lou", "Rae", "Max", "Tod"
    public static void main(String[]args){ 
        add("Bea"); 
        add("Tim"); 
        add("Len"); 
        add("Moe"); 
        add("Mia"); 
        add("Zoe"); 
        add("Sue"); 
        add("Lou"); 
        add("Rae"); 
        add("Max"); 
        add("Tod"); 
        test_add("Bea"); 
        test_add("Tim"); 
        test_add("Len"); 
        test_add("Moe"); 
        test_add("Mia"); 
        test_add("Zoe"); 
        test_add("Sue"); 
        test_add("Lou"); 
        test_add("Rae"); 
        test_add("Max"); 
        test_add("Tod"); 
        for(LinkedList a : list){
            System.out.println(a.toString()); 
        }
        System.out.println("---------------------------------------------------------"); 
        for(LinkedList b : test){ 
            System.out.println(b.toString()); 
        }
    }
} 

class LinkedList{ 
    Node head; 
    Node current; 

    public LinkedList(){ 
        head = null; 
        current = null;  
    }

    void add(String s){ 
        if(head == null){ 
            head = new Node(s); 
            current = head; 
            return; 
        }
        current.next = new Node(s); 
        current = current.next; 
    }

    int size(){ 
        if(head == null){ 
            return 0; 
        }
        int result = 1; 
        current = head; 
        while(current.next != null){ 
            result++; 
            current = current.next; 
        }
        return result; 
    }

    public String toString(){
        if(head == null){ 
            return ""; 
        }
        String result = head.data; 
        current = head; 
        while(current.next != null){ 
            current = current.next; 
            result += ", " + current.data; 
        }
        return result; 
    }
}

class Node{ 
    String data; 
    Node next; 

    Node(String d){ 
        data = d; 
        next = null; 
    }
}
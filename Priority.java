import java.util.PriorityQueue; 

public class Priority{ 
    private static class Node implements Comparable<Node> { 
        int length; 
        int priority; 
        String name; 

        public Node(String job, int l, int p){
            name = job; 
            length = l; 
            priority = p; 
        }

        public int compareTo(Node n){ 
            return n.priority > this.priority ? -1 : 1; 
        }
    }

    public static void main(String[]args){  
        Node n1 = new Node("toes", 1, 1); 
        Node n2 = new Node("beans", 5, -1); 
        Node n3 = new Node("bloberm", 3, -20); 
        Node n4 = new Node("L", 5, 19); 
        Node n5 = new Node("UWU", 0, -21); 
        PriorityQueue<Node> NodeQueue = new PriorityQueue<>(); 
        NodeQueue.add(n1); 
        NodeQueue.add(n2); 
        NodeQueue.add(n3); 
        NodeQueue.add(n4); 
        NodeQueue.add(n5); 
        while(!NodeQueue.isEmpty()){ 
            Node job = NodeQueue.poll(); 
            if(job.length < 1 || job.length > 100 || job.priority < -20 || job.priority > 19){ 
                continue;  
            } 
            System.out.println("add job " + job.name + " with length " + job.length + " and priority " + job.priority);
            for(int i = 0 ; i < job.length; i++){ 
                   System.out.println("no new job this slice");
            } 
        }
    }
}
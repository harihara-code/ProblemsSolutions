// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        
        one.setNextNode(two);
        two.setNextNode(three);
        three.setNextNode(four);
        four.setNextNode(five);
        five.setNextNode(six);
        six.setNextNode(seven);
        seven.setNextNode(eight);
        eight.setNextNode(nine);
        nine.setNextNode(ten);
        ten.setNextNode(five);
        
        checkCycle(one);
        checkCycle(one);
    }
    
    private static void checkCycle(Node headNode) {
        Boolean isCycle = false;
        
        if (headNode != null  || headNode.nextNode != null) {
            Node slow = headNode;
            Node fast = headNode;
            
            while (fast != null && fast.nextNode != null) {
                slow = slow.nextNode;
                fast = fast.nextNode.nextNode;
                
                if (slow == fast) {
                    isCycle = true;
                    System.out.println("meeting node value: "+ slow.value);
                    Node startNode = findStartNodeInCycle(headNode, slow);
                    System.out.println("StartNode :" + startNode.value);
                
                // remove cycle 
                    Node tempNode = startNode;
                    
                    while(tempNode.nextNode != startNode) {
                        tempNode = tempNode.nextNode;
                    }
                    
                    tempNode.nextNode = null;
                    break;
                }
            }
        }
        
        if (isCycle == false) {
            System.out.println("No cycle detected");
        } else {
            System.out.println("Cycle detected");
        }
    }
    
    private static Node findStartNodeInCycle(Node headNode, Node meetingNode) {
        Node pointer1 = headNode;
        Node pointer2 = meetingNode;
        
        while(pointer1 != pointer2) {
            pointer1 = pointer1.nextNode;
            pointer2 = pointer2.nextNode;
        }
        
        return pointer1;
    }
}

class Node {
    int value;
    Node nextNode;
    
    public Node(int value) {
        this.value = value;
    }
    
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

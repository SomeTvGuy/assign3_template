package assign3_template;

import javax.swing.text.html.HTMLDocument.RunElement;

//File: SimpleLinkedList.java. 
//Add a file header comment or a class header comment to your work.
/*
CIS2168 Data Structures 005
Anthony Poole 
tun48981@temple.edu 
Assign 3 
Program name:
Simple Linked List 
Program description:
    Finish making an simple singlely linked list
*/

/*
 * Assign 3 template. Implement more methods in List interface.
 */
public class SimpleLinkedList {

    //-------Start of Assign 3  --------/  
    
    //2.1.2 Coding Requirements
    //You can call other methods to complete a method.
    //You can also add private methods, and then call these methods 
    //  to complete a method required in this assignment. 
    //You are NOT allowed to add or remove data fields to/from SimpleLinkedList class. 
    //You are NOT allowed to change the definition of Node class.
    
    //2.1.1 What Code to Add
    //-----Required ---------------//    
    
    //Remove the first occurrence of the specified item from this linked list. 
    // If success, return true. Otherwise, return false.
    public boolean removeByValue(int item) {
        //add your own code
        
        //Hint:
        //  call your indexOf(...) to locate the item,
        //  convert the following in SingleLinkedList<E>
        //     private E removeFirst()        
        //     private Node<E> getNode(int index)         
        //     private E removeAfter(Node<E> node)
        
        
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        
        return false;
    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    // if index is size, append item to the end of this linked list.
    public void add(int index, int item) {
        //add your own code
        
        //Hint:
        //convert the following in SingleLinkedList<E>
        //    public void add(int index, E item)
 	//    public void addFirst(E item)
        //    private Node<E> getNode(int index)
    	//    private void addAfter(Node<E> node, E item)          
        
    }

    //Get the integer item at the specified position and return the integer value. 
    //If the index is not valid, throw an exception or print an error message 
    //  and return Integer.MIN_VALUE.
    public int get(int index) {
        //add your own code
        // Will need a Node to count throguh (All of this feels very 0(n))
        Node Current = this.head;
        // if the sleected index isnt valid it throws an index out of bounds error
        // and returns integer min val like ya asked
        int Target =0;
        if( index <0 || index>= this.size){
            throw  new ArrayIndexOutOfBoundsException("It Seems that the index is out of range of this list");
        }
        //Iterator for this list, will use the next method until index is found and will retrun dta from that mode
       for(int i =0; i<=index;i++){
            if(i == index){
                Target = Current.data;
            }
            Current= Current.next;
       }

        //Hint:
	//convert the following in SingleLinkedList<E>
        //    public E get(int index)
        //    private Node<E> getNode(int index)       
        
        return Target;

    }

    //Search this linked list for the first occurrence of the specified integer: item. 
    //If the item is found, return its index. Otherwise return -1.
    public int indexOf(int item) {
        //add your own code
        // need a refference for the head of the linked list
        Node currentNode = this.head;
        //condition if head points to null, if it does and the index given isn't zero return -1
        // this counts the number of elements and the 
        int index = 0;
        if(currentNode.data == item){
            return index;
        }
        // a whie loop tthat ierates over the linked list, upnting the head node if head points to null
        while(currentNode.next != null){
            index++;
            currentNode = currentNode.next;
            //this will increment the ndoe value to next, if next == null this loop will simply conclude
            if(currentNode.data == item){
                return index;
            }
        }
        //Hint:
        //use a looping like the one in toString()
        //in addition, add a counter, 
        //    increment the counter for each element checked 
        //can use size for loop control.
        
        return -1;
    }

    //Find out if the specified integer: item is in this linked list. 
    // Returns true if yes, false otherwise.
    public boolean contains(int item) {
        //add your own code
        // this condistion gauges n if he indexof method is able to find the associated item
        // if the result isn't -1 then return true, if it is -1 return false
        if(indexOf(item) !=-1){
            return true;
        }
        //Hint:
        //can either call indexOf(...) 
        //    or directly search for the item using a loop like the one in toString()


        return false;
    }

    //return how many integers are in this linked list
    public int size() {
        //add your own code
        
        //Hint: this is actually a getter
        
        return this.size;
    }

    //-----Bonus ---------------//
    //Remove the item at the specified position from this linked list and 
    //  return the removed item.
    //If the index is not valid, throw an exception or print an error message 
    //   and return Integer.MIN_VALUE.
    public int removeByIndex(int index) {
        //Add your own code
     
        //Hint:        
        //verify that index is valid
        //convert the following in SingleLinkedList<E>
        //     private Node<E> getNode(int index) 
        //     private E removeAfter(Node<E> node)        
       
        //Hint: if you implement this from scratch, remember to save:
        //   predecessor node reference        
        //   current node reference
        
        return 2;
    }

    //-------End of Assign 3 --------/ 
    
    //Following code were covered in Lec#6. 
    //Don't change them.
    //Nested class Node, enclosing class: SimpleLinkedList
    private static class Node {

        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
        
        //constructor used to create a Node that has a following neighbor
        private Node(int dataNew, Node nextNew) {
            data = dataNew;
            next = nextNew;
        }

        @Override
        public String toString() {
            return data + "";  //"10"
        }        
    }

    //the reference to the first Node in this linked list.
    private Node head;
    //the size of this linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    //append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }

    //return a string that contains all integers (in the original sequence) in the linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
    public static void main(String[] args) {
        SimpleLinkedList Link = new SimpleLinkedList();
        Link.add(255);
        Link.add(125);
        Link.add(113);
        System.out.println(Link.get(2));
    }
}

//Andrew Merrill

//this class is a generic linked list
public class GenLL<T> {
    private class ListNode{
        private T data;
        private ListNode link,prev;
        public ListNode(T aData, ListNode aLink){
            data = aData;
            link = aLink;
        }
    }
    private ListNode head;//head node
    private ListNode curr;//current node
    private ListNode prev;//previous node
    public GenLL(){
        head = curr = prev = null;
    }
    //returns the current data
    public T getCurrent(){
        if(curr != null){
            return curr.data;
        }
        return null;
    }
    //sets the current data
    public void setCurrent (T aData){
        if(curr != null)
            curr.data = aData;
    }
    //moves the current over one
    public void gotoNext(){
        if(curr == null){
            return;
        }
        prev = curr;
        curr = curr.link;
    }
    //sets the current to the head
    public void resetCurrent(){
        curr = head;
    }
    //checks if current is not null for looping the database
    public boolean hasMore(){
        return curr != null;
    }
    //adds a node
    public void insert(T aData){
        ListNode newNode = new ListNode(aData,null);
        if(head == null){//list is empty
            head = newNode;
            curr = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.link != null){
            temp = temp.link;
        }
        temp.link = newNode;

    }
    //inserts a node in the middle
    public void insertAfterCurernt(T aData){
        if(curr == null){
            return;
        }
        curr.link = new ListNode(aData,curr.link);
    }
    //removes the current node from the list
    public void deleteCurrent(){
        if(curr != null && prev != null){
            prev.link = curr.link;
            curr = curr.link;
        }
        else if(curr != null){
            head = head.link;
            curr = head;
        }

    }
    //prints the data in the node
    public void print(){
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.data.toString());//TODO check this
            temp = temp.link;
        }
    }
    //checks if the given data is contained
    public boolean isContained(T aData){
        return this.findNodeWith(aData) != null;
    }
    //moves the current to the data node
    public void gotoItem(T aData){
        ListNode temp = this.findNodeWith(aData);
        if(temp == null)
            return;
        this.resetCurrent();
        while(this.hasMore() && curr != temp){
            this.gotoNext();
        }
    }
    // finds a node with the given data
    private ListNode findNodeWith(T aData){
        ListNode temp = head;
        while(temp != null){
            if (temp.data == aData)
                return temp;
            temp = temp.link;
        }
        return null;
    }
}
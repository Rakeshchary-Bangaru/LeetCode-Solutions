class MyCircularDeque {
    int[] list;
    int front;
    int rear;
    public MyCircularDeque(int k) {
        list = new int[k];
        front = -1;
        rear = -1;
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        else if ( front == -1 && rear == -1){
            front = 0;
            rear = 0;
            list[front] = value;
            return true;
        }
        else if(front == 0){
            front = list.length-1;
            list[front] = value;
            return true;
        }
        else{
            front--;
            list[front] = value;
            return true;
        }
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        else if ( front == -1 && rear == -1){
            front = 0;
            rear = 0;
            list[rear] = value;
            return true;
        }
        else if(rear==list.length-1){
            rear = 0;
            list[rear] = value;
            return true;
        }
        else{
            rear++;
            list[rear] = value;
            return true;
        }
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        else if(front == rear){
            front = -1;
            rear = -1;
            return true;
        }
        else if(front==list.length-1){
            front = 0;
            return true;
        }
        else{
            front++;
            return true;
        }
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        else if(front == rear){
            front = -1;
            rear = -1;
            return true;
        }
        else if(rear==0){
            rear = list.length-1;
            return true;
        }
        else{
            rear--;
            return true;
        }
    }
    
    public int getFront() {
        if(front!= -1){
            return list[front];
        }
        return -1;
        
    }
    
    public int getRear() {
        if(rear!=-1){
            return list[rear];
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if(front== -1 && rear == -1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(front == (rear+1)%list.length){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
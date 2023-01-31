package org.example;

public class DynamicArray {
    int size;
    int capacity;
    Object [] array;
    public DynamicArray (){
        this.array = new Object[capacity];
    }
    public DynamicArray(int capacity){ // overloaded constructor
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public void add (Object a){
        if (size >= capacity){
            grow();
        }
        array[size] = a;
        size++;
    };
    public void insert(int index, Object a){
        if (size >= capacity){
            grow();
        }
        for (int i = index ; i <= size -1; i++){
            array[i+1] = array[i];
        }
        array[index] = a;
        size++;
    };
    public int search(Object a){
        for(int i = 0; i <= size-1; i++){
            if(array[i] == a){
                return i;
            }
        }
        return -1;
    };
    public boolean isEmpty(){
        return size ==0;
    };
    public String toString(){
        String s = null;
        for (int i = 0; i<= size-1; i++){
            s = array[i] + ", ";
        }
        if(s != "") {
            s = "[" + s.substring(0,s.length()-2) + "]";
        }
        return s;
    };

    public void delete(Object a){
        int index = 0;
        for(int i = 0; i<= size-1; i++){
            if(array[i] == a){
                index = i;
                break;
            }
        }
        for (int i = index; i <= size -2; i++){
            array[i] = array [i+1];
        }
        array[size-1] = null;
        size--;
        if(size <= (int) capacity/3){
            shrink();
        }
        
    };
    public void grow(){
        int newcapacity = (int) capacity*2;
        Object[] newarray = new Object[newcapacity];
        for(int i = 0; i<=size-1; i++){
            newarray[i] = array[i];
        }
        capacity = newcapacity;
        array = newarray;

    };
    public void shrink(){
        int newcapacity = (int) capacity/2;
        Object[] newarray = new Object[newcapacity];
        for(int i = 0; i <= size-1; i++){
            newarray[i] = array[i];
        }
        capacity = newcapacity;
        array = newarray;
    };

}

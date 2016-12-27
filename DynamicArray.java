import java.util.*;

public class DynamicArray {

  private int[] arr;
  private int currSize;

  DynamicArray() {
    this.arr = new int[20];
    this.currSize = -1;
  }

  DynamicArray(int desiredSize) {

    if(desiredSize < 20) {
      this.arr = new int[20];
    }
    else {
      this.arr = new int[desiredSize];
    }
    this.currSize = -1;
  }

  public int[] getArr() {
    return this.arr;
  }

  public int getCurrSize() {
    return this.currSize;
  }

  public int getCapacity() {
    return this.arr.length;
  }

  public void add(int num) {

    checkCapacity(this.currSize++);
    arr[this.currSize] = num;
  }

  private void checkCapacity(int size) {

    int currCapacity = this.arr.length;
    if (size + 1 >= currCapacity) {
      int newCapacity = currCapacity * 2;

      if (size > newCapacity) {
        newCapacity = size;
      }
      this.arr = Arrays.copyOf(this.arr, newCapacity);
    }

  }

  public int get(int index) {

    if(index > this.currSize || index < 0) {
      return -1;
    } else {
      return this.arr[index];
    }

  }

  public void set(int index, int data) {

    if(index > this.currSize || index < 0) {
      return;
    } else {
      this.arr[index] = data;
    }

  }

  public void clear() {
    this.currSize = 0;
  }

  public static void main(String[] args) {
    DynamicArray d = new DynamicArray();
    for(int i = 0; i <= 25; i++) {
      d.add(i);
    }

    for(int i = 0; i <= d.getCurrSize(); i++) {
      System.out.println(d.get(i));
    }
    d.set(1, 543);
    for(int i = 0; i <= d.getCurrSize(); i++) {
      System.out.println(d.get(i));
    }
    System.out.println(d.getCapacity());
    System.out.println(d.getCurrSize());
    d.clear();
    System.out.println(d.getCapacity());
    System.out.println(d.getCurrSize());

  }

}

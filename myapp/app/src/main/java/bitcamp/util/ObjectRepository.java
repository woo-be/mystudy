package bitcamp.util;

import java.util.Arrays;

public class ObjectRepository<E> {

  Object[] objects = new Object[3];
  int length = 0;

  public void add(E object) {

    if (this.length == this.objects.length) {
      //System.out.println("과제를 더이상 등록할 수 없습니다.");
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize / 2);

      // 이전 배열에 들어 있는 값을 새 배열에 복사
//      Object[] arr = new Object[newSize];
//      for (int i = 0; i < oldSize; i++) {
//        arr[i] = this.objects[i];
//      }

      // 새 배열을 가리키도록 배열 레퍼런스를 변경

//      Object[] arr = new Object[newSize];
//      System.arraycopy(this.objects, 0, arr, 0, this.objects.length);
//      this.objects = arr;

      this.objects = Arrays.copyOf(this.objects, newSize);

    }
    this.objects[this.length++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index > this.length) {
      return null;
    }

    Object deleted = this.objects[index];

//    for (int i = index; i < (this.length - 1); i++) {
//      this.objects[i] = this.objects[i
//          + 1]; // 다음 레퍼런스의 값을 삭제하려는 현재 레퍼런스로 이동
//    }

    System.arraycopy(this.objects, index + 1, this.objects, index, this.length - (index + 1));

    this.objects[--this.length] = null;

    return (E) deleted;
  }

  public Object[] toArray() {
//    Object[] arr = new Object[this.length];
//    for (int i = 0; i < this.length; i++) {
//      arr[i] = this.objects[i];
//    }
//    return (E[]) arr;

    return Arrays.copyOf(this.objects, this.length);
  }

  public E get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    return (E) this.objects[index];
  }

  public E set(int index, Object object) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (E) old;
  }
}

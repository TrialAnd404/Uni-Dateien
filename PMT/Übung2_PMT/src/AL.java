import java.util.Iterator;
@SuppressWarnings("unchecked")
public class AL<E> implements Iterable<E> {
  @SuppressWarnings("unchecked")
  protected E[] store = (E[]) new Object[5];
  protected int size = 0;

  @SuppressWarnings("unchecked")
  public AL(E... es) {
    for (E e : es)
      add(e);
  }

  @SuppressWarnings("unchecked")
  private void mkNewStore() {
    E[] newStore = (E[]) new Object[size + 5];
    for (int i = 0; i < store.length; i++)
      newStore[i] = store[i];
    store = newStore;
  }

  public void add(E e) {
    if (store.length <= size)
      mkNewStore();
    store[size++] = e;
  }

  public int size() {
    return size;
  }

  public E get(int i) {
    return store[i];
  }

  @Override
  public Iterator<E> iterator() {
    return new MyIterator(store, size);
  }

  public class MyIterator implements Iterator<E>{
    E[] store;
    int size;

    public MyIterator(E[] store, int size){
      this.store=store;
      this.size=size;
    }

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public E next() {
      return null;
    }
  }
}
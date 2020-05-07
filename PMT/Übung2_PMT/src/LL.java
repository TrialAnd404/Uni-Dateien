import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LL<A>  {
  private final A hd;
  private final LL<A> tl;

  public boolean isEmpty(){
    return hd==null&&tl==null;
  }

  public LL(A hd, LL<A> tl) {
    this.hd = hd;
    this.tl = tl;
  }
  public LL() {
    this(null,null);
  }

  public int size() {
    if (isEmpty())
      return 0;
    return 1 + tl.size();
  }

  public A get(int i) {
    return i==0?hd:tl.get(i-1);
  }

  boolean containsWith(Predicate<? super A> p) {
    if (isEmpty())
      return false;
    if(p.test(hd))
      return true;
    return tl.containsWith(p);
  }

  boolean contains(A el) {
    if (isEmpty())
      return false;
    if (hd==el)
      return true;
    return tl.contains(el);
  }

  boolean isPrefixOf(LL<A> that) {
    if(that.isEmpty())
      return true;
    if (!(that.hd == this.hd))
      return false;
    return tl.isPrefixOf(that.tl);
  }

  LL<A> drop(int i){
    if(i==0)
      return new LL<A>(hd,tl);
    else {
      i=i-1;
      return tl.drop(i);
    }
  }

  LL<A> take(int i){
    return new LL<>();
  }


  LL<A> sublist(int from, int length){
    return new LL<>();
  }

  A last(){
    if(tl.isEmpty())
      return hd;
    return tl.last();
  }

  LL<A> append(LL<A> that){
    if(isEmpty()){
      return that;
    }
    return new LL<A>(hd, tl.append(that));
  }

  void forEach(Consumer<? super A> con){
  }

  LL<A> filter(Predicate<? super A> p){
    if(isEmpty())
      return
    return new LL<>();
  }

  <B> LL<B> map(Function<? super A, ? extends B> f){
    return new LL<B>();
  }

  LL<A> reverse(){
    return new LL<A>();
  }

  @SuppressWarnings("unchecked")
  static <A> LL<A> create(A... es){
    LL<A> result = new LL<A>();
    for (int i=es.length-1;i>=0;i--){
      result = new LL<A>(es[i],result);
    }
    return result;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((hd == null) ? 0 : hd.hashCode());
    result = prime * result + ((tl == null) ? 0 : tl.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj){
      return true;
    }
    if (obj == null){
      return false;
    }
    if (!(obj instanceof LL)){
      return false;
    }
    LL other = (LL) obj;
    if (hd == null) {
      if (other.hd != null){
        return false;
      }
    } else if (!hd.equals(other.hd)){
      return false;
    }
    if (tl == null) {
      if (other.tl != null){
        return false;
      }
    } else if (!tl.equals(other.tl)){
      return false;
    }
    return true;
  }
  @Override
  public String toString(){
    StringBuffer result = new StringBuffer("[");
    boolean first = true;
    for (LL<A> it = this;!it.isEmpty();it=it.tl){
      if (first){
        first = false;
      } else{
        result.append(", ");
      }
      result.append(it.hd);
    }
    result.append("]");
    return result.toString();
  }

}
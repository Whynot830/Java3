import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SafeSet<E> implements Set<E> {
    private final HashSet<E> set = new HashSet<>();
    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    synchronized public boolean add(E e) {
        return set.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    synchronized public void clear() {
        set.clear();
    }
}

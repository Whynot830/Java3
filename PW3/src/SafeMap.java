import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeMap<K, V> implements Map<K, V> {
    private static final Lock lock = new ReentrantLock();

    private final Map<K, V> map = new HashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        V res = map.put(key, value);
        lock.unlock();
        return res;
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        V res = map.remove(key);
        lock.unlock();
        return res;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }
}

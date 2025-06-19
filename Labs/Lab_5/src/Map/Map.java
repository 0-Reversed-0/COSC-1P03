package Map;

public interface Map<E> extends Iterable<E>
{
    void add(String key, E entry);
    E get(String key);
    void delete(String key);
    int count();
    String[] keys();
}

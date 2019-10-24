package services;

import java.util.List;

public interface MappingService {
    <T, K> T map(K object, Class<T> klass);
    <T, K> List<T> map(List<K> object, Class<T> klass);
}

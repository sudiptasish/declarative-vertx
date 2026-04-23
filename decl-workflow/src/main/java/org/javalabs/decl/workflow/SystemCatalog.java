package org.javalabs.decl.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * System catalog. 
 *
 * @author Sudiptasish Chanda
 */
public class SystemCatalog implements Catalog {
    
    private static final Catalog CATALOG = new SystemCatalog();
    
    private final ConcurrentMap<String, Chain> registry = new ConcurrentHashMap<>();
    
    private SystemCatalog() {}
    
    public static Catalog get() {
        return CATALOG;
    }

    @Override
    public void add(Chain chain) {
        registry.put(chain.name(), chain);
    }

    @Override
    public Chain get(String name) {
        return registry.get(name);
    }

    @Override
    public List<Chain> getAll() {
        return new ArrayList<>(registry.values());
    }

    @Override
    public void clear() {
        registry.clear();
    }
}

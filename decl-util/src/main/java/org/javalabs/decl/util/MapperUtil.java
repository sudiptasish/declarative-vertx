package org.javalabs.decl.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;

/**
 * Utility class to keep the {@link ObjectMapper}.
 *
 * @author Sudiptasish Chanda
 */
public class MapperUtil {
    
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    
    private static final ObjectWriter JSON_PRETTY_MAPPER = new ObjectMapper().writerWithDefaultPrettyPrinter();
    
    private static final ObjectMapper YML_MAPPER = new ObjectMapper(new YAMLFactory());
    
    public static <T> T decode(byte[] buff, Class<T> clazz) {
        try {
            return (T)mapper().readValue(buff, clazz);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <T> T decode(byte[] buff, T type) {
        try {
            return (T)mapper().readValue(buff, new TypeReference<T>() {});
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encode(Object obj) {
        try {
            return mapper().writeValueAsBytes(obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectMapper mapper() {
        return JSON_MAPPER;
    }

    public static ObjectMapper ymlMapper() {
        return YML_MAPPER;
    }

    public static byte[] prettyWrite(Object obj) {
        try {
            return JSON_PRETTY_MAPPER.writeValueAsBytes(obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

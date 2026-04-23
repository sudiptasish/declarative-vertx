package org.javalabs.decl.api.doc;

import org.javalabs.decl.api.doc.SwaggerDoc;
import org.javalabs.decl.api.doc.DocOption;
import org.junit.jupiter.api.Test;

/**
 *
 * @author schan280
 */
public class SwaggerDocTest {
    
    // @Test
    public void testGenerate() throws Exception {
        // String file = "/Users/schan280/Projects/example-rest/src/main/resources/routing-config.xml";
        DocOption docOpt = new DocOption();
        docOpt.setConfigFile("routing-config.xml");
        // docOpt.setMethods(Arrays.asList("get", "post", "put", "delete"));
        docOpt.setOutFile("/Users/schan280/Projects/openapi.yaml");
        
        SwaggerDoc doc = new SwaggerDoc();
        doc.generate(docOpt);
    }
}

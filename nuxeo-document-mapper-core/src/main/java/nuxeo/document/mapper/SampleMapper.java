package nuxeo.document.mapper;
import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.tree.DefaultElement;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom4j.Dom4jXPath;
import org.nuxeo.ecm.platform.scanimporter.processor.DocumentTypeMapper;

public class SampleMapper  implements DocumentTypeMapper {
	 @Override
	    public String getTargetDocumentType(Document xmlDoc, File file) {
	        try {
	            XPath xpath = new Dom4jXPath("//resource-definition");
	            List<?> nodes = xpath.selectNodes(xmlDoc);
	            if (nodes.size() >= 1) {
	                DefaultElement elem = (DefaultElement) nodes.get(0);
	                return elem.attribute("name").getValue();
	            } else {
	                return "File";
	            }
	        } catch (JaxenException e) {
	            return "File";
	        }
	    }
}

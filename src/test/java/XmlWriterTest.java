import org.testng.annotations.Test;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlWriterTest {
    private XmlWriter xmlWriter = new XmlWriter("src/test/resources/sample.xml");

    public XmlWriterTest() throws XMLStreamException, IOException {
    }

    @Test
    public void writeXml() throws XMLStreamException {
        Map<String, String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        xmlWriter.writeXml(map, "Properties");
    }
}
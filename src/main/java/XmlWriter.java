import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class XmlWriter {
    private final XMLStreamWriter xmlStreamWriter;

    public XmlWriter(String filePath) throws XMLStreamException, IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        this.xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fileWriter);
    }

    public void writeXml(Map<String, String> elements, String startElement) throws XMLStreamException {
        this.xmlStreamWriter.writeStartDocument();
        this.xmlStreamWriter.writeStartElement(startElement);
        for (Map.Entry<String, String> element : elements.entrySet()) {
            this.xmlStreamWriter.writeAttribute(element.getKey(), element.getValue());
        }
        this.xmlStreamWriter.writeEndElement();
        this.xmlStreamWriter.writeEndDocument();
        this.xmlStreamWriter.flush();
        this.xmlStreamWriter.close();
    }
}

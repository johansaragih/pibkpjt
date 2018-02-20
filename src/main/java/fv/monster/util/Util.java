package fv.monster.util;

import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import barangkirimanclient.ConnectionBuilder;
import barangkirimanclient.WSBarangKiriman;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Johan Saragih
 */
public class Util {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExcelHandler.class);
    
    public static String[] decodeCredential(String encodedCredential) {
        String credentials = new String(Base64.getDecoder().decode(encodedCredential), Charset.forName("UTF-8"));
        // credentials = username:password
        return credentials.split(":", 2);
    }

    public static void callWS(File file) {
            String ret = "";
        StringBuilder finXml = new StringBuilder();
        try {
            Util util = new Util();
            WSBarangKiriman wstpb;
            wstpb = new ConnectionBuilder().getWSTPB();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            NodeList list = doc.getFirstChild().getChildNodes();
            
            for (int i=0; i<list.getLength(); i++){
                Node element = list.item(i).cloneNode(true);
                if(element.hasChildNodes()){
                    String kdBrg="";
                    for (int j = 0; j < element.getChildNodes().getLength(); j++) {
                        Node tempNode = element.getChildNodes().item(j);
                        if (tempNode.getNodeName().equals("NO_BARANG")) {
                            kdBrg = tempNode.getTextContent();
//                            System.out.println(kdBrg);
                        }
                    }
                    Source src = new DOMSource(element);
                    StreamResult result = new StreamResult(new StringWriter());
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.transform(src, result);
                    String xmlString = result.getWriter().toString();
                    xmlString = xmlString.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
                    xmlString = "<CN_PIBK>" + xmlString + "</CN_PIBK>" + "\n";
                    xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+ "\n" + xmlString;
//                    finXml.append(xmlString);
//                    ret = kdBrg + "--"+wstpb.kirimData(xmlString, util.id, util.sign)+"\n";
//                    logger.debug(util.id);
                    String hsl="";
                    hsl = wstpb.kirimData(xmlString, "eksprespi","eksprespi");
                    
                    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document mydoc = db.parse(new InputSource(new StringReader(hsl)));
                    ret = kdBrg + " -- Kode Respon :"+mydoc.getElementsByTagName("KD_RESPON").item(0).getTextContent()+ " -- Ket Respon:"+mydoc.getElementsByTagName("KET_RESPON").item(0).getTextContent();
                    ret = ret + System.lineSeparator();
                    logger.info(hsl);
                    
                    finXml.append(ret);
//                    finXml.append("Id : ")
//                            .append(util.id)
//                            .append(System.lineSeparator())
//                            .append("Sign : ")
//                            .append(util.sign)
//                            .append(System.lineSeparator());
//                    finXml.append(hsl);
                }
            }
            
            logger.debug(finXml.toString(), "Log Kirim");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
//            logger.error(ex.printStackTrace());
                ex.printStackTrace();
        } catch (TransformerConfigurationException ex) {
//            logger.error(ex.printStackTrace());
                ex.printStackTrace();
        } catch (TransformerException ex) {
//            logger.error(ex.printStackTrace());
                ex.printStackTrace();
        }
//        return finXml.toString();
    }
}


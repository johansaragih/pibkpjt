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
//import barangkirimanclient.ConnectionBuilder;
//import barangkirimanclient.WSBarangKiriman;

/**
 *
 * @author Johan Saragih
 */
public class Util {

    public static String[] decodeCredential(String encodedCredential) {
        String credentials = new String(Base64.getDecoder().decode(encodedCredential), Charset.forName("UTF-8"));
        // credentials = username:password
        return credentials.split(":", 2);
    }
    
//    public static void callWS(){
//        wstpb = new ConnectionBuilder().getWSTPB();
//                    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//                    String respon="";
//                    for (String data : multiData) {
//                        
//                        String p = wstpb.getResponByAwb(data, util.id, util.sign);
//                        
//                        Document pdoc = db.parse(new InputSource(new StringReader(p)));
//                        NodeList pList = pdoc.getElementsByTagName("CEK_STATUS");
//                        Node pNode = pList.item(0);
//                        if (pNode.getNodeType() == Node.ELEMENT_NODE) {
//                            Element eElement = (Element) pNode;
//
//                            String ketRes = eElement.getElementsByTagName("KET_RESPON").item(0).getTextContent();
//                            String kdRes = eElement.getElementsByTagName("KD_RESPON").item(0).getTextContent();
//                            String noBarang = eElement.getElementsByTagName("NO_BARANG").item(0).getTextContent();
//                            respon = respon + "No Barang : "
//                                    + noBarang + System.lineSeparator()+
//                                    "Kode Respon : "
//                                    + kdRes + System.lineSeparator();
//                            if (eElement.getElementsByTagName("KD_RESPON").item(0).getTextContent().equals("ERR")) {
//                                respon = respon + "Waktu Respon : "
//                                    + eElement.getElementsByTagName("WK_RESPON").item(0).getTextContent() + System.lineSeparator();
//                            }else{
//                                respon = respon + "Waktu Rekam : "
//                                    + eElement.getElementsByTagName("WK_REKAM").item(0).getTextContent() + System.lineSeparator();                        
//                            }
//                                respon = respon + "Ket Respon : "
//                                    + ketRes + System.lineSeparator();
//            //                            System.out.println(respon);
//                        }
//
//    }
}

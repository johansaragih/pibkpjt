/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.util;

//import com.sun.xml.internal.txw2.Document;
//import javax.swing.text.html.parser.Element;
import fv.monster.dto.DetailDataDto;
import fv.monster.dto.HeaderDataDto;
import fv.monster.model.UpdateData;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Administrator
 */
public class XMLHandler {
    private static Document doc;

    // Root "ORDER"
    public static Element addRoot(String rootName) {
        Element root = doc.createElement(rootName);
        doc.appendChild(root);
        return root;
    }

    // Elements inside ROOT like INFO, OTHERS
    public static Element addElement(String rootName, Element root) {
        Element e = doc.createElement(rootName);
        root.appendChild(e);
        return e;
    }

    // Elements inside other elements INFO -> Id, Value
    public static void addNode(Element e, String tagName, String content) {
        Element employ = doc.createElement(tagName);
        employ.appendChild(doc.createTextNode(content));
        e.appendChild(employ);
    }

    // Document
    public static void makeDoc() {
        try {
            DocumentBuilderFactory dF = DocumentBuilderFactory.newInstance();
            DocumentBuilder docB = dF.newDocumentBuilder();       
            doc = docB.newDocument();
        } catch (ParserConfigurationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(XMLHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Save the xml file
    public static void makeFile(String filePath) {
        try {
            TransformerFactory tF = TransformerFactory.newInstance();
            Transformer t = tF.newTransformer();
            DOMSource source = new DOMSource(doc);
            File xml = new File(filePath);
            StreamResult r = new StreamResult(xml);
            t.transform(source, r);
        } catch (TransformerConfigurationException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(XMLHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(XMLHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createUpdateXML(List<UpdateData> listData, String pathToSave) {
        XMLHandler.makeDoc();
        Element order = XMLHandler.addRoot("PIBK_UPDATE");
        for (UpdateData data : listData) {
            Element info = XMLHandler.addElement("HEADER", order);
            XMLHandler.addNode(info, "NO_BARANG", String.valueOf(data.getNO_BARANG()));
            XMLHandler.addNode(info, "TGL_HOUSE_BLAWB", String.valueOf(data.getTGL_HOUSE_BLAWB()));
            XMLHandler.addNode(info, "NO_BC11", String.valueOf(data.getNO_BC11()));
            XMLHandler.addNode(info, "TGL_BC11", String.valueOf(data.getTGL_BC11()));
            XMLHandler.addNode(info, "NO_POS_BC11", String.valueOf(data.getNO_POS_BC11()));
            XMLHandler.addNode(info, "NO_SUBPOS_BC11", String.valueOf(data.getNO_SUBPOS_BC11()));
            XMLHandler.addNode(info, "NO_SUBSUBPOS_BC11", String.valueOf(data.getNO_SUBSUBPOS_BC11()));
            XMLHandler.addNode(info, "KD_GUDANG", String.valueOf(data.getKD_GUDANG()));
            
        }
        XMLHandler.makeFile(pathToSave+".xml");
    }
    
    public static void createMainXML(List<HeaderDataDto> listDataH, String pathToSave, boolean includeManifest){
        XMLHandler.makeDoc();
        Element order = XMLHandler.addRoot("CN_PIBK");
        for (HeaderDataDto header : listDataH) {
            Element info = XMLHandler.addElement("HEADER", order);
            XMLHandler.addNode(info, "JNS_AJU", String.valueOf(header.getJNS_AJU()));
            XMLHandler.addNode(info, "KD_JNS_PIBK", String.valueOf(header.getKD_JNS_PIBK()));
            XMLHandler.addNode(info, "NO_BARANG", String.valueOf(header.getNO_BARANG()));
            XMLHandler.addNode(info, "KD_KANTOR", String.valueOf(header.getKD_KANTOR()));
            XMLHandler.addNode(info, "KD_JNS_ANGKUT", String.valueOf(header.getKD_JNS_ANGKUT()));
            XMLHandler.addNode(info, "NM_PENGANGKUT", String.valueOf(header.getNM_PENGANGKUT()));
            XMLHandler.addNode(info, "NO_FLIGHT", String.valueOf(header.getNO_FLIGHT()));
            XMLHandler.addNode(info, "KD_PEL_MUAT", String.valueOf(header.getKD_PEL_MUAT()));
            XMLHandler.addNode(info, "KD_PEL_BONGKAR", String.valueOf(header.getKD_PEL_BONGKAR()));
            XMLHandler.addNode(info, "KD_GUDANG", String.valueOf(header.getKD_GUDANG()));
            XMLHandler.addNode(info, "NO_INVOICE", String.valueOf(header.getNO_INVOICE()));
            XMLHandler.addNode(info, "TGL_INVOICE", String.valueOf(header.getTGL_INVOICE()));
            XMLHandler.addNode(info, "KD_NEGARA_ASAL", String.valueOf(header.getKD_NEGARA_ASAL()));
            XMLHandler.addNode(info, "JML_BRG", String.valueOf(header.getJML_BRG()));
            if (includeManifest) {
                XMLHandler.addNode(info, "NO_BC11", "");
                XMLHandler.addNode(info, "TGL_BC11", "");
                XMLHandler.addNode(info, "NO_POS_BC11", "");
                XMLHandler.addNode(info, "NO_SUBPOS_BC11", "");
                XMLHandler.addNode(info, "NO_SUBSUBPOS_BC11", "");
            }else{
                XMLHandler.addNode(info, "NO_BC11", String.valueOf(header.getNO_BC11()));
                XMLHandler.addNode(info, "TGL_BC11", String.valueOf(header.getTGL_BC11()));
                XMLHandler.addNode(info, "NO_POS_BC11", String.valueOf(header.getNO_POS_BC11()));
                XMLHandler.addNode(info, "NO_SUBPOS_BC11", String.valueOf(header.getNO_SUBPOS_BC11()));
                XMLHandler.addNode(info, "NO_SUBSUBPOS_BC11", String.valueOf(header.getNO_SUBSUBPOS_BC11()));
            }
            
            XMLHandler.addNode(info, "NO_MASTER_BLAWB", String.valueOf(header.getNO_MASTER_BLAWB()));
            XMLHandler.addNode(info, "TGL_MASTER_BLAWB", String.valueOf(header.getTGL_MASTER_BLAWB()));
            XMLHandler.addNode(info, "NO_HOUSE_BLAWB", String.valueOf(header.getNO_HOUSE_BLAWB()));
            XMLHandler.addNode(info, "TGL_HOUSE_BLAWB", String.valueOf(header.getTGL_HOUSE_BLAWB()));
            XMLHandler.addNode(info, "KD_NEG_PENGIRIM", String.valueOf(header.getKD_NEG_PENGIRIM()));
            XMLHandler.addNode(info, "NM_PENGIRIM", String.valueOf(header.getNM_PENGIRIM()));
            XMLHandler.addNode(info, "AL_PENGIRIM", String.valueOf(header.getAL_PENGIRIM()));
            XMLHandler.addNode(info, "JNS_ID_PENERIMA", String.valueOf(header.getJNS_ID_PENERIMA()));
            XMLHandler.addNode(info, "NO_ID_PENERIMA", String.valueOf(header.getNO_ID_PENERIMA()));
            XMLHandler.addNode(info, "NM_PENERIMA", String.valueOf(header.getNM_PENERIMA()));
            XMLHandler.addNode(info, "AL_PENERIMA", String.valueOf(header.getAL_PENERIMA()));
            XMLHandler.addNode(info, "TELP_PENERIMA", String.valueOf(header.getTELP_PENERIMA()));
            XMLHandler.addNode(info, "JNS_ID_PEMBERITAHU", String.valueOf(header.getJNS_ID_PEMBERITAHU()));
            XMLHandler.addNode(info, "NO_ID_PEMBERITAHU", String.valueOf(header.getNO_ID_PEMBERITAHU()));
            XMLHandler.addNode(info, "NM_PEMBERITAHU", String.valueOf(header.getNM_PEMBERITAHU()));
            XMLHandler.addNode(info, "AL_PEMBERITAHU", String.valueOf(header.getAL_PEMBERITAHU()));
            XMLHandler.addNode(info, "NO_IZIN_PEMBERITAHU", String.valueOf(header.getNO_IZIN_PEMBERITAHU()));
            XMLHandler.addNode(info, "TGL_IZIN_PEMBERITAHU", String.valueOf(header.getTGL_IZIN_PEMBERITAHU()));
            XMLHandler.addNode(info, "KD_VAL", String.valueOf(header.getKD_VAL()));
            XMLHandler.addNode(info, "NDPBM", header.getNDPBM().stripTrailingZeros().toPlainString());
            XMLHandler.addNode(info, "FOB", header.getFOB().stripTrailingZeros().toPlainString());
            XMLHandler.addNode(info, "ASURANSI", header.getASURANSI().stripTrailingZeros().toPlainString());
            XMLHandler.addNode(info, "FREIGHT", header.getFREIGHT().stripTrailingZeros().toPlainString());
            XMLHandler.addNode(info, "CIF", header.getCIF().stripTrailingZeros().toPlainString());
            XMLHandler.addNode(info, "NETTO", String.valueOf(header.getNETTO()));
            XMLHandler.addNode(info, "BRUTO", String.valueOf(header.getBRUTO()));
            XMLHandler.addNode(info, "TOT_DIBAYAR", header.getTOT_DIBAYAR().stripTrailingZeros().toPlainString());
            XMLHandler.addNode(info, "NPWP_BILLING", String.valueOf(header.getNPWP_BILLING()));
            XMLHandler.addNode(info, "NAMA_BILLING", String.valueOf(header.getNAMA_BILLING()));
            
            Element headerPungutan = XMLHandler.addElement("HEADER_PUNGUTAN", info);
//                new BigDecimal(val).stripTrailingZeros().toPlainString()
            BigDecimal totPungutan1= BigDecimal.ZERO.stripTrailingZeros();
            BigDecimal totPungutan2= BigDecimal.ZERO.stripTrailingZeros();
            BigDecimal totPungutan3= BigDecimal.ZERO.stripTrailingZeros();
            BigDecimal totPungutan4= BigDecimal.ZERO.stripTrailingZeros();
            
//            if (header.getNO_HOUSE_BLAWB().equals(jLabel1)) {
//                
//            }
            
            
            Element details = XMLHandler.addElement("DETIL", info);
//                XMLHandler.addNode(info, "Value", "99999");
            for (DetailDataDto detail : header.getDetails()) {
                if (header.getNO_HOUSE_BLAWB().equals(detail.getNO_HOUSE_BLAWB())) {
                    Element det = XMLHandler.addElement("BARANG", details);
                    XMLHandler.addNode(det, "SERI_BRG", String.valueOf(detail.getSERI_BRG()));
                    XMLHandler.addNode(det, "HS_CODE", String.valueOf(detail.getHS_CODE()));
                    XMLHandler.addNode(det, "UR_BRG", String.valueOf(detail.getUR_BRG()));
                    XMLHandler.addNode(det, "KD_NEG_ASAL", String.valueOf(detail.getKD_NEG_ASAL()));
                    XMLHandler.addNode(det, "JML_KMS", String.valueOf(detail.getJML_KMS()));
                    XMLHandler.addNode(det, "JNS_KMS", String.valueOf(detail.getJNS_KMS()));
                    XMLHandler.addNode(det, "CIF", detail.getCIF().stripTrailingZeros().toPlainString());
                    XMLHandler.addNode(det, "KD_SAT_HRG", String.valueOf(detail.getKD_SAT_HRG()));
                    XMLHandler.addNode(det, "JML_SAT_HRG", String.valueOf(detail.getJML_SAT_HRG()));
                    XMLHandler.addNode(det, "FL_BEBAS", String.valueOf(detail.getFL_BEBAS()));
                    XMLHandler.addNode(det, "NO_SKEP", String.valueOf(detail.getNO_SKEP()));
                    XMLHandler.addNode(det, "TGL_SKEP", String.valueOf(detail.getTGL_SKEP()));
                    BigDecimal pun1 = BigDecimal.ZERO.stripTrailingZeros();
                    
                    for (int i = 0; i < 4; i++) {
                        BigDecimal pungutan1 = BigDecimal.ZERO.stripTrailingZeros();
                        BigDecimal pungutan2;
                        BigDecimal pungutan3;
                        BigDecimal pungutan4;
                        
                        Element detPungutan = XMLHandler.addElement("DETIL_PUNGUTAN", det);
                        XMLHandler.addNode(detPungutan, "KD_PUNGUTAN", String.valueOf(i+1));
                        switch (i) {
                            case 0:
                                pungutan1 = detail.getCIF().multiply(header.getNDPBM());
                                pungutan1 = pungutan1.multiply(detail.getBM_TRF());
                                pungutan1 = pungutan1.divide(BigDecimal.valueOf(100));
                                pungutan1 = pungutan1.stripTrailingZeros();
                                pungutan1 = pungutan1.setScale(0, RoundingMode.HALF_EVEN);
                                pun1 = pungutan1;
                                XMLHandler.addNode(detPungutan, "NILAI", pungutan1.stripTrailingZeros().toPlainString());
                                XMLHandler.addNode(detPungutan, "TARIF", detail.getBM_TRF().stripTrailingZeros().toPlainString());
                                totPungutan1 = totPungutan1.add(pungutan1).stripTrailingZeros();
                                totPungutan1 = totPungutan1.setScale(0, RoundingMode.HALF_EVEN);
                                break;
                            case 1:
                                pungutan2 = detail.getCIF().multiply(header.getNDPBM());
                                pungutan2 = pungutan2.add(pun1);
                                pungutan2= pungutan2.multiply(detail.getPPH_TRF());
                                pungutan2 = pungutan2.divide(BigDecimal.valueOf(100));
                                pungutan2 = pungutan2.stripTrailingZeros();
                                pungutan2 = pungutan2.setScale(0, RoundingMode.HALF_EVEN);
                                XMLHandler.addNode(detPungutan, "NILAI", pungutan2.stripTrailingZeros().toPlainString());
                                XMLHandler.addNode(detPungutan, "TARIF", detail.getPPH_TRF().stripTrailingZeros().toPlainString());
                                totPungutan2 = totPungutan2.add(pungutan2).stripTrailingZeros();
                                totPungutan2 = totPungutan2.setScale(0, RoundingMode.HALF_EVEN);
                                break;
                            case 2:
                                pungutan3 = detail.getCIF().multiply(header.getNDPBM());
                                pungutan3 = pungutan3.add(pun1);
                                pungutan3 = pungutan3.multiply(detail.getPPN_TRF());
                                pungutan3 = pungutan3.divide(BigDecimal.valueOf(100));
                                pungutan3 = pungutan3.stripTrailingZeros();
                                pungutan3 = pungutan3.setScale(0, RoundingMode.HALF_EVEN);
                                XMLHandler.addNode(detPungutan, "NILAI", pungutan3.stripTrailingZeros().toPlainString());
                                XMLHandler.addNode(detPungutan, "TARIF", detail.getPPN_TRF().stripTrailingZeros().toPlainString());
                                totPungutan3 = totPungutan3.add(pungutan3).stripTrailingZeros();
                                totPungutan3 = totPungutan3.setScale(0, RoundingMode.HALF_EVEN);
                                break;
                            case 3:
                                pungutan4 = detail.getCIF().multiply(header.getNDPBM());
                                pungutan4 = pungutan4.add(pun1);
                                pungutan4 = pungutan4.multiply(detail.getPPNBM_TRF());
                                pungutan4 = pungutan4.divide(BigDecimal.valueOf(100));
                                pungutan4 = pungutan4.stripTrailingZeros();
                                pungutan4 = pungutan4.setScale(0, RoundingMode.HALF_EVEN);
                                XMLHandler.addNode(detPungutan, "NILAI", pungutan4.stripTrailingZeros().toPlainString());
                                XMLHandler.addNode(detPungutan, "TARIF", detail.getPPNBM_TRF().stripTrailingZeros().toPlainString());
                                totPungutan4 = totPungutan4.add(pungutan4).stripTrailingZeros();
                                totPungutan4 = totPungutan4.setScale(0, RoundingMode.HALF_EVEN);
                                break;
                        }
                        
                        
                        XMLHandler.addNode(detPungutan, "JNS_TARIF", detail.getJNS_TARIF());
                        XMLHandler.addNode(detPungutan, "KD_TARIF", detail.getJNS_TARIF());
                        XMLHandler.addNode(detPungutan, "JNS_TARIF", detail.getJNS_TARIF());
                        XMLHandler.addNode(detPungutan, "JML_SAT", String.valueOf(detail.getJML_SAT()));
                    }
                    
                    //remove the detail from list (if needed)
//                        listDataD.remove(detail);
                }
            }
            for (int i = 0; i < 4; i++) {
                Element pungutan = XMLHandler.addElement("PUNGUTAN_TOTAL", headerPungutan);
                XMLHandler.addNode(pungutan, "KD_PUNGUTAN", String.valueOf(i+1));
                switch (i) {
                    case 0:
                        XMLHandler.addNode(pungutan, "NILAI", totPungutan1.stripTrailingZeros().toPlainString());
                        break;
                    case 1:
                        XMLHandler.addNode(pungutan, "NILAI", totPungutan2.stripTrailingZeros().toPlainString());
                        break;
                    case 2:
                        XMLHandler.addNode(pungutan, "NILAI", totPungutan3.stripTrailingZeros().toPlainString());
                        break;
                    case 3:
                        XMLHandler.addNode(pungutan, "NILAI", totPungutan4.stripTrailingZeros().toPlainString());
                        break;
                }
            }
        }
        if (includeManifest) {
            XMLHandler.makeFile(pathToSave+"/DataPreno.xml");
        }else{
            XMLHandler.makeFile(pathToSave+".xml");
        }
    }
}

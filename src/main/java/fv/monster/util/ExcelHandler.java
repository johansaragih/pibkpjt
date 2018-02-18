package fv.monster.util;

import fv.monster.dto.DetailDataDto;
import fv.monster.dto.HeaderDataDto;
import fv.monster.model.DetailBarang;
import fv.monster.model.MasterBarang;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Johan Saragih
 */
public class ExcelHandler {

    private static MasterBarang masterBarang;
    private static DetailBarang detailBarang;
    private static Workbook workbook;
    public static boolean isCN = true;
    
    
    public static List<HeaderDataDto> process(String filePath) {
        try {
            workbook = new XSSFWorkbook(new FileInputStream(filePath));
            sort(workbook.getSheetAt(0), 22, 1);
            FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
            List<HeaderDataDto> lstHeaderData = createListHeader(workbook.getSheetAt(0), objFormulaEvaluator);
            
            return lstHeaderData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    private static void sort(Sheet sheet, int column, int rowStart) {
        boolean sorting = true;
        int lastRow = sheet.getLastRowNum();
        while (sorting == true) {
            sorting = false;
            for (Row row : sheet) {
                // skip if this row is before first to sort
                if (row.getRowNum() < rowStart) {
                    continue;
                }
                // end if this is last row
                if (lastRow == row.getRowNum()) {
                    break;
                }
                Row nextRow = sheet.getRow(row.getRowNum() + 1);
                if (nextRow == null) {
                    continue;
                }
                String firstValue = (row.getCell(column) != null) ? row.getCell(column).getStringCellValue() : "";
                String secondValue = (nextRow.getCell(column) != null) ? nextRow.getCell(column).getStringCellValue() : "";
                //compare cell from current row and next row - and switch if secondValue should be before first
                if (secondValue.compareToIgnoreCase(firstValue) < 0) {
                    sheet.shiftRows(nextRow.getRowNum(), nextRow.getRowNum(), -1);
                    sheet.shiftRows(row.getRowNum(), row.getRowNum(), 1);
                    sorting = true;
                }
            }
        }
    }

    private static List<HeaderDataDto> createListHeader(Sheet hSheet, FormulaEvaluator objFormulaEvaluator) {

        List<HeaderDataDto> listData = new ArrayList<>();
        Iterator<Row> rowIterator = hSheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            System.out.print(row.getRowNum());
            //add header data

            HeaderDataDto hData = new HeaderDataDto();
            System.out.println(getCellValue(row.getCell(0)));
            hData.setJNS_AJU((int) getCellValue(row.getCell(0)));
            if ((int) getCellValue(row.getCell(0)) != 1) {
                isCN = false;
            }
            hData.setKD_JNS_PIBK((int) getCellValue(row.getCell(1)));
            hData.setNO_BARANG(String.valueOf(getCellValue(row.getCell(2))).trim());
            hData.setKD_KANTOR(String.valueOf(getCellValue(row.getCell(3))));
            hData.setKD_JNS_ANGKUT((int) getCellValue(row.getCell(4)));
            hData.setNM_PENGANGKUT(String.valueOf(getCellValue(row.getCell(5))));
            hData.setNO_FLIGHT(String.valueOf(getCellValue(row.getCell(6))));
            hData.setKD_PEL_MUAT(String.valueOf(getCellValue(row.getCell(7))));
            hData.setKD_PEL_BONGKAR(String.valueOf(getCellValue(row.getCell(8))));
            hData.setKD_GUDANG(String.valueOf(getCellValue(row.getCell(9))));
            hData.setNO_INVOICE(checkCN(String.valueOf(getCellValue(row.getCell(10)))));
            hData.setTGL_INVOICE(checkCN(String.valueOf(getCellValue(row.getCell(11)))));
            hData.setKD_NEGARA_ASAL(String.valueOf(getCellValue(row.getCell(12))));
            hData.setJML_BRG((int) getCellValue(row.getCell(13)));

            if (String.valueOf(getCellValue(row.getCell(14))).equals("0")) {
                hData.setNO_BC11("");
            } else {
                hData.setNO_BC11(String.valueOf(getCellValue(row.getCell(14))).trim());
            }
            if (String.valueOf(getCellValue(row.getCell(15))).equals("0")) {
                hData.setTGL_BC11("");
            } else {
                hData.setTGL_BC11(String.valueOf(getCellValue(row.getCell(15))));
            }
            if (String.valueOf(getCellValue(row.getCell(16))).equals("0")) {
                hData.setNO_POS_BC11("");
            } else {
                hData.setNO_POS_BC11(String.valueOf(getCellValue(row.getCell(16))).trim());
            }
            if (String.valueOf(getCellValue(row.getCell(17))).equals("0")) {
                hData.setNO_SUBPOS_BC11("");
            } else {
                hData.setNO_SUBPOS_BC11(String.valueOf(getCellValue(row.getCell(17))).trim());
            }
            if (String.valueOf(getCellValue(row.getCell(18))).equals("0")) {
                hData.setNO_SUBSUBPOS_BC11("");
            } else {
                hData.setNO_SUBSUBPOS_BC11(String.valueOf(getCellValue(row.getCell(18))).trim());
            }
            if (String.valueOf(getCellValue(row.getCell(19))).equals("0")) {
                hData.setNO_MASTER_BLAWB("");
            } else {
                hData.setNO_MASTER_BLAWB(String.valueOf(getCellValue(row.getCell(19))).trim());
            }
            if (String.valueOf(getCellValue(row.getCell(20))).equals("0")) {
                hData.setTGL_MASTER_BLAWB("");
            } else {
                hData.setTGL_MASTER_BLAWB(String.valueOf(getCellValue(row.getCell(20))));
            }
            if (String.valueOf(getCellValue(row.getCell(21))).equals("0")) {
                hData.setNO_HOUSE_BLAWB("");
            } else {
                hData.setNO_HOUSE_BLAWB(String.valueOf(getCellValue(row.getCell(21))).trim());
            }
            if (String.valueOf(getCellValue(row.getCell(22))).equals("0")) {
                hData.setTGL_HOUSE_BLAWB("");
            } else {
                hData.setTGL_HOUSE_BLAWB(String.valueOf(getCellValue(row.getCell(22))));
            }

            hData.setKD_NEG_PENGIRIM(String.valueOf(getCellValue(row.getCell(23))));
            hData.setNM_PENGIRIM(String.valueOf(getCellValue(row.getCell(24))));
            hData.setAL_PENGIRIM(String.valueOf(getCellValue(row.getCell(25))));
            hData.setJNS_ID_PENERIMA(Integer.valueOf(String.valueOf(getCellValue(row.getCell(26)))));
            hData.setNO_ID_PENERIMA(String.valueOf(getCellValue(row.getCell(27))));
            hData.setNM_PENERIMA(String.valueOf(getCellValue(row.getCell(28))));
            hData.setAL_PENERIMA(String.valueOf(getCellValue(row.getCell(29))));

            if (String.valueOf(getCellValue(row.getCell(30))).equals("0")) {
                hData.setTELP_PENERIMA("");
            } else {
                hData.setTELP_PENERIMA(String.valueOf(getCellValue(row.getCell(30))));
            }

            hData.setJNS_ID_PEMBERITAHU((int) getCellValue(row.getCell(31)));
            hData.setNO_ID_PEMBERITAHU(String.valueOf(getCellValue(row.getCell(32))));
            hData.setNM_PEMBERITAHU(String.valueOf(getCellValue(row.getCell(33))));
            hData.setAL_PEMBERITAHU(String.valueOf(getCellValue(row.getCell(34))));
            hData.setNO_IZIN_PEMBERITAHU(String.valueOf(getCellValue(row.getCell(35))));
            hData.setTGL_IZIN_PEMBERITAHU(String.valueOf(getCellValue(row.getCell(36))));
            hData.setKD_VAL(String.valueOf(getCellValue(row.getCell(37))));
            hData.setNDPBM(setBDNilai((row.getCell(38)), objFormulaEvaluator));
            hData.setFOB(setBDNilai(row.getCell(39), objFormulaEvaluator));
            hData.setASURANSI(setBDNilai(row.getCell(40), objFormulaEvaluator));
            hData.setFREIGHT(setBDNilai(row.getCell(41), objFormulaEvaluator));
            hData.setCIF(setBDNilai(row.getCell(42), objFormulaEvaluator));
            hData.setNETTO(setBDNilai(row.getCell(43), objFormulaEvaluator));
            hData.setBRUTO(setBDNilai(row.getCell(44), objFormulaEvaluator));
            if (String.valueOf(getCellValue(row.getCell(45))).equals("0")) {
                hData.setTOT_DIBAYAR(BigDecimal.ZERO);
            } else {
                hData.setTOT_DIBAYAR(BigDecimal.valueOf(row.getCell(45).getNumericCellValue()));
            }

            hData.setNPWP_BILLING(String.valueOf(getCellValue(row.getCell(46))));
            if (String.valueOf(getCellValue(row.getCell(47))).equals("0")) {
                hData.setNAMA_BILLING("");
            } else {
                hData.setNAMA_BILLING(String.valueOf(getCellValue(row.getCell(47))));
            }

            if (String.valueOf(getCellValue(row.getCell(48))).equals("0")) {
                Date date = new Date();
                String tglTiba = new SimpleDateFormat("yyyyMMdd").format(date);
                hData.setTGL_TIBA(tglTiba);
            } else {
                hData.setTGL_TIBA(String.valueOf(getCellValue(row.getCell(48))).replaceAll("/", ""));
            }
            DataFormatter dfr = new DataFormatter();

            if (String.valueOf(dfr.formatCellValue(row.getCell(49))).equals("0")) {
                System.out.println(String.valueOf(getCellValue(row.getCell(49))));
                DateFormat df = new SimpleDateFormat("HHmmss");
                String jamTiba = df.format(new Date().toString());
                hData.setJAM_TIBA(jamTiba);
            } else {
                hData.setJAM_TIBA(String.valueOf(getCellValue(row.getCell(49))).replaceAll(":", ""));
            }
            if (String.valueOf(getCellValue(row.getCell(50))).equals("0")) {
                hData.setPART_SHIPMENT("0");
            } else {
                hData.setPART_SHIPMENT(String.valueOf(getCellValue(row.getCell(50))));
            }
            if (String.valueOf(getCellValue(row.getCell(51))).equals("0")) {
                hData.setKD_PEL_TRANSIT(" ");
            } else {
                hData.setKD_PEL_TRANSIT(String.valueOf(getCellValue(row.getCell(51))));
            }
            if (String.valueOf(getCellValue(row.getCell(52))).equals("0")) {
                hData.setKD_PEL_AKHIR(" ");
            } else {
                hData.setKD_PEL_AKHIR(String.valueOf(getCellValue(row.getCell(52))));
            }
//            if (String.valueOf(getCellValue(row.getCell(53))).equals("0")) {
//                hData.setVOLUME(0);
//            }else{
//                System.out.println(getCellValue(row.getCell(53)));
//                hData.setVOLUME(setBDNilai(row.getCell(53), objFormulaEvaluator));
//            }
            hData.setVOLUME(setBDNilai(row.getCell(53), objFormulaEvaluator));
            if (String.valueOf(getCellValue(row.getCell(54))).equals("0")) {
                hData.setKD_KMS("PK");
            } else {
                hData.setKD_KMS(String.valueOf(getCellValue(row.getCell(54))).substring(0, 2));
            }
            if (String.valueOf(getCellValue(row.getCell(55))).equals("0")) {
                hData.setTOTAL_PARTIAL(0);
            } else {
                hData.setTOTAL_PARTIAL((int) getCellValue(row.getCell(55)));
            }
            if (String.valueOf(getCellValue(row.getCell(56))).equals("0")) {
                hData.setMARKING(" ");
            } else {
                hData.setMARKING(String.valueOf(getCellValue(row.getCell(57))));
            }
            hData.setDetails(createListDetail(hSheet, objFormulaEvaluator));
            listData.add(hData);
        }

        return listData;
    }

    private static List<DetailDataDto> createListDetail(Sheet dSheet, FormulaEvaluator objFormulaEvaluator) {
        List<DetailDataDto> listData = new ArrayList<>();
        Iterator<Row> rowIterator = dSheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            //add detail data
            DetailDataDto dData = new DetailDataDto();
            dData.setNO_HOUSE_BLAWB(String.valueOf(getCellValue(row.getCell(0))));
            dData.setSERI_BRG(String.valueOf(getCellValue(row.getCell(1))));
            if (String.valueOf(getCellValue(row.getCell(2))).equals("0")) {
                dData.setHS_CODE("");
            } else {
                dData.setHS_CODE(String.valueOf(getCellValue(row.getCell(2))));
            }

            dData.setUR_BRG(String.valueOf(getCellValue(row.getCell(3))));
            dData.setKD_NEG_ASAL(String.valueOf(getCellValue(row.getCell(4))));
            if (String.valueOf(getCellValue(row.getCell(5))).equals("0")) {
                dData.setJML_KMS(0);
            } else {
                dData.setJML_KMS((int) getCellValue(row.getCell(5)));
            }

            if (String.valueOf(getCellValue(row.getCell(6))).equals("0")) {
                dData.setJNS_KMS("");
            } else {
                dData.setJNS_KMS(String.valueOf(getCellValue(row.getCell(6))));
            }
//            System.out.println(dData.getNO_HOUSE_BLAWB() + " HS "+ dData.getHS_CODE());
//            dData.setCIF(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()));
            dData.setCIF(setBDNilai(row.getCell(7), objFormulaEvaluator));

            dData.setKD_SAT_HRG(String.valueOf(getCellValue(row.getCell(8))));
            if (String.valueOf(getCellValue(row.getCell(9))).equals("0")) {
                dData.setJML_SAT_HRG(0);
            } else {
                dData.setJML_SAT_HRG((int) getCellValue(row.getCell(9)));
            }

            dData.setFL_BEBAS(String.valueOf(getCellValue(row.getCell(10))));
            if (String.valueOf(getCellValue(row.getCell(11))).equals("0")) {
                dData.setNO_SKEP("");
            } else {
                dData.setNO_SKEP(String.valueOf(getCellValue(row.getCell(11))));
            }
            if (String.valueOf(getCellValue(row.getCell(12))).equals("0")) {
                dData.setTGL_SKEP("");
            } else {
                dData.setTGL_SKEP(String.valueOf(getCellValue(row.getCell(12))));
            }

            dData.setJNS_TARIF(String.valueOf(getCellValue(row.getCell(13))));
            dData.setKD_TARIF(String.valueOf(getCellValue(row.getCell(14))));
            dData.setKD_SAT_TARIF(String.valueOf(getCellValue(row.getCell(15))));
            if (String.valueOf(getCellValue(row.getCell(16))).equals("0")) {
                dData.setJML_SAT(0);
            } else {
                dData.setJML_SAT((int) getCellValue(row.getCell(16)));
            }

            System.out.println(dData.getNO_HOUSE_BLAWB());
            dData.setBM_TRF(setBDNilai(row.getCell(17), objFormulaEvaluator));
            dData.setPPH_TRF(setBDNilai(row.getCell(18), objFormulaEvaluator));
            dData.setPPN_TRF(setBDNilai(row.getCell(19), objFormulaEvaluator));
            dData.setPPNBM_TRF(setBDNilai(row.getCell(20), objFormulaEvaluator));
//            System.out.println("CIF="+dData.getCIF());

            dData.setBM(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()).multiply(BigDecimal.valueOf(row.getCell(17).getNumericCellValue())).divide(new BigDecimal(100)));
            dData.setPPH(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()).multiply(BigDecimal.valueOf(row.getCell(18).getNumericCellValue())).divide(new BigDecimal(100)));
            dData.setPPN(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()).multiply(BigDecimal.valueOf(row.getCell(19).getNumericCellValue())).divide(new BigDecimal(100)));
            dData.setPPNBM(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()).multiply(BigDecimal.valueOf(row.getCell(20).getNumericCellValue())).divide(new BigDecimal(100)));
            listData.add(dData);
        }

        return listData;
    }

//    private static List<MasterBarang> readMaster(Sheet sheet) {
//        Iterator<Row> rowIterator = sheet.iterator();
//        List<MasterBarang> lstMasterBarang = new ArrayList<>();
//        while (rowIterator.hasNext()) {
//            Row currentRow = rowIterator.next();
//            if (currentRow.getRowNum() != 0) {
//                masterBarang = new MasterBarang();
//                masterBarang.setId(new Long(System.currentTimeMillis() * 1000));
//                masterBarang.setJenisAJU(getCellValue(currentRow.getCell(0)).toString());
//                masterBarang.setKodeJenisPIBK(getCellValue(currentRow.getCell(1)).toString());
//                masterBarang.setNomorBarang(getCellValue(currentRow.getCell(2)).toString());
//                masterBarang.setKodeKantor(getCellValue(currentRow.getCell(3)).toString());
//                masterBarang.setKodeJenisAngkut(getCellValue(currentRow.getCell(4)).toString());
//                masterBarang.setNamaPengangkut(getCellValue(currentRow.getCell(5)).toString());
//                masterBarang.setNomorFlight(getCellValue(currentRow.getCell(6)).toString());
//                masterBarang.setKodePelabuhanMuat(getCellValue(currentRow.getCell(7)).toString());
//                masterBarang.setKodePelabuhanBongkar(getCellValue(currentRow.getCell(8)).toString());
//                masterBarang.setKodeGudangAsal(getCellValue(currentRow.getCell(9)).toString());
//                masterBarang.setNomorInvoice(getCellValue(currentRow.getCell(10)).toString());
//                masterBarang.setTanggalInvoice(getCellValue(currentRow.getCell(11)).toString());
//                masterBarang.setKodeNegaraAsal(getCellValue(currentRow.getCell(12)).toString());
//                masterBarang.setJumlahBarang(getCellValue(currentRow.getCell(13)).toString());
//                masterBarang.setNomorDokumenBC11(getCellValue(currentRow.getCell(14)).toString());
//                masterBarang.setTanggalDokumenBC11(getCellValue(currentRow.getCell(15)).toString());
//                masterBarang.setNomorPosBC11(getCellValue(currentRow.getCell(16)).toString());
//                masterBarang.setNomorSubPosBC11(getCellValue(currentRow.getCell(17)).toString());
//                masterBarang.setNomorSubSubPosBC11(getCellValue(currentRow.getCell(18)).toString());
//                masterBarang.setNomorMasterBLAWB(getCellValue(currentRow.getCell(19)).toString());
//                masterBarang.setTanggalMasterBLAWB(getCellValue(currentRow.getCell(20)).toString());
//                masterBarang.setNomorHouseBLAWB(getCellValue(currentRow.getCell(21)).toString());
//                masterBarang.setTanggalHouseBLAWB(getCellValue(currentRow.getCell(22)).toString());
//                masterBarang.setKodeNegaraPengirim(getCellValue(currentRow.getCell(23)).toString());
//                masterBarang.setNamaPengirim(getCellValue(currentRow.getCell(24)).toString());
//                masterBarang.setAlamatPengirim(getCellValue(currentRow.getCell(25)).toString());
//                masterBarang.setJenisIDPenerima(getCellValue(currentRow.getCell(26)).toString());
//                masterBarang.setNomorIDPenerima(getCellValue(currentRow.getCell(27)).toString());
//                masterBarang.setNamaPenerima(getCellValue(currentRow.getCell(28)).toString());
//                masterBarang.setAlamatPenerima(getCellValue(currentRow.getCell(29)).toString());
//                masterBarang.setTeleponPenerima(getCellValue(currentRow.getCell(30)).toString());
//                masterBarang.setJenisIDPemberitahu(getCellValue(currentRow.getCell(31)).toString());
//                masterBarang.setNomorIDPemberitahu(getCellValue(currentRow.getCell(32)).toString());
//                masterBarang.setNamaPemberitahu(getCellValue(currentRow.getCell(33)).toString());
//                masterBarang.setNomorIzinPemberitahu(getCellValue(currentRow.getCell(34)).toString());
//                masterBarang.setTanggalIzinPemberitahu(getCellValue(currentRow.getCell(35)).toString());
//                masterBarang.setKodeValutaAsing(getCellValue(currentRow.getCell(36)).toString());
//                masterBarang.setNDPBM(getCellValue(currentRow.getCell(37)).toString());
//                masterBarang.setNilaiTotalFOB(getCellValue(currentRow.getCell(38)).toString());
//                masterBarang.setNilaiAsuransi(getCellValue(currentRow.getCell(39)).toString());
//                masterBarang.setNilaiFreight(getCellValue(currentRow.getCell(40)).toString());
//                masterBarang.setNilaiTotalCIF(getCellValue(currentRow.getCell(41)).toString());
//                masterBarang.setJumlahBeratNetto(getCellValue(currentRow.getCell(42)).toString());
//                masterBarang.setJumlahBeratBrutto(getCellValue(currentRow.getCell(43)).toString());
//                masterBarang.setTotalDibayar(getCellValue(currentRow.getCell(44)).toString());
//                masterBarang.setNpwpBilling(getCellValue(currentRow.getCell(45)).toString());
//                masterBarang.setNamaBilling(getCellValue(currentRow.getCell(46)).toString());
//                masterBarang.setTanggalTiba(getCellValue(currentRow.getCell(47)).toString());
//                masterBarang.setJamTiba(getCellValue(currentRow.getCell(48)).toString());
//                masterBarang.setPartShipment(getCellValue(currentRow.getCell(49)).toString());
//                masterBarang.setKodePelabuhanTransit(getCellValue(currentRow.getCell(50)).toString());
//                masterBarang.setKodePelabuhanAkhir(getCellValue(currentRow.getCell(51)).toString());
//                masterBarang.setVolume(getCellValue(currentRow.getCell(52)).toString());
//                masterBarang.setJenisKemasan(getCellValue(currentRow.getCell(53)).toString());
//                masterBarang.setTotalPartial(getCellValue(currentRow.getCell(54)).toString());
//                masterBarang.setMarking(getCellValue(currentRow.getCell(55)).toString());
//                masterBarang.setDetailBarang(readDetail(workbook.getSheetAt(1), masterBarang.getNomorHouseBLAWB()));
//                lstMasterBarang.add(masterBarang);
//
//            }
//        }
//        return lstMasterBarang;
//    }
//
//    private static List<DetailBarang> readDetail(Sheet sheet,String nomorHouseBLAWB) {
//        Iterator<Row> rowIterator = sheet.iterator();
//        List<DetailBarang> lstDetailBarang = new ArrayList<>();
//        while (rowIterator.hasNext()) {
//            Row currentRow = rowIterator.next();
//            if (currentRow.getRowNum() != 0) {
//                String _nomorHouseBLAWB = getCellValue(currentRow.getCell(0)).toString();
//                boolean isSame = getCellValue(currentRow.getCell(0)).toString().equals(nomorHouseBLAWB);
//                if (getCellValue(currentRow.getCell(0)).toString().equals(nomorHouseBLAWB)) {
//                    detailBarang = new DetailBarang();
//                    detailBarang.setId(new Long(System.currentTimeMillis() * 1000));
//                    detailBarang.setNomorHouseBLAWB(getCellValue(currentRow.getCell(0)).toString());
//                    detailBarang.setSeriBarang(getCellValue(currentRow.getCell(1)).toString());
//                    detailBarang.setHsCode(getCellValue(currentRow.getCell(2)).toString());
//                    detailBarang.setUraianBarang(getCellValue(currentRow.getCell(3)).toString());
//                    detailBarang.setKodeNegaraAsal(getCellValue(currentRow.getCell(4)).toString());
//                    detailBarang.setJumlahKemasan(getCellValue(currentRow.getCell(5)).toString());
//                    detailBarang.setJenisKemasan(getCellValue(currentRow.getCell(6)).toString());
//                    detailBarang.setCIF(getCellValue(currentRow.getCell(7)).toString());
//                    detailBarang.setKodeSatuanHarga(getCellValue(currentRow.getCell(8)).toString());
//                    detailBarang.setJumlahSatuanHarga(getCellValue(currentRow.getCell(9)).toString());
//                    detailBarang.setFlagPembebasan(getCellValue(currentRow.getCell(10)).toString());
//                    detailBarang.setNomorSKEPembebasan(getCellValue(currentRow.getCell(11)).toString());
//                    detailBarang.setTanggalSKEPPembebasan(getCellValue(currentRow.getCell(12)).toString());
//                    detailBarang.setJenisTarif(getCellValue(currentRow.getCell(13)).toString());
//                    detailBarang.setKodeTarif(getCellValue(currentRow.getCell(14)).toString());
//                    detailBarang.setKodeSatuanTarif(getCellValue(currentRow.getCell(15)).toString());
//                    detailBarang.setJumlahSatuanTarif(getCellValue(currentRow.getCell(16)).toString());
//                    detailBarang.setBeaMasukTarif(getCellValue(currentRow.getCell(17)).toString());
//                    detailBarang.setPajakPenghasilanTarif(getCellValue(currentRow.getCell(18)).toString());
//                    detailBarang.setPajakPertambahanNilaiTarif(getCellValue(currentRow.getCell(19)).toString());
//                    detailBarang.setPajakPertambahanNilaiBarangMewahTarif(getCellValue(currentRow.getCell(20)).toString());
//                    lstDetailBarang.add(detailBarang);
//                }
//            }
//        }
//        return lstDetailBarang;
//    }
    private static Object getCellValue(Cell cell) {
        Object obj;
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            obj = "0";
        } else if (cell.getCellType() == Cell.CELL_TYPE_STRING && cell.getStringCellValue().isEmpty()) {
            obj = "0";
        } else {
            if (cell.getCellType() == 0) {
                obj = (int) cell.getNumericCellValue();
            } else {
                obj = cell.getStringCellValue();
            }
        }
        return obj;
    }

    private static BigDecimal setBDNilai(Cell cell, FormulaEvaluator objFormulaEvaluator) {
        Cell fobMy = cell;
        DataFormatter df = new DataFormatter();
        objFormulaEvaluator.evaluate(fobMy);
        String s = df.formatCellValue(fobMy, objFormulaEvaluator);
        if (s.equals("0")) {
            return new BigDecimal(BigDecimal.ZERO.stripTrailingZeros().toPlainString());
        } else {
            return new BigDecimal(s.replaceAll(",", "."));
        }
    }

    private static String checkCN(String inp){
        String ret ="";
        if (isCN) {
            if (inp.equals("0")) {
                ret ="";
            }else{
                ret = inp;
            }
        }else{
            ret = inp;
        }
        return ret;
    }

    public static void main(String[] args) {
//        ExcelHandler.process("C:\\Users\\Johan Saragih\\Downloads\\Data Contoh.xlsx");
    }
}

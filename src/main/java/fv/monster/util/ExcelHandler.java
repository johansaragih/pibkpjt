package fv.monster.util;

import fv.monster.model.DetailBarang;
import fv.monster.model.MasterBarang;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Johan Saragih
 */
public class ExcelHandler {

    private static MasterBarang masterBarang;
    private static DetailBarang detailBarang;
    private static Workbook workbook;
    public static List<MasterBarang> process(String filePath) {
        try {
            workbook = new XSSFWorkbook(new FileInputStream(filePath));
            sort(workbook.getSheetAt(0), 22, 1);
            List<MasterBarang> lstMasterBarang = readMaster(workbook.getSheetAt(0));
            return lstMasterBarang;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public static void sort(Sheet sheet, int column, int rowStart) {
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

    private static List<MasterBarang> readMaster(Sheet sheet) {
        Iterator<Row> rowIterator = sheet.iterator();
        List<MasterBarang> lstMasterBarang = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            if (currentRow.getRowNum() != 0) {
                masterBarang = new MasterBarang();
                masterBarang.setId(new Long(System.currentTimeMillis() * 1000));
                masterBarang.setJenisAJU(getCellValue(currentRow.getCell(0)).toString());
                masterBarang.setKodeJenisPIBK(getCellValue(currentRow.getCell(1)).toString());
                masterBarang.setNomorBarang(getCellValue(currentRow.getCell(2)).toString());
                masterBarang.setKodeKantor(getCellValue(currentRow.getCell(3)).toString());
                masterBarang.setKodeJenisAngkut(getCellValue(currentRow.getCell(4)).toString());
                masterBarang.setNamaPengangkut(getCellValue(currentRow.getCell(5)).toString());
                masterBarang.setNomorFlight(getCellValue(currentRow.getCell(6)).toString());
                masterBarang.setKodePelabuhanMuat(getCellValue(currentRow.getCell(7)).toString());
                masterBarang.setKodePelabuhanBongkar(getCellValue(currentRow.getCell(8)).toString());
                masterBarang.setKodeGudangAsal(getCellValue(currentRow.getCell(9)).toString());
                masterBarang.setNomorInvoice(getCellValue(currentRow.getCell(10)).toString());
                masterBarang.setTanggalInvoice(getCellValue(currentRow.getCell(11)).toString());
                masterBarang.setKodeNegaraAsal(getCellValue(currentRow.getCell(12)).toString());
                masterBarang.setJumlahBarang(getCellValue(currentRow.getCell(13)).toString());
                masterBarang.setNomorDokumenBC11(getCellValue(currentRow.getCell(14)).toString());
                masterBarang.setTanggalDokumenBC11(getCellValue(currentRow.getCell(15)).toString());
                masterBarang.setNomorPosBC11(getCellValue(currentRow.getCell(16)).toString());
                masterBarang.setNomorSubPosBC11(getCellValue(currentRow.getCell(17)).toString());
                masterBarang.setNomorSubSubPosBC11(getCellValue(currentRow.getCell(18)).toString());
                masterBarang.setNomorMasterBLAWB(getCellValue(currentRow.getCell(19)).toString());
                masterBarang.setTanggalMasterBLAWB(getCellValue(currentRow.getCell(20)).toString());
                masterBarang.setNomorHouseBLAWB(getCellValue(currentRow.getCell(21)).toString());
                masterBarang.setTanggalHouseBLAWB(getCellValue(currentRow.getCell(22)).toString());
                masterBarang.setKodeNegaraPengirim(getCellValue(currentRow.getCell(23)).toString());
                masterBarang.setNamaPengirim(getCellValue(currentRow.getCell(24)).toString());
                masterBarang.setAlamatPengirim(getCellValue(currentRow.getCell(25)).toString());
                masterBarang.setJenisIDPenerima(getCellValue(currentRow.getCell(26)).toString());
                masterBarang.setNomorIDPenerima(getCellValue(currentRow.getCell(27)).toString());
                masterBarang.setNamaPenerima(getCellValue(currentRow.getCell(28)).toString());
                masterBarang.setAlamatPenerima(getCellValue(currentRow.getCell(29)).toString());
                masterBarang.setTeleponPenerima(getCellValue(currentRow.getCell(30)).toString());
                masterBarang.setJenisIDPemberitahu(getCellValue(currentRow.getCell(31)).toString());
                masterBarang.setNomorIDPemberitahu(getCellValue(currentRow.getCell(32)).toString());
                masterBarang.setNamaPemberitahu(getCellValue(currentRow.getCell(33)).toString());
                masterBarang.setNomorIzinPemberitahu(getCellValue(currentRow.getCell(34)).toString());
                masterBarang.setTanggalIzinPemberitahu(getCellValue(currentRow.getCell(35)).toString());
                masterBarang.setKodeValutaAsing(getCellValue(currentRow.getCell(36)).toString());
                masterBarang.setNDPBM(getCellValue(currentRow.getCell(37)).toString());
                masterBarang.setNilaiTotalFOB(getCellValue(currentRow.getCell(38)).toString());
                masterBarang.setNilaiAsuransi(getCellValue(currentRow.getCell(39)).toString());
                masterBarang.setNilaiFreight(getCellValue(currentRow.getCell(40)).toString());
                masterBarang.setNilaiTotalCIF(getCellValue(currentRow.getCell(41)).toString());
                masterBarang.setJumlahBeratNetto(getCellValue(currentRow.getCell(42)).toString());
                masterBarang.setJumlahBeratBrutto(getCellValue(currentRow.getCell(43)).toString());
                masterBarang.setTotalDibayar(getCellValue(currentRow.getCell(44)).toString());
                masterBarang.setNpwpBilling(getCellValue(currentRow.getCell(45)).toString());
                masterBarang.setNamaBilling(getCellValue(currentRow.getCell(46)).toString());
                masterBarang.setTanggalTiba(getCellValue(currentRow.getCell(47)).toString());
                masterBarang.setJamTiba(getCellValue(currentRow.getCell(48)).toString());
                masterBarang.setPartShipment(getCellValue(currentRow.getCell(49)).toString());
                masterBarang.setKodePelabuhanTransit(getCellValue(currentRow.getCell(50)).toString());
                masterBarang.setKodePelabuhanAkhir(getCellValue(currentRow.getCell(51)).toString());
                masterBarang.setVolume(getCellValue(currentRow.getCell(52)).toString());
                masterBarang.setJenisKemasan(getCellValue(currentRow.getCell(53)).toString());
                masterBarang.setTotalPartial(getCellValue(currentRow.getCell(54)).toString());
                masterBarang.setMarking(getCellValue(currentRow.getCell(55)).toString());
                masterBarang.setDetailBarang(readDetail(workbook.getSheetAt(1), masterBarang.getNomorHouseBLAWB()));
                lstMasterBarang.add(masterBarang);

            }
        }
        return lstMasterBarang;
    }

    private static List<DetailBarang> readDetail(Sheet sheet,String nomorHouseBLAWB) {
        Iterator<Row> rowIterator = sheet.iterator();
        List<DetailBarang> lstDetailBarang = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row currentRow = rowIterator.next();
            if (currentRow.getRowNum() != 0) {
                String _nomorHouseBLAWB = getCellValue(currentRow.getCell(0)).toString();
                boolean isSame = getCellValue(currentRow.getCell(0)).toString().equals(nomorHouseBLAWB);
                if (getCellValue(currentRow.getCell(0)).toString().equals(nomorHouseBLAWB)) {
                    detailBarang = new DetailBarang();
                    detailBarang.setId(new Long(System.currentTimeMillis() * 1000));
                    detailBarang.setNomorHouseBLAWB(getCellValue(currentRow.getCell(0)).toString());
                    detailBarang.setSeriBarang(getCellValue(currentRow.getCell(1)).toString());
                    detailBarang.setHsCode(getCellValue(currentRow.getCell(2)).toString());
                    detailBarang.setUraianBarang(getCellValue(currentRow.getCell(3)).toString());
                    detailBarang.setKodeNegaraAsal(getCellValue(currentRow.getCell(4)).toString());
                    detailBarang.setJumlahKemasan(getCellValue(currentRow.getCell(5)).toString());
                    detailBarang.setJenisKemasan(getCellValue(currentRow.getCell(6)).toString());
                    detailBarang.setCIF(getCellValue(currentRow.getCell(7)).toString());
                    detailBarang.setKodeSatuanHarga(getCellValue(currentRow.getCell(8)).toString());
                    detailBarang.setJumlahSatuanHarga(getCellValue(currentRow.getCell(9)).toString());
                    detailBarang.setFlagPembebasan(getCellValue(currentRow.getCell(10)).toString());
                    detailBarang.setNomorSKEPembebasan(getCellValue(currentRow.getCell(11)).toString());
                    detailBarang.setTanggalSKEPPembebasan(getCellValue(currentRow.getCell(12)).toString());
                    detailBarang.setJenisTarif(getCellValue(currentRow.getCell(13)).toString());
                    detailBarang.setKodeTarif(getCellValue(currentRow.getCell(14)).toString());
                    detailBarang.setKodeSatuanTarif(getCellValue(currentRow.getCell(15)).toString());
                    detailBarang.setJumlahSatuanTarif(getCellValue(currentRow.getCell(16)).toString());
                    detailBarang.setBeaMasukTarif(getCellValue(currentRow.getCell(17)).toString());
                    detailBarang.setPajakPenghasilanTarif(getCellValue(currentRow.getCell(18)).toString());
                    detailBarang.setPajakPertambahanNilaiTarif(getCellValue(currentRow.getCell(19)).toString());
                    detailBarang.setPajakPertambahanNilaiBarangMewahTarif(getCellValue(currentRow.getCell(20)).toString());
                    lstDetailBarang.add(detailBarang);
                }
            }
        }
        return lstDetailBarang;
    }

    public static Object getCellValue(Cell cell) {
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

    public static void main(String[] args) {
//        ExcelHandler.process("C:\\Users\\Johan Saragih\\Downloads\\Data Contoh.xlsx");
    }
}
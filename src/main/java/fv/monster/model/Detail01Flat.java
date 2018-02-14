/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fv.monster.model;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class Detail01Flat {
    public static String RECORDLABLE= "DTL01";
    public static String MANIFESTGROUPCODE= "01I";
    public static String FILLER= " ";
    public static String FILLER2= "  ";
//    private String manifestGroupCode;
    private String posNumber;
    private String subPos;
    private String flagOfConsolidation;
    private String flagPartialShipment;
//    private String filler;
    private String portOfOrigin;
    private String portOfLastTransit;
    private String portOfDischarge;
    private String finalDestinationPort;
    private String motherVessel;
    private String motherVesselCallsign;
    private String BLAWBNumber;
    private String BLAWBIssueDate;
    private String MasterBLAWBNumber;
    private String MasterBLAWBIssueDate;
//    private String filler2;
    private String bruto;
    private String volume;
    private String numberOfContainerLoaded;
    private String numberOfPackagesLoaded;
    private String numberOfContainerMaster;
    private String numberOfPackagesMaster;
    private String totalContainerPartial;
    private String totalPackagePartial;
    private String packagingCode;
    
    private List<Detail02Flat> dtl02;
}

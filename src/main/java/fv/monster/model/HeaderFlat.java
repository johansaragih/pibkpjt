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
public class HeaderFlat {
    public static String RECORDLABLE= "HDR01";
    public static String MESSAGEFUNCTIONCODE= "1";
    public static String CODETRANSPORTATIONTOOL= "2";//1=vessel;2=aircraft;3=land;
    public static String MANIFESTTYPE= "IA";//IA = Inward Manifest Udara;IS = Inward manifest Laut;OA = Outward Manifest Udata;OS = Outward Manifest Laut;
    public static String FILLER= "   ";//IA = Inward Manifest Udara;IS = Inward manifest Laut;OA = Outward Manifest Udata;OS = Outward Manifest Laut;
    
//    private String messageFunctionCode;
//    private String codeTransportationTool;
//    private String manifestType;
    private String aircraftName;
    private String callsign;
    private String flag;
    private String flightNo;
//    private String filler;
    private String portOfOrigin;
    private String portOfLastTransit;
    private String portOfDischarge;
    private String nextPortToCall;
    private String arrivingDate;
    private String arrivingTime;
    
    public static String VERSIONNUMBER= "V99";
    public static String APPLICATIONVERSION= "MEM31";
//    private String versionNumber;
//    private String applicationVersion;
    private String masterAwb;
    
    private List<Detail01Flat> dtl01;
}

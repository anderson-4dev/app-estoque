package Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson_dev
 */
public class DataHora {

    /**
     * String Data e hora atual padrão do banco de dados mysql
     */
    public static String CURRENT_DATE_TIME_STRING = getDateTimeString();

    /**
     * String Data do dia padrâo do banco de dados
     */
    public static String CURRENT_DATE_STRING = getDateDataBase();
    
    /**
     * String Data atual padrão BR
     */
    public static String CURRENT_DATE_STRING_BR = setFormat("dd/MM/yyyy").format(new Date());
    
    
    /**
     * Retorna data e hora padrão database yyyy-MM-dd HH:mm:ss
     * @return String
     */
    private static String getDateTimeString() {
        return setFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private static String getDateDataBase() {
        return setFormat("yyyy-MM-dd").format(new Date());
    }

    public static SimpleDateFormat setFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * Passa Date para o padrão do banco de dados
     */
    public static String parseDateToStringDataBase(Date data) {
        return setFormat("yyyy-MM-dd").format(data);
    }
    
    /**
     * Passa Date java para padrão dd/MM/yyyy
     * @param data
     * @return data
     */
    public static String parseDateToDateBr(Date data){
        return setFormat("dd/MM/yyyy").format(data);
    }
    
    /**
     * Passa String date dd/MM/yyyy para 
     * @param data
     * @return String yyyy-MM-dd
     */
    public static String parseDateStringBrToDateDataBase(String data){
        return parseDateToStringDataBase(parseStringToDate(data));
    }

    /**
     * Transforma String data dd/MM/yyyy em Date
     *
     * @param data
     * @return Date
     */
    public static Date parseStringToDate(String data) {
        try {
            return setFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
            System.out.println("erro ao converter string em Date " + ex);
            Logger.getLogger(DataHora.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Date();
    }

    public static void main(String[] args) {

    }
    /**
     * Transforma string 2022-05-24 20:23:27.0
     * em 24/05/2022 - 20:23
     * 
     * 
     * @param registro
     * @return 
     */
    public static String fomartStringDateTime(String registro) {
        
        try {
            Date d = setFormat("yyyy-MM-dd HH:mm:ss").parse(registro);
            
            return setFormat("dd/MM/yyyy - HH:mm").format(d);
            
        } catch (ParseException ex) {
            Logger.getLogger(DataHora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

}

package Helpers;

import java.text.DecimalFormat;

/**
 *
 * @author Anderson_dev
 */
public class FormatNumber {
    
    /**
     * Formata um numero double para o padrão de moeda
     * Padrão do sistema do tem que ser BR.
     * 
     * @param valor
     * @return Ex.125.49 -> 125,49 ou 1457.99 -> 1.457,99
     */
    public static String formatDouble (Double valor){
        return new DecimalFormat("#,##0.00##").format(valor);//#,##0.00##
    }
    
    /**
     * Converte a virgula de uma String em ponto
     * @param pString
     * @return double
     */
    public static Double convertVirgulaParaPonto(String pString){

        pString = pString.replace(".", "");

        return Double.parseDouble(pString.replace(",", "."));
    }
    
    public static String clearFormatedNumber(String nString){
        nString = nString.replace(".", "");
        return  nString.replace(",", ".");
    }
    
    
    /**
     * Converte a ponto de uma String em virgula
     * @param pString
     * @return String
     */
    public static String convertPontoParaVirgula(String pString){

        pString = pString.replace(",", "-"); //1,250.25 * 1-250.25
        pString = pString.replace(".", ","); //1-250.25 * 1-250,25

        return pString.replace("-", ".");//1.250,25
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.intro.readers;
import edu.escuelaing.arem.intro.structures.LinkedListG;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
/**
 *
 * @author J. Eduardo Arias
 */
public class FileReaderColumns {   
    private int ncolumns;
    private List<List<Double>> data;
    
    /**
     * Inicializa una lista de listas basado en una cantidad de columnas
     * @param ncolumns columnas requeridas
     */
    public FileReaderColumns(int ncolumns) {
        this.ncolumns=ncolumns;
        data=new LinkedListG<>();    
        for (int i=1; i<=ncolumns;i++)
            data.add(new LinkedListG<>());      
    }  
    
    /**
     * Lee y guarda en "data" los datos de las columnas.
     * @param file archivo que tiene los datos
     * @throws Exception 
     */
    public void read(Path file) throws Exception {      
        Charset charset = Charset.forName("UTF-8");                                 
        try {
            BufferedReader BR = Files.newBufferedReader(file, charset);
            String linea= BR.readLine();
            while (linea != null) {  
                int j=0;
                String[] tmp = linea.split(" "); 
                for (List<Double> col:data){
                    col.add(Double.parseDouble(tmp[j]));
                    j++;
                }
                linea= BR.readLine();
            }                     
        } catch (IOException ex) {
            throw new Exception("Error leyendo el archivo, revise la ruta"); 
        }        
    }    
    
    public int getNcolumns() {
        return ncolumns;
    }

    public void setNcolumns(int ncolumns) {
        this.ncolumns = ncolumns;
    }

    /**
     * @return cada lista contenida es una columna.
     */
    public List<List<Double>> getData() {
        return data;
    }

    public void setData(List<List<Double>> data) {
        this.data = data;
    }
    
}

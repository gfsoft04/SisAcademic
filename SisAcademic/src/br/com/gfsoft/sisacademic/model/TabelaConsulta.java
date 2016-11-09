package br.com.gfsoft.sisacademic.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TabelaConsulta extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;

    public TabelaConsulta(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    public ArrayList getLinhas() {
        return linhas;
    }
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    public Object getValueAt(int numLin, int numCol){
        Object[] linhas = (Object[])getLinhas().get(numLin);
        return linhas[numCol];
    }
}
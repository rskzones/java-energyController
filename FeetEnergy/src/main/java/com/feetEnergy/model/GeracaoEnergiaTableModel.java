package com.feetEnergy.model;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



public class GeracaoEnergiaTableModel extends AbstractTableModel {
	
	//aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
	
    private String colunas[] = {"data", "gerado", "tempo", "porcentagem"};
    private ArrayList<GeracaoEnergia> geracaoEnergia;
    private final int COL_DATA = 0;
    private final int COL_GERADO = 1;
    private final int COL_TEMPO = 2;
    private final int COL_PORCENTAGEM = 3;

    public GeracaoEnergiaTableModel(ArrayList<GeracaoEnergia> geracaoEnergia) {
        this.geracaoEnergia = geracaoEnergia;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return geracaoEnergia.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COL_DATA:
                return Date.class;
            case COL_GERADO:
                return Integer.class;
            case COL_TEMPO:
                return Integer.class;
            case COL_PORCENTAGEM:
                return Integer.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GeracaoEnergia geracaoEn = this.geracaoEnergia.get(rowIndex);

        switch (columnIndex) {
            case COL_DATA:
                return geracaoEn.getData();
            case COL_GERADO:
                return geracaoEn.getGerado();
            case COL_TEMPO:
                return geracaoEn.getTempo();
            case COL_PORCENTAGEM:
                return geracaoEn.getPorcentagem();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    	//o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
    	
    	GeracaoEnergia geracaoEn = this.geracaoEnergia.get(rowIndex);
        
    	//de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        
    	switch (columnIndex) {
            case COL_DATA:
            	geracaoEn.setData((Date)aValue);
                break;
            case COL_GERADO:
            	geracaoEn.setGerado((int) aValue);
                break;
            case COL_TEMPO:
            	geracaoEn.setTempo((int) aValue);
                break;
            case COL_PORCENTAGEM:
            	geracaoEn.setPorcentagem((int) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
}
	

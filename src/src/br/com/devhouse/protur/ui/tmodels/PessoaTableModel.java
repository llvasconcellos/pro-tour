package br.com.devhouse.protur.ui.tmodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import br.com.devhouse.protur.beans.pessoa.Pessoa;


@SuppressWarnings("serial")
public class PessoaTableModel extends AbstractTableModel {

	private List<Pessoa> lista;

	public PessoaTableModel(List<Pessoa> lista) {
		this.lista = lista;
	}

	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Nome";
		case 1:
			return "Documento";
		case 2:
			return "Sobrenome";
		default:
			return null;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Pessoa p = lista.get(rowIndex);
		if(p != null)
			switch (columnIndex) {
			case 0:
				return p.getNome();
			case 1:
				return p.getDocumento();
			case 2:
				return p.getSobrenome();
			default:
				return null;
			}			
		else
			return null;
	}
	
	public void fireTableDataChanged() {
		// TODO Auto-generated method stub
		super.fireTableDataChanged();
	}
	
}

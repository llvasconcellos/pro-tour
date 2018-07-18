package br.com.devhouse.protur.ui.tmodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import br.com.devhouse.protur.beans.pessoa.Cliente;


@SuppressWarnings("serial")
public class ClienteTableModel extends AbstractTableModel {

	private List<Cliente> lista;

	public ClienteTableModel(List<Cliente> lista) {
		this.lista = lista;
	}

	public int getColumnCount() {
		return 5;
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
			return "Sobrenome";
		case 2:
			return "CPF";
		case 3:
			return "E-Mail";
		case 4:
			return "Telefone";
		default:
			return null;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente p = lista.get(rowIndex);
		if(p != null)
			switch (columnIndex) {
			case 0:
				return p.getNome();
			case 1:
				return p.getSobrenome();
			case 2:
				return p.getCpf();
			case 3:
				return p.getEmail();
			case 4:
				return p.getTelefone();
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

package br.com.devhouse.protur.ui.tmodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import br.com.devhouse.protur.beans.reservas.Reserva;


@SuppressWarnings("serial")
public class ReservaTableModel extends AbstractTableModel {

	private List<Reserva> lista;

	public ReservaTableModel(List<Reserva> lista) {
		this.lista = lista;
	}

	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Cliente";
		case 1:
			return "Nr. Reserva";
		case 2:
			return "Empresa";
		case 3:
			return "E-Mail";
		case 4:
			return "Inicio";
		case 5:
			return "Fim";
		case 6:
			return "Preço";
		default:
			return null;
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Reserva p = lista.get(rowIndex);
		if(p != null)
			switch (columnIndex) {
			case 0:
				return p.getPessoa().getNome();
			case 1:
				return p.getNumReserva();
			case 2:
				return p.getNomeEmpresa();
			case 3:
				return p.getEmailContato();
			case 4:
				return p.getDataHoraInicial();
			case 5:
				return p.getDataHoraFinal();
			case 6:
				return p.getPreco();
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

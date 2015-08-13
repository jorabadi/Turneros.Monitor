package turneros.view.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class TablaTurnosUI extends JTable {
	private int maximoTurnos;
	private int tamanoTurnos;
	private int tamanoEncabezadoTurnos;
	public TablaTurnosUI(int maximoTurnos,int tamanoTurnos,int tamanoEncabezadoTurnos) {
		/*maximoTurnos = Integer.parseInt(Configuration.getPreference("maximoTurnos"));
		tamanoTurnos = Integer.parseInt(Configuration.getPreference("tamanoTurnos"));
		tamanoEncabezadoTurnos = Integer.parseInt(Configuration.getPreference("tamanoEncabezadoTurnos"));*/
		
		this.maximoTurnos = maximoTurnos;
		this.tamanoTurnos = tamanoTurnos;
		this.tamanoEncabezadoTurnos = tamanoEncabezadoTurnos;
		
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("TURNO");
	    model.addColumn("TAQUILLA");
	    this.setModel(model);
	    this.setPreferredScrollableViewportSize(this.getPreferredSize());
	    this.setShowVerticalLines(true);
	    this.setGridColor(Color.decode("#005EAA"));
	    this.setEnabled(true);
	    this.setRowHeight(tamanoTurnos+20);
	     
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	    this.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
	    this.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
	     
	     //estilo de la tabla
	    JTableHeader header = this.getTableHeader();
	    header.setBackground(Color.decode("#388479"));
	    header.setForeground(Color.WHITE);
	    header.setFont(new Font("Arial", Font.CENTER_BASELINE, tamanoEncabezadoTurnos));
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
	{
		Component comp = super.prepareRenderer(renderer, row, column);
		comp.setBackground(Color.decode("#e7e4cf"));
		comp.setFont(new Font("Arial", Font.BOLD, tamanoTurnos));
		
		if (row==0) {
			comp.setForeground(Color.RED);
		} else {
			comp.setForeground(Color.decode("#388479"));
		}
		
		return comp;
	}
	
	public void agregarTurno(String[] turno) {
		System.out.println("Agregar turno tabla");
		DefaultTableModel model = (DefaultTableModel) this.getModel();
		if(model.getRowCount() == this.maximoTurnos) {
			model.removeRow(model.getRowCount() - 1);
		}
        model.addRow(turno);
        model.moveRow(model.getRowCount() - 1, model.getRowCount() - 1, 0);
		this.validate();
		this.repaint();
	}
}

package turneros.turnos.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import turneros.Common.entidades.Turno;
import turneros.view.ui.TablaTurnosUI;


public class MonitorView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTable tablaTurnos;
	
	public MonitorView(int maximoTurnos,int tamanoTurnos,int tamanoEncabezadoTurnos){
		super();
		this.setLayout(new GridLayout(0,1));
		this.crearTablaTurnos(maximoTurnos,tamanoTurnos,tamanoEncabezadoTurnos);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setUndecorated(true);
		this.pack();
		this.show();
	}
	
	public void crearTablaTurnos(int maximoTurnos,int tamanoTurnos,int tamanoEncabezadoTurnos) {
		tablaTurnos = new TablaTurnosUI(maximoTurnos,tamanoTurnos,tamanoEncabezadoTurnos);
	    this.add(new JScrollPane(tablaTurnos));
	}
	
	public void drawLastElement(Turno turno) {
		((TablaTurnosUI) tablaTurnos).agregarTurno(new String[]{turno.getTurno(),turno.getTaquilla()});
	}
	
	/***
	 * Funcion que agrega un turno
	 * @param turno
	 */
	public void addTurno(Turno turno) {
		if(turno!=null) {
			drawLastElement(turno);
		}
	}
	
	public static void main(String[] args) {
		MonitorView view = new MonitorView(5,25,34);
		view.show();
	}
}


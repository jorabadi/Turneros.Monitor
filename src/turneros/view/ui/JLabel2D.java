package turneros.view.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class JLabel2D extends JLabel {
	private Color colorInicial;
	private Color colorFinal;
	
	public void JLabel2D() {
		
	}
	
	public void activateEffects(Color cInicial, Color cFinal) {
		this.colorInicial = cInicial;
		this.colorFinal = cFinal;
		
		Timer time = new Timer();
		time.schedule(new TimerTask() {
			public void run() {
				cambiarColor(colorInicial);
			}
		}, 3000,6000);
		
		cambiarColor(colorFinal);
	}
	
	public void cambiarColor(Color color) {
		this.setForeground(color);
		this.validate();
		this.repaint();
	}
}
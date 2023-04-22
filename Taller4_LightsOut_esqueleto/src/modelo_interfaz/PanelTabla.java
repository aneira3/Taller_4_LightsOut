package modelo_interfaz;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTabla extends JPanel implements MouseListener{
	
	private Image imagenON;
	private Image imagenOFF;
	private boolean[][] tablero;
	private int jugadas;
	private interfaz_juego interfaz;
	
	
	
	
	
	public PanelTabla(interfaz_juego Interfaz) {
	
	setLayout(new BorderLayout());
	imagenON = new ImageIcon("./imagenes/encendido.png").getImage();
	imagenOFF = new ImageIcon("./imagenes/apagado.png").getImage();
	addMouseListener(this);
	interfaz = Interfaz;
	
	
	}
	
	public void prueba( Tablero ObjectTablero) {
		this.tablero = ObjectTablero.darTablero();
		this.jugadas = ObjectTablero.darJugadas();
		
		repaint();
		
	}
	
	
	public void hacer_jugada(int x,int y) {
		
		Tablero ObjectTablero = interfaz.hacer_jugada(x, y);
		if (ObjectTablero !=null) {
			
		
		this.tablero = ObjectTablero.darTablero();
		this.jugadas = ObjectTablero.darJugadas();
		repaint();
		if (ObjectTablero.tableroIluminado()) {
			interfaz.terminarJuego();
			
		}
		}
	}
	
	public void reiniciar(Tablero ObjectTablero) {
		this.tablero = ObjectTablero.darTablero();
		this.jugadas = ObjectTablero.darJugadas();
		repaint();
		
	}
	
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		if(tablero !=null) {
		int tamaño = tablero.length;
		int distribucion_x = (int) 440/tamaño;
		int distribucion_y = (int) 620/tamaño;
		int x = 0;
		int y= 0;
		if (tamaño>0) {
			for (int i=0; i<tamaño; i++) {
				for (int e=0; e<tamaño; e++) {
					if (tablero[i][e]) {
						g.drawImage(imagenON, x, y, distribucion_x, distribucion_y, null);
					}
					else {
						g.drawImage(imagenOFF, x, y, distribucion_x, distribucion_y, null);
					}
					
					y+=distribucion_y;
				}
				x+=distribucion_x;
				y=0;
			}
		}
		}
		
		
		
		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (tablero !=null) {
		int x_pixeles = e.getX();
		int y_pixeles = e.getY();
		int tamaño = tablero.length;
		int distribucion_x = (int) 440/tamaño;
		int distribucion_y = (int) 620/tamaño;
		//calculo fila:
		int fila = x_pixeles/distribucion_x;
		//calculo columna
		int columna = y_pixeles/distribucion_y;
		hacer_jugada(fila, columna);
		}
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}

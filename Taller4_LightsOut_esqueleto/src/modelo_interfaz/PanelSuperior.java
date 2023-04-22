package modelo_interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel {
	
	private JLabel txtTamaño;
	
	private JLabel txtDificultad;
	
	private JComboBox<String> tamaños;
	
	private JRadioButton facil,medio,dificil;
	
	private interfaz_juego interfaz;
	
	public final static String POR4 = "4x4";
	
	public final static String POR5 = "5x5";
	
	public final static String POR6 = "6x6";
	
	
	
	
	public PanelSuperior(interfaz_juego Interfaz) {
	    this.interfaz = Interfaz;
		setLayout(new FlowLayout(1));
		this.setBackground(Color.WHITE);
		txtTamaño = new JLabel("Tamaño:");
		txtDificultad = new JLabel("Dificultad:");
		tamaños = new JComboBox<String>();
		tamaños.addItem("");
		tamaños.addItem("4x4");
		tamaños.addItem("5x5");
		tamaños.addItem("6x6");
		ButtonGroup bg = new ButtonGroup();
		facil = new JRadioButton("Facil");
		medio = new JRadioButton("Medio");
		dificil = new JRadioButton("Díficil");
		bg.add(facil);
		bg.add(medio);
		bg.add(dificil);
		add(txtTamaño);
		add(tamaños);
		add(txtDificultad);
		add(facil);
		add(medio);
		add(dificil);
		
	}

	public int getTamaño() {
		String dimension = (String) tamaños.getSelectedItem();
		if(dimension.equals("4x4")) {
			return 4;
		}
		else if (dimension.equals("5x5")) {
			return 5;
		}
		else if (dimension.equals("6x6")) {
			return 6;
		}
		else {
			return 0;
		}
	}
	
	public int getDificultad() {
		if (facil.isSelected()) {
			return 3;
		}
		else if (medio.isSelected()) {
			return 7;
		}
		else if (dificil.isSelected()) {
			return 10;
		}
		else {
			return 0;
		}
	}
	
	
	
	

}

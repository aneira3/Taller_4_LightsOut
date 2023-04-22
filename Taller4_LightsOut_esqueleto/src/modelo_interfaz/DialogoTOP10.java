package modelo_interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class DialogoTOP10 {
	
	private JDialog dialogo;
	
	private Top10 TOP10;
	
	private Collection<RegistroTop10> lista;
	
	
	
	public DialogoTOP10(JFrame j,Collection<RegistroTop10> Coleccion){
		dialogo = new JDialog();
		dialogo.setTitle("TOP 10");
		dialogo.setResizable(false);
		dialogo.setSize(300, 200);
		dialogo.setLocationRelativeTo(j);
		this.lista = Coleccion;
		String[] TOP3 = new String[3];
		String[] TOP4 = new String[1];
		String[] TOP5_10 = new String[6];
		int i = 0;
		for (RegistroTop10 registro: lista) {
			String texto = registro.toString();
			if (i>=0 && i<=2) {
				TOP3[i] = texto;
			}
			else if(i==3) {
				TOP4[0]=texto;
				
			}
			else if (i>=4 && i<=9) {
				TOP5_10[i-4] = texto;
				
			}
			
			i +=1;
		}
		dialogo.setLayout(new BorderLayout());
		JList<String> top3 = new JList<>(TOP3);
		top3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JList<String> top4 = new JList<>(TOP4);
		top4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JList<String> top5_10 = new JList<>(TOP5_10);
		top5_10.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		top3.setForeground(Color.GREEN);
		top4.setForeground(Color.BLUE);
		top5_10.setForeground(Color.BLACK);
		dialogo.add(top3, BorderLayout.NORTH);
		dialogo.add(top4, BorderLayout.CENTER);
		dialogo.add(top5_10, BorderLayout.SOUTH);
		dialogo.setModal(true);
		dialogo.setVisible(true);
		
		
		
		
	
	}
	

}

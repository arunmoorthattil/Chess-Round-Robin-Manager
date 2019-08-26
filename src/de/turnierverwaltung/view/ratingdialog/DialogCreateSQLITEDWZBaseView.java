package de.turnierverwaltung.view.ratingdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import de.turnierverwaltung.view.Messages;

public class DialogCreateSQLITEDWZBaseView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;

	public DialogCreateSQLITEDWZBaseView() {
		super();
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void createDialog() {
		this.setModal(true);
		// Titel wird gesetzt
		this.setTitle(Messages.getString("DialogCreateSQLITEDWZBaseView.0"));
		// Breite und Höhe des Fensters werden
		// auf 200 Pixel gesetzt
		this.setSize(600, 300);
		this.setLayout(new BorderLayout());
		// Dialog wird auf modal gesetzt

		JLabel label = new JLabel(Messages.getString("DialogCreateSQLITEDWZBaseView.1"));
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(label);
		panel.setVisible(true);
		this.add(panel, BorderLayout.CENTER);
//		this.add(label, BorderLayout.NORTH);
//		 progressBar = new JProgressBar(JProgressBar.HORIZONTAL);

//		progressBar.setValue(0);
//		progressBar.setStringPainted(true);
//		progressBar.setIndeterminate(true);
//		JPanel panel2 = new JPanel();
//		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel2.add(progressBar);
//		this.add(panel2, BorderLayout.CENTER);
//		this.setBackground(Color.WHITE);
//		this.setAlwaysOnTop(true);
//		this.setModal(true);
		this.setLocationRelativeTo(null);
//		this.setEnabled(true);
		this.setVisible(true);
//		setModal(true);

	}

	public void closeDialog() {
		this.dispose();
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
	
}

package de.turnierverwaltung.view.tournamenttable;
//JKlubTV - Ein Programm zum verwalten von Schach Turnieren

import java.util.Comparator;

//Copyright (C) 2015  Martin Schmuck m_schmuck@gmx.net
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.

//JKlubTV - Ein Programm zum verwalten von Schach Turnieren
//Copyright (C) 2015  Martin Schmuck m_schmuck@gmx.net
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.
//import java.awt.Color;

import java.util.Properties;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;

import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import de.turnierverwaltung.model.TournamentConstants;
import de.turnierverwaltung.model.table.MeetingTableModel;
import de.turnierverwaltung.view.Messages;
import de.turnierverwaltung.view.TitleLabelView;

public class MeetingTableView<M> extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton okButton;
	private JButton saveButton;
	private JButton htmlButton;
	private JTable table;
	private JComboBox<String> comboBox;
	private MeetingTableModel simpleTerminTabelle;
	private Properties property;
	private TitleLabelView statusLabel;

	public MeetingTableView(MeetingTableModel simpleTerminTabelle) {

		this.simpleTerminTabelle = simpleTerminTabelle;
		setLayout(new BorderLayout());

		table = new JTable();

		table.setModel(this.simpleTerminTabelle);

		table.setLocale(getDefaultLocale());
		comboBox = new JComboBox<String>();
		comboBox.addItem(TournamentConstants.KEIN_ERGEBNIS);
		comboBox.addItem(TournamentConstants.PARTIE_GEWINN_OPPONENT);
		comboBox.addItem(TournamentConstants.PARTIE_REMIS);
		comboBox.addItem(TournamentConstants.PARTIE_GEWINN_PLAYER);
		comboBox.addItem(TournamentConstants.PARTIE_GEWINN_KAMPFLOS_OPPONENT);
		comboBox.addItem(TournamentConstants.PARTIE_GEWINN_KAMPFLOS_PLAYER);
		comboBox.addItem(TournamentConstants.PARTIE_VERLUST_KAMPFLOS_BEIDE);
		property = new Properties();
		property.put("text.today", Messages.getString("SimpleTerminTabelleView.8")); //$NON-NLS-1$ //$NON-NLS-2$
		property.put("text.month", Messages.getString("SimpleTerminTabelleView.10")); //$NON-NLS-1$ //$NON-NLS-2$
		property.put("text.year", Messages.getString("SimpleTerminTabelleView.12")); //$NON-NLS-1$ //$NON-NLS-2$

		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setRowHeight(30);
		setColumnWidth();
//		table.getModel().addTableModelListener(new TableListener());

		JScrollPane sPane = new JScrollPane();
		sPane.setViewportView(table);

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());

		JPanel hinweis = new JPanel();
		hinweis.setLayout(new FlowLayout(FlowLayout.LEFT));
		hinweis.add(new JLabel(Messages.getString("SimpleTerminTabelleView.13") //$NON-NLS-1$
				+ Messages.getString("SimpleTerminTabelleView.14"))); //$NON-NLS-1$

		southPanel.add(hinweis, BorderLayout.CENTER);
//		JTextField tf = new JTextField();
//		tf.setVisible(false);
		JPanel status = new JPanel();
		status.setLayout(new FlowLayout(FlowLayout.LEFT));
		status.add(new JLabel(Messages.getString("SimpleTerminTabelleView.15"))); //$NON-NLS-1$
		statusLabel = new TitleLabelView("0");
		statusLabel.setFlowLayoutLeft();
		statusLabel.setOpaque(true);

		JLabel changesLabel = new JLabel(Messages.getString("SimpleTerminTabelleView.16"));
//		status.add(tf);
		status.add(statusLabel);
		status.add(changesLabel);
		southPanel.add(status, BorderLayout.SOUTH);

		add(sPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		this.setVisible(true);

	}

	@SuppressWarnings("unused")
	private int[] dateStringToInt(String datum) {
		int[] dateInt = new int[3];

		int index = 0;
		for (String zahlenWerte : datum.split("\\.")) { //$NON-NLS-1$

			dateInt[index] = Integer.parseInt(zahlenWerte);

			index++;

		}
		dateInt[1] = dateInt[1] - 1;
		return dateInt;

	}

	public JButton getHtmlButton() {
		return htmlButton;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JLabel getStatusLabel() {
		return statusLabel.getTitleLabel();
	}

	public JTable getTable() {
		return table;
	}

	public void setColumnWidth() {

		int columnCount = table.getColumnCount();

		for (int i = 0; i < columnCount; i++) {

			TableColumn c = table.getColumnModel().getColumn(i);
			if (i == 3) {
				c.setCellEditor(new DefaultCellEditor(comboBox));
			}
//			if (i == 4) {
//
//			}

		}

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		sorter.setComparator(4, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				int tag1 = Integer.parseInt(arg0.substring(0, 2));
				int monat1 = Integer.parseInt(arg0.substring(3, 5));
				int jahr1 = Integer.parseInt(arg0.substring(6, 10));
				int gesamt1 = jahr1 * 10000 + monat1 * 100 + tag1;

				int tag2 = Integer.parseInt(arg1.substring(0, 2));
				int monat2 = Integer.parseInt(arg1.substring(3, 5));
				int jahr2 = Integer.parseInt(arg1.substring(6, 10));
				int gesamt2 = jahr2 * 10000 + monat2 * 100 + tag2;

				return gesamt1 - gesamt2;
			}

		});
		sorter.setRowFilter(RowFilter.regexFilter("\\d", 0));

		table.setRowSorter(sorter);

		this.updateUI();
	}

	public void setHtmlButton(JButton htmlButton) {
		this.htmlButton = htmlButton;
	}

	public void setOkButton(JButton okButton) {
		this.okButton = okButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public void setStatusLabel(JLabel statusLabel) {
		this.statusLabel.setTitleLabel(statusLabel);

	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
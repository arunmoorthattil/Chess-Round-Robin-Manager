package de.turnierverwaltung.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.undo.*;

public class JTextFieldRegularPopupMenu {
	public static void addTo(JTextField txtField) {
		JPopupMenu popup = new JPopupMenu();
		UndoManager undoManager = new UndoManager();
		txtField.getDocument().addUndoableEditListener(undoManager);

		Action undoAction = new AbstractAction("Undo") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				if (undoManager.canUndo()) {
					undoManager.undo();
				} else {
					System.out.println("No Undo Buffer.");
				}
			}
		};

		Action copyAction = new AbstractAction("Copy") {
			/**
			* 
			*/
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				txtField.copy();
			}
		};

		Action cutAction = new AbstractAction("Cut") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				txtField.cut();
			}
		};

		Action pasteAction = new AbstractAction("Paste") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				txtField.paste();
			}
		};

		Action selectAllAction = new AbstractAction("Select All") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent ae) {
				txtField.selectAll();
			}
		};

		cutAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
		copyAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
		pasteAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
		selectAllAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control A"));

		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		popup.addSeparator();
		popup.add(selectAllAction);
		popup.addSeparator();
		popup.add(undoAction);
		txtField.setComponentPopupMenu(popup);
	}
}
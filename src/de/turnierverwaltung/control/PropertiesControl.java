package de.turnierverwaltung.control;

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
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;
import java.util.prefs.Preferences;

import javax.swing.JLabel;

import de.turnierverwaltung.model.TournamentConstants;

public class PropertiesControl {

	public static final String ONLYTABLES = "onlyTables";
	public static final String NODWZ = "noDWZ";
	public static final String NOFOLGEDWZ = "noFolgeDWZ";
	public static final String NOELO = "noELO";
	public static final String NOFOLGEELO = "noFolgeELO";
	public static final String PATHTODATABASE = "PathToDatabase";
	public static final String ZPS = "ZPS";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String LANGUAGE = "language";
	public static final String PATHTOVEREINECSV = "PathToVereineCSV";
	public static final String PATHTOPLAYERSCSV = "PathToPlayersCSV";
	public static final String PATHTOPLAYERSELO = "PathToPlayersELO";
	public static final String DEFAULTPATH = "defaultPath";
	public static final String TURNIEREPROTAB = "TurniereproTab";
	public static final String SPIELERPROTAB = "SpielerproTab";
	public static final String SPIELFREI = TournamentConstants.SPIELFREI;

	public static final String PACKAGE = "/de/jklubtv";
	public static final String TABLE_COLUMN_OLD_DWZ = "tablecolumn-olddwz";
	public static final String TABLE_COLUMN_NEW_DWZ = "tablecolumn-newdwz";
	public static final String TABLE_COLUMN_OLD_ELO = "tablecolumn-oldelo";
	public static final String TABLE_COLUMN_NEW_ELO = "tablecolumn-newelo";
	public static final String TABLE_COLUMN_POINTS = "tablecolumn-points";
	public static final String TABLE_COLUMN_SONNEBORNBERGER = "tablecolumn-sonnebornberger";
	public static final String TABLE_COLUMN_RANKING = "tablecolumn-ranking";
	public static final String TABLE_COLUMN_WHITE = "tablecolumn-white";
	public static final String TABLE_COLUMN_BLACK = "tablecolumn-black";
	public static final String TABLE_COLUMN_RESULT = "tablecolumn-result";
	public static final String TABLE_COLUMN_MEETING = "tablecolumn-meeting";
	public static final String TABLE_COLUMN_PLAYER = "tablecolumn-player";
	public static final String TABLE_COLUMN_ROUND = "tablecolumn-round";
	public static final String CUT_FORENAME = "cut-forename";
	public static final String CUT_SURNAME = "cut-surname";
	public static final String DATABASE_UPDATED = "database-updated";
	public static final String PDFLINKS = "pdflinks";
	public static final String WEBSERVER_PATH = "webserver-path";
	public static final String HTMLTOCLIPBOARD = "htmltoclipboard";
	public static final String FRAME_X = "frame-x";
	public static final String FRAME_Y = "frame-y";
	public static final String FRAME_WIDTH = "frame-width";
	public static final String FRAME_HEIGHT = "frame-height";

	public static final String DWZ_DIALOG_X = "dwz-dialog-x";
	public static final String DWZ_DIALOG_Y = "dwz-dialog-y";
	public static final String DWZ_DIALOG_WIDTH = "dwz-dialog-width";
	public static final String DWZ_DIALOG_HEIGHT = "dwz-dialog-height";

	public static final String ELO_DIALOG_X = "elo-dialog-x";
	public static final String ELO_DIALOG_Y = "elo-dialog-y";
	public static final String ELO_DIALOG_WIDTH = "elo-dialog-width";
	public static final String ELO_DIALOG_HEIGHT = "elo-dialog-height";

	public static final String INFO_DIALOG_X = "info-dialog-x";
	public static final String INFO_DIALOG_Y = "info-dialog-y";
	public static final String INFO_DIALOG_WIDTH = "info-dialog-width";
	public static final String INFO_DIALOG_HEIGHT = "info-dialog-height";

	public static final String SETTINGS_DIALOG_X = "settings-dialog-x";
	public static final String SETTINGS_DIALOG_Y = "settings-dialog-y";
	public static final String SETTINGS_DIALOG_WIDTH = "settings-dialog-width";
	public static final String SETTINGS_DIALOG_HEIGHT = "settings-dialog-height";

	public static final String STARTPAGE_DIALOG_X = "startpage-dialog-x";
	public static final String STARTPAGE_DIALOG_Y = "startpage-dialog-y";
	public static final String STARTPAGE_DIALOG_WIDTH = "startpage-dialog-width";
	public static final String STARTPAGE_DIALOG_HEIGHT = "startpage-dialog-height";

	public static final String FONT_NAME = "font-name";
	public static final String FONT_STYLE = "font-style";
	public static final String FONT_SIZE = "font-size";

	public static final String CSSTABLE = "css-table";
	public static final String TEXTFIELD_WIDTH = "textfield-width";
	public static final String TEXTFIELD_HEIGHT = "textfield-height";
	private Properties prop;
	private Boolean NoWritableProperties;
	private final Preferences prefs;
	private final MainControl mainControl;

	public PropertiesControl(final MainControl mainControl) {
		super();
		this.mainControl = mainControl;
		prefs = Preferences.userRoot().node(PACKAGE);
		prop = new Properties();
		prop.setProperty(PATHTODATABASE, "");
		prop.setProperty(ONLYTABLES, FALSE);
		prop.setProperty(NODWZ, FALSE);
		prop.setProperty(NOFOLGEDWZ, FALSE);
		prop.setProperty(NOELO, FALSE);
		prop.setProperty(NOFOLGEELO, FALSE);
		prop.setProperty(ZPS, "");
		prop.setProperty(LANGUAGE, "");
		prop.setProperty(PATHTOVEREINECSV, "");
		prop.setProperty(PATHTOPLAYERSCSV, "");
		prop.setProperty(PATHTOPLAYERSELO, "");
		prop.setProperty(DEFAULTPATH, "");
		prop.setProperty(TURNIEREPROTAB, "1");
		prop.setProperty(SPIELERPROTAB, "1");
		prop.setProperty(SPIELFREI, "");
		prop.setProperty(TABLE_COLUMN_OLD_DWZ, "");
		prop.setProperty(TABLE_COLUMN_NEW_DWZ, "");
		prop.setProperty(TABLE_COLUMN_OLD_ELO, "");
		prop.setProperty(TABLE_COLUMN_NEW_ELO, "");
		prop.setProperty(TABLE_COLUMN_POINTS, "");
		prop.setProperty(TABLE_COLUMN_SONNEBORNBERGER, "");
		prop.setProperty(TABLE_COLUMN_RANKING, "");
		prop.setProperty(TABLE_COLUMN_WHITE, "");
		prop.setProperty(TABLE_COLUMN_BLACK, "");
		prop.setProperty(TABLE_COLUMN_RESULT, "");
		prop.setProperty(TABLE_COLUMN_MEETING, "");
		prop.setProperty(TABLE_COLUMN_PLAYER, "");
		prop.setProperty(TABLE_COLUMN_ROUND, "");
		prop.setProperty(CUT_FORENAME, "");
		prop.setProperty(CUT_SURNAME, "");
		prop.setProperty(DATABASE_UPDATED, FALSE);
		prop.setProperty(PDFLINKS, FALSE);
		prop.setProperty(WEBSERVER_PATH, "");
		prop.setProperty(HTMLTOCLIPBOARD, FALSE);
		prop.setProperty(FRAME_WIDTH, String.valueOf(setWidth()));
		prop.setProperty(FRAME_HEIGHT, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
		prop.setProperty(FRAME_X, String.valueOf(setWidth() - 200));
		prop.setProperty(FRAME_Y, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
		prop.setProperty(DWZ_DIALOG_WIDTH, String.valueOf(setWidth()));
		prop.setProperty(DWZ_DIALOG_HEIGHT, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
		prop.setProperty(DWZ_DIALOG_X, String.valueOf(setWidth() - 200));
		prop.setProperty(DWZ_DIALOG_Y, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
		prop.setProperty(ELO_DIALOG_WIDTH, String.valueOf(setWidth()));
		prop.setProperty(ELO_DIALOG_HEIGHT, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
		prop.setProperty(ELO_DIALOG_X, String.valueOf(setWidth() - 200));
		prop.setProperty(ELO_DIALOG_Y, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
		prop.setProperty(INFO_DIALOG_WIDTH, String.valueOf(setWidth()));
		prop.setProperty(INFO_DIALOG_HEIGHT, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
		prop.setProperty(INFO_DIALOG_X, String.valueOf(setWidth() - 200));
		prop.setProperty(INFO_DIALOG_Y, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
		prop.setProperty(SETTINGS_DIALOG_WIDTH, String.valueOf(setWidth()));
		prop.setProperty(SETTINGS_DIALOG_HEIGHT,
				String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
		prop.setProperty(SETTINGS_DIALOG_X, String.valueOf(setWidth() - 200));
		prop.setProperty(SETTINGS_DIALOG_Y,
				String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
		prop.setProperty(STARTPAGE_DIALOG_WIDTH, String.valueOf(setWidth()));
		prop.setProperty(STARTPAGE_DIALOG_HEIGHT,
				String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
		prop.setProperty(STARTPAGE_DIALOG_X, String.valueOf(setWidth() - 200));
		prop.setProperty(STARTPAGE_DIALOG_Y,
				String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
		prop.setProperty(FONT_NAME, "");
		prop.setProperty(FONT_STYLE, "");
		prop.setProperty(FONT_SIZE, "");

		prop.setProperty(CSSTABLE, "");
		prop.setProperty(TEXTFIELD_WIDTH, "150");
		prop.setProperty(TEXTFIELD_HEIGHT, "40");
		TournamentConstants.setTextField(getTextFieldWidth(), getTextFieldHeight());

	}

	public void checkCrossTableColumnForDoubles() {
		final String[] tableColumns = new String[8];
		tableColumns[0] = prop.getProperty(TABLE_COLUMN_PLAYER);
		tableColumns[1] = prop.getProperty(TABLE_COLUMN_OLD_DWZ);
		tableColumns[2] = prop.getProperty(TABLE_COLUMN_NEW_DWZ);
		tableColumns[3] = prop.getProperty(TABLE_COLUMN_OLD_ELO);
		tableColumns[4] = prop.getProperty(TABLE_COLUMN_NEW_ELO);
		tableColumns[5] = prop.getProperty(TABLE_COLUMN_POINTS);
		tableColumns[6] = prop.getProperty(TABLE_COLUMN_SONNEBORNBERGER);
		tableColumns[7] = prop.getProperty(TABLE_COLUMN_RANKING);
		Boolean loop = false;
		do {
			loop = false;
			for (int i = 0; i < 8; i++) {
				for (int y = 0; y < 8; y++) {
					if (i != y) {
						if (tableColumns[i].equals(tableColumns[y])) {
							tableColumns[y] = tableColumns[y] + "#";
							loop = true;
						}
					}

				}
			}
		} while (loop == true);
		prop.setProperty(TABLE_COLUMN_PLAYER, tableColumns[0]);
		prop.setProperty(TABLE_COLUMN_OLD_DWZ, tableColumns[1]);
		prop.setProperty(TABLE_COLUMN_NEW_DWZ, tableColumns[2]);
		prop.setProperty(TABLE_COLUMN_OLD_ELO, tableColumns[3]);
		prop.setProperty(TABLE_COLUMN_NEW_ELO, tableColumns[4]);
		prop.setProperty(TABLE_COLUMN_POINTS, tableColumns[5]);
		prop.setProperty(TABLE_COLUMN_SONNEBORNBERGER, tableColumns[6]);
		prop.setProperty(TABLE_COLUMN_RANKING, tableColumns[7]);
	}

	private static int setWidth() {

		final int widthAllowed = Toolkit.getDefaultToolkit().getScreenSize().width;
		final int widthDreamSize = TournamentConstants.WINDOW_HEIGHT * 4 / 3;
		if (widthDreamSize < widthAllowed) {
			return widthDreamSize;
		} else {
			return widthAllowed;
		}

	}

	private Boolean checkDefaultPath() {
		final String path = prop.getProperty(DEFAULTPATH);

		final File f = new File(path);

		if (f.isDirectory()) {
			return true;
		} else {
			return false;
		}

	}

	public void checkMeetingTableColumnForDoubles() {
		final String[] tableColumns = new String[6];
		tableColumns[0] = prop.getProperty(TABLE_COLUMN_ROUND);
		tableColumns[1] = prop.getProperty(TABLE_COLUMN_WHITE);
		tableColumns[2] = prop.getProperty(TABLE_COLUMN_BLACK);
		tableColumns[3] = prop.getProperty(TABLE_COLUMN_RESULT);
		tableColumns[4] = prop.getProperty(TABLE_COLUMN_MEETING);
		boolean loop = false;
		do {
			loop = false;
			for (int i = 0; i < 5; i++) {
				for (int y = 0; y < 5; y++) {
					if (i != y) {
						if (tableColumns[i].equals(tableColumns[y])) {
							tableColumns[y] = tableColumns[y] + "#";
							loop = true;
						}
					}

				}
			}
		} while (loop == true);
		prop.setProperty(TABLE_COLUMN_ROUND, tableColumns[0]);
		prop.setProperty(TABLE_COLUMN_WHITE, tableColumns[1]);
		prop.setProperty(TABLE_COLUMN_BLACK, tableColumns[2]);
		prop.setProperty(TABLE_COLUMN_RESULT, tableColumns[3]);
		prop.setProperty(TABLE_COLUMN_MEETING, tableColumns[4]);
	}

	public void resetProperties() {
		prop.clear();
		writeProperties();
	}

	private Boolean checkPath(final String path) {

		final File f = new File(path);

		if (f.exists() && !f.isDirectory()) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean checkPathToDatabase() {
		final String path = prop.getProperty(PATHTODATABASE);
		return checkPath(path);
	}

	public Boolean checkPathToELOXML() {
		final String path = prop.getProperty(PATHTOPLAYERSELO);
		return checkPath(path);

	}

	private boolean checkPathToPlayersCSV() {
		final String path = prop.getProperty(PATHTOPLAYERSCSV);
		return checkPath(path);

	}

	private boolean checkPathToPlayersELO() {
		final String path = prop.getProperty(PATHTOPLAYERSELO);
		return checkPath(path);
	}

	public Boolean checkPathToSpielerCSV() {
		final String path = prop.getProperty(PATHTOPLAYERSCSV);
		return checkPath(path);

	}

	public Boolean checkPathToVereineCSV() {
		final String path = prop.getProperty(PATHTOVEREINECSV);
		return checkPath(path);

	}

	public void checkProperties() {
		Boolean saveChanges = false;
		int turniereProTab = 0;
		int spielerProTab = 0;
		try {
			turniereProTab = Integer.parseInt(prop.getProperty(TURNIEREPROTAB));
		} catch (final NumberFormatException e) {
			prop.setProperty(TURNIEREPROTAB, "1");
			turniereProTab = 1;
			saveChanges = true;
		}

		try {
			spielerProTab = Integer.parseInt(prop.getProperty(SPIELERPROTAB));
		} catch (final NumberFormatException e) {
			prop.setProperty(SPIELERPROTAB, "1");
			spielerProTab = 1;
			saveChanges = true;
		}
		if (!prop.getProperty(PATHTODATABASE).equals("") && checkPathToDatabase() == false) {
			prop.setProperty(PATHTODATABASE, "");
			saveChanges = true;
		}
		if (prop.getProperty(SPIELFREI).equals("") && checkPathToDatabase() == false) {
			prop.setProperty(SPIELFREI, TournamentConstants.SPIELFREI);
			saveChanges = true;
		}
		if (!prop.getProperty(PATHTOVEREINECSV).equals("") && checkPathToVereineCSV() == false) {
			prop.setProperty(PATHTOVEREINECSV, "");
			saveChanges = true;
		}
		if (!prop.getProperty(PATHTOPLAYERSCSV).equals("") && checkPathToPlayersCSV() == false) {
			prop.setProperty(PATHTOPLAYERSCSV, "");
			saveChanges = true;
		}
		if (!prop.getProperty(PATHTOPLAYERSELO).equals("") && checkPathToPlayersELO() == false) {
			prop.setProperty(PATHTOPLAYERSELO, "");
			saveChanges = true;
		}
		if (!prop.getProperty(DEFAULTPATH).equals("") && checkDefaultPath() == false) {
			prop.setProperty(DEFAULTPATH, "");
			saveChanges = true;
		}
		if (!(prop.getProperty(ONLYTABLES).equals(TRUE) || prop.getProperty(ONLYTABLES).equals(FALSE))) {
			prop.setProperty(ONLYTABLES, FALSE);
			saveChanges = true;
		}
		if (!(prop.getProperty(NODWZ).equals(TRUE) || prop.getProperty(NODWZ).equals(FALSE))) {
			prop.setProperty(NODWZ, FALSE);
			saveChanges = true;
		}
		if (!(prop.getProperty(NOFOLGEDWZ).equals(TRUE) || prop.getProperty(NOFOLGEDWZ).equals(FALSE))) {
			prop.setProperty(NOFOLGEDWZ, FALSE);
			saveChanges = true;
		}
		if (!(prop.getProperty(NOELO).equals(TRUE) || prop.getProperty(NOELO).equals(FALSE))) {
			prop.setProperty(NOELO, FALSE);
			saveChanges = true;
		}
		if (!(prop.getProperty(NOFOLGEELO).equals(TRUE) || prop.getProperty(NOFOLGEELO).equals(FALSE))) {
			prop.setProperty(NOFOLGEELO, FALSE);
			saveChanges = true;
		}
		if (!(turniereProTab >= 0 && turniereProTab <= 3)) {
			prop.setProperty(TURNIEREPROTAB, "1");
			saveChanges = true;
		}
		if (!(spielerProTab >= 0 && spielerProTab <= 3)) {
			prop.setProperty(SPIELERPROTAB, "1");
			saveChanges = true;
		}

		if (mainControl.getLanguagePropertiesControl().checkLanguage() == false) {
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_OLD_DWZ).equals("")) {
			prop.setProperty(TABLE_COLUMN_OLD_DWZ, TournamentConstants.TABLE_COLUMN_OLD_DWZ);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_NEW_DWZ).equals("")) {
			prop.setProperty(TABLE_COLUMN_NEW_DWZ, TournamentConstants.TABLE_COLUMN_NEW_DWZ);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_OLD_ELO).equals("")) {
			prop.setProperty(TABLE_COLUMN_OLD_ELO, TournamentConstants.TABLE_COLUMN_OLD_ELO);

			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_NEW_ELO).equals("")) {
			prop.setProperty(TABLE_COLUMN_NEW_ELO, TournamentConstants.TABLE_COLUMN_NEW_ELO);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_POINTS).equals("")) {
			prop.setProperty(TABLE_COLUMN_POINTS, TournamentConstants.TABLE_COLUMN_POINTS);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_SONNEBORNBERGER).equals("")) {
			prop.setProperty(TABLE_COLUMN_SONNEBORNBERGER, TournamentConstants.TABLE_COLUMN_SONNEBORNBERGER);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_RANKING).equals("")) {
			prop.setProperty(TABLE_COLUMN_RANKING, TournamentConstants.TABLE_COLUMN_RANKING);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_WHITE).equals("")) {
			prop.setProperty(TABLE_COLUMN_WHITE, TournamentConstants.TABLE_COLUMN_WHITE);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_BLACK).equals("")) {
			prop.setProperty(TABLE_COLUMN_BLACK, TournamentConstants.TABLE_COLUMN_BLACK);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_RESULT).equals("")) {
			prop.setProperty(TABLE_COLUMN_RESULT, TournamentConstants.TABLE_COLUMN_RESULT);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_MEETING).equals("")) {
			prop.setProperty(TABLE_COLUMN_MEETING, TournamentConstants.TABLE_COLUMN_MEETING);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_PLAYER).equals("")) {
			prop.setProperty(TABLE_COLUMN_PLAYER, TournamentConstants.TABLE_COLUMN_PLAYER);
			saveChanges = true;
		}
		if (prop.getProperty(TABLE_COLUMN_ROUND).equals("")) {
			prop.setProperty(TABLE_COLUMN_ROUND, TournamentConstants.TABLE_COLUMN_ROUND);
			saveChanges = true;
		}
		if (prop.getProperty(CUT_FORENAME).equals("")) {
			prop.setProperty(CUT_FORENAME, TournamentConstants.CUT_FORENAME);
			saveChanges = true;
		}
		if (prop.getProperty(CUT_SURNAME).equals("")) {
			prop.setProperty(CUT_SURNAME, TournamentConstants.CUT_SURNAME);
			saveChanges = true;
		}
		if (prop.getProperty(DATABASE_UPDATED).equals("")) {
			prop.setProperty(DATABASE_UPDATED, FALSE);
			saveChanges = true;
		}
		if (!(prop.getProperty(PDFLINKS).equals(TRUE) || prop.getProperty(PDFLINKS).equals(FALSE))) {
			prop.setProperty(PDFLINKS, FALSE);
			saveChanges = true;
		}

		if (!(prop.getProperty(HTMLTOCLIPBOARD).equals(TRUE) || prop.getProperty(HTMLTOCLIPBOARD).equals(FALSE))) {
			prop.setProperty(HTMLTOCLIPBOARD, FALSE);
			saveChanges = true;
		}
		if (prop.getProperty(FRAME_WIDTH).equals("")) {
			prop.setProperty(FRAME_WIDTH, String.valueOf(setWidth()));
			saveChanges = true;
		}

		if (prop.getProperty(FRAME_HEIGHT).equals("")) {
			prop.setProperty(FRAME_HEIGHT, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
			saveChanges = true;
		}
		if (prop.getProperty(FRAME_X).equals("")) {
			prop.setProperty(FRAME_X, String.valueOf(setWidth() - 200));
			saveChanges = true;
		}
		if (prop.getProperty(FRAME_Y).equals("")) {
			prop.setProperty(FRAME_Y, String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
			saveChanges = true;

		}
		if (prop.getProperty(DWZ_DIALOG_WIDTH).equals("")) {
			prop.setProperty(DWZ_DIALOG_WIDTH, String.valueOf(setWidth()));
			saveChanges = true;
		}

		if (prop.getProperty(DWZ_DIALOG_HEIGHT).equals("")) {
			prop.setProperty(DWZ_DIALOG_HEIGHT,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
			saveChanges = true;
		}
		if (prop.getProperty(DWZ_DIALOG_X).equals("")) {
			prop.setProperty(DWZ_DIALOG_X, String.valueOf(setWidth() - 200));
			saveChanges = true;
		}
		if (prop.getProperty(DWZ_DIALOG_Y).equals("")) {
			prop.setProperty(DWZ_DIALOG_Y,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
			saveChanges = true;

		}
		if (prop.getProperty(ELO_DIALOG_WIDTH).equals("")) {
			prop.setProperty(ELO_DIALOG_WIDTH, String.valueOf(setWidth()));
			saveChanges = true;
		}

		if (prop.getProperty(ELO_DIALOG_HEIGHT).equals("")) {
			prop.setProperty(ELO_DIALOG_HEIGHT,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
			saveChanges = true;
		}
		if (prop.getProperty(ELO_DIALOG_X).equals("")) {
			prop.setProperty(ELO_DIALOG_X, String.valueOf(setWidth() - 200));
			saveChanges = true;
		}
		if (prop.getProperty(ELO_DIALOG_Y).equals("")) {
			prop.setProperty(ELO_DIALOG_Y,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
			saveChanges = true;

		}
		if (prop.getProperty(INFO_DIALOG_WIDTH).equals("")) {
			prop.setProperty(INFO_DIALOG_WIDTH, String.valueOf(setWidth()));
			saveChanges = true;
		}

		if (prop.getProperty(INFO_DIALOG_HEIGHT).equals("")) {
			prop.setProperty(INFO_DIALOG_HEIGHT,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
			saveChanges = true;
		}
		if (prop.getProperty(INFO_DIALOG_X).equals("")) {
			prop.setProperty(INFO_DIALOG_X, String.valueOf(setWidth() - 200));
			saveChanges = true;
		}
		if (prop.getProperty(INFO_DIALOG_Y).equals("")) {
			prop.setProperty(INFO_DIALOG_Y,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
			saveChanges = true;

		}
		if (prop.getProperty(SETTINGS_DIALOG_WIDTH).equals("")) {
			prop.setProperty(SETTINGS_DIALOG_WIDTH, String.valueOf(setWidth()));
			saveChanges = true;
		}

		if (prop.getProperty(SETTINGS_DIALOG_HEIGHT).equals("")) {
			prop.setProperty(SETTINGS_DIALOG_HEIGHT,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
			saveChanges = true;
		}
		if (prop.getProperty(SETTINGS_DIALOG_X).equals("")) {
			prop.setProperty(SETTINGS_DIALOG_X, String.valueOf(setWidth() - 200));
			saveChanges = true;
		}
		if (prop.getProperty(SETTINGS_DIALOG_Y).equals("")) {
			prop.setProperty(SETTINGS_DIALOG_Y,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
			saveChanges = true;

		}
		if (prop.getProperty(STARTPAGE_DIALOG_WIDTH).equals("")) {
			prop.setProperty(STARTPAGE_DIALOG_WIDTH, String.valueOf(setWidth()));
			saveChanges = true;
		}

		if (prop.getProperty(STARTPAGE_DIALOG_HEIGHT).equals("")) {
			prop.setProperty(STARTPAGE_DIALOG_HEIGHT,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150));
			saveChanges = true;
		}
		if (prop.getProperty(STARTPAGE_DIALOG_X).equals("")) {
			prop.setProperty(STARTPAGE_DIALOG_X, String.valueOf(setWidth() - 200));
			saveChanges = true;
		}
		if (prop.getProperty(STARTPAGE_DIALOG_Y).equals("")) {
			prop.setProperty(STARTPAGE_DIALOG_Y,
					String.valueOf(Toolkit.getDefaultToolkit().getScreenSize().height - 150 - 200));
			saveChanges = true;

		}
		Font font;
		try {
			final Font genericFont = Font.createFont(Font.TRUETYPE_FONT,
					this.getClass().getResourceAsStream("/Fonts/Vollkorn-Regular.ttf"));
			font = genericFont.deriveFont(Font.TRUETYPE_FONT, 14);
		} catch (final FontFormatException e) {
			font = new JLabel().getFont();
			e.printStackTrace();
		} catch (final IOException e) {
			font = new JLabel().getFont();
			e.printStackTrace();
		}

		if (prop.getProperty(FONT_NAME).equals("")) {
			prop.setProperty(FONT_NAME, font.getFontName());
			saveChanges = true;
		}

		if (prop.getProperty(FONT_STYLE).equals("")) {
			prop.setProperty(FONT_STYLE, String.valueOf(font.getStyle()));
			saveChanges = true;
		}
		if (prop.getProperty(FONT_SIZE).equals("")) {
			prop.setProperty(FONT_SIZE, String.valueOf(font.getSize()));
			saveChanges = true;
		}
		if (prop.getProperty(CSSTABLE).equals("")) {
			prop.setProperty(CSSTABLE, "table");
			saveChanges = true;
		}
		if (prop.getProperty(TEXTFIELD_WIDTH).equals("")) {
			prop.setProperty(TEXTFIELD_WIDTH, "150");
			saveChanges = true;
		}
		if (prop.getProperty(TEXTFIELD_HEIGHT).equals("")) {
			prop.setProperty(TEXTFIELD_HEIGHT, "40");
			saveChanges = true;
		}
		if ((prop.getProperty(SPIELFREI).equals(""))) {
			prop.setProperty(SPIELFREI, TournamentConstants.SPIELFREI);
			saveChanges = true;
		}

		TournamentConstants.setTextField(getTextFieldWidth(), getTextFieldHeight());

		checkCrossTableColumnForDoubles();
		checkMeetingTableColumnForDoubles();
		if (saveChanges == true) {
			writeProperties();
		}
	}

	private String getFontName() {

		return prop.getProperty(FONT_NAME);

	}

	private int getFontStyle() {
		try {
			return Integer.parseInt(prop.getProperty(FONT_STYLE));
		} catch (final NumberFormatException e) {
			return Font.BOLD;
		}
	}

	private int getFontSize() {
		try {
			return Integer.parseInt(prop.getProperty(FONT_SIZE));
		} catch (final NumberFormatException e) {
			return 14;
		}
	}

	private void setFontName(final String fontName) {

		prop.setProperty(FONT_NAME, fontName);

	}

	private void setFontStyle(final int style) {

		prop.setProperty(FONT_STYLE, String.valueOf(style));
	}

	private void setFontSize(final int size) {

		prop.setProperty(FONT_SIZE, String.valueOf(size));

	}

	public void setFont(final Font font) {
		setFontName(font.getFontName());
		setFontStyle(font.getStyle());
		setFontSize(font.getSize());
	}

	public Font getFont() {
		final Font font = new Font(getFontName(), getFontStyle(), getFontSize());
		return font;
	}

	public int getTextFieldWidth() {
		try {
			return Integer.parseInt(prop.getProperty(TEXTFIELD_WIDTH));
		} catch (final NumberFormatException e) {
			return 150;
		}

	}

	public void setTextFieldWidth(final int width) {

		prop.setProperty(TEXTFIELD_WIDTH, Integer.toString(width));
		TournamentConstants.setTextField(getTextFieldWidth(), getTextFieldHeight());
	}

	public int getTextFieldHeight() {

		try {
			return Integer.parseInt(prop.getProperty(TEXTFIELD_HEIGHT));
		} catch (final NumberFormatException e) {
			return 150;
		}
	}

	public void setTextFieldHeight(final int height) {

		prop.setProperty(TEXTFIELD_HEIGHT, Integer.toString(height));
		TournamentConstants.setTextField(getTextFieldWidth(), getTextFieldHeight());

	}

	public String getCSSTable() {

		return prop.getProperty(CSSTABLE);

	}

	public void setCSSTable(final String css) {

		prop.setProperty(CSSTABLE, css);

	}

	public int getFrameX() {
		try {
			return Integer.parseInt(prop.getProperty(FRAME_X));

		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_X;
		}
	}

	public int getFrameY() {
		try {
			return Integer.parseInt(prop.getProperty(FRAME_Y));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_Y;
		}
	}

	public int getFrameWidth() {
		try {
			return Integer.parseInt(prop.getProperty(FRAME_WIDTH));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_WIDTH;
		}
	}

	public int getFrameHeight() {
		try {
			return Integer.parseInt(prop.getProperty(FRAME_HEIGHT));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_HEIGHT;
		}
	}

	public int getDWZDialogX() {
		try {
			return Integer.parseInt(prop.getProperty(DWZ_DIALOG_X));

		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_X;
		}
	}

	public int getDWZDialogY() {
		try {
			return Integer.parseInt(prop.getProperty(DWZ_DIALOG_Y));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_Y;
		}
	}

	public int getDWZDialogWidth() {
		try {
			return Integer.parseInt(prop.getProperty(DWZ_DIALOG_WIDTH));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_WIDTH;
		}
	}

	public int getDWZDialogHeight() {
		try {
			return Integer.parseInt(prop.getProperty(DWZ_DIALOG_HEIGHT));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_HEIGHT;
		}
	}

	public int getELODialogX() {
		try {
			return Integer.parseInt(prop.getProperty(ELO_DIALOG_X));

		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_X;
		}
	}

	public int getELODialogY() {
		try {
			return Integer.parseInt(prop.getProperty(ELO_DIALOG_Y));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_Y;
		}
	}

	public int getELODialogWidth() {
		try {
			return Integer.parseInt(prop.getProperty(ELO_DIALOG_WIDTH));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_WIDTH;
		}
	}

	public int getELODialogHeight() {
		try {
			return Integer.parseInt(prop.getProperty(ELO_DIALOG_HEIGHT));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_HEIGHT;
		}
	}

	public int getInfoDialogX() {
		try {
			return Integer.parseInt(prop.getProperty(INFO_DIALOG_X));

		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_X;
		}
	}

	public int getInfoDialogY() {
		try {
			return Integer.parseInt(prop.getProperty(INFO_DIALOG_Y));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_Y;
		}
	}

	public int getInfoDialogWidth() {
		try {
			return Integer.parseInt(prop.getProperty(INFO_DIALOG_WIDTH));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_WIDTH;
		}
	}

	public int getInfoDialogHeight() {
		try {
			return Integer.parseInt(prop.getProperty(INFO_DIALOG_HEIGHT));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_HEIGHT;
		}
	}

	public int getSettingsDialogX() {
		try {
			return Integer.parseInt(prop.getProperty(SETTINGS_DIALOG_X));

		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_X;
		}
	}

	public int getSettingsDialogY() {
		try {
			return Integer.parseInt(prop.getProperty(SETTINGS_DIALOG_Y));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_Y;
		}
	}

	public int getSettingsDialogWidth() {
		try {
			return Integer.parseInt(prop.getProperty(SETTINGS_DIALOG_WIDTH));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_WIDTH;
		}
	}

	public int getSettingsDialogHeight() {
		try {
			return Integer.parseInt(prop.getProperty(SETTINGS_DIALOG_HEIGHT));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_HEIGHT;
		}
	}

	public int getStartpageDialogX() {
		try {
			return Integer.parseInt(prop.getProperty(STARTPAGE_DIALOG_X));

		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_X;
		}
	}

	public int getStartpageDialogY() {
		try {
			return Integer.parseInt(prop.getProperty(STARTPAGE_DIALOG_Y));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_BOUNDS_Y;
		}
	}

	public int getStartpageDialogWidth() {
		try {
			return Integer.parseInt(prop.getProperty(STARTPAGE_DIALOG_WIDTH));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_WIDTH;
		}
	}

	public int getStartpageDialogHeight() {
		try {
			return Integer.parseInt(prop.getProperty(STARTPAGE_DIALOG_HEIGHT));
		} catch (final NumberFormatException e) {
			return TournamentConstants.WINDOW_HEIGHT;
		}
	}

	public String getCutForename() {
		return prop.getProperty(CUT_FORENAME);
	}

	public String getCutSurname() {
		return prop.getProperty(CUT_SURNAME);
	}

	public void setFrameX(final int x) {
		prop.setProperty(FRAME_X, Integer.toString(x));
	}

	public void setFrameY(final int y) {
		prop.setProperty(FRAME_Y, Integer.toString(y));
	}

	public void setFrameWidth(final int width) {
		prop.setProperty(FRAME_WIDTH, Integer.toString(width));
	}

	public void setFrameHeight(final int height) {
		prop.setProperty(FRAME_HEIGHT, Integer.toString(height));
	}

	public Boolean getDatabaseUpdated() {
		if (prop.getProperty(DATABASE_UPDATED).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public String getDefaultPath() {
		return prop.getProperty(DEFAULTPATH);
	}

	public Boolean gethtmlToClipboard() {
		if (prop.getProperty(HTMLTOCLIPBOARD).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public String getLanguage() {
		return prop.getProperty(LANGUAGE);
	}

	public Boolean getNoDWZ() {
		if (prop.getProperty(NODWZ).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getNoELO() {
		if (prop.getProperty(NOELO).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getNoFolgeDWZ() {
		if (prop.getProperty(NOFOLGEDWZ).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getNoFolgeELO() {
		if (prop.getProperty(NOFOLGEELO).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean getNoWritableProperties() {
		return NoWritableProperties;
	}

	public Boolean getOnlyTables() {
		if (prop.getProperty(ONLYTABLES).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public String getPathToDatabase() {
		return prop.getProperty(PATHTODATABASE);
	}

	public String getPathToPlayersCSV() {
		return prop.getProperty(PATHTOPLAYERSCSV);
	}

	public String getPathToPlayersELO() {
		return prop.getProperty(PATHTOPLAYERSELO);
	}

	public String getPathToVereineCSV() {
		return prop.getProperty(PATHTOVEREINECSV);
	}

	public String getPathToVereineCVS() {
		return prop.getProperty(PATHTOVEREINECSV);
	}

	public Boolean getPDFLinks() {
		if (prop.getProperty(PDFLINKS).equals(TRUE)) {
			return true;
		} else {
			return false;
		}
	}

	public Properties getProp() {
		return prop;
	}

	public int getSpielerProTab() {
		try {
			return Integer.parseInt(prop.getProperty(SPIELERPROTAB));
		} catch (final NumberFormatException e) {
			return 1;
		}
	}

	public int getTabellenAbstand() {
		int dwzabstand = 0;
		int eloabstand = 0;
		if (getNoDWZ() == false) {
			dwzabstand++;
			// ohneDWZString = "";
		}
		if (getNoFolgeDWZ() == false) {
			dwzabstand++;
			// ohneFolgeDWZString = "";
		}
		if (getNoELO() == false) {
			eloabstand++;
			// ohneELOString = "";
		}
		if (getNoFolgeELO() == false) {
			eloabstand++;
			// ohneFolgeELOString = "";
		}
		final int gesamtabstand = dwzabstand + eloabstand;

		return gesamtabstand;
	}

	public String getTableComumnBlack() {

		return prop.getProperty(TABLE_COLUMN_BLACK);
	}

	public String getTableComumnMeeting() {

		return prop.getProperty(TABLE_COLUMN_MEETING);
	}

	public String getTableComumnNewDWZ() {

		return prop.getProperty(TABLE_COLUMN_NEW_DWZ);
	}

	public String getTableComumnNewELO() {

		return prop.getProperty(TABLE_COLUMN_NEW_ELO);
	}

	public String getTableComumnOldDWZ() {

		return prop.getProperty(TABLE_COLUMN_OLD_DWZ);
	}

	public String getTableComumnOldELO() {
		return prop.getProperty(TABLE_COLUMN_OLD_ELO);
	}

	public String getTableComumnPlayer() {

		return prop.getProperty(TABLE_COLUMN_PLAYER);
	}

	public String getTableComumnPoints() {

		return prop.getProperty(TABLE_COLUMN_POINTS);
	}

	public String getTableComumnRanking() {

		return prop.getProperty(TABLE_COLUMN_RANKING);
	}

	public String getTableComumnResult() {

		return prop.getProperty(TABLE_COLUMN_RESULT);
	}

	public String getTableComumnRound() {

		return prop.getProperty(TABLE_COLUMN_ROUND);
	}

	public String getTableComumnSonnebornBerger() {

		return prop.getProperty(TABLE_COLUMN_SONNEBORNBERGER);
	}

	public String getTableComumnWhite() {

		return prop.getProperty(TABLE_COLUMN_WHITE);
	}

	public int getTurniereProTab() {
		try {
			return Integer.parseInt(prop.getProperty(TURNIEREPROTAB));
		} catch (final NumberFormatException e) {
			return 1;
		}
	}

	public String getWebserverPath() {
		return prop.getProperty(WEBSERVER_PATH);
	}

	public String getZPS() {
		return prop.getProperty(ZPS);
	}

	public Boolean readProperties() {
		Boolean ok = true;

		// auslesen
		try {
			prop.load(new StringReader(prefs.get("properties", null)));
			checkProperties();

			ok = true;
		} catch (final IOException e) {

			ok = false;
		} catch (final NullPointerException e) {
			checkProperties();
			writeProperties();
			ok = true;
		}
		return ok;
	}

	public void setCutForename(final String namecut) {
		prop.setProperty(CUT_FORENAME, namecut);
	}

	public void setCutSurname(final String namecut) {
		prop.setProperty(CUT_SURNAME, namecut);
	}

	public void setDatabaseUpdated(final boolean b) {
		if (b == true) {
			prop.setProperty(DATABASE_UPDATED, TRUE);
		} else {
			prop.setProperty(DATABASE_UPDATED, FALSE);
		}

	}

	public void setDefaultPath(final String absolutePath) {
		prop.setProperty(DEFAULTPATH, absolutePath);
	}

	public void sethtmlToClipboard(final Boolean htmlToClipboard) {
		if (htmlToClipboard == true) {
			prop.setProperty(HTMLTOCLIPBOARD, TRUE);
		} else {
			prop.setProperty(HTMLTOCLIPBOARD, FALSE);
		}
	}

	public void setLanguage(final String language) {
		prop.setProperty(LANGUAGE, language);
	}

	public void setNoDWZ(final Boolean noDWZWert) {
		if (noDWZWert == true) {
			prop.setProperty(NODWZ, TRUE);
		} else {
			prop.setProperty(NODWZ, FALSE);
		}
	}

	public void setNoELO(final Boolean noELO) {
		if (noELO == true) {
			prop.setProperty(NOELO, TRUE);
		} else {
			prop.setProperty(NOELO, FALSE);
		}

	}

	public void setNoFolgeDWZ(final Boolean noDWZWert) {
		if (noDWZWert == true) {
			prop.setProperty(NOFOLGEDWZ, TRUE);
		} else {
			prop.setProperty(NOFOLGEDWZ, FALSE);
		}
	}

	public void setNoFolgeELO(final boolean noFolgeELO) {
		if (noFolgeELO == true) {
			prop.setProperty(NOFOLGEELO, TRUE);
		} else {
			prop.setProperty(NOFOLGEELO, FALSE);
		}
	}

	public void setNoWritableProperties(final Boolean noWritableProperties) {
		NoWritableProperties = noWritableProperties;
	}

	public void setOnlyTables(final boolean b) {
		if (b == true) {
			prop.setProperty(ONLYTABLES, TRUE);
		} else {
			prop.setProperty(ONLYTABLES, FALSE);
		}

	}

	public void setPathToDatabase(final String db_PATH) {
		prop.setProperty(PATHTODATABASE, db_PATH);
	}

	public void setPathToPlayersCSV(final String csv_PATH) {
		prop.setProperty(PATHTOPLAYERSCSV, csv_PATH);
	}

	public void setPathToPlayersELO(final String absolutePath) {
		prop.setProperty(PATHTOPLAYERSELO, absolutePath);

	}

	public void setPathToVereineCSV(final String vereinecsv_PATH) {
		prop.setProperty(PATHTOVEREINECSV, vereinecsv_PATH);
	}

	public void setPathToVereineCVS(final String absolutePath) {
		prop.setProperty(PATHTOVEREINECSV, absolutePath);
	}

	public void setPDFLinks(final Boolean pdfLinks) {
		if (pdfLinks == true) {
			prop.setProperty(PDFLINKS, TRUE);
		} else {
			prop.setProperty(PDFLINKS, FALSE);
		}
	}

	public void setProp(final Properties prop) {
		this.prop = prop;
	}

	public void setSpielerProTab(final int anzahlprotab) {

		prop.setProperty(SPIELERPROTAB, Integer.toString(anzahlprotab));

	}

	public void setTableComumnBlack(final String tableString) {
		prop.setProperty(TABLE_COLUMN_BLACK, tableString);

	}

	public void setTableComumnMeeting(final String tableString) {
		prop.setProperty(TABLE_COLUMN_MEETING, tableString);

	}

	public void setTableComumnNewDWZ(final String tableString) {
		prop.setProperty(TABLE_COLUMN_NEW_DWZ, tableString);

	}

	public void setTableComumnNewELO(final String tableString) {
		prop.setProperty(TABLE_COLUMN_NEW_ELO, tableString);

	}

	public void setTableComumnOldDWZ(final String tableString) {
		prop.setProperty(TABLE_COLUMN_OLD_DWZ, tableString);

	}

	public void setTableComumnOldELO(final String tableString) {
		prop.setProperty(TABLE_COLUMN_OLD_ELO, tableString);

	}

	public void setTableComumnPlayer(final String tableString) {
		prop.setProperty(TABLE_COLUMN_PLAYER, tableString);

	}

	public void setTableComumnPoints(final String tableString) {
		prop.setProperty(TABLE_COLUMN_POINTS, tableString);

	}

	public void setTableComumnRanking(final String tableString) {
		prop.setProperty(TABLE_COLUMN_RANKING, tableString);

	}

	public void setTableComumnResult(final String tableString) {
		prop.setProperty(TABLE_COLUMN_RESULT, tableString);

	}

	public void setTableComumnRound(final String tableString) {
		prop.setProperty(TABLE_COLUMN_ROUND, tableString);

	}

	public void setTableComumnSonnebornBerger(final String tableString) {
		prop.setProperty(TABLE_COLUMN_SONNEBORNBERGER, tableString);

	}

	public void setTableComumnWhite(final String tableString) {
		prop.setProperty(TABLE_COLUMN_WHITE, tableString);

	}

	public void setTurniereProTab(final int anzahlprotab) {
		prop.setProperty(TURNIEREPROTAB, Integer.toString(anzahlprotab));
	}

	public void setWebserverPath(final String path) {
		prop.setProperty(WEBSERVER_PATH, path);
	}

	public void setZPS(final String zps) {
		prop.setProperty(ZPS, zps);

	}

	public void setBounds() {
		setFrameX(mainControl.getBounds().x);
		setFrameY(mainControl.getBounds().y);
		setFrameWidth(mainControl.getBounds().width);
		setFrameHeight(mainControl.getBounds().height);
	}

	public Boolean writeProperties() {
		Boolean ok = true;

		// speichern
		final StringWriter sw = new StringWriter();
		try {
			prop.store(sw, null);
			prefs.put("properties", sw.toString());
			ok = true;
			NoWritableProperties = false;
		} catch (final IOException e) {
			e.printStackTrace();
			ok = false;
			NoWritableProperties = true;
		}

		return ok;
	}

	public Boolean writeDWZDialogProperties(final int x, final int y, final int width, final int height) {
		Boolean ok = true;

		final String dwzx = String.valueOf(x);
		final String dwzy = String.valueOf(y);
		final String dwzwidth = String.valueOf(width);
		final String dwzheight = String.valueOf(height);
		prop.setProperty(DWZ_DIALOG_X, dwzx);
		prop.setProperty(DWZ_DIALOG_Y, dwzy);
		prop.setProperty(DWZ_DIALOG_WIDTH, dwzwidth);
		prop.setProperty(DWZ_DIALOG_HEIGHT, dwzheight);
		ok = writeProperties();

		return ok;

	}

	public Boolean writeELODialogProperties(final int x, final int y, final int width, final int height) {
		Boolean ok = true;

		final String dwzx = String.valueOf(x);
		final String dwzy = String.valueOf(y);
		final String dwzwidth = String.valueOf(width);
		final String dwzheight = String.valueOf(height);
		prop.setProperty(ELO_DIALOG_X, dwzx);
		prop.setProperty(ELO_DIALOG_Y, dwzy);
		prop.setProperty(ELO_DIALOG_WIDTH, dwzwidth);
		prop.setProperty(ELO_DIALOG_HEIGHT, dwzheight);
		ok = writeProperties();

		return ok;

	}

	public Boolean writeInfoDialogProperties(final int x, final int y, final int width, final int height) {
		Boolean ok = true;

		final String dwzx = String.valueOf(x);
		final String dwzy = String.valueOf(y);
		final String dwzwidth = String.valueOf(width);
		final String dwzheight = String.valueOf(height);
		prop.setProperty(INFO_DIALOG_X, dwzx);
		prop.setProperty(INFO_DIALOG_Y, dwzy);
		prop.setProperty(INFO_DIALOG_WIDTH, dwzwidth);
		prop.setProperty(INFO_DIALOG_HEIGHT, dwzheight);
		ok = writeProperties();

		return ok;

	}

	public Boolean writeSettingsDialogProperties(final int x, final int y, final int width, final int height) {
		Boolean ok = true;

		final String dwzx = String.valueOf(x);
		final String dwzy = String.valueOf(y);
		final String dwzwidth = String.valueOf(width);
		final String dwzheight = String.valueOf(height);
		prop.setProperty(SETTINGS_DIALOG_X, dwzx);
		prop.setProperty(SETTINGS_DIALOG_Y, dwzy);
		prop.setProperty(SETTINGS_DIALOG_WIDTH, dwzwidth);
		prop.setProperty(SETTINGS_DIALOG_HEIGHT, dwzheight);
		ok = writeProperties();

		return ok;

	}

	public Boolean writeStartpageDialogProperties(final int x, final int y, final int width, final int height) {
		Boolean ok = true;

		final String startpagex = String.valueOf(x);
		final String startpagey = String.valueOf(y);
		final String startpagewidth = String.valueOf(width);
		final String startpageheight = String.valueOf(height);
		prop.setProperty(STARTPAGE_DIALOG_X, startpagex);
		prop.setProperty(STARTPAGE_DIALOG_Y, startpagey);
		prop.setProperty(STARTPAGE_DIALOG_WIDTH, startpagewidth);
		prop.setProperty(STARTPAGE_DIALOG_HEIGHT, startpageheight);
		ok = writeProperties();

		return ok;

	}

	public void setSpielfrei(final String spielfrei) {
		prop.setProperty(SPIELFREI, spielfrei);
		TournamentConstants.setSpielfrei(spielfrei);

	}

	public String getSpielfrei() {
		return prop.getProperty(SPIELFREI);
	}
}
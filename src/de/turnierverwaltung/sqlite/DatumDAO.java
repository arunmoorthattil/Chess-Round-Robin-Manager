package de.turnierverwaltung.sqlite;

import java.sql.SQLException;
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
import java.util.ArrayList;

public interface DatumDAO {
	public void createDatumTable() throws SQLException;

	public boolean deleteDatum(int id) throws SQLException;

	public String[] findDatum(int id) throws SQLException;

	public int insertDatum(String startDatum, String endDatum) throws SQLException;

	public ArrayList<String> selectAllDatum() throws SQLException;

	public boolean updateDatum(int idDatum, String startDatum, String endDatum) throws SQLException;

}

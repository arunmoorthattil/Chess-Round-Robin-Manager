package de.turnierverwaltung.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.turnierverwaltung.model.rating.ELOData;
import de.turnierverwaltung.model.rating.ELOPlayer;

public class SQLiteELODataDAO implements ELODataDAO {
	private Connection dbConnect;

	public SQLiteELODataDAO() {
		dbConnect = null;
		dbConnect = SQLiteDAOFactory.createConnection();
	}

	@Override
	public void createELOTable() throws SQLException {
		final String sql = "CREATE TABLE 'elo_data' (\n" + "  'Name'               varchar(57)  NOT NULL default '',\n"
				+ "  'Fed'                varchar(5)   NOT NULL default '',\n"
				+ "  'Sex'                varchar(3)      NOT NULL default '',\n"
				+ "  'Tit'                varchar(3)               default NULL,\n"
				+ "  'WTit'               varchar(3)               default NULL,\n"
				+ "  'OTit'               varchar(3)      NOT NULL default '',\n"
				+ "  'FOA'                varchar(3)       NOT NULL default '',\n"
				+ "  'Rating'              INTEGER  unsigned default NULL,\n"
				+ "  'Gms'                INTEGER  unsigned default NULL,\n"
				+ "  'K'                  INTEGER  unsigned default NULL,\n"
				+ "  'Bday'              INTEGER  unsigned default NULL,\n"
				+ "  'Flag'               char(2)               default NULL,\n"
				+ "  'idSpieler'           INTEGER NOT NULL,\n" // ---
				+ "  'ID_Number'          INTEGER NOT NULL,\n"
				+ "  'idELOData' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL\n" + ");";
		Statement stmt;
		if (dbConnect != null) {

			// create a database connection

			stmt = dbConnect.createStatement();

			stmt.setQueryTimeout(30); // set timeout to 30 sec.
			stmt.executeUpdate(sql);
			stmt.close();

		}

	}

	@Override
	public void deleteELO(final int id) throws SQLException {
		final String sql = "delete from elo_data where idSpieler=?" + ";";
		if (dbConnect != null) {

			final PreparedStatement preStm = dbConnect.prepareStatement(sql);
			preStm.setInt(1, id);
			preStm.addBatch();
			dbConnect.setAutoCommit(false);
			preStm.executeBatch();
			dbConnect.setAutoCommit(true);
			preStm.close();

		}

	}

	@Override
	public void flush(final ArrayList<ELOPlayer> eloDataArray) throws SQLException {
		final String sql = "Insert into elo_data (Name, Fed, Sex, Tit, WTit, OTit, FOA, Rating, Gms, K, Bday, Flag, idSpieler, ID_Number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		if (dbConnect != null) {

			final PreparedStatement preStm = dbConnect.prepareStatement(sql);

			for (final ELOPlayer eloPlayer : eloDataArray) {
				final ELOData eloData = eloPlayer.getEloData();
				preStm.setString(1, eloData.getName());
				preStm.setString(2, eloData.getCountry());
				preStm.setString(3, eloData.getSex());
				preStm.setString(4, eloData.getTitle());
				preStm.setString(5, eloData.getW_title());
				preStm.setString(6, eloData.getO_title());
				preStm.setString(7, eloData.getFoa_title());
				preStm.setInt(8, eloData.getRating());
				preStm.setInt(9, eloData.getGames());
				preStm.setInt(10, eloData.getK());
				preStm.setInt(11, eloData.getBirthday());
				preStm.setString(12, eloData.getFlag());
				preStm.setInt(13, eloData.getSpielerId());
				preStm.setInt(14, eloData.getFideid());
				preStm.addBatch();
			}

			dbConnect.setAutoCommit(false);
			preStm.executeBatch();
			dbConnect.setAutoCommit(true);
			preStm.close();
		}

	}

	@Override
	public ELOData getELOData(final int id) throws SQLException {
		final String sql = "Select * from elo_data WHERE idSpieler=" + id + ";";
		final ELOData eloData = new ELOData();

		Statement stmt;
		if (dbConnect != null) {

			stmt = dbConnect.createStatement();
			final ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				eloData.setSpielerId(id);
				eloData.setName(rs.getString("Name"));
				eloData.setCountry(rs.getString("Fed"));
				eloData.setSex(rs.getString("Sex"));
				eloData.setTitle(rs.getString("Tit"));
				eloData.setW_title(rs.getString("WTit"));
				eloData.setO_title(rs.getString("OTit"));
				eloData.setFoa_title(rs.getString("FOA"));
				eloData.setRating(rs.getInt("Rating"));
				eloData.setGames(rs.getInt("Gms"));
				eloData.setK(rs.getInt("K"));
				eloData.setBirthday(rs.getInt("Bday"));
				eloData.setFlag(rs.getString("Flag"));
				eloData.setFideid(rs.getInt("ID_Number"));
				eloData.setSpielerId(rs.getInt("idSpieler"));
			}

			stmt.close();

		}
		return eloData;
	}

	@Override
	public ELOData getELODataByFideId(final int id) throws SQLException {
		final String sql = "Select * from elo_data WHERE ID_Number=" + id + ";";
		final ELOData eloData = new ELOData();

		Statement stmt;
		if (dbConnect != null) {

			stmt = dbConnect.createStatement();
			final ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				eloData.setSpielerId(id);
				eloData.setName(rs.getString("Name"));
				eloData.setCountry(rs.getString("Fed"));
				eloData.setSex(rs.getString("Sex"));
				eloData.setTitle(rs.getString("Tit"));
				eloData.setW_title(rs.getString("WTit"));
				eloData.setO_title(rs.getString("OTit"));
				eloData.setFoa_title(rs.getString("FOA"));
				eloData.setRating(rs.getInt("Rating"));
				eloData.setGames(rs.getInt("Gms"));
				eloData.setK(rs.getInt("K"));
				eloData.setBirthday(rs.getInt("Bday"));
				eloData.setFlag(rs.getString("Flag"));
				eloData.setFideid(rs.getInt("ID_Number"));
				eloData.setSpielerId(rs.getInt("idSpieler"));
			}

			stmt.close();

		}
		return eloData;
	}

	@Override
	public ArrayList<ELOData> getELODataByName(final String eingabe) throws SQLException {
		final String sql = "Select * from elo_data WHERE Name LIKE '%" + eingabe + "%' LIMIT 40;";

		final ArrayList<ELOData> eloDataArray = new ArrayList<ELOData>();

		Statement stmt;
		if (dbConnect != null) {

			stmt = dbConnect.createStatement();
			final ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				final ELOData eloData = new ELOData();
				int sId = -1;
				final String spielerid = rs.getString("idSpieler");
				try {
					sId = Integer.parseInt(spielerid);
				} catch (final NumberFormatException e) {
					sId = -1;
				}
				eloData.setSpielerId(sId);
				eloData.setName(rs.getString("Name"));
				eloData.setCountry(rs.getString("Fed"));
				eloData.setSex(rs.getString("Sex"));
				eloData.setTitle(rs.getString("Tit"));
				eloData.setW_title(rs.getString("WTit"));
				eloData.setO_title(rs.getString("OTit"));
				eloData.setFoa_title(rs.getString("FOA"));
				eloData.setRating(rs.getInt("Rating"));
				eloData.setGames(rs.getInt("Gms"));
				eloData.setK(rs.getInt("K"));
				eloData.setBirthday(rs.getInt("Bday"));
				eloData.setFlag(rs.getString("Flag"));
				eloData.setFideid(rs.getInt("ID_Number"));
				eloDataArray.add(eloData);
			}

			stmt.close();

		}
		return eloDataArray;
	}

	@Override
	public void insertELO(final ELOData eloData) throws SQLException {
		String sql;

		sql = "Insert into elo_data (Name, Fed, Sex, Tit, WTit, OTit, FOA, Rating, Gms, K, Bday, Flag, idSpieler, ID_Number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

		if (dbConnect != null) {

			final PreparedStatement preStm = dbConnect.prepareStatement(sql);
			preStm.setString(1, eloData.getName());
			preStm.setString(2, eloData.getCountry());
			preStm.setString(3, eloData.getSex());
			preStm.setString(4, eloData.getTitle());
			preStm.setString(5, eloData.getW_title());
			preStm.setString(6, eloData.getO_title());
			preStm.setString(7, eloData.getFoa_title());
			preStm.setInt(8, eloData.getRating());
			preStm.setInt(9, eloData.getGames());
			preStm.setInt(10, eloData.getK());
			preStm.setInt(11, eloData.getBirthday());
			preStm.setString(12, eloData.getFlag());
			preStm.setInt(13, eloData.getSpielerId());
			preStm.setInt(14, eloData.getFideid());

			preStm.addBatch();
			dbConnect.setAutoCommit(false);
			preStm.executeBatch();
			dbConnect.setAutoCommit(true);
			// ResultSet rs = preStm.getGeneratedKeys();

			preStm.close();

		}
	}

	@Override
	public boolean playerExist(final int fideId) throws SQLException {
		final String sql = "Select idSpieler from elo_data where ID_Number LIKE '" + fideId + ";";

		int id = -1;
		Statement stmt;
		if (dbConnect != null) {

			try {
				stmt = dbConnect.createStatement();
				final ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					id = rs.getInt("idSpieler");

				}
				stmt.close();
			} catch (final SQLException e) {
				id = -1;

			}
		}
		Boolean returnStatement = false;
		if (id > 0) {
			returnStatement = true;
		}

		return returnStatement;
	}

	@Override
	public void updateELO(final ELOData eloData) throws SQLException {
		final String sql = "update elo_data set Name = ?, Fed = ?, Sex = ?, Tit = ?, WTit = ?, OTit = ?, FOA = ?, Rating = ?, Gms = ?, K = ?, Bday = ?, Flag = ?, ID_Number = ? where idSpieler = "
				+ eloData.getSpielerId() + ";";

		if (dbConnect != null) {
			final PreparedStatement preStm = dbConnect.prepareStatement(sql);
			preStm.setString(1, eloData.getName());
			preStm.setString(2, eloData.getCountry());
			preStm.setString(3, eloData.getSex());
			preStm.setString(4, eloData.getTitle());
			preStm.setString(5, eloData.getW_title());
			preStm.setString(6, eloData.getO_title());
			preStm.setString(7, eloData.getFoa_title());
			preStm.setInt(8, eloData.getRating());
			preStm.setInt(9, eloData.getGames());
			preStm.setInt(10, eloData.getK());
			preStm.setInt(11, eloData.getBirthday());
			preStm.setString(12, eloData.getFlag());
			preStm.setInt(13, eloData.getFideid());
			preStm.addBatch();
			dbConnect.setAutoCommit(false);
			preStm.executeBatch();
			dbConnect.setAutoCommit(true);
			preStm.close();

		}

	}

	@Override
	public boolean spielerIdExist(int spielerId) throws SQLException {
		final String sql = "Select idSpieler from elo_data where idSpieler = '" + spielerId + ";";

		int id = -1;
		Statement stmt;
		if (dbConnect != null) {

			try {
				stmt = dbConnect.createStatement();
				final ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					id = rs.getInt("idSpieler");

				}
				stmt.close();
			} catch (final SQLException e) {
				id = -1;

			}
		}
		Boolean returnStatement = false;
		if (id > 0) {
			returnStatement = true;
		}

		return returnStatement;
	}

}

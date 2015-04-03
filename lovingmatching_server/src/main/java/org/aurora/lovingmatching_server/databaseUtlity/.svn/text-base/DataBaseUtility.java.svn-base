package org.aurora.lovingmatching_server.databaseUtlity;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aurora.lovingmatching_server.po.EnemyPO;
import org.aurora.lovingmatching_server.po.HitInfoPO;
import org.aurora.lovingmatching_server.po.PKHistoryPO;
import org.aurora.lovingmatching_server.po.PartnerPO;
import org.aurora.lovingmatching_server.po.UserPO;
import org.omg.CORBA.portable.IDLEntity;
import org.aurora.lovingmatching_server.po.CoopHistoryPO;

/**
 * 
 * @author ljing12[AT]software.nju.edu.cn
 */
public class DataBaseUtility implements AbstractDataBaseUtility {

	Connection dbConnection;
	Statement statement;
	ResultSet resultSet;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	String url = "jdbc:mysql://localhost:3306/";
	String user = "root";
	String psw = "12345678";

	public DataBaseUtility() {
		try {
			// 建立数据库连接
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			dbConnection = DriverManager.getConnection(url, user, psw);
			statement = dbConnection.createStatement();
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	@Override
	public boolean addUser(UserPO upo) {
		String addString = "insert into ";
		addString = addString + DBInfo.getDbName() + "."
				+ DBInfo.getUserTName() + " values(\'";
		addString = addString + upo.getUid() + "\' , \'" + upo.getUpsw()
				+ "\' , " + upo.getRank() + " , " + upo.getTotalScore() + " , ";
		addString = addString + upo.getMoney() + ")";
		// System.out.println(addString);
		try {
			statement.executeUpdate(addString);
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	public boolean updateUserInfo(UserPO upo) {
		String updateString = "update ";
		updateString = updateString + DBInfo.getDbName() + "."
				+ DBInfo.getUserTName() + " set ";
		updateString = updateString + DBInfo.getUserPSWAttr() + " = '"
				+ upo.getUpsw() + "' , ";
		updateString = updateString + DBInfo.getUserRankAttr() + " = "
				+ upo.getRank() + " , ";
		updateString = updateString + DBInfo.getUserScoreAttr() + " = "
				+ upo.getTotalScore() + " , ";
		updateString = updateString + DBInfo.getUserMoneyAttr() + " = "
				+ upo.getMoney() + " ";
		updateString = updateString + "where " + DBInfo.getUserIDAttr()
				+ " = '" + upo.getUid() + "' ";
		// System.out.println(updateString);
		try {
			statement.executeUpdate(updateString);
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(String uid) {
		String deleteString = "delete from " + DBInfo.getDbName() + "."
				+ DBInfo.getUserTName() + " where ";
		deleteString = deleteString + DBInfo.getUserIDAttr() + " = '" + uid
				+ "' ";
		// System.out.println(deleteString);
		try {
			statement.executeUpdate(deleteString);
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	@Override
	public UserPO getUserInfo(String uid) {
		UserPO resultUserPO = null;
		String getInfoString = "select * from " + DBInfo.getDbName() + "."
				+ DBInfo.getUserTName() + " where ";
		getInfoString = getInfoString + DBInfo.getUserIDAttr() + " = '" + uid
				+ "' ";
		// System.out.println(getInfoString);
		try {
			resultSet = statement.executeQuery(getInfoString);
			while (resultSet.next()) {
				String userID = ""
						+ resultSet.getString(DBInfo.getUserIDAttr());
				String psw = "" + resultSet.getString(DBInfo.getUserPSWAttr());
				int rank = resultSet.getInt(DBInfo.getUserRankAttr());
				int totalScore = resultSet.getInt(DBInfo.getUserScoreAttr());
				int money = resultSet.getInt(DBInfo.getUserMoneyAttr());
				resultUserPO = new UserPO(userID, psw, rank, totalScore, money);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}

		return resultUserPO;
	}

	@Override
	public boolean addCoopHistory(CoopHistoryPO chPO) {
		String hostID = chPO.getHostID();
		Date timeStamp = chPO.getTimestamp();
		int score = chPO.getScore();
		int money = chPO.getMoney();
		ArrayList<String> members = chPO.getMemberList();
		String addCoopPreString = "insert into " + DBInfo.getDbName() + "."
				+ DBInfo.getCoopHistoryTName();
		addCoopPreString = addCoopPreString + " values(?,?,?,?)";
		// System.out.println(addCoopPreString);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbConnection.prepareStatement(addCoopPreString);
			preparedStatement.setString(1, hostID);
			// preparedStatement.setDate(2, new
			// java.sql.Date(timeStamp.getDate()));
			preparedStatement.setTimestamp(2,
					new java.sql.Timestamp(timeStamp.getTime()));
			preparedStatement.setInt(3, score);
			preparedStatement.setInt(4, money);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}

		members.add(hostID);
		int memberSum = members.size();
		for (int i = 0; i < memberSum; i++) {
			ArrayList<String> parterIDs = (ArrayList<String>) members.clone();
			parterIDs.remove(i);
			PartnerPO ppo = new PartnerPO(members.get(i), timeStamp, hostID,
					parterIDs);
			addPartner(ppo);
		}
		return true;
	}

	@Override
	public ArrayList<CoopHistoryPO> getCoopHistory(String uid) {
		ArrayList<CoopHistoryPO> chpos = new ArrayList<CoopHistoryPO>();
		String getChpString = "select distinct " + DBInfo.getpHisUser() + ","
				+ DBInfo.getPkHisTime();
		getChpString += "," + DBInfo.getpHisHost();
		getChpString += " from " + DBInfo.getDbName() + "."
				+ DBInfo.getPartnerHistoryTName();
		getChpString += " where uid = '" + uid + "' order by "
				+ DBInfo.getPkHisTime();
		ArrayList<String> hostIDs = new ArrayList<String>();
		ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();

		// System.out.println(getChpString);
		try {
			resultSet = statement.executeQuery(getChpString);
			while (resultSet.next()) {
				hostIDs.add(resultSet.getString(DBInfo.getPkHisHostString()));
				timestamps.add(resultSet.getTimestamp(DBInfo.getPkHisTime()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		int i = 0;
		for (String hid : hostIDs) {
			Timestamp tmstp = timestamps.get(i++);
			chpos.add(getCoopHistoryPO(hid, tmstp));
		}
		return chpos;
	}

	private CoopHistoryPO getCoopHistoryPO(String hostuid, Timestamp timestamp) {
		CoopHistoryPO chpo = null;
		String getchString = "select * from " + DBInfo.getDbName() + "."
				+ DBInfo.getCoopHistoryTName();
		getchString += " where " + DBInfo.getCoopHisHostString() + " = '"
				+ hostuid + "' and ";
		getchString += DBInfo.getCoopHisTime() + " = '"
				+ timestamp.toLocaleString() + "' ";
		// 下面这两行的写法也是可以的
		// getchString+="date_format( "+DBInfo.getCoopHistoryTName()+"."+DBInfo.getCoopHisTime();
		// getchString+=", '%Y-%c-%e %T') ="+timestamp.toLocaleString();
		// System.out.println(getchString);
		try {
			resultSet = statement.executeQuery(getchString);
			Date date = sdf.parse(timestamp.toLocaleString());
			while (resultSet.next()) {
				int score = resultSet.getInt(DBInfo.getCoopHisScore());
				int money = resultSet.getInt(DBInfo.getCoopHisMoney());
				chpo = new CoopHistoryPO(hostuid, date, score, money);
				ArrayList<String> memberIDs = getOneGamePartenrs(hostuid,
						timestamp);
				if (memberIDs != null) {
					for (String mem : memberIDs) {
						chpo.addMember(mem);
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		} catch (ParseException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		return chpo;
	}

	@Override
	public ArrayList<CoopHistoryPO> getCoopHistory(int sum) {
		ArrayList<CoopHistoryPO> chpos = new ArrayList<CoopHistoryPO>();
		ArrayList<String> hostIDs = new ArrayList<String>();
		ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();
		String getCoopString = "select * from " + DBInfo.getDbName() + "."
				+ DBInfo.getCoopHistoryTName();
		getCoopString += " order by " + DBInfo.getCoopHisScore()
				+ " desc limit 0," + sum;
		// System.out.println(getCoopString);
		try {
			resultSet = statement.executeQuery(getCoopString);
			while (resultSet.next()) {
				hostIDs.add(resultSet.getString(DBInfo.getPkHisHostString()));
				timestamps.add(resultSet.getTimestamp(DBInfo.getPkHisTime()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		int i = 0;
		int size = hostIDs.size();
		for (String hid : hostIDs) {
			Timestamp tmstp = timestamps.get(i++);
			chpos.add(getCoopHistoryPO(hid, tmstp));
		}
		return chpos;
	}

	@Override
	public boolean addPKHistory(PKHistoryPO pkhpo) {
		CoopHistoryPO cpo1 = pkhpo.getChpo1();
		CoopHistoryPO cpo2 = pkhpo.getChpo2();
		ArrayList<String> team2users = (ArrayList<String>) cpo2.getMemberList()
				.clone();
		ArrayList<String> team1users = (ArrayList<String>) cpo1.getMemberList()
				.clone();
		String hostID1 = cpo1.getHostID();
		String hostID2 = cpo2.getHostID();
		Date timestamp = pkhpo.getTimestamp();
		String addPKString = "insert into " + DBInfo.getDbName() + "."
				+ DBInfo.getPkHistoryTName();
		addPKString += " values(?,?,?)";
		System.out.println(addPKString);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbConnection.prepareStatement(addPKString);
			preparedStatement.setString(1, hostID1);
			preparedStatement.setTimestamp(2,
					new java.sql.Timestamp(timestamp.getTime()));
			preparedStatement.setString(3, hostID2);
			System.out.println(preparedStatement.toString());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		addPKCoopHistory(cpo1);
		addPKCoopHistory(cpo2);
		team2users.add(cpo2.getHostID());
		team1users.add(cpo1.getHostID());
		for (String us : team1users) {
			// System.out.println(++i);
			addEnemy(new EnemyPO(us, cpo1.getTimestamp(), hostID2));
		}
		for (String us : team2users) {
			addEnemy(new EnemyPO(us, cpo2.getTimestamp(), hostID1));
		}

		return true;
	}

	private boolean addPKCoopHistory(CoopHistoryPO chPO) {
		String hostID = chPO.getHostID();
		Date timeStamp = chPO.getTimestamp();
		int score = chPO.getScore();
		int money = chPO.getMoney();
		ArrayList<String> members = chPO.getMemberList();
		String addCoopPreString = "insert into " + DBInfo.getDbName() + "."
				+ DBInfo.getPkCoophistoryTName();
		addCoopPreString = addCoopPreString + " values(?,?,?,?)";
		// System.out.println(addCoopPreString);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbConnection.prepareStatement(addCoopPreString);
			preparedStatement.setString(1, hostID);
			// preparedStatement.setDate(2, new
			// java.sql.Date(timeStamp.getDate()));
			preparedStatement.setTimestamp(2,
					new java.sql.Timestamp(timeStamp.getTime()));
			preparedStatement.setInt(3, score);
			preparedStatement.setInt(4, money);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}

		members.add(hostID);
		int memberSum = members.size();
		for (int i = 0; i < memberSum; i++) {
			ArrayList<String> parterIDs = (ArrayList<String>) members.clone();
			parterIDs.remove(i);
			PartnerPO ppo = new PartnerPO(members.get(i), timeStamp, hostID,
					parterIDs);
			addpkPartner(ppo);
		}
		return true;
	}

	@Override
	public ArrayList<PKHistoryPO> getPKHistory(String uid) {
		ArrayList<PKHistoryPO> pkhpos = new ArrayList<PKHistoryPO>();
		String getChpString = "select distinct " + DBInfo.getPkPartnerUser()
				+ "," + DBInfo.getPkPartnerTime();
		getChpString += "," + DBInfo.getPkPartnerHostID();
		getChpString += " from " + DBInfo.getDbName() + "."
				+ DBInfo.getPkPartnerhistoryTName();
		getChpString += " where uid = '" + uid + "' order by "
				+ DBInfo.getPkPartnerTime();
		ArrayList<String> hostIDs = new ArrayList<String>();
		ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();

		// System.out.println(getChpString);
		try {
			resultSet = statement.executeQuery(getChpString);
			while (resultSet.next()) {
				hostIDs.add(resultSet.getString(DBInfo.getPkPartnerHostID()));
				timestamps
						.add(resultSet.getTimestamp(DBInfo.getPkPartnerTime()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		int i = 0;
		for (String hid : hostIDs) {
			Timestamp tmstp = timestamps.get(i++);
			pkhpos.add(getpkHistoryPO(hid, tmstp));
		}
		return pkhpos;
	}

	private PKHistoryPO getpkHistoryPO(String hostid, Timestamp timestamp) {
		PKHistoryPO pkhpo = null;
		CoopHistoryPO chpo1 = null;
		CoopHistoryPO chpo2 = null;
		String getchString = "select * from " + DBInfo.getDbName() + "."
				+ DBInfo.getPkCoophistoryTName();
		getchString += " where " + DBInfo.getPkCoopHostString() + " = '"
				+ hostid + "' and ";
		getchString += DBInfo.getPkCoopTime() + " = '"
				+ timestamp.toLocaleString() + "' ";
		try {
			resultSet = statement.executeQuery(getchString);
			Date date = sdf.parse(timestamp.toLocaleString());
			while (resultSet.next()) {
				int score = resultSet.getInt(DBInfo.getCoopHisScore());
				int money = resultSet.getInt(DBInfo.getCoopHisMoney());
				chpo1 = new CoopHistoryPO(hostid, date, score, money);
				ArrayList<String> memberIDs = getOneGamePKPartners(hostid,
						timestamp);
				if (memberIDs != null) {
					for (String mem : memberIDs) {
						chpo1.addMember(mem);
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ParseException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		chpo2 = getPKEnemyCoopHistoryPO(hostid, timestamp);
		pkhpo = new PKHistoryPO(chpo1, chpo2);
		return pkhpo;

	}

	private String getPKEnemyHostID(String uid, Timestamp timestamp) {
		String ID = null;
		String getEnemyIDString = "select distinct "
				+ DBInfo.geteEnemyHisHost();
		getEnemyIDString += " from " + DBInfo.getDbName() + "."
				+ DBInfo.getEnemyHistoryTName();
		getEnemyIDString += " where " + DBInfo.geteHisUser() + " = '" + uid
				+ "' and ";
		getEnemyIDString += DBInfo.geteEnemyHisTime() + " = '"
				+ timestamp.toLocaleString() + "' ";
		System.out.println(getEnemyIDString);
		try {
			resultSet = statement.executeQuery(getEnemyIDString);
			while (resultSet.next()) {
				ID = resultSet.getString(DBInfo.geteEnemyHisHost());
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return ID;
	}

	private CoopHistoryPO getPKEnemyCoopHistoryPO(String uid,
			Timestamp timestamp) {
		CoopHistoryPO chpo = null;
		String enemyhost = getPKEnemyHostID(uid, timestamp);
		String getchString = "select * from " + DBInfo.getDbName() + "."
				+ DBInfo.getPkCoophistoryTName();
		getchString += " where " + DBInfo.getPkCoopHostString() + " = '"
				+ enemyhost + "' and ";
		getchString += DBInfo.getPkCoopTime() + " = '"
				+ timestamp.toLocaleString() + "' ";
		// 下面这两行的写法也是可以的
		// getchString+="date_format( "+DBInfo.getCoopHistoryTName()+"."+DBInfo.getCoopHisTime();
		// getchString+=", '%Y-%c-%e %T') ="+timestamp.toLocaleString();
		// System.out.println(getchString);
		try {
			resultSet = statement.executeQuery(getchString);
			Date date = sdf.parse(timestamp.toLocaleString());
			while (resultSet.next()) {
				int score = resultSet.getInt(DBInfo.getPkCoophisScore());
				int money = resultSet.getInt(DBInfo.getPkCoopHisMoney());
				chpo = new CoopHistoryPO(enemyhost, date, score, money);
				ArrayList<String> memberIDs = getOneGamePKPartners(enemyhost,
						timestamp);
				if (memberIDs != null) {
					for (String mem : memberIDs) {
						chpo.addMember(mem);
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		} catch (ParseException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}

		return chpo;
	}

	private ArrayList<String> getOneGamePKPartners(String hostid,
			Timestamp timestamp) {
		ArrayList<String> parters = new ArrayList<String>();
		String oneGMemsString = "select distinct " + DBInfo.getPkPartnerUser()
				+ " from " + DBInfo.getDbName() + "."
				+ DBInfo.getPkPartnerhistoryTName();
		oneGMemsString += " where " + DBInfo.getPkPartnerHostID() + " = '"
				+ hostid + "' and ";
		oneGMemsString += DBInfo.getPkPartnerTime() + " = '"
				+ timestamp.toLocaleString() + "' ";
		System.out.println(oneGMemsString);
		try {
			resultSet = statement.executeQuery(oneGMemsString);
			while (resultSet.next()) {
				parters.add(resultSet.getString(DBInfo.getpHisUser()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		parters.remove(parters.indexOf(hostid));
		return parters;

	}

	private boolean addpkPartner(PartnerPO ppo) {
		String uid = ppo.getUid();
		Date timeStamp = ppo.getTimestamp();
		String hostID = ppo.getHostID();
		ArrayList<String> partnerIDs = ppo.getPartners();
		PreparedStatement preparedStatement = null;

		try {
			for (String pid : partnerIDs) {
				String addPartnerString = "insert into " + DBInfo.getDbName()
						+ "." + DBInfo.getPkPartnerhistoryTName();
				addPartnerString = addPartnerString + " values(?,?,?,?)";
				System.out.println(addPartnerString);
				preparedStatement = dbConnection
						.prepareStatement(addPartnerString);
				preparedStatement.setString(1, uid);
				// preparedStatement.setDate(2, new
				// java.sql.Date(timeStamp.getDate()));
				preparedStatement.setTimestamp(2, new java.sql.Timestamp(
						timeStamp.getTime()));
				preparedStatement.setString(3, pid);
				preparedStatement.setString(4, hostID);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<PKHistoryPO> getPKHistory(int sum) {
		ArrayList<PKHistoryPO> pkhpos = new ArrayList<PKHistoryPO>();
		String getChpString = "select distinct " + DBInfo.getPkCoopHostString()
				+ "," + DBInfo.getPkCoopTime();
		getChpString += " from " + DBInfo.getDbName() + "."
				+ DBInfo.getPkCoophistoryTName();
		getChpString += " order by " + DBInfo.getPkCoophisScore()
				+ " desc limit 0," + sum;
		;
		ArrayList<String> hostIDs = new ArrayList<String>();
		ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();

		System.out.println(getChpString);
		try {
			resultSet = statement.executeQuery(getChpString);
			while (resultSet.next()) {
				hostIDs.add(resultSet.getString(DBInfo.getPkPartnerHostID()));
				timestamps
						.add(resultSet.getTimestamp(DBInfo.getPkPartnerTime()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		int i = 0;
		for (String hid : hostIDs) {
			Timestamp tmstp = timestamps.get(i++);
			pkhpos.add(getpkHistoryPO(hid, tmstp));
		}
		return pkhpos;
	}

	public boolean addPartner(PartnerPO ppo) {
		String uid = ppo.getUid();
		Date timeStamp = ppo.getTimestamp();
		String hostID = ppo.getHostID();
		ArrayList<String> partnerIDs = ppo.getPartners();
		PreparedStatement preparedStatement = null;

		try {
			for (String pid : partnerIDs) {
				String addPartnerString = "insert into " + DBInfo.getDbName()
						+ "." + DBInfo.getPartnerHistoryTName();
				addPartnerString = addPartnerString + " values(?,?,?,?)";
				System.out.println(addPartnerString);
				preparedStatement = dbConnection
						.prepareStatement(addPartnerString);
				preparedStatement.setString(1, uid);
				// preparedStatement.setDate(2, new
				// java.sql.Date(timeStamp.getDate()));
				preparedStatement.setTimestamp(2, new java.sql.Timestamp(
						timeStamp.getTime()));
				preparedStatement.setString(3, pid);
				preparedStatement.setString(4, hostID);
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<String> getPartners(String uid) {
		ArrayList<String> partners = new ArrayList<String>();
		String getPtnersString = "select distinct " + DBInfo.getpHisPartner()
				+ " from " + DBInfo.getDbName() + "."
				+ DBInfo.getPartnerHistoryTName();
		getPtnersString += " where " + DBInfo.getpHisUser() + " = '" + uid
				+ "' ";
		// System.out.println(getPtnersString);
		try {
			resultSet = statement.executeQuery(getPtnersString);
			while (resultSet.next()) {
				partners.add(resultSet.getString(DBInfo.getpHisPartner()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		return partners;
	}

	private ArrayList<String> getOneGamePartenrs(String uid, Timestamp timestamp) {
		ArrayList<String> parters = new ArrayList<String>();
		String oneGMemsString = "select distinct " + DBInfo.getpHisUser()
				+ " from " + DBInfo.getDbName() + "."
				+ DBInfo.getPartnerHistoryTName();
		oneGMemsString += " where " + DBInfo.getpHisHost() + " = '" + uid
				+ "' and ";
		oneGMemsString += DBInfo.getpHisTime() + " = '"
				+ timestamp.toLocaleString() + "' ";
		// System.out.println(oneGMemsString);
		try {
			resultSet = statement.executeQuery(oneGMemsString);
			while (resultSet.next()) {
				parters.add(resultSet.getString(DBInfo.getpHisUser()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		parters.remove(parters.indexOf(uid));
		return parters;

	}

	private boolean addEnemy(EnemyPO epo) {
		String addenemyString = "insert into " + DBInfo.getDbName() + "."
				+ DBInfo.getEnemyHistoryTName();
		addenemyString += " values(?,?,?)";
		// System.out.println(addenemyString);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbConnection.prepareStatement(addenemyString);
			preparedStatement.setString(1, epo.getUid());
			preparedStatement.setTimestamp(2, new java.sql.Timestamp(epo
					.getTimestamp().getTime()));
			preparedStatement.setString(3, epo.getEhostuid());
			System.out.println(preparedStatement.toString());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}

		return true;
	}

	@Override
	public ArrayList<String> getEnemis(String uid) {
		ArrayList<String> enemies = new ArrayList<String>();
		ArrayList<String> enemyHosts = new ArrayList<String>();
		ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();
		String getEnemyhostString = "select  " + DBInfo.geteEnemyHisHost()
				+ "," + DBInfo.geteEnemyHisTime();
		getEnemyhostString += " from " + DBInfo.getDbName() + "."
				+ DBInfo.getEnemyHistoryTName();
		getEnemyhostString += " where " + DBInfo.geteHisUser() + " = '" + uid
				+ "' ";
		try {
			resultSet = statement.executeQuery(getEnemyhostString);
			while (resultSet.next()) {
				enemyHosts.add(resultSet.getString(DBInfo.geteEnemyHisHost()));
				timestamps
						.add(resultSet.getTimestamp(DBInfo.geteEnemyHisTime()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
		int i = 0;
		for (String hostID : enemyHosts) {
			Timestamp t = timestamps.get(i++);
			enemies.addAll(getOneGamePKPartners(hostID, t));
			enemies.add(hostID);
		}
		return enemies;
	}

	private boolean addOneHit(String id, Date date, int hit) {
		String addString = "insert into " + DBInfo.getDbName() + "."
				+ DBInfo.getHitTName();
		addString += "values(?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = dbConnection.prepareStatement(addString);
			preparedStatement.setString(1, id);
			preparedStatement.setTimestamp(2,
					new java.sql.Timestamp(date.getTime()));
			preparedStatement.setInt(3, hit);
			System.out.println(preparedStatement.toString());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return false;
		}
		return true;
	}

	public int getOneHit(String uid, Timestamp timestamp) {
		int result = 0;
		String getString = "select " + DBInfo.getHit() + " from "
				+ DBInfo.getDbName() + "." + DBInfo.getHitTName();
		getString += " where " + DBInfo.getHitUId() + " = '" + uid + "' "
				+ " and ";
		getString += DBInfo.getHitTime() + " = '" + timestamp.toLocaleString()
				+ "' ";
		System.out.println(getString);
		try {
			resultSet = statement.executeQuery(getString);
			while (resultSet.next()) {
				result = resultSet.getInt(DBInfo.getHit());
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
			return 0;
		}
		return result;
	}

	public boolean addHit(HitInfoPO hitInfo) {
		ArrayList<String> ids = hitInfo.getIDs();
		ArrayList<Integer> hits = hitInfo.getHits();
		int i = 0;
		Date time = hitInfo.getTime();
		for (String s : ids) {
			int hit = hits.get(i);
			addOneHit(s, time, hit);
			i++;
		}
		return true;
	}

	public ArrayList<HitInfoPO> getHitInfo(String uid) {
		ArrayList<HitInfoPO> hitInfos = new ArrayList<HitInfoPO>();
		ArrayList<Timestamp> timestamps = new ArrayList<Timestamp>();
		String getTimeString1 = "select " + DBInfo.getpHisTime() + " from "
				+ DBInfo.getDbName();
		getTimeString1 += DBInfo.getPartnerHistoryTName() + " where "
				+ DBInfo.getpHisUser() + " = '" + uid + "' ";
		String getTimeString2 = "select " + DBInfo.getPkPartnerTime()
				+ " from " + DBInfo.getDbName();
		getTimeString2 += DBInfo.getPkPartnerhistoryTName() + " where "
				+ DBInfo.getPkPartnerUser() + " = '" + uid + "' ";
		try {
			resultSet = statement.executeQuery(getTimeString1);
			while (resultSet.next()) {
				timestamps.add(resultSet.getTimestamp(DBInfo.getpHisTime()));
			}
			resultSet = statement.executeQuery(getTimeString2);
			while (resultSet.next()) {
				timestamps.add(resultSet.getTimestamp(DBInfo.getpHisTime()));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		Date date = null;
		for (Timestamp t : timestamps) {
			try {
				date = sdf.parse(t.toLocaleString());
			} catch (ParseException ex) {
				Logger.getLogger(DataBaseUtility.class.getName()).log(
						Level.SEVERE, null, ex);
			}
			int maxHit = getOneHit(uid, t);
			HitInfoPO hipo = new HitInfoPO(date);
			hipo.addHitInfo(uid, maxHit);
			hitInfos.add(hipo);
		}
		return hitInfos;
	}

	public ArrayList<HitInfoPO> getHitInfo(int sum) {
		ArrayList<HitInfoPO> hitInfos = new ArrayList<HitInfoPO>();
		String getString = "select * from " + DBInfo.getDbName() + "."
				+ DBInfo.getHitTName();
		getString += " order by " + DBInfo.getHitTime() + " desc limit 0,"
				+ sum;
		try {
			resultSet = statement.executeQuery(getString);
			while (resultSet.next()) {
				Timestamp t = resultSet.getTimestamp(DBInfo.getHitTime());
				String uid = resultSet.getString(DBInfo.getHitUId());
				int maxHit = resultSet.getInt(DBInfo.getHit());
				Date d = sdf.parse(t.toLocaleString());
				HitInfoPO hipo = new HitInfoPO(d);
				hipo.addHitInfo(uid, maxHit);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (ParseException ex) {
			Logger.getLogger(DataBaseUtility.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return hitInfos;
	}
}

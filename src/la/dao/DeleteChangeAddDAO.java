package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.DramaInfoBean;

public class DeleteChangeAddDAO {
	private Connection con;

	public DeleteChangeAddDAO() throws DAOException {
		getConnection();
	}

	public void deleteDrama(int code) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			//SQL文の作成
			String sql = "DELETE FROM kindOfDrama WHERE code=?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,code);
			//SQLの実行
			st.executeUpdate();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public void deleteDramaPoints(int code) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			//SQL文の作成
			String sql = "DELETE FROM dramaPoints WHERE code=?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,code);
			//SQLの実行
			st.executeUpdate();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public DramaInfoBean show_change(int number) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT code,title,category,season,casts,services FROM kindOfDrama WHERE code=?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,number);
			//SQLの実行
			rs = st.executeQuery();
			if(rs.next()) {
				int code = rs.getInt("code");
				String title = rs.getString("title");
				String category = rs.getString("category");
				int season = rs.getInt("season");
				String casts = rs.getString("casts");
				String services = rs.getString("services");
				DramaInfoBean bean = new DramaInfoBean(code,title,category,season,casts,services);
				return bean;
			}else {
				return null;
			}

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public int[] show_change_questionPoint(int code, String[] questionList) throws DAOException {
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			//SQL文の作成
			String sql = "SELECT * FROM dramaPoints WHERE code=?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,code);
			//SQLの実行
			rs = st.executeQuery();

			int[] now_pointList = new int[29];

			if(rs.next()) {
				for(int i = 0; i < 29; i++) {
					int now_point = rs.getInt(questionList[i]);
					now_pointList[i] = now_point;
				}
			}

			return now_pointList;

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}


	public void changeDrama(int code,String title,String category,int season,String casts,String services) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			//SQL文の作成
			String sql = "UPDATE kindOfDrama SET title=?,category=?,season=?,casts=?,services=? WHERE code=?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setString(1,title);
			st.setString(2,category);
			st.setInt(3, season);
			st.setString(4, casts);
			st.setString(5,services);
			st.setInt(6, code);
			//SQLの実行
			st.executeUpdate();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public void changeDramaPoints(int code, int[] new_pointList) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		int a;
		try {
			//SQL文の作成
			String sql = "UPDATE dramaPoints SET \"1-1\"=?,\"1-2\"=?,\"1-3\"=?,\"2-1\"=?,\"2-2\"=?,\"2-3\"=?,\"2-4\"=?,\"3-1\"=?,\"3-2\"=?,\"3-3\"=?,\"4-1\"=?,\"4-2\"=?,\"4-3\"=?,\"4-4\"=?,\"4-5\"=?,\"4-6\"=?,\"5-1\"=?,\"5-2\"=?,\"5-3\"=?,\"5-4\"=?,\"5-5\"=?,\"6-1\"=?,\"6-2\"=?,\"6-3\"=?,\"7-1\"=?,\"7-2\"=?,\"8-1\"=?,\"8-2\"=?,\"8-3\"=? WHERE code=?";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			for(int i = 1; i <= 29; i++) {
				a = new_pointList[i-1];
				st.setInt(i,a);
			}
			st.setInt(30, code);
			//SQLの実行
			st.executeUpdate();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public void addDrama(String title,String category,int season,String image,String casts,String content,String services) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		int code = 0;
		try {
			String sql = "SELECT setval('kindOfDrama_code_seq', (SELECT MAX(code) FROM kindOfDrama))";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			st.close();
			rs.close();

			sql = "SELECT nextval('kindOfDrama_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			if(rs.next()) {
				code = rs.getInt(1);
			}
			st.close();
			rs.close();

			//SQL文の作成
			sql = "INSERT INTO kindOfDrama VALUES(?,?,?,?,?,?,?,?)";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,code);
			st.setString(2,title);
			st.setString(3,category);
			st.setInt(4, season);
			st.setString(5,image);
			st.setString(6, casts);
			st.setString(7,content);
			st.setString(8,services);
			//SQLの実行
			st.executeUpdate();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public void addDramaPoints(int[] new_pointList) throws DAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		int code = 0;
		int a;
		try {
			String sql = "SELECT setval('dramaPoints_code_seq', (SELECT MAX(code) FROM dramaPoints))";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			st.close();
			rs.close();

			sql = "SELECT nextval('dramaPoints_code_seq')";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			if(rs.next()) {
				code = rs.getInt(1);
			}
			st.close();
			rs.close();

			//SQL文の作成
			sql = "INSERT INTO dramaPoints VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			//主キーの設定
			st.setInt(1,code);
			for(int i = 2; i < 31; i++) {
				a = new_pointList[i-2];
				st.setInt(i,a);
			}
			//SQLの実行
			st.executeUpdate();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				//リソースの開放
				if(st != null) st.close();
				close();
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {
			//JDBCドライバの登録
			Class.forName("org.postgresql.Driver");
			//URL、ユーザ名、パスワードの設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";
			//データベースへの接続
			con = DriverManager.getConnection(url,user,pass);
		}catch (Exception e) {
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
	}
}

package ooptest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Mysql {

	public static boolean ans() {
		String msg = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost/SalaPay?serverTimezone=JST","root","");

			String sql = "select * from user where id = ? and password = ?" ;

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,Log_in.userid);
			stmt.setString(2,Log_in.passwordstr);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			Log_in.username = rsmd.getColumnName(1);
			//idとpasswordが一致したレコードの結果（trueかfalse)をansに代入
			 Log_in.ans = rs.next();
			rs.close();
			stmt.close();
			con.close();

		}catch(Exception ex) {
			msg = "ドライバのロードに失敗しました";
			System.out.println(ex+"\t"+msg);
		}
		return Log_in.ans;

	}

	public static boolean new_ans() {
		String msg = "";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost/SalaPay?serverTimezone=JST","root","");

			 String sql = "insert into user values(?,?,?,false)";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 stmt.setString(1, Log_in.userid);
			 stmt.setString(2, Log_in.passwordstr);
			 stmt.setString(3,Shinki_registration_Main.new_name);
			 stmt.executeUpdate();
			 Log_in.ans = true;
		     con.close();

	}catch(Exception ex){
		msg = "ドライバのロードに失敗しました";
		System.out.println(msg);
	}
	return Log_in.ans;
	}

}

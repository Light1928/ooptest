package ooptest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mysql {
//
	public static boolean ans(int flag) {
		String msg = "";
		String sql = "select * from user where id = ? and password = ?" ;
		String sql1 = "insert into user values(?,?,?,false)";
		String sql2 =  "delete from money where id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection
					("jdbc:mysql://localhost/SalaPay?serverTimezone=JST","root","root");

			if(flag == 0) {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,Log_in.userid);
			stmt.setString(2,Log_in.passwordstr);
			ResultSet rs = stmt.executeQuery();
			//抽出したらカーソルの位置は０行目になっているためrs.nextで合わせる
			Log_in.ans = rs.next();
			Log_in.username = rs.getString("name");
			Log_in.permission = rs.getBoolean("permission");
			//idとpasswordが一致したレコードの結果（trueかfalse)をansに代入
   			rs.close();
			stmt.close();
			con.close();

		}else if(flag == 1) {
			PreparedStatement stmt = con.prepareStatement(sql1);
			 stmt.setString(1, Log_in.userid);
			 stmt.setString(2, Log_in.passwordstr);
			 stmt.setString(3,Shinki_registration_Main.new_name);
			 Log_in.record = stmt.executeUpdate();
			 Log_in.ans = true;
			 stmt.close();
		     con.close();

		}else if(flag == 2) {
			PreparedStatement stmt = con.prepareStatement(sql2);
			stmt.setString(1,Log_in.userid);
						
			Log_in.record = stmt.executeUpdate();
			sql2 = "delete from time where id = ?";
			stmt=con.prepareStatement(sql2);
			stmt.setString(1,Log_in.userid);
			Log_in.record = stmt.executeUpdate();
			sql2 ="delete from user where id = ? and password = ?";
		   stmt=con.prepareStatement(sql2);
			stmt.setString(1,Log_in.userid);
			stmt.setString(2,Log_in.passwordstr);
		
			stmt.executeUpdate();
			Log_in.ans = true;
			stmt.close();
			con.close();
		}

		}catch(Exception ex) {
			msg = "ドライバのロードに失敗しました";
			System.out.println(ex+"\t"+msg);
		}
		return Log_in.ans;
	}

}
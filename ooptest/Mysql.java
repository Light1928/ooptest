package ooptest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mysql {

	public static boolean ans(int flag) {
		String msg = "";
		String sql = "select * from user where id = ? and password = ?" ;
		String sql1 = "insert into user values(?,?,?,false)";
		String sql2 =  "delete from money where id = ?";
		String sql3 = "insert into time values(?,?,?,?,?,?)";
		String sql4 = "insert into money value(?,?,?,?,?)";
		String sql5 = " select * from time where id = ? and year = ? and month = ? order by day asc ";
		String sql6 = "select * from money where id = ? and year = ? and month = ? order by day asc";
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
		//
			stmt.executeUpdate();
			Log_in.ans = true;
			stmt.close();
			con.close();
		}else if(flag == 3) {
			PreparedStatement stmt = con.prepareStatement(sql3);
			stmt.setString(1, Log_in.userid);
			stmt.setString(2,Data_input.yeardata);
			stmt.setString(3, Data_input.monthdata1);
			stmt.setString(4, Data_input.daydata1);
			stmt.setString(5, Data_input.starttime);
			stmt.setString(6,Data_input.endtime);

			stmt.executeUpdate();
			stmt =con.prepareStatement(sql4);
			stmt.setString(1,Log_in.userid);
			stmt.setString(2, Data_input.yeardata);
			stmt.setString(3, Data_input.monthdata1);
			stmt.setString(4,Data_input.daydata1);
			stmt.setString(5,Data_input.money);
			stmt.executeUpdate();
			Log_in.ans=true;
			stmt.close();
			con.close();
//

		}else if(flag == 4) {
			PreparedStatement stmt = con.prepareStatement(sql5);
			//空のコンストラクタ実行
			Month month = new Month("SQL");
			stmt.setString(1,Log_in.userid);
			stmt.setString(2,month.getYeardata());
			stmt.setString(3,month.getMonthdata());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			//列の値を取得し文字列からint型にキャスト
			int start_time = Integer.parseInt(rs.getString("start_time"));
			int end_time = Integer.parseInt(rs.getString("end_time"));
			}
		}

		}catch(Exception ex) {
			msg = "ドライバのロードに失敗しました";
			System.out.println(ex+"\t"+msg);
		}
		return Log_in.ans;
	}

}
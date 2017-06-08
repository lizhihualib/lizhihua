package com.chinasoft.goods.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.goods.bean.Goods;
import com.chinasoft.goods.dao.IGoodsDao;
import com.chinasoft.goods.utils.JdbcUtil;
/**
 * 商品dao实现
 * @author Administrator
 *
 */
public class GoodsDaoImpl implements IGoodsDao{

	@Override
	public boolean insert(Goods goods) {
		//获取连接
		Connection conn=JdbcUtil.getConn();
		String sql="insert into goods(g_name,g_price,g_nums,g_type,g_desc)"
				+ "values(?,?,?,?,?)";
		try {
			//预编译sql
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, goods.getG_name());
			pst.setInt(3, goods.getG_nums());
			pst.setBigDecimal(2, goods.getG_price());
			pst.setInt(4, goods.getG_type());
			pst.setString(5, goods.getG_desc());
			//执行sql
			int rows=pst.executeUpdate();
			pst.close();
			if(rows>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(conn);
		}
		
		return false;
	}

	@Override
	public int update(Goods goods) {
		Connection conn=JdbcUtil.getConn();
		int rows=0;
		String sql="update goods set g_name=? , g_price=? ,g_nums=? "
				+ ", g_type=?, g_desc=? where id=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, goods.getG_name());
			pst.setBigDecimal(2, goods.getG_price());
			pst.setInt(3, goods.getG_nums());
			pst.setInt(4, goods.getG_type());
			pst.setString(5, goods.getG_desc());
			pst.setInt(6, goods.getId());
			
			rows=pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(conn);
		}
		
		return rows;
	}

	@Override
	public int delete(int g_id) {
		Connection conn=JdbcUtil.getConn();
		int rows=0;
		String sql="delete from goods where id=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, g_id);
			rows=pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(conn);
		}
		
		return rows;
	}

	@Override
	public List<Goods> query(Goods goods) {
		Connection conn=JdbcUtil.getConn();
		String sql="select * from goods g ";
		String sql1="select * from goods g where g.g_name like '%"+goods.getG_name()+"%'";
		
		//根据传入条件拼接sql语句
		if(goods.getG_name()!=null && !goods.getG_name().equals("")){
			sql+="where g.g_name like '%"+goods.getG_name()+"%'";
			if(goods.getG_price()!=null && !goods.getG_price().equals("")){
				sql+=" and g.g_price like '%"+goods.getG_price()+"%'";
			}
			if(goods.getG_desc()!=null && !goods.getG_desc().equals("")){
				sql+=" and g.g_desc like '%"+goods.getG_desc()+"%'";
			}
			
		}else if(goods.getG_price()!=null && !goods.getG_price().equals("")){
			
			sql+=" where g.g_price like '%"+goods.getG_price()+"%'";
			
			if(goods.getG_desc()!=null && !goods.getG_desc().equals("")){
				sql+=" and g.g_desc like '%"+goods.getG_desc()+"%'";
			}
		}else if(goods.getG_desc()!=null && !goods.getG_desc().equals("")){
			sql+=" where g.g_desc like '%"+goods.getG_desc()+"%'";
		}
		
		sql+=" limit "+goods.getStart()+" , "+goods.getPageSize();
		
		List<Goods> list=new ArrayList<Goods>();
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Goods good=new Goods();
				good.setId(rs.getInt(1));
				good.setG_name(rs.getString(2));
				good.setG_price(rs.getBigDecimal(3));
				good.setG_nums(rs.getInt(4));
				good.setG_type(rs.getInt(5));
				good.setG_desc(rs.getString(6));
				
				list.add(good);
			}
			
			rs.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(conn);
		}
		
		return list;
	}

	@Override
	public Goods queryByid(int id) {
		Connection conn=JdbcUtil.getConn();
		Goods good=null;
		String sql="select * from goods where id=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				good=new Goods();
				good.setId(rs.getInt(1));
				good.setG_name(rs.getString(2));
				good.setG_price(rs.getBigDecimal(3));
				good.setG_nums(rs.getInt(4));
				good.setG_type(rs.getInt(5));
				good.setG_desc(rs.getString(6));
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(conn);
		}
		
		return good;
	}

	@Override
	public int queryCount(Goods goods) {
		Connection conn=JdbcUtil.getConn();
		String sql="select count(id) from goods g ";
		
		//根据传入条件拼接sql语句
		if(goods.getG_name()!=null && !goods.getG_name().equals("")){
			sql+="where g.g_name like '%"+goods.getG_name()+"%'";
			if(goods.getG_price()!=null && !goods.getG_price().equals("")){
				sql+=" and g.g_price like '%"+goods.getG_price()+"%'";
			}
			if(goods.getG_desc()!=null && !goods.getG_desc().equals("")){
				sql+=" and g.g_desc like '%"+goods.getG_desc()+"%'";
			}
			
		}else if(goods.getG_price()!=null && !goods.getG_price().equals("")){
			
			sql+=" where g.g_price like '%"+goods.getG_price()+"%'";
			
			if(goods.getG_desc()!=null && !goods.getG_desc().equals("")){
				sql+=" and g.g_desc like '%"+goods.getG_desc()+"%'";
			}
		}else if(goods.getG_desc()!=null && !goods.getG_desc().equals("")){
			sql+=" where g.g_desc like '%"+goods.getG_desc()+"%'";
		}
		
		
		int count=0;
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			
			rs.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConn(conn);
		}
		
		
		return count;
	}

}

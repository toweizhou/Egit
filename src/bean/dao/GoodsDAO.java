package bean.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DBBean;
import bean.vo.GoodsVo;

public class GoodsDAO {
	DBBean db = new DBBean();
	int recordsPerPage = 2;
	
	public ArrayList getGoodsByPage(int pageNo){
		ArrayList goodsList = new ArrayList();
		
		Connection con = db.getConnection();
		int beginIndex = (pageNo -1)*this.recordsPerPage; //第n条，n从1开始
		
		try {
			ResultSet rs = db.executeQuery("select * from goods limit "+beginIndex + ","+recordsPerPage, null);
			if(rs != null){
				while(rs.next()){
					GoodsVo g = new GoodsVo();
					g.setGoodsId(rs.getString("goodsid"));
					g.setGoodsName(rs.getString("goodsname"));
					g.setPrice(rs.getFloat("price"));
					
					goodsList.add(g);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goodsList;
		
	}
	
	
	public GoodsVo getGoodsById(String goodsId){
		GoodsVo g = null;
		
		Connection con = db.getConnection();
		try {
			ResultSet rs = db.executeQuery("select * from goods where goodsid='"+goodsId+"'", null);
			if(rs != null){
				while(rs.next()){
					g.setGoodsId(rs.getString("goodsid"));
					g.setGoodsName(rs.getString("goodsname"));
					g.setPrice(rs.getFloat("price"));
					
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return g;
		
	}
}

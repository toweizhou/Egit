package bean.dao;

import java.util.ArrayList;
import java.util.Iterator;

import bean.vo.GoodsVo;
import bean.vo.Item;

public class CartManager {
	ArrayList<Item> cart = new ArrayList<Item>();
	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}

	GoodsDAO goodsDAO = new GoodsDAO();
	
	public void addToCart(String goodsId,int count){
		Iterator<Item> it = cart.iterator();
		boolean existFlag = false;
		
		while(it.hasNext()){
			Item oneItem = it.next();
			if(goodsId.equals(oneItem.getGoods().getGoodsId())){
				existFlag = true;
				oneItem.setCount(oneItem.getCount()+count);
			}
			
		}
		
		if(existFlag == false){
			GoodsVo g = goodsDAO.getGoodsById(goodsId);
			Item newItem = new Item();
			newItem.setGoods(g);
			newItem.setCount(count);
			
			this.cart.add(newItem);
		}
		
	}
	
}

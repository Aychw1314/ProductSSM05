package com.chw.dao;

import java.util.List;
import java.util.Map;

import com.chw.bean.Category;
import com.chw.bean.Product;

public interface ProductMapper {

	public Product queryProduct(String id);//查询一个产品的数据
	public List<Product> queryProducts();//查询所有的产品的数据
	public List<Category> queryCategory(Map<Object, Object> map);//查询一个商品的所有分类属性
	public List<Category> queryAllCategory();//查询搜有的分类属性
	
	public int insertProduct(Product product);//添加一个产品
	public int insertPC(Map<Object, Object> map);//添加一个中间表的id
	
	public int deleteProduct(String id);//删除一个产品
	public int deletePC(String pid);//根据产品编号，删除一个中间表id
	
	public int updateProduct(Product product);//更新一个商品
	
	
	
	

	
}

package com.chw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chw.bean.Category;
import com.chw.bean.Product;
import com.chw.dao.ProductMapper;


@Service
public class ProductService {

	@Autowired
	private ProductMapper mapper;	
	
	public List<Product> queryProducts(){
			//查询所有的商品，通过增强for来拿到商品id,来关联查询分类信息
		List<Product> products = mapper.queryProducts();
						
		for (Product product : products) {			
			String id = product.getId();
			Map<Object, Object> map = new HashMap<>();
			map.put("id", id);
			List<Category> categorys= mapper.queryCategory(map);
			//System.out.println("categorys查询"+categorys);
			product.setCategorys(categorys);						   				
		}
		return  products;
	}
	
	
	
	 public int insertProduct(Product product){
		 
		int result = mapper.insertProduct(product);
		
		if(result>0){
			
			String[] cids = product.getCids().split(",");
			Map<Object, Object> map = new HashMap<>();
			map.put("pid", product.getId());
			map.put("cids", cids);
			mapper.insertPC(map);
		}
		return result;
		
	}
	
	public int deleteProduct(String id){
		//根据产品id删除中间表的cid
		mapper.deletePC(id);
		return mapper.deleteProduct(id);
	}
	
	
	public Product queryProduct(String id){
		 Product product = mapper.queryProduct(id);
		 return product;

	}
	
	public int updateProduct(Product product){
		//根据产品id删除中间表的cid
		mapper.deletePC(product.getId());
		//查询所有的商品，通过getcids()方法来拿到分类属性的id
		//System.out.println("product更新="+product);
		String[] cids = product.getCids().split(",");
		Map<Object, Object> map = new HashMap<>();
		map.put("cids", cids);
		map.put("pid", product.getId());
		//更据cids添加新的中间表
		mapper.insertPC(map);
		
		int result = mapper.updateProduct(product);
		return result;
	}
	
	public List<Category> queryAllCategory(){
		return mapper.queryAllCategory();
				
	}
}

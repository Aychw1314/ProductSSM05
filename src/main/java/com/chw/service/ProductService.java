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
			//��ѯ���е���Ʒ��ͨ����ǿfor���õ���Ʒid,��������ѯ������Ϣ
		List<Product> products = mapper.queryProducts();
						
		for (Product product : products) {			
			String id = product.getId();
			Map<Object, Object> map = new HashMap<>();
			map.put("id", id);
			List<Category> categorys= mapper.queryCategory(map);
			//System.out.println("categorys��ѯ"+categorys);
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
		//���ݲ�Ʒidɾ���м���cid
		mapper.deletePC(id);
		return mapper.deleteProduct(id);
	}
	
	
	public Product queryProduct(String id){
		 Product product = mapper.queryProduct(id);
		 return product;

	}
	
	public int updateProduct(Product product){
		//���ݲ�Ʒidɾ���м���cid
		mapper.deletePC(product.getId());
		//��ѯ���е���Ʒ��ͨ��getcids()�������õ��������Ե�id
		//System.out.println("product����="+product);
		String[] cids = product.getCids().split(",");
		Map<Object, Object> map = new HashMap<>();
		map.put("cids", cids);
		map.put("pid", product.getId());
		//����cids����µ��м��
		mapper.insertPC(map);
		
		int result = mapper.updateProduct(product);
		return result;
	}
	
	public List<Category> queryAllCategory(){
		return mapper.queryAllCategory();
				
	}
}

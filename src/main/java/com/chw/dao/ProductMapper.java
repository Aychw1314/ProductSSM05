package com.chw.dao;

import java.util.List;
import java.util.Map;

import com.chw.bean.Category;
import com.chw.bean.Product;

public interface ProductMapper {

	public Product queryProduct(String id);//��ѯһ����Ʒ������
	public List<Product> queryProducts();//��ѯ���еĲ�Ʒ������
	public List<Category> queryCategory(Map<Object, Object> map);//��ѯһ����Ʒ�����з�������
	public List<Category> queryAllCategory();//��ѯ���еķ�������
	
	public int insertProduct(Product product);//���һ����Ʒ
	public int insertPC(Map<Object, Object> map);//���һ���м���id
	
	public int deleteProduct(String id);//ɾ��һ����Ʒ
	public int deletePC(String pid);//���ݲ�Ʒ��ţ�ɾ��һ���м��id
	
	public int updateProduct(Product product);//����һ����Ʒ
	
	
	
	

	
}

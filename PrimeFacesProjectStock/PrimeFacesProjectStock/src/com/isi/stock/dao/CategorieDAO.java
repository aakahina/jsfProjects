package com.isi.stock.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.isi.stock.entities.Categorie;
import com.isi.stock.mapping.CategorieMapper;
import com.isi.stock.services.MyBatisConnectionFactory;

public class CategorieDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public CategorieDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	

	public Map<String, Integer> selectAllCat() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			CategorieMapper mapper = session.getMapper(CategorieMapper.class);
			List<Categorie> list = mapper.selectAllCat();
			
			Map<String, Integer> categories = new HashMap<String, Integer>();
			for (Categorie categorie : list) {
				categories.put(categorie.getCatNom(), categorie.getCatID());
				//System.out.println("categorie: "+categorie);
				
			}
			return categories;
		} finally {
			session.close();
		}		
	}
	
	public String getCategorie(int cat) {
		
SqlSession session = sqlSessionFactory.openSession();
		
		try {
			CategorieMapper mapper = session.getMapper(CategorieMapper.class);
			String nom = (mapper.selectByIdCat(cat)).getCatNom();
			
			
			
			return nom;
		} finally {
			session.close();
		}		
		
	}
	
}

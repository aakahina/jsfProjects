package com.isi.stock.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.isi.stock.entities.Membre;
import com.isi.stock.mapping.MembreMapper;
import com.isi.stock.services.MyBatisConnectionFactory;

public class MembreDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MembreDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	
	public Membre selectMembre(String email, String pw) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			MembreMapper mapper = session.getMapper(MembreMapper.class);
			Membre user = mapper.selectMembre(email, pw);
			
			return user;
		} finally {
			session.close();
		}		
	}
	
//	public List<Produit> selectProduitByCat(int catId) {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
//			List<Produit> list = mapper.selectProduitByCatId(catId);
//			return list;
//		} finally {
//			session.close();
//		}		
//	}
//	
//	public Produit selectById(int id) {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
//			Produit list = mapper.selectById(id);
//			return list;
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void update(Produit produit) {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
//			mapper.update(produit);
//			
//			session.commit();
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void updateName(String name, int id) {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
//			mapper.updateName(name, id);
//			
//			session.commit();
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void insert(Produit produit) {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
//			mapper.insert(produit);
//			session.commit();
//		} finally {
//			session.close();
//		}
//	}
//	
//	public void delete(int id) {
//		SqlSession session = sqlSessionFactory.openSession();
//		
//		try {
//			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
//			mapper.delete(id);
//			
//			session.commit();
//		} finally {
//			session.close();
//		}
//	}
}

package com.isi.stock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.isi.stock.entities.Produit;
import com.isi.stock.mapping.ProduitMapper;
import com.isi.stock.services.MyBatisConnectionFactory;

public class ProduitDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public ProduitDAO() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produit> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			List<Produit> list = mapper.selectAll();
			return list;
		} finally {
			session.close();
		}		
	}

	
	public Produit selectProductById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			Produit list = mapper.selectProductById(id);
			return list;
		} finally {
			session.close();
		}
	}
	
	
	
	public List<Produit> selectAllProductCatDetail(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			List<Produit> list = mapper.selectAllProductCatDetail(id);
			return list;
		} finally {
			session.close();
		}		
	}
	
	

	
	
	
	public void update(Produit produit) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			mapper.update(produit);
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void updateName(String name, int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			mapper.updateName(name, id);
			
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void insert(Produit produit) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			mapper.insert(produit);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void delete(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			ProduitMapper mapper = session.getMapper(ProduitMapper.class);
			mapper.delete(id);
			
			session.commit();
		} finally {
			session.close();
		}
	}
}

package com.isi.stock.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isi.stock.entities.Categorie;
import com.isi.stock.entities.Produit;

public interface ProduitMapper {

	final String SELECT_ALL = "SELECT * FROM PRODUIT";
	final String SELECT_BY_ID = "SELECT * FROM PRODUIT WHERE ID = #{id}";
	final String SELECT_ALL_BY_CATID = "SELECT * FROM PRODUIT WHERE CATID = #{catId}";
	
	final String UPDATE = "UPDATE PRODUIT SET catId = #{catId}, nom = #{nom}, prix = #{prix} WHERE id = #{id}";
	final String UPDATE_NAME = "UPDATE PRODUIT SET nom = #{nom} WHERE id = #{id}";
	final String DELETE = "DELETE FROM PRODUIT WHERE id = #{id}";
	final String INSERT = "INSERT INTO PRODUIT (nom, prix, catId) VALUES (#{nom}, #{prix}, #{catId})";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="id"),
		@Result(property="nom", column="nom"),
		@Result(property="prix", column="prix"),
		@Result(property="catId", column="catId")//,
		//@Result(property="categorie", column="catId", javaType=Categorie.class, one=@One(select="com.isi.ibatis.mapping.CategorieMapper.selectByIdCat"))
	})
	List<Produit> selectAll();
	
	@Select(SELECT_BY_ID)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="nom", column="nom"),
			@Result(property="prix", column="prix"),
			@Result(property="catId", column="catId")	
	})
	Produit selectProductById(int id);
	
	@Select(SELECT_ALL_BY_CATID)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="nom", column="nom"),
			@Result(property="prix", column="prix"),
			@Result(property="catId", column="catId")//,
			//@Result(property="categorie", column="catId", javaType=Categorie.class, one=@One(select="com.isi.ibatis.mapping.CategorieMapper.selectByIdCat"))
	})
	List<Produit> selectAllProductCatDetail(int catId);
		
	@Update(UPDATE)
	void update(Produit contact);
	
	@Update(UPDATE_NAME)
	void updateName(@Param("nom") String name, @Param("id") int id);
	
	@Delete(DELETE)
	void delete(int id);
	
	@Insert(INSERT)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(Produit produit);
}

package com.isi.stock.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.isi.stock.entities.Categorie;

public interface CategorieMapper {

	final String SELECT_ALL_CAT = "SELECT catid, catNom FROM categorie";
	final String SELECT_CAT_BYID = "SELECT catNom FROM categorie WHERE catID = #{catID}";

	
	@Select(SELECT_ALL_CAT)
	@Results(value = {
			@Result(property="catID", column="catID"),
			@Result(property="catNom", column="catNom")
			//@Result(property="description", column="description")
	
	})
	
	List<Categorie> selectAllCat();
	
	
	@Select(SELECT_CAT_BYID)
	@Results(value = {@Result(property="catNom", column="catNom")})
	Categorie selectByIdCat(int catID);
	
	
	
	
}
package com.isi.stock.mapping;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.isi.stock.entities.Membre;




public interface MembreMapper {
	


final String SELECT_BY_ID = "SELECT * FROM MEMBRES WHERE email = #{email} and pw = #{pw}";





@Select(SELECT_BY_ID)
@Results(value = {
		@Result(property="membreId", column="membreId"),
		@Result(property="nom", column="nom"),
		@Result(property="email", column="email"),
		@Result(property="pw", column="pw")	
})

Membre selectMembre(@Param("email") String email, @Param("pw") String pw);


}

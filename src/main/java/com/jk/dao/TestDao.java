package com.jk.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jk.pojo.User;

@Mapper
public interface TestDao {

	@ResultType(java.util.LinkedHashMap.class)
	@Select(value="select * from t_user")
	/*@Select(value="<script>"+
    "select  *   from  t_user  "
    + "where   userId in "
    + "<foreach collection =\"list\" item=\"hrm\" index= \"index\" open=\"(\" close=\")\" separator =\",\"> "
    + "#{hrm} "
    + "</foreach > "
    + "</script>")*/
	List<LinkedHashMap<String, Object>> findEmpl(List<String> list);
	/**
	 * 删除
	 * @param id
	 */
	@Delete(value="delete from t_user where userId=#{id}")
	void deleteUser(Integer id);
	/**
	 * 新增
	 * @param usr
	 */
	@Insert("insert into t_user(userName,userSex,userAge,userDate) values(#{userName},#{userSex},#{userAge},#{userDate})")
	void saveuser(User usr);
	/**
	 * 回显
	 * @param id
	 * @return
	 */
	@Select(value="select e.userId as userId,e.userName as userName,e.userAge as userAge,e.userSex as userSex,e.userDate as userDate from t_user e where e.userId=#{id}")
	User updatetoUser(Integer id);
	/**
	 * 修改
	 * @param usr
	 */
	//@Update(value="update t_user set userName=#{1},userInfo=#{2},userDate=#{3} where userId=#{0}")
	//public void updateUser(Integer userId, String userName, String userInfo, Date userDate);

	/*@Update("update variety set variety_name = #{varietyName} , variety_money = #{varietyMoney} where variety_Id = #{varietyId}")
	void updateVar(Variety variety);*/

	@Update(value="update t_user set userName=#{userName},userAge=#{userAge},userSex=#{userSex},userDate=#{userDate} where userId=#{userId}")
	void updateUser(User usr);
	/**
	 * 查询
	 * @param user
	 * @param pageSize
	 * @param start
	 * @return
	 */
	@ResultType(java.util.LinkedHashMap.class)
	/*@Select(value="<script>"+
			"SELECT m.* FROM t_user m where m.t_menu_cook=c.t_cookId "
			+"<if test=\"user.userName!=null  and user.userName!='' \"> "
			+"AND m.t_menuName LIKE concat(concat('%', #{user.userName}),'%')</if> "
			
			+"<if test=\"cookMenu.minDate!=null\"> "
			+"AND m.t_menuDate <![CDATA[>=]]> #{cookMenu.minDate}</if> "
			+"<if test=\"cookMenu.maxDate!=null\"> "
			+"AND m.t_menuDate <![CDATA[<=]]> #{cookMenu.maxDate}</if>"
			+"LIMIT #{start},#{start}</script>")*/
	@Select(value="select * from t_user limit #{2},#{1}")
	List<LinkedHashMap<String, Object>> queryCookMenu(User user, Integer pageSize, Integer start);
	
	@ResultType(java.lang.Long.class)
	/*@Select(value="<script>"+
			"SELECT count(1) FROM t_menu m,t_cook c where m.t_menu_cook=c.t_cookId "
			+"<if test=\"cookMenu.menuName!=null  and cookMenu.menuName!='' \"> "
			+"AND m.t_menuName LIKE concat(concat('%', #{cookMenu.menuName}),'%')</if> "
			+"<if test=\"cookMenu.minDate!=null\"> "
			+"AND m.t_menuDate <![CDATA[>=]]> #{cookMenu.minDate}</if> "
			+"<if test=\"cookMenu.maxDate!=null\"> "
			+"AND m.t_menuDate <![CDATA[<=]]> #{cookMenu.maxDate}</if></script>")*/
	@Select(value="select count(1) from t_user")
	Long queryMenuCount(User user);	
}

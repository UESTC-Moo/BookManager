package com.nowcoder.project.dao;

import com.nowcoder.project.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    String table_name = " user ";
    String insert_field = " name, email, password ";
    String select_filed = " id, " + insert_field;

    @Insert({"insert into", table_name, "(", insert_field, ") values (#{name},#{email},#{password})"})
    int addUser(User user);

    @Select({"select", select_filed, "from", table_name, "where id=#{uid}"})
    User selectById(int uid);

    @Select({"select", select_filed, "from", table_name, "where name=#{name}"})
    User selectByName(String name);

    @Select({"select", select_filed, "from", table_name, "where email=#{email}"})
    User selectByEmail(String email);

    @Update({"update", table_name, "set password=#{password} where id=#{id}"})
    void updatePassword(String password);
}
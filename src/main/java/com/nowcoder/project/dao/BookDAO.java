package com.nowcoder.project.dao;

import com.nowcoder.project.model.Book;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by nowcoder on 2018/08/04 下午3:41
 */
@Mapper
@Repository
public interface BookDAO {

  String table_name = " book ";
  String insert_filed = " name, author, price ";
  String select_filed = " id, status, " + insert_filed;

  @Insert({"insert into", table_name, "(", insert_filed, ") values (#{name},#{author},#{price})"})
  int addBook(Book book);

  @Update({"update ", table_name, "set status=#{status} where id=#{id}"})
  void updateBookStatus(@Param("id") int id,@Param("status") int status);

  @Select({"select ",select_filed,"from ",table_name})
  List<Book> selectAll();
}

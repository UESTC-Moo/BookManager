package com.nowcoder.project.dao;

import com.nowcoder.project.model.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TicketDAO {
    String table_name = " ticket ";
    String insert_field = " user_id, ticket, expired_time ";
    String select_filed = " id, " + insert_field;

    @Insert({"insert into", table_name, "(", insert_field, ") values (#{userId},#{ticket},#{expiredTime})"})
    int addTicket(Ticket ticket);

    @Select({"select", select_filed, "from", table_name, "where id=#{id}"})
    Ticket selectById(int id);

    @Select({"select", select_filed, "from", table_name, "where ticket=#{ticket}"})
    Ticket selectByTicket(String ticket);

    @Delete({"delete from", table_name, " where id=#{tid}"})
    void deleteTicketById(int tid);

    @Delete({"delete from", table_name, " where ticket=#{ticket}"})
    void deleteTicket(String ticket);
}

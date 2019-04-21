package com.nowcoder.project.utils;

import com.nowcoder.project.model.Ticket;
import org.joda.time.DateTime;

public class TicketUtils {
    public static Ticket next(int uid){
        Ticket ticket = new Ticket();
        ticket.setTicket(UuidUtils.next());
        ticket.setUserId(uid);

        DateTime expiredTime = new DateTime();
        expiredTime = expiredTime.plusMonths(1);
        ticket.setExpiredTime(expiredTime.toDate());

        return ticket;
    }
}

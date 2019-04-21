package com.nowcoder.project.biz;

import com.nowcoder.project.model.Ticket;
import com.nowcoder.project.model.User;
import com.nowcoder.project.model.exception.LoginRegisterException;
import com.nowcoder.project.service.TicketService;
import com.nowcoder.project.service.UserService;
import com.nowcoder.project.utils.ConcurrentUtils;
import com.nowcoder.project.utils.Md5Utils;
import com.nowcoder.project.utils.TicketUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginBiz {
    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    public String login(String email, String password) throws Exception{
        User user = userService.getUser(email);
        //check login information
        if (user == null)
            throw new LoginRegisterException("Not have this email");
        if (!StringUtils.equals(Md5Utils.next(password),user.getPassword()))
            throw new LoginRegisterException("Wrong login password");

        Ticket ticket = ticketService.getTicket(user.getId());
        //check ticket
        if (ticket==null){
            ticket = TicketUtils.next(user.getId());
            ticketService.addTicket(ticket);
            return ticket.getTicket();
        }
        //if out of time, remove the oldest and create new one
        if (ticket.getExpiredTime().before(new Date())){
            ticketService.deleteTicket(ticket.getId());
        }
        ticket = TicketUtils.next(user.getId());
        ticketService.addTicket(ticket);
        //and set this user is host
        ConcurrentUtils.setHost(user);
        return ticket.getTicket();
    }

    public void logout(String ticket){
        ticketService.deleteTicket(ticket);
    }

    public String register(User user) throws Exception{
        //check register information
        if (userService.getUser(user.getEmail()) != null){
            throw new LoginRegisterException("Already have this email");
        }

        //MD5 this password
        String md5Password = Md5Utils.next(user.getPassword());
        user.setPassword(md5Password);

        userService.addUser(user);

        Ticket ticket = TicketUtils.next(user.getId());
        ticketService.addTicket(ticket);

        ConcurrentUtils.setHost(user);
        return ticket.getTicket();
    }
}

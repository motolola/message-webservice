package com.tantalumcorporation.microservice.microone.service;

import com.tantalumcorporation.microservice.microone.model.Message;
import com.tantalumcorporation.microservice.microone.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepo;

    public Message get(int id)
    {
        Optional<Message> message = messageRepo.findById(id);
        return message.get();
    }

    public String update(int id, String subject, String body)
    {
        Optional<Message> OptMessage = messageRepo.findById(id);
        Message message = OptMessage.get();

        Date createTime = message.getCreateDate();
        Date currentTime = new Date();

        if (currentTime.getTime() - createTime.getTime() < 10000){
            message.setSubject(subject);
            message.setBody(body);

            this.save(message);
            return "Deleted";
        }
        return "canOnlyDeleteAfterTenSeconds";
    }

    public List<Message> getAll()
    {
       return messageRepo.findAll();
    }
     public List<Message> getAllLimit(int limit)
     {
         List<Message> messages = this.getAll();
         int to = messages.size() > 0 ? messages.size(): 0;
         int from = limit >= messages.size() ? 0 : (messages.size() - limit);
         return messages.subList(from , to);
     }

    public Message save(Message message)
    {
        return messageRepo.save(message);
    }

    public String delete(int id)
    {
        Message message = this.get(id);

        Date createTime = message.getCreateDate();
        Date currentTime = new Date();

        if (currentTime.getTime() - createTime.getTime() >= 120000){
            messageRepo.deleteById(id);
            return "deleted";
        } else {
            return "canOnlyDeleteAfterTwoMinutes";
        }
    }

}

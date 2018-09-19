package com.tantalumcorporation.microservice.microone.controller;

import com.tantalumcorporation.microservice.microone.model.Message;
import com.tantalumcorporation.microservice.microone.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "add")
    public ResponseEntity<Object> createMessage(@RequestParam(value = "subject") String subject,
                                @RequestParam(value = "body") String body)
    {
        Message savedMessage = messageService.save(new Message(subject,body));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMessage.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("find/{id}")
    public Message getMessage(@PathVariable(value = "id") int id)
    {
        return messageService.get(id);
    }

    @GetMapping("find_all")
    public List<Message> allMessages()
    {
        List<Message> messages = messageService.getAll();
        return messages;
    }
    @GetMapping("find_all_limit/{limit}")
    public List<Message> findAllLimit(@PathVariable(value = "limit") int limit)
    {
        List<Message> messages = messageService.getAllLimit(limit);
        return messages;
    }
    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateMessage(@RequestParam(value = "id") int id, @RequestParam(value = "subject") String subject,
                                        @RequestParam(value = "body") String body)
    {
        messageService.update(id,subject,body);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public String deleteMessage(@PathVariable int id)
    {
        return messageService.delete(id);
    }


}

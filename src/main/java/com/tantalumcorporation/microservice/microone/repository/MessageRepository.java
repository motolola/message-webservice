package com.tantalumcorporation.microservice.microone.repository;

import com.tantalumcorporation.microservice.microone.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Override
    Message getOne(Integer integer);
    @Override
    Optional<Message> findById(Integer integer);
    List<Message> findAll();
    Message save(Message message);
    @Override
    void deleteById(Integer integer);
}

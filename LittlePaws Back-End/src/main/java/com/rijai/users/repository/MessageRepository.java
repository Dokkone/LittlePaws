package com.rijai.users.repository;

import com.rijai.users.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message, Integer> {

}
package eci.ieti.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.ieti.data.model.User;

import java.util.List;

/**
 *
 * @author Diego23p
 */
public interface UserRepository extends MongoRepository<User, String>{
    
}

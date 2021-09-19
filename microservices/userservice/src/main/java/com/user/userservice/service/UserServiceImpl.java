package com.user.userservice.service;

import com.user.userservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{
    List<User> list= List.of(
            new User(101L,"Kamal","1234"),
            new User(102L,"Raj","1235"),
            new User(103L,"Dinkar","1236")
    );
    @Override
    public User getUser(Long id) {
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getUserId()==id)
            {
                return list.get(i);
            }
        }
        return null;
    }
}

package com.example.springcloudvaultdemo.service;

import com.example.springcloudvaultdemo.dto.UserDto;
import com.example.springcloudvaultdemo.entity.User;
import com.example.springcloudvaultdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto add(UserDto userDto) {
        User saved = userRepository.save(new User(0, userDto.getUsername(), userDto.getPassword()));
        userDto.setId(saved.getId());
        return userDto;
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().parallelStream().map(user -> new UserDto(user.getId(), user.getUsername(), user.getPassword())).toList();
    }
}

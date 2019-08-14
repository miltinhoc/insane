package org.academiadecodigo.codezillas.insane.dtos;

import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDto {

        public UserDto userDto(User user) {

            UserDto userDto = new UserDto();

            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setMainSkill(user.getMainSkill());
            userDto.setDisorder(user.getDisorder());
            userDto.setCountry(user.getCountry());
            userDto.setAge(user.getAge());
            userDto.setEmail(user.getEmail());
            userDto.setId(user.getId());
            userDto.setPassword(user.getPassword());
            userDto.setSummary(user.getSummary());

            return userDto;
        }
}

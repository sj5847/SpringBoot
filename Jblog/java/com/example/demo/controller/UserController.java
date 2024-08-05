package com.example.demo.controller;


import com.example.demo.domain.RoleType;
//import com.example.demo.domain.User;
import com.example.demo.domain.User;
import com.example.demo.exception.JBlogException;
import com.example.demo.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.function.Supplier;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/get/{id}")
    public @ResponseBody User getUser(@PathVariable int id) {
        //검색된 회원이 없을 경우 특정 id에 해당하는 User 객체 반환
        User findUser =
                userRepository.findById(id).orElseThrow(() -> {
                    return new JBlogException(id + "번 회원이 없습니다.");
                });
        return findUser;
    }

    @PostMapping("/user")
    public @ResponseBody String insertUser(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return user.getUsername() + "회원가입 성공";
    }

    @Transactional  //save메서드를 호출하지 않고 어노테이션을 설정해도 결과는 같다.
    //메서드가 호출될때 트랜잭션이 시작되고, 메서드가 종료되면 자동으로 종료된다.
    @PutMapping("/user")  //모든 컬럼을 수정할 수 있기 때문에 효율적이다.
    public @ResponseBody String updateUser(@RequestBody User user) {//내용을 변경해야 하므로 RequestBody
        //메서드는 회원을 검색하며 엔티티를 매개변수로 받은 user객체의 값으로 수정한다. 그리고 최종적으로
        //jpaRepository의 save메서드를 이용하여 수정을 완료한다.
        //save메서드는 매개변수로 전달된 엔티티에 식별자 값이 설정되어 있으면 update로 동작학 식별자 값이 설정되어
        //있지 않으면 insert로 동작한다.
        System.out.println("전달된 값:" + user.toString());
        User findUser = userRepository.findById(user.getId()).orElseThrow(() -> {
//            return new JBlogException(user.getId()+"번 회원이 없습니다.");//클래스를 만들어서 예외처리
            return new IllegalArgumentException(user.getId() + "번 회원이 없습니다.");
        });
        findUser.setUsername(user.getUsername());
        findUser.setPassword(user.getPassword());
        findUser.setEmail(user.getEmail());

//        userRepository.save(findUser);  //Transactional 사용으로 생략가능
        return "회원 수정 성공";


    }

    @DeleteMapping("user/{id}")
    public @ResponseBody String delteUser(@PathVariable int id) {
        userRepository.deleteById(id);
        return "회원 삭제 성공";
    }


    @GetMapping("/user/list")
    public @ResponseBody List<User> getUserList() {
        return userRepository.findAll();
    }

    @GetMapping("/user/page")
    public @ResponseBody Page<User> getUserListPaging (
        @PageableDefault(page = 0, size = 2, direction = Sort.Direction.DESC,
            sort = {"id", "username"})Pageable pageable) {
        //첫 번째 페이지(0)에 해당하는 2개의 데이터 조회
        //id 내림차순 정렬
        return userRepository.findAll(pageable);
        }

    }






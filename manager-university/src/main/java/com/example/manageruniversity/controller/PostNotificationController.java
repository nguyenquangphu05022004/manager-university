package com.example.manageruniversity.controller;

import com.example.manageruniversity.dto.PostNotificationDTO;
import com.example.manageruniversity.entity.PostNotification;
import com.example.manageruniversity.service.impl.PostNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PostNotificationController {

    private final PostNotificationService postNotificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostNotificationDTO postDto) {
         postNotificationService.saveOrUpdate(postDto);
    }
    @GetMapping
    public List<PostNotificationDTO> getListPostNotification() {
        return postNotificationService.getList();
    }
    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postNotificationService.deleteById(postId);
    }
    @GetMapping("/{postId}")
    public PostNotificationDTO getPostById(@PathVariable("postId") Long postId) {
        return postNotificationService.findById(postId);
    }
}

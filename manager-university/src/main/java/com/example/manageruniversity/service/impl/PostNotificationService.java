package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.PostNotificationDTO;
import com.example.manageruniversity.entity.PostNotification;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.repository.PostNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostNotificationService {
    private final PostNotificationRepository postNotificationRepository;

    public void saveOrUpdate(PostNotificationDTO postDto) {
        PostNotification post = new PostNotification(postDto.getTitle(), postDto.getContent());
        postNotificationRepository.save(post);
    }

    public List<PostNotificationDTO> getList() {
        return postNotificationRepository.findAllByOrderByIdDesc()
                .stream()
                .map(post -> {
                    PostNotificationDTO postDto = new PostNotificationDTO(post.getTitle(), post.getContent());
                    postDto.setId(post.getId());
                    return postDto;
                })
                .toList();
    }

    public void deleteById(Long postId) {
        postNotificationRepository.deleteById(postId);
    }

    public PostNotificationDTO findById(Long postId) {
        PostNotification post = postNotificationRepository.findById(postId).orElseThrow(
                () -> new NotFoundIdException("PostNotification", "Id", postId.toString())
        );
        PostNotificationDTO postDto = new PostNotificationDTO(post.getTitle(), post.getContent());
        postDto.setId(post.getId());
        return postDto;
    }
}

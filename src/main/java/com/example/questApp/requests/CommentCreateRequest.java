package com.example.questApp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
    Long Id;
    Long userId;
    Long postId;
    String text;
}

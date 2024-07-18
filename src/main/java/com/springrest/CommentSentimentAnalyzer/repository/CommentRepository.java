package com.springrest.CommentSentimentAnalyzer.repository;

import com.springrest.CommentSentimentAnalyzer.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}


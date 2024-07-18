package com.springrest.CommentSentimentAnalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springrest.CommentSentimentAnalyzer.model.Comment;
import com.springrest.CommentSentimentAnalyzer.service.SentimentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/comments")
@Tag(name = "CommentSentimentAnalyzer API", description = "API for Analyzing Comment Sentiment")
public class CommentController {
    @Autowired
    private SentimentService sentimentService;

    @PostMapping("/analyze")
    @Operation(summary = "Analyze Comment", description = "Return Message after Analyzing")
    public ResponseEntity<?> analyzeComment(@RequestBody Comment comment) {
        try {
            Comment analyzedComment = sentimentService.analyzeSentiment(comment);
            return new ResponseEntity<>(analyzedComment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to analyze comment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

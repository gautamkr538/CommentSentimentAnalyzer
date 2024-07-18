package com.springrest.CommentSentimentAnalyzer.service;

import com.springrest.CommentSentimentAnalyzer.exception.SentimentAnalysisException;
import com.springrest.CommentSentimentAnalyzer.model.Comment;
import com.springrest.CommentSentimentAnalyzer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SentimentService {

    private static final Logger logger = LoggerFactory.getLogger(SentimentService.class);

    @Autowired
    private CommentRepository commentRepository;

    public Comment analyzeSentiment(Comment comment) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://text-processing.com/api/sentiment/";

            // Prepare the request
            Map<String, String> request = new HashMap<>();
            request.put("text", comment.getText());

            // Call the external API to get the sentiment
            String sentiment = restTemplate.postForObject(url, request, String.class);

            // Log the sentiment analysis result
            logger.debug("Sentiment for comment '{}' is '{}'", comment.getText(), sentiment);

            // Set the sentiment as the comment text (or handle it appropriately)
            comment.setText(sentiment);

            // Save the comment to the repository
            return commentRepository.save(comment);
        } catch (Exception e) {
            logger.error("Error analyzing sentiment for comment '{}': ", comment.getText(), e);
            throw new SentimentAnalysisException("Failed to analyze sentiment", e);
        }
    }
}

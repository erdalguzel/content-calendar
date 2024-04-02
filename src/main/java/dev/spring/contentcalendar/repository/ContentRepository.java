package dev.spring.contentcalendar.repository;

import dev.spring.contentcalendar.model.Content;
import dev.spring.contentcalendar.model.Status;
import dev.spring.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentRepository() {
    }

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(content -> content.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1,
                "Tale of two cities",
                "Classics",
                Status.PUBLISHED,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        Content c1 = new Content(2,
                "Madame Bovary",
                "Classics",
                Status.PUBLISHED,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contents.add(c);
        contents.add(c1);
    }

    public void save(Content content) {
        contents.add(content);
    }
}
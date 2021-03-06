package com.deivmercer.kanbanboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "tile")
public class Tile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @javax.persistence.Column(nullable = false)
    private String title;

    @JsonIgnoreProperties("password")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @javax.persistence.Column(nullable = false, length = 4096)
    private String content;

    @javax.persistence.Column(nullable = false)
    private char content_type;  // Organizational / Informational

    @javax.persistence.Column(nullable = false)
    private char tile_type; // Text / Image

    @JsonIgnoreProperties("tiles")
    @ManyToOne
    @JoinColumn(name = "column_id", nullable = false)
    private Column column;

    public Integer getId() {
        return id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public User getAuthor() {

        return author;
    }

    public void setAuthor(User author) {

        this.author = author;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

    public char getContent_type() {

        return content_type;
    }

    public void setContent_type(char content_type) throws IllegalArgumentException {

        if (content_type != 'O' && content_type != 'I')
            throw new IllegalArgumentException("Content type " + content_type + " is invalid.");
        this.content_type = content_type;
    }

    public char getTile_type() {

        return tile_type;
    }

    public void setTile_type(char tile_type) {

        if (tile_type != 'T' && tile_type != 'I')
            throw new IllegalArgumentException("Content type " + content_type + " is invalid.");
        this.tile_type = tile_type;
    }

    public Column getColumn() {

        return column;
    }

    public void setColumn(Column column) {

        this.column = column;
    }
}

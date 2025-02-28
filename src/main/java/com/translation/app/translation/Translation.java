package com.translation.app.translation;

import jakarta.persistence.*;

@Entity
@Table(name = "translations")
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Translation() {
    }

    @Column(nullable = false)
    private String language;

    public Translation(Long id, String language, String text, String tag) {
        this.id = id;
        this.language = language;
        this.text = text;
        this.tag = tag;
    }

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String translatedText;

    @Column(nullable = false)
    private String tag;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

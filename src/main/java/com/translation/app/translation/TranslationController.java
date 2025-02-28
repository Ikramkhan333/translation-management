package com.translation.app.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class TranslationController {
    @Autowired
    private TranslationService translationService;

    @PostMapping("/translate")
    public ResponseEntity<Translation> createTranslation(@RequestBody Translation translation) {
        return ResponseEntity.ok(translationService.createTranslation(translation));
    }
    @GetMapping("/translations")
    public ResponseEntity<List<Translation>> searchTranslations(@RequestParam(required = false) String tag,
                                                                @RequestParam(required = false) String text,
                                                                @RequestParam(required = false) String language) {
        return ResponseEntity.ok(translationService.searchTranslations(tag, text, language));
    }

    @GetMapping("/translations/export")
    public ResponseEntity<List<Translation>> exportTranslations(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "1000") int size) {
        return ResponseEntity.ok(translationService.exportTranslations(page, size));
    }
}
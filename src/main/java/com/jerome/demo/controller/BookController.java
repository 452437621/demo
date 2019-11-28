package com.jerome.demo.controller;

import com.jerome.demo.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    private List<Book> bookList = Collections.synchronizedList(new ArrayList<Book>());

    @PostMapping("/book")
    public ResponseEntity<List<Book>> add(@RequestBody Book book) {
        bookList.add(book);
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/book/id")
    public ResponseEntity<List<Book>> getById(@RequestParam long id) {
        List<Book> result = bookList.stream().filter(book -> book.getId() == id).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/book/name")
    public ResponseEntity<List<Book>> getByName(@RequestParam String name) {
        List<Book> result = bookList.stream().filter(book -> book.getName() == name).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("book/{id}")
    public ResponseEntity<Book> delete(@PathVariable int id) {
        Book book = bookList.remove(id);
        return ResponseEntity.ok(book);
    }

}

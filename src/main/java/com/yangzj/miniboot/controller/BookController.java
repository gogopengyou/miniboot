package com.yangzj.miniboot.controller;

import com.yangzj.miniboot.domain.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author yangzj
 * @date 2020/03/23
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity delete(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/get")
    public ResponseEntity get(@RequestParam("name") String name) {
        List<Book> res = books.stream().filter(b -> b.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }

}

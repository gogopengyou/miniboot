package com.yangzj.miniboot.controller;

import com.yangzj.miniboot.domain.entity.Book;
import com.yangzj.miniboot.service.kafka.BookProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
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

    @Value("${kafka.topic.my-topic}")
    String myTopic;
    @Value("${kafka.topic.my-topic2}")
    String myTopic2;
    @Autowired
    private BookProducerService producer;
    private AtomicLong atomicLong = new AtomicLong();

    private List<Book> books = new ArrayList<>();

    @RequestMapping
    public void sendMessageToKafkaTopic(@RequestParam("name") String name) {
        this.producer.sendMessage(myTopic, new Book(name+atomicLong.addAndGet(1), atomicLong.addAndGet(1)+""));
        this.producer.sendMessage(myTopic2, new Book(name+atomicLong.addAndGet(1), atomicLong.addAndGet(1)+""));
    }

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

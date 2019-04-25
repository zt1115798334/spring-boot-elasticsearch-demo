package com.example;

import com.example.entity.Book;
import com.example.service.BookService;
import com.example.utils.EsUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    public void save() {
        Book book = new Book(EsUtils.getEsID(),
                "蜡笔小新",
                "蜡笔小新作者",
                "蜡笔小新作");
        bookService.save(book);
    }

    @Test
    public void delete() {
        Book book = new Book("469e4c838f144406b918222ec70c5e3e",
                "蜡笔小新",
                "蜡笔小新作者",
                "蜡笔小新作");
        bookService.delete(book);
    }

    @Test
    public void findOne() {
        String s = null;
        try {
            s = bookService.findOne("ba55170a7d7648fd8e8a7f50a7a96f5f").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("s = " + s);
    }

    @Test
    public void findAll() {
        bookService.findAll().forEach(System.out::println);
    }

    @Test
    public void findByAuthor() {
        Pageable pageable = PageRequest.of(1, 10);
        bookService.findByAuthor("蜡笔小新作者",pageable).getContent().forEach(System.out::println);
    }

    @Test
    public void findByTitle() {
        Pageable pageable = PageRequest.of(1, 10);
        bookService.findByTitle("蜡笔小新",pageable).getContent().forEach(System.out::println);
    }
}

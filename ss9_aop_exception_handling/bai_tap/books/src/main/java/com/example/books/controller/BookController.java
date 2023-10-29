package com.example.books.controller;


import com.example.books.model.Book;
import com.example.books.model.Oder;
import com.example.books.service.IBookService;
import com.example.books.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOderService oderService;

    @GetMapping("home")
    public ModelAndView showHome() {

        return new ModelAndView("index", "book", bookService.findAllBook());
    }

    @GetMapping("/oder/{idBook}")
    public ModelAndView oder(@PathVariable long idBook) throws Exception {

        Book book = bookService.findByIdBook(idBook);
        if(book.getCount() == 0) {
            throw new Exception();
        }
        book.setCount(book.getCount() - 1);

        Oder oder = new Oder();

        long code = (long) (Math.random() * (99999 - 10000) + 10000);
        oder.setCode(code);

        long millis = System.currentTimeMillis();
        oder.setDate(new java.sql.Date(millis));



        List<Oder> oders = book.getList();
        oders.add(oder);
        book.setList(oders);

        oderService.saveOder(oder);
        bookService.saveBook(book);

        return new ModelAndView("redirect:/home");
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerError() {
        return new ModelAndView("error");
    }
}

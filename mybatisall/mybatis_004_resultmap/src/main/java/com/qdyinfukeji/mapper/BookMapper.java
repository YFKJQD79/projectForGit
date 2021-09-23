package com.qdyinfukeji.mapper;

import com.qdyinfukeji.pojo.Book;

import java.util.List;

public interface BookMapper {


    List<Book>getAll();

    List<Book> getAllNew();
}

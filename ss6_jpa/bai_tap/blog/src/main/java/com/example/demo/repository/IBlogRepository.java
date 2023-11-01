package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
//    @Query(nativeQuery = true,value = "select summary from Blog where id = :param")
//    String getSummaryById(@Param("param") Integer id);
    @Query(nativeQuery = true,value = "select * from Blog where id_category =:param")
    List<Blog> getBlogByCategoryId(@Param("param") Integer idCategory);
    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);

}

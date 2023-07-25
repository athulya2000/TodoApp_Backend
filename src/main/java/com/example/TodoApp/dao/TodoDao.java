package com.example.TodoApp.dao;

import com.example.TodoApp.model.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TodoDao extends CrudRepository<Todo,Integer> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `todo` WHERE `id`=:id",nativeQuery = true)
    void  delete(@Param("id") Integer id);
}

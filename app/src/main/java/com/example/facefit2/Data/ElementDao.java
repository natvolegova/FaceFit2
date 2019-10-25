package com.example.facefit2.Data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.facefit2.Objects.Element;

import java.util.List;

@Dao
public interface ElementDao {
    @Query("SELECT * FROM Element")
    List<Element> getAllElements();

    @Query("SELECT E._id, E.NAME, E.IMAGE, E.TIME, E.VIDEO FROM Element E INNER JOIN ELEMENT_BY_PROGRAM EP on E._id = EP.ELEMENT_ID WHERE EP.program_id = :id")
    List<Element> getElementsByProgram(int id);

    //пример запроса с выборкой
    @Query("SELECT * FROM Element WHERE _id = :id")
    Element getById(int id);
}

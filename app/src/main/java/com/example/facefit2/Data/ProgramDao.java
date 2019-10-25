package com.example.facefit2.Data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.facefit2.Objects.Program;
import com.example.facefit2.Objects.ProgramFullInfo;

import java.util.List;

@Dao
public interface ProgramDao {
    @Query("select * from PROGRAM")
    List<Program> getAllElements();

    @Query("select P._id, P.NAME, P.TEXT_DESC, P.IMAGE, sum(E.TIME) as time, count(E._ID) as countOfElements from PROGRAM P LEFT JOIN ELEMENT_BY_PROGRAM EP on P._id = EP.PROGRAM_ID LEFT JOIN ELEMENT E on E._id = EP.ELEMENT_ID GROUP BY P.NAME")
    List<ProgramFullInfo> getProgramsFullInfo();

    @Query("select P._id, P.NAME, P.TEXT_DESC, P.IMAGE, sum(E.TIME) as time, count(E._ID) as countOfElements from PROGRAM P LEFT JOIN ELEMENT_BY_PROGRAM EP on P._id = EP.PROGRAM_ID LEFT JOIN ELEMENT E on E._id = EP.ELEMENT_ID WHERE P._id = :id GROUP BY P.NAME ")
    ProgramFullInfo getProgramsFullInfoById(int id);


    //пример запроса с выборкой
    @Query("SELECT * FROM Program WHERE _id = :id")
    Program getById(int id);
}

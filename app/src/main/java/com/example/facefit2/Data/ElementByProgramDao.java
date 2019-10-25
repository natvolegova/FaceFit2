package com.example.facefit2.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.facefit2.Objects.Element;

import java.util.List;

@Dao
public interface ElementByProgramDao {
    @Query("SELECT  Element._id, Element.name, Element.time, Element.image, Element.video FROM Element INNER JOIN element_by_program ON Element._id=element_by_program.element_id WHERE element_by_program.program_id=:id")
    List<Element> getElementByProgram(int id);
}

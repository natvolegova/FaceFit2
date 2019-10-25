package com.example.facefit2.Objects;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "element_by_program",
        indices = {@Index(value = {"element_id", "program_id"}, unique = true)},
        primaryKeys = {"element_id", "program_id"},
        foreignKeys = {
                @ForeignKey(entity = Element.class,
                        parentColumns = "_id",
                        childColumns = "element_id"),
                @ForeignKey(entity = Program.class,
                        parentColumns = "_id",
                        childColumns = "program_id")
        })
public class ElementByProgram {
    private int element_id;
    private int program_id;

    public ElementByProgram(int element_id, int program_id) {
        this.element_id = element_id;
        this.program_id = program_id;
    }

    public int getElement_id() {
        return element_id;
    }

    public void setElement_id(int element_id) {
        this.element_id = element_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }
}

package com.example.facefit2.Objects;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_by_program",
        primaryKeys = {"product_id", "program_id"},
        foreignKeys = {
                @ForeignKey(entity = Product.class,
                        parentColumns = "_id",
                        childColumns = "product_id"),
                @ForeignKey(entity = Program.class,
                        parentColumns = "_id",
                        childColumns = "program_id")
        })
public class ProductByProgram {
    private int product_id;
    private int program_id;

    public ProductByProgram(int product_id, int program_id) {
        this.product_id = product_id;
        this.program_id = program_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getProgram_id() {
        return program_id;
    }
}

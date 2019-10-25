package com.example.facefit2.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.facefit2.Objects.Product;

import java.util.List;
@Dao
public interface ProductByProgramDao {

    @Query("SELECT _id, name, text_desc, image FROM Product INNER JOIN product_by_program ON Product._id=product_by_program.product_id WHERE product_by_program.program_id=:id")
    List<Product> getProductByProgram(int id);
}

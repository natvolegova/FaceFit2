package com.example.facefit2.Data;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.facefit2.Objects.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product")
    List<Product> getAllElements();

    @Query("SELECT E._id, E.NAME, E.TEXT_DESC, E.IMAGE FROM Product E INNER JOIN PRODUCT_BY_PROGRAM EP on E._id = EP.PRODUCT_ID WHERE EP.program_id = :id")
    List<Product> getProductsByProgram(int id);

    //пример запроса с выборкой
    @Query("SELECT * FROM Product WHERE _id = :id")
    Product getById(int id);
}

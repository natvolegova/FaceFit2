package com.example.facefit2.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.facefit2.Objects.Element;
import com.example.facefit2.Objects.ElementByProgram;
import com.example.facefit2.Objects.Product;
import com.example.facefit2.Objects.ProductByProgram;
import com.example.facefit2.Objects.Program;

@Database(entities = {Element.class, ElementByProgram.class, Product.class, ProductByProgram.class, Program.class}, version = 1, exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {
    public abstract ElementDao ElementDao();

    public abstract ElementByProgramDao ElementByProgramDao();

    public abstract ProductByProgramDao ProductByProgramDao();

    public abstract ProductDao ProductDao();

    public abstract ProgramDao ProgramDao();
}

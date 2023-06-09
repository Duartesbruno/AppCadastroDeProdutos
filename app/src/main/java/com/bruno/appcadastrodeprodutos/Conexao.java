package com.bruno.appcadastrodeprodutos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String NOME_BD = "banco_produtos";
    private static final int VERSAO_BD = 1;

    public Conexao(Context context){
        super( context, NOME_BD , null, VERSAO_BD  );
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE produtos ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                " nome TEXT NOT NULL ," +
                " quantidade TEXT NOT NULL," +
                " preco TEXT NOT NULL, " +
                " conservacao NOT NULL ) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}

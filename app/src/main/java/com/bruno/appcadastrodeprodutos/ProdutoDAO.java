package com.bruno.appcadastrodeprodutos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static void inserir(Context context, Produto produto){
        Conexao conn = new Conexao(context);
        SQLiteDatabase db = conn.getWritableDatabase();
//        db.execSQL("INSERT INTO produto ( nome, quantidade) VALUES (" +
//                    " '"+produto.getNome()+"'  ," +
//                    " '"+produto.getQuantidade()+"' )");

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome() );
        valores.put("quantidade", produto.getQuantidade() );

        db.insert("produtos", null, valores);
    }

    public static void editar(Context context, Produto produto){
        Conexao conn = new Conexao(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome() );
        valores.put("quantidade", produto.getQuantidade() );

        db.update("produto", valores ,
                " id = " + produto.getId(), null  );
    }

    public static void excluir(Context context, int idProduto){
        SQLiteDatabase db = new Conexao(context).getWritableDatabase();

        db.delete("produtos",
                " id = " + idProduto, null  );
    }

    public static List<Produto> getProdutos(Context context){
        Conexao conn = new Conexao(context);
        SQLiteDatabase db = conn.getReadableDatabase();
        List<Produto> lista = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT id, nome, quantidade FROM produtos ORDER BY nome",
                null);
        if( cursor != null && cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto produto = new Produto();
                produto.setId( cursor.getInt( 0 )  );
                produto.setNome( cursor.getString( 1 )  );
                produto.setQuantidade( cursor.getString( 2 )  );
                lista.add( produto );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

    public static Produto getProdutoById(Context context, int idProduto){
        SQLiteDatabase db = new Conexao(context).getReadableDatabase();
        Produto produto = null;
        Cursor cursor = db.rawQuery("SELECT id, nome, quantidade FROM produtos " +
                " WHERE id = " + idProduto, null);
        if( cursor != null && cursor.getCount() > 0 ){
            cursor.moveToFirst();
            produto = new Produto();
            produto.setId( cursor.getInt( 0 )  );
            produto.setNome( cursor.getString( 1 )  );
            produto.setQuantidade( cursor.getString( 2 )  );
        }
        return produto;
    }

}

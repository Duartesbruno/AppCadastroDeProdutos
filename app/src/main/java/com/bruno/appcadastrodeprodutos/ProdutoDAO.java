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

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome() );
        valores.put("quantidade", produto.getQuantidade() );
        valores.put("preco", produto.getPreco().toString() );
        valores.put("conservacao", produto.getConservacao().toString() );

        db.insert("produtos", null, valores);
    }

    public static void editar(Context context, Produto produto){
        Conexao conn = new Conexao(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome() );
        valores.put("quantidade", produto.getQuantidade() );
        valores.put("preco", produto.getPreco().toString() );
        valores.put("conservacao", produto.getConservacao().toString() );

        db.update("produtos", valores ,
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

        Cursor cursor = db.rawQuery("SELECT id, nome, quantidade, preco, conservacao FROM produtos ORDER BY nome",
                null);
        if( cursor != null && cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto produto = new Produto();
                produto.setId( cursor.getInt( 0 )  );
                produto.setNome( cursor.getString( 1 )  );
                produto.setQuantidade( cursor.getString( 2 )  );
                produto.setPreco( cursor.getString( 3 )  );
                produto.setConservacao(Conservacao.valueOf(cursor.getString( 4 ))  );

                lista.add( produto );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

}

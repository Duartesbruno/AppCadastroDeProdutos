package com.bruno.appcadastrodeprodutos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etQto;
    private Button btnSalvar;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = findViewById(R.id.etNome);
        etQto = findViewById(R.id.etQto);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

    }

    private void salvar(){

        String nome = etNome.getText().toString();
        if ( nome.isEmpty() ){
            Toast.makeText(this,
                    "O campo nome deve ser preenchido!" ,
                    Toast.LENGTH_LONG
                    ).show();
        }else {
            produto = new Produto();
            produto.setNome( nome );
            produto.setQuantidade( etQto.getText().toString() );
            ProdutoDAO.inserir(this, produto);
            etNome.setText( "" );
            etQto.setText( "" );
            produto = null;
        }
    }

}

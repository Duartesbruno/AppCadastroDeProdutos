package com.bruno.appcadastrodeprodutos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome, etQto, etPreco;
    private RadioGroup rgConservacao;
    private RadioButton rbConservacaoSelecionada;
    private Button btnSalvar;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = findViewById(R.id.etNome);
        etQto = findViewById(R.id.etQto);
        etPreco = findViewById(R.id.etPreco);
        rgConservacao = findViewById(R.id.rgConservacao);
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
        String quantidade = etQto.getText().toString();
        String preco = etPreco.getText().toString();
        rbConservacaoSelecionada = findViewById(rgConservacao.getCheckedRadioButtonId());

        if (nome.isEmpty()) {
            Toast.makeText(this,
                    "O campo Nome deve ser preenchido!",
                    Toast.LENGTH_LONG
            ).show();
        } else if (quantidade.isEmpty()) {
            Toast.makeText(this, "O campo Quantidade deve ser preenchido!",
                    Toast.LENGTH_LONG
            ).show();
        } else if (preco.isEmpty()) {
            Toast.makeText(this, "O campo Preço deve ser preenchido!",
                    Toast.LENGTH_LONG
            ).show();
        } else if (rbConservacaoSelecionada == null) {
            Toast.makeText(this, "Você deve selecionar um tipo de Conservação!",
                    Toast.LENGTH_LONG
            ).show();
        }else {
            Conservacao conservacao = Conservacao.valueOf(rbConservacaoSelecionada.getText().toString().toUpperCase());

            produto = new Produto(nome, quantidade, preco, conservacao);

            ProdutoDAO.inserir(this, produto);
            etNome.setText( "" );
            etQto.setText( "" );
            etPreco.setText( "" );
            rgConservacao.clearCheck();
            produto = null;
        }
    }

}

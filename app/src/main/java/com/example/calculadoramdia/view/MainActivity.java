package com.example.calculadoramdia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.calculadoramdia.R;

public class MainActivity extends AppCompatActivity {

    private EditText nome;

    private EditText nota1;

    private EditText nota2;

    private Button btnCalcular;

    private Button btnLimpar;

    private TextView aluno;

    private TextView media;

    private TextView situacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        nome = findViewById(R.id.nome);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        aluno = findViewById(R.id.aluno);
        media = findViewById(R.id.media);
        situacao = findViewById(R.id.situacao);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia();
            }
        });

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void calcularMedia() {
        try {

            if (nota1.getText().toString() == null || nota1.getText().toString().trim().isEmpty()) {
                throw new Exception();
            }
            Double n1 = Double.parseDouble(nota1.getText().toString());

            try {
                if (nota2.getText().toString() == null || nota2.getText().toString().trim().isEmpty()) {
                    throw new Exception();
                }
                Double n2 = Double.parseDouble(nota2.getText().toString());

                double m = (n1 + n2) / 2;

                aluno.setText(getString(R.string.aluno) + " " + nome.getText().toString());
                media.setText(getString(R.string.media) + " " + m);


                if (m >= 7) {
                    situacao.setText(getString(R.string.situacao) + " " + getString(R.string.aprovado));
                } else {
                    situacao.setText(getString(R.string.situacao) + " " + getString(R.string.reprovado));
                }
            } catch (Exception e) {
                nota2.setError("Nota inválida!");
            }
        } catch (Exception e) {
            nota1.setError("Nota inválida!");
        }

    }

    private void limparCampos() {
        aluno.setText("");
        media.setText("");
        situacao.setText("");
        nome.setText("");
        nota1.setText("");
        nota2.setText("");
    }
}

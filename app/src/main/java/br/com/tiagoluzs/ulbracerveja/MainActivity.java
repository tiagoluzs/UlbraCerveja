package br.com.tiagoluzs.ulbracerveja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPreco300 = findViewById(R.id.preco300);
    EditText txtPreco350 = findViewById(R.id.preco350);
    EditText txtPreco473 = findViewById(R.id.preco473);
    EditText txtPreco600 = findViewById(R.id.preco600);

    Button btnCalcular = findViewById(R.id.btnCalcular);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                float preco300 = 0;
                try {
                    preco300 = Float.valueOf(txtPreco300.getText().toString());
                } catch(Exception e) {
                    preco300 = 0;
                }

                float preco350 = 0;
                try {
                    preco350 = Float.valueOf(txtPreco350.getText().toString());
                } catch(Exception e) {
                    preco350 = 0;
                }

                float preco473 = 0;
                try {
                    preco473 = Float.valueOf(txtPreco473.getText().toString());
                } catch(Exception e) {
                    preco473 = 0;
                }

                float preco600 = 0;
                try {
                    preco600 = Float.valueOf(txtPreco600.getText().toString());
                } catch(Exception e) {
                    preco600 = 0;
                }

                int menor = 0;
                float menor_preco_por_litro = 0;

                if(preco300 > 0) {
                    menor = 1; // por padrão é o primeiro se não for zero
                    menor_preco_por_litro = preco300 / 300 * 1000;
                }

                if(preco350 > 0 && (preco350/350*1000) < menor_preco_por_litro) {
                    menor = 2;
                    menor_preco_por_litro = preco350/350*1000;
                }

                if(preco473 > 0 && (preco473/473*1000) < menor_preco_por_litro) {
                    menor = 3;
                    menor_preco_por_litro = preco473/473*1000;
                }

                if(preco600 > 0 && (preco600/600*1000) < menor_preco_por_litro) {
                    menor = 4;
                    menor_preco_por_litro = preco600/600*1000;
                }

                if(menor == 0) {
                    Toast.makeText(MainActivity.this,R.string.Infome_pelo_menos_dois_precos,Toast.LENGTH_LONG).show();
                } else {
                    StringBuilder resultado = new StringBuilder();

                    switch (menor) {
                        case 1:
                            resultado.append(R.string.resultado_cerveja_300);
                            break;
                        case 2:
                            resultado.append(R.string.resultado_cerveja_350);
                            break;
                        case 3:
                            resultado.append(R.string.resultado_cerveja_473);
                            break;
                        case 4:
                            resultado.append(R.string.resultado_cerveja_600);
                            break;
                    }

                    resultado.append("\n");
                    resultado.append(R.string.cujo_preco_por_litro_e);
                    resultado.append(R.string.locale_currency+" "+String.valueOf(menor_preco_por_litro));

                    Toast.makeText(MainActivity.this,R.string.o_melhor_preco_e + resultado.toString(),Toast.LENGTH_LONG).show();

                }



            }
        });

    }
}

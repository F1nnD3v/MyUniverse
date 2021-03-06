package com.example.MyUniverse.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.MyUniverse.R;
import com.example.MyUniverse.constructors.Utilizador;
import com.example.MyUniverse.daos.UtilizadoresDAO;

public class EditarPerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        //buscar a tabela utilizadores
        UtilizadoresDAO utilizadoresDAO = new UtilizadoresDAO(this);

        //Esconder a actionbar(barra com o nome da app no topo)
        getSupportActionBar().hide();

        //Variáveis
        String loginId = getIntent().getStringExtra("loginId");
        Utilizador utilizador = utilizadoresDAO.getUserData(loginId);

        //Buttons
        Button btnGuardar = findViewById(R.id.btnGuardar);
        ImageButton btnVoltar2 = findViewById(R.id.btnVoltar2);

        //text boxes
        EditText txtDescrição = findViewById(R.id.txtDesc);

        txtDescrição.setText(utilizadoresDAO.getUserData(loginId).getDesc());

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String desc = txtDescrição.getText().toString();
                desc.trim();
                if (desc.length() == 0){
                    desc = "This user doesn't have the description set yet.";
                }
                utilizadoresDAO.updateDescricao(loginId, desc);
                Toast.makeText(getApplicationContext(),"Profile updated sucessfully!", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnVoltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtDescrição.getText().length() > 0){
                    //enviar mensagem de confirmação
                }
                finish();
            }
        });
    }
}
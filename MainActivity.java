package com.example.classificacao;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Switch swSexo;
    Button btnVerificar;
    String classe,categoria,limites;
    TextView txtAnoNasc,txtclasse,txtPeso,txtCategoria,txtLimites;
    String sexo= "Masculino";
    String lista[];
    Date data = new Date();
    SimpleDateFormat ano = new SimpleDateFormat("Y");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        swSexo = findViewById(R.id.switchSexo);
        txtclasse = findViewById(R.id.txtClasse);
        txtAnoNasc = findViewById(R.id.textAnoNasc);
        txtPeso = findViewById(R.id.textPeso);
        txtLimites = findViewById(R.id.textLimite);
        txtCategoria = findViewById(R.id.textCategoria);
        btnVerificar = findViewById(R.id.buttonVerificar);



        swSexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (swSexo.isChecked()){
                    sexo = "Feminino";
                }
                else{
                    sexo = "Masculino";
                }
                btnVerificar.callOnClick();
            }
        });


        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    if (sexo == "Masculino") {
                        classe = verificarClasseM(Integer.parseInt(ano.format(data)) - Integer.parseInt(txtAnoNasc.getText().toString()));
                        lista = verificarCategoriaM(classe, Double.parseDouble(txtPeso.getText().toString().replace(",", "."))).split(";");

                    } else {
                        classe = verificarClasseF(Integer.parseInt(ano.format(data)) - Integer.parseInt(txtAnoNasc.getText().toString()));
                        lista = verificarCategoriaF(classe, Double.parseDouble(txtPeso.getText().toString().replace(",", "."))).split(";");
                    }
                    categoria = lista[0];
                    limites = lista[1];
                    txtclasse.setText(classe);
                    txtCategoria.setText(categoria);
                    txtLimites.setText(limites);

                    if (getCurrentFocus() != null) {
                        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static String verificarClasseM(int idadeCorrente) {
        if (idadeCorrente<7 )return "invalido";
        if (idadeCorrente==7 || idadeCorrente==8 )return("SUB-9");
        if (idadeCorrente==9 || idadeCorrente==10 )return("SUB-11");
        if (idadeCorrente==11 || idadeCorrente==12 )return("SUB-13");
        if (idadeCorrente==13 || idadeCorrente==14 )return("SUB-15");
        if (idadeCorrente>14 && idadeCorrente<18 )return("SUB-18");
        if (idadeCorrente>=18 && idadeCorrente<30)return("ADULTO");
        if (idadeCorrente>=30 && idadeCorrente<35)return("ADULTO-M1");
        if (idadeCorrente>=35 && idadeCorrente<40)return("ADULTO-M2");
        if (idadeCorrente>=40 && idadeCorrente<45)return("ADULTO-M3");
        if (idadeCorrente>=45 && idadeCorrente<50)return("ADULTO-M4");
        if (idadeCorrente>=50 && idadeCorrente<55)return("ADULTO-M5");
        if (idadeCorrente>=55)return("ADULTO-M6");
        return null;
    }

    private static String verificarCategoriaM(String classe, double peso) {
        switch (classe) {
            case "SUB-9":
                if(peso<=23)return"Superligeiro;até 23kg";
                if(peso>23 && peso<=26)return"Ligeiro;+23kg a 26kg";
                if(peso>26 && peso<=29)return"Meio Leve;+26kg a 29kg";
                if(peso>29 && peso<=32)return"Leve;+29kg a 32kg";
                if(peso>32 && peso<=36)return"Meio Médio;+32kg a 36kg";
                if(peso>36 && peso<=40)return"Médio;+36kg a 40kg";
                if(peso>40 && peso<=45)return"Meio Pesado;+40kg a 45kg";
                if(peso>45 && peso<=50)return"Pesado;+ 45kg a 50kg";
                if(peso>50)return"Super Pesado;acima dos 50kg";
                break;
            case "SUB-11":
                if(peso<=28)return"Superligeiro;até 28kg";
                if(peso>28 && peso<=30)return"Ligeiro;+28kg a 30kg";
                if(peso>30 && peso<=33)return"Meio Leve;+30kg a 33kg";
                if(peso>33 && peso<=36)return"Leve;+33kg a 36kg";
                if(peso>36 && peso<=40)return"Meio Médio;+36kg a 40kg";
                if(peso>40 && peso<=45)return"Médio;+40kg a 45kg";
                if(peso>45 && peso<=50)return"Meio Pesado;+45kg a 50kg";
                if(peso>50 && peso<=55)return"Pesado;+50kg a 55kg+";
                if(peso>55 && peso<= 60)return"Super Pesado;+55kg a 60kg";
                if(peso>60)return"Extra Pesado;acima dos 60kg";
                break;
            case "SUB-13":
                if(peso<=28)return"Superligeiro;até 28kg";
                if(peso>28 && peso<=31)return"Ligeiro *+28kg a 31kg";
                if(peso>31 && peso<=34)return"Meio Leve;+31kg a 34kg";
                if(peso>34 && peso<=38)return"Leve;+34kg a 38kg";
                if(peso>38 && peso<=42)return"Meio Médio;+38kg a 42kg";
                if(peso>42 && peso<=47)return"Médio;+42kg a 47kg";
                if(peso>47 && peso<=52)return"Meio Pesado;+47kg a 52kg";
                if(peso>52 && peso<=60)return"Pesado;+52kg a 60kg";
                if(peso>60)return"Super Pesado;acima dos 60kg";
                break;
            case "SUB-15":
                if(peso<=36)return"Superligeiro;até 36kg";
                if(peso>36 && peso<=40)return"Ligeiro;+36kg a 40kg";
                if(peso>40 && peso<=44)return"Meio Leve;+40kg a 44kg";
                if(peso>44 && peso<=48)return"Leve;+44kg a 48kg";
                if(peso>48 && peso<=53)return"Meio Médio;+48kg a 53kg";
                if(peso>53 && peso<=58)return"Médio;+53kg a 58kg";
                if(peso>58 && peso<=64)return"Meio Pesado;+58kg a 64kg";
                if(peso>64 && peso<=73)return"Pesado;+64kg a 73kg";
                if(peso>73)return"Super Pesado;cima dos 73kg";
                break;
            case "SUB-18":
                if(peso<=50)return"Superligeiro;até 50kg";
                if(peso>50 && peso<=55)return"Ligeiro;+50kg a 55kg";
                if(peso>55 && peso<=60)return"Meio Leve;+55kg a 60kg";
                if(peso>60 && peso<=66)return"Leve;+60kg a 66kg";
                if(peso>66 && peso<=73)return"Meio Médio;+66kg a 73kg";
                if(peso>73 && peso<=81)return"Médio;+73kg a 81kg";
                if(peso>81 && peso<=90)return"Meio Pesado;+81kg a 90kg";
                if(peso>90)return"Pesado;acima dos 90kg";
                break;
            default:
                if(peso<=60)return"Ligeiro;até 60kg";
                if(peso>60 && peso<=66)return"Meio Leve;+60kg a 66kg";
                if(peso>66 && peso<=73)return"Leve;+66kg a 73kg";
                if(peso>73 && peso<=81)return"Meio Médio;+73kg a 81kg";
                if(peso>81 && peso<=90)return"Médio;+81kg a 90kg";
                if(peso>90 && peso<=100)return"Meio Pesado;+90kg a 100kg";
                if(peso>100)return"Pesado;acima dos 100kg";
                break;
        }
        return null;
    }

    private static String verificarCategoriaF(String classe, double peso) {
        // TODO Auto-generated method stub
        switch (classe) {
            case "SUB-9":
                if(peso<=23)return"Superligeiro;até os 23kg";
                if(peso>23 && peso<=26)return"Ligeiro;+23kg a 26kg";
                if(peso>26 && peso<=29)return"Meio Leve;+26kg a 29kg";
                if(peso>29 && peso<=32)return"Leve;+29kg a 32kg";
                if(peso>32 && peso<=36)return"Meio Médio;+32kg a 36kg";
                if(peso>36 && peso<=40)return"Médio;+36kg a 40kg";
                if(peso>40 && peso<=45)return"Meio Pesado;+40kg a 45kg";
                if(peso>45 && peso<=50)return"Pesado;+45kg a 50kg";
                if(peso>50)return"Super Pesado;acima dos 50kg";
                break;
            case "SUB-11":
                if(peso<=28)return"Superligeiro;até os 28kg";
                if(peso>28 && peso<=30)return"Ligeiro;+28kg a 30kg";
                if(peso>30 && peso<=33)return"Meio Leve;+30kg a 33kg";
                if(peso>33 && peso<=36)return"Leve;+33kg a 36kg";
                if(peso>36 && peso<=40)return"Meio Médio;+36kg a 40kg";
                if(peso>40 && peso<=45)return"Médio;+40kg a 45kg";
                if(peso>45 && peso<=50)return"Meio Pesado;+45kg a 50kg";
                if(peso>50 && peso<=55)return"Pesado;+50kg a 55kg";
                if(peso>55)return"Super Pesado;acima dos 55kg";

                break;
            case "SUB-13":
                if(peso<=28)return"Superligeiro;até os 28kg";
                if(peso>28 && peso<=31)return"Ligeiro;+28kg a 31kg";
                if(peso>31 && peso<=34)return"Meio Leve;+31kg a 34kg";
                if(peso>34 && peso<=38)return"Leve;+34kg a 38kg";
                if(peso>38 && peso<=42)return"Meio Médio;+38kg a 42kg";
                if(peso>42 && peso<=47)return"Médio;+42kg a 47kg";
                if(peso>47 && peso<=52)return"Meio Pesado;+47kg a 52kg";
                if(peso>52 && peso<=60)return"Pesado;+52kg a 60kg";
                if(peso>60)return"Super Pesado;acima dos 60kg";
                break;
            case "SUB-15":
                if(peso<=36)return"Superligeiro;até os 36kg";
                if(peso>36 && peso<=40)return"Ligeiro;+36kg a 40kg";
                if(peso>40 && peso<=44)return"Meio Leve;+40kg a 44kg";
                if(peso>44 && peso<=48)return"Leve;+44kg a 48kg";
                if(peso>48 && peso<=53)return"Meio Médio;+48kg a 53kg";
                if(peso>53 && peso<=58)return"Médio;+53kg a 58kg";
                if(peso>58 && peso<=64)return"Meio Pesado;+58kg a 64kg";
                if(peso>64 && peso<=73)return"Pesado;+64kg a 73kg";
                if(peso>73)return"Super Pesado;acima dos 73kg";
                break;
            case "SUB-18":
                if(peso<=40)return"Superligeiro;até os 40kg";
                if(peso>40 && peso<=44)return"Ligeiro;+40kg a 44kg";
                if(peso>44 && peso<=48)return"Meio Leve;+44kg a 48kg";
                if(peso>48 && peso<=52)return"Leve;+48kg a 52kg";
                if(peso>52 && peso<=57)return"Meio Médio;+52kg a 57kg";
                if(peso>57 && peso<=63)return"Médio;+57kg a 63kg";
                if(peso>63 && peso<=70)return"Meio Pesado;+63kg a 70kg";
                if(peso>70)return"Pesado;acima dos 70kg";
                break;
            default:
                if(peso<=48)return"Ligeiro;até os 48kg";
                if(peso>48 && peso<=52)return"Meio Leve;+48kg a 52kg";
                if(peso>52 && peso<=57)return"Leve;+52kg a 57kg";
                if(peso>57 && peso<=63)return"Meio Médio;+57kg a 63kg";
                if(peso>63 && peso<=70)return"Médio;+63kg a 70kg";
                if(peso>70 && peso<=78)return"Meio Pesado;+70kg a 78kg";
                if(peso>78)return"Pesado;acima dos 78kg";
                break;
        }
        return null;

    }

    private static String verificarClasseF(int idadeCorrente) {
        if (idadeCorrente<7 )return "invalido";
        if (idadeCorrente==7 || idadeCorrente==8 )return("SUB-9");
        if (idadeCorrente==9 || idadeCorrente==10 )return("SUB-11");
        if (idadeCorrente==11 || idadeCorrente==12 )return("SUB-13");
        if (idadeCorrente==13 || idadeCorrente==14 )return("SUB-15");
        if (idadeCorrente>14 && idadeCorrente<18 )return("SUB-18");
        if (idadeCorrente>=18 && idadeCorrente<30)return("ADULTO");
        if (idadeCorrente>=30 && idadeCorrente<35)return("ADULTO-F1");
        if (idadeCorrente>=35 && idadeCorrente<40)return("ADULTO-F2");
        if (idadeCorrente>=40 && idadeCorrente<45)return("ADULTO-F3");
        if (idadeCorrente>=45 )return("ADULTO-F4");
        return null;
    }}

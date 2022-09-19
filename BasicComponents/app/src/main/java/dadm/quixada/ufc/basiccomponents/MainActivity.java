package dadm.quixada.ufc.basiccomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView texto1, texto2, texto3;
    Spinner spnr, spnr2;

    RadioButton result;

    RadioGroup radioG;

    int itemRGselecionado;

    String aposta;

    MediaPlayer som;

    public String [] personagens = {
            "",
            "Goku",
            "Vegeta",
            "Trunks",
            "Gohan",
            "Goten",
            "Picollo",
            "Freeza",
            "Broly",
            "Majin Boo",
            "Kuririn",
            "Oob",
            "Zamasu",
            "Bills",
            "Whis",
            "Gogeta",
            "Vegeta",
            "Jiren"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        som = MediaPlayer.create(this, R.raw.aberturadragonballgt );
        som.start();

        texto1 = (TextView) findViewById(R.id.textView8);
        texto2 = (TextView) findViewById(R.id.textView7);
        texto3 = (TextView) findViewById(R.id.textView5);
        texto1.setTextColor(getResources().getColor(R.color.white));
        texto1.setBackgroundResource(R.color.SlateGray);
        texto2.setTextColor(getResources().getColor(R.color.white));
        texto2.setBackgroundResource(R.color.SlateGray);
        texto3.setTextColor(getResources().getColor(R.color.white));
        texto3.setBackgroundResource(R.color.SlateGray);

        spnr = (Spinner)findViewById(R.id.spinner);
        spnr.setBackgroundResource(R.color.black);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, personagens);

        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spnr.getSelectedItemPosition();
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );

        spnr2 = (Spinner)findViewById(R.id.spinner2);
        spnr2.setBackgroundResource(R.color.black);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, personagens);

        spnr2.setAdapter(adapter2);
        spnr2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spnr2.getSelectedItemPosition();
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );

    }

    public void jogar(View view){
        radioG = (RadioGroup)findViewById(R.id.radioGroup);

        itemRGselecionado = radioG.getCheckedRadioButtonId();
        result = findViewById(itemRGselecionado);
        aposta = result.getText().toString();
        Intent intent = new Intent(this, WinnerActivity.class);
        String personagemSelecionado01 = personagens[spnr.getSelectedItemPosition()];
        String personagemSelecionado02 = personagens[spnr2.getSelectedItemPosition()];

        if(personagemSelecionado02 != "" && personagemSelecionado01 != "" ) {
            intent.putExtra("lutador1", personagemSelecionado01);
            intent.putExtra("lutador2", personagemSelecionado02);
            intent.putExtra("resultado", aposta);
            //som.stop();
            startActivity(intent);
        }else{
            Snackbar mySnackbar = Snackbar.make(view, "Algum campo não foi preenchido! \nReveja os campos.", 1000);
            mySnackbar.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.orangeRed));
            View mview = mySnackbar.getView();
            TextView tv = (TextView) mview.findViewById(com.google.android.material.R.id.snackbar_text);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mySnackbar.show();

        }
    }

    public void playSom (View view){
        if(som.isPlaying()){
            som.pause();
        }
        else{
            som.start();
        }
    }
}
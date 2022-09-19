package dadm.quixada.ufc.basiccomponents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        String lutador1 = (String) getIntent().getExtras().get("lutador1");
        String lutador2 = (String) getIntent().getExtras().get("lutador2");
        String result = (String) getIntent().getExtras().get("resultado");

        TextView textLutador = findViewById(R.id.textViewWinner);


        int win = new Random().nextInt(3);

        TextView resultadoFinal = findViewById(R.id.textViewAposta);

        if(win == 0){
            textLutador.setText("Empatou");
            if(result.equals("Empate")){
                resultadoFinal.setText("Você venceu!");
            }else{
                resultadoFinal.setText("Você perdeu!");
            }
        }else if(win == 1){
            textLutador.setText(lutador1);
            if(result.equals("Lutador 1 vence")){
                resultadoFinal.setText("Você venceu!");
            }else{
                resultadoFinal.setText("Você perdeu!");
            }
        }else{
            textLutador.setText(lutador2);
            if(result.equals("Lutador 2 vence")){
                resultadoFinal.setText("Você venceu!");
            }else{
                resultadoFinal.setText("Você perdeu!");
            }
        }

    }


}
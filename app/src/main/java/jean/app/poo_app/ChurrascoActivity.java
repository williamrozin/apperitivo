package jean.app.poo_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class ChurrascoActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    Button bttelaprincipal, bttela2;
    SeekBar mSeekHomens, mSeekMulheres, mSeekCriancas;
    CheckBox cAperitivos, cBebidas;
    TextView pGh, pGm, pGc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_churrasco);
        bttela2 = (Button) findViewById(R.id.bttela2);
        bttela2.setOnClickListener(new
                                           View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   CarregarTela2();
                                               }
                                           });

        pGh = (TextView) findViewById(R.id.textView8);
        pGh.setText("0");

        mSeekHomens = (SeekBar) findViewById(R.id.seekBar1);
        mSeekHomens.setOnSeekBarChangeListener(this);
        mSeekHomens.setMax(20);

        pGm = (TextView) findViewById(R.id.textView9);
        pGm.setText("0");

        mSeekMulheres = (SeekBar) findViewById(R.id.seekBar2);
        mSeekMulheres.setOnSeekBarChangeListener(this);
        mSeekMulheres.setMax(20);

        pGc = (TextView) findViewById(R.id.textView10);
        pGc.setText("0");

        mSeekCriancas = (SeekBar) findViewById(R.id.seekBar3);
        mSeekCriancas.setOnSeekBarChangeListener(this);
        mSeekCriancas.setMax(20);

        cAperitivos = (CheckBox) findViewById(R.id.checkBox);

        cBebidas = (CheckBox) findViewById(R.id.checkBox2);

        //Inicializa o toolbar a partir do layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        //Define o título
        toolbar.setTitle("Apperitivo");
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Log.d("tag","Valor"+progress);
        if (seekBar.getId() == R.id.seekBar1){//homens
           pGh.setText(String.valueOf(progress));
        }
        if (seekBar.getId() == R.id.seekBar2){//mulheres
            pGm.setText(String.valueOf(progress));
        }
        if (seekBar.getId() == R.id.seekBar3){//criancas
            pGc.setText(String.valueOf(progress));
        }

    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    public void CarregarTela2()
    {

        Tela2Activity.startNewInstance(this, mSeekHomens.getProgress(), mSeekMulheres.getProgress(), mSeekCriancas.getProgress(), cAperitivos.isChecked(), cBebidas.isChecked());

    }
}

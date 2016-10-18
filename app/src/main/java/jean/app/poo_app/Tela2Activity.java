package jean.app.poo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2Activity extends AppCompatActivity {

    TextView cResultCarne;
    TextView cAperitivo;
    TextView cRefrigerante;

    public static void startNewInstance(AppCompatActivity appCompatActivity, int qtdHomens, int qtdMulheres, int qtdCriancas, boolean temAperitivo, boolean temBebida){
        Intent intent = new Intent(appCompatActivity,Tela2Activity.class);
        intent.putExtra("HOMENS", qtdHomens);
        intent.putExtra("MULHERES", qtdMulheres);
        intent.putExtra("CRIANCAS", qtdCriancas);
        intent.putExtra("APERITIVOS", temAperitivo);
        intent.putExtra("BEBIDAS", temBebida);

        appCompatActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2);
        //Inicializa o toolbar a partir do layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Define o título
        toolbar.setTitle("Resultados");
        //Define o Toolbar como ActionBar
        //para permitir a compatibilidade
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calcReults();

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void calcReults(){
        int qtdH = getIntent().getIntExtra("HOMENS",0);
        int qtdM = getIntent().getIntExtra("MULHERES",0);
        int qtdC = getIntent().getIntExtra("CRIANCAS",0);
        double totalCarne = 0;
        double totalAperitivo = 0;
        float cRefri = 0;
        float cCerva = 0;
        boolean tmAperit = getIntent().getBooleanExtra("APERITIVOS",false);
        boolean tmBebida = getIntent().getBooleanExtra("BEBIDAS",false);

        totalCarne = (0.7*qtdH)+(0.5*qtdM)+(0.2*qtdC);

        cAperitivo = (TextView) findViewById(R.id.textView6);
        if(tmAperit){
            totalAperitivo = totalCarne/4;
            totalCarne = (totalCarne/3)*4;
            cAperitivo.setText(String.format("%.2f", totalAperitivo) + " kg de aperitivos para " + String.valueOf(qtdH + qtdM + qtdC));
        }else{
            cAperitivo.setText("0");
        }

        cResultCarne = (TextView) findViewById(R.id.textView2);
        cResultCarne.setText(String.format("%.2f", totalCarne) + " kg de carne para " + String.valueOf(qtdH + qtdM + qtdC));

        cRefrigerante = (TextView) findViewById(R.id.textView7);
        if(tmBebida){
            cRefri = (((500)*qtdH) + ((500)*qtdM) + (qtdC*350))/1000 ;
            cCerva = 2*qtdH + qtdM;
            cRefrigerante.setText(String.format("%.2f", cRefri) + " L de Refrigerante\n" + String.format("%.2f", cCerva) + " L de Cerveja");
        }else{
            cRefrigerante.setText("0");
        }


    }
}

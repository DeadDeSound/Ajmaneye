package inspection.ded.ajman.ajmaninspection2;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ChooseLanguage extends AppCompatActivity {


    RelativeLayout btnEngLang;
    RelativeLayout btnArLang;
    ImageView imgArLang;
    ImageView imgEnLang;
    Button btnSubmitLang;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);
        btnEngLang = findViewById(R.id.btnEnLang);
        btnArLang = findViewById(R.id.btnArLang);
        imgArLang = findViewById(R.id.imgArLang);
        imgEnLang = findViewById(R.id.imgEnLang);
        btnSubmitLang = findViewById(R.id.btnSubmitLang);

        btnSubmitLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x != 0) {
                    Intent intent = new Intent(ChooseLanguage.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ChooseLanguage.this, "You Should Choose Language First", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnArLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgArLang.getVisibility() == View.INVISIBLE) {
                    btnEngLang.setBackground(ContextCompat.getDrawable(ChooseLanguage.this, R.drawable.choose_lang_unchecked));
                    imgEnLang.setVisibility(View.INVISIBLE);
                    btnArLang.setBackground(ContextCompat.getDrawable(ChooseLanguage.this, R.drawable.choose_lang_checked));
                    imgArLang.setVisibility(View.VISIBLE);
                    x = 1;
                }
            }
        });

        btnEngLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgEnLang.getVisibility() == View.INVISIBLE) {
                    btnEngLang.setBackground(ContextCompat.getDrawable(ChooseLanguage.this, R.drawable.choose_lang_checked));
                    imgEnLang.setVisibility(View.VISIBLE);
                    btnArLang.setBackground(ContextCompat.getDrawable(ChooseLanguage.this, R.drawable.choose_lang_unchecked));
                    imgArLang.setVisibility(View.INVISIBLE);
                    x = 2;
                }
            }
        });


    }
}

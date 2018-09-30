package inspection.ded.ajman.ajmaninspection2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView txtToolbar;
    ImageView toggleMaleFemaleBtn;
    EditText editTxtFullName, editTxtPhone;
    RelativeLayout signUpParentLayout;
    int count = 0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.app_bar);
        toggleMaleFemaleBtn = findViewById(R.id.toggleMaleFemaleBtn);
        signUpParentLayout = findViewById(R.id.signUpParentLayout);
        toggleMaleFemaleBtn.setTag("alive");
        editTxtFullName = findViewById(R.id.editTxtFullName);
        editTxtPhone = findViewById(R.id.editTxtPhone);

        editTxtFullName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (editTxtFullName.getText().toString().equals("")) {
                        Toast.makeText(SignUpActivity.this, "Full name Empty", Toast.LENGTH_SHORT).show();
                        editTxtFullName.setBackgroundResource(R.drawable.edittextbackgrounderror);
                        editTxtFullName.setError("please Enter Full Name");
                        editTxtFullName.setHintTextColor(getResources().getColor(R.color.colorPrimary));
                    } else {
                        editTxtFullName.setBackgroundResource(R.drawable.edittextbackground);
                        editTxtFullName.setHintTextColor(getResources().getColor(R.color.signup_edittext_hint));
                    }
                }
            }
        });


        editTxtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (count <= editTxtPhone.getText().toString().length()
                        &&(editTxtPhone.getText().toString().length()==3
                        ||editTxtPhone.getText().toString().length()==6
                        ||editTxtPhone.getText().toString().length()==9))
                {
                    editTxtPhone.setText(editTxtPhone.getText().toString()+" ");
                    int pos = editTxtPhone.getText().length();
                    editTxtPhone.setSelection(pos);
                }else if (count >= editTxtPhone.getText().toString().length()
                        &&(editTxtPhone.getText().toString().length()==3
                        ||editTxtPhone.getText().toString().length()==6
                        ||editTxtPhone.getText().toString().length()==9)){
                    editTxtPhone.setText(editTxtPhone.getText().toString().substring(0,editTxtPhone.getText().toString().length()-1));
                    int pos = editTxtPhone.getText().length();
                    editTxtPhone.setSelection(pos);
                }
                count = editTxtPhone.getText().toString().length();
            }
        });

//
//        signUpParentLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                hideKeyboard(v);
//                return true;
//            }
//        });


//        signUpParentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hideKeyboard(v);
//
//            }
//        });

        toggleMaleFemaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleMaleFemaleBtn.getTag().equals("alive")) {
                    toggleMaleFemaleBtn.setImageResource(R.drawable.checkfemale);
                    toggleMaleFemaleBtn.setTag("dead");
                    Toast.makeText(SignUpActivity.this, "Female", Toast.LENGTH_SHORT).show();
                } else {
                    toggleMaleFemaleBtn.setImageResource(R.drawable.checkmale);
                    toggleMaleFemaleBtn.setTag("alive");
                    Toast.makeText(SignUpActivity.this, "Male", Toast.LENGTH_SHORT).show();


                }
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.app_bar);


    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public void hideKeyboard(View view) {

        InputMethodManager imm = (InputMethodManager) getSystemService(
                Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

//        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}

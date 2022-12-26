package uz.hakimkhon.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import uz.hakimkhon.quiz.databinding.ActivityMainBinding;
import uz.hakimkhon.quiz.databinding.GameStartActivityBinding;

public class GameActivity extends AppCompatActivity {

    private GameStartActivityBinding gameBinding;
    private ActivityMainBinding mainBinding;
    private int[] images = Datasource.images;
    private String[][] ansvers = Datasource.ansvers;
    private String[] javob = Datasource.javob;
    public static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gameBinding = GameStartActivityBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(gameBinding.getRoot());

        gameBinding.textSavol.setOnClickListener(v ->{
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
            gameBinding.textSavol.startAnimation(animation);
        });

        id = 0;
        savolVaJavobniChaqirish(id);
        id++;
        gameBinding.btnFinish.setOnClickListener(v ->{
            gameOverOynasigaUtish();
        });

        gameBinding.btnNext.setOnClickListener(v ->{
            dastlabkiHolat();
            if (id == 10){
                gameOverOynasigaUtish();
            }
            else {
                savolVaJavobniChaqirish(id);
                ++id;
            }
            gameBinding.questionNum.setText("Savol: " + (id));
        });
    }
    private void gameOverOynasigaUtish(){
        Intent intent = new Intent(this, GameOver.class);
        startActivity(intent);
    }

    private void dastlabkiHolat(){
        gameBinding.checkAnsver1.setVisibility(View.INVISIBLE);
        gameBinding.checkAnsver2.setVisibility(View.INVISIBLE);
        gameBinding.checkAnsver3.setVisibility(View.INVISIBLE);
        gameBinding.checkAnsver4.setVisibility(View.INVISIBLE);
    }

    public void savolVaJavobniChaqirish(int id){
        gameBinding.imgRasm.setImageResource(images[id]);
        gameBinding.text1.setText(ansvers[id][0]);
        gameBinding.text2.setText(ansvers[id][1]);
        gameBinding.text3.setText(ansvers[id][2]);
        gameBinding.text4.setText(ansvers[id][3]);
    }

    @SuppressLint("NonConstantResourceId")
    public void javobniBelgilash(View view){
        switch (view.getId()){
            case R.id.ansver_1:
                gameBinding.checkAnsver1.setVisibility(View.VISIBLE);
                gameBinding.checkAnsver2.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver3.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver4.setVisibility(View.INVISIBLE);
                break;
            case R.id.ansver_2:
                gameBinding.checkAnsver2.setVisibility(View.VISIBLE);
                gameBinding.checkAnsver1.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver3.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver4.setVisibility(View.INVISIBLE);
                break;
            case R.id.ansver_3:
                gameBinding.checkAnsver3.setVisibility(View.VISIBLE);
                gameBinding.checkAnsver1.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver2.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver4.setVisibility(View.INVISIBLE);
                break;
            case R.id.ansver_4:
                gameBinding.checkAnsver4.setVisibility(View.VISIBLE);
                gameBinding.checkAnsver1.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver3.setVisibility(View.INVISIBLE);
                gameBinding.checkAnsver2.setVisibility(View.INVISIBLE);
                break;
        }
    }


}
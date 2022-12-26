package uz.hakimkhon.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import uz.hakimkhon.quiz.databinding.ActivityGameOverBinding;

public class GameOver extends AppCompatActivity {
    private ActivityGameOverBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameOverBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.textSavollarSoni.setText(String.valueOf(GameActivity.id));
        binding.textTugriJavob.setText(String.valueOf(GameActivity.id - 3));
        binding.textNotugriJavob.setText(String.valueOf(GameActivity.id - 1));

        binding.btnBoshlash.setOnClickListener(v ->{
            navigateToGameView();

        });
    }
    private void navigateToGameView(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }
}
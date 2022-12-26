package uz.hakimkhon.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import uz.hakimkhon.quiz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnBoshlash.setOnClickListener(v ->{
            navigateToGameView();

        });
    }
    private void navigateToGameView(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }
}
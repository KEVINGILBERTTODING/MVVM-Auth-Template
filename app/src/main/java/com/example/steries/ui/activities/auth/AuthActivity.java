package com.example.steries.ui.activities.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.steries.R;
import com.example.steries.ui.fragments.auth.LoginFragment;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        moveFragment(new LoginFragment());

    }

    private void moveFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameAuth, fragment)
                .commit();
    }
}
package com.example.steries.viewmodel.auth;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.steries.data.repository.AuthRepository;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SignInWithGooglViewModel  extends ViewModel {
    private AuthRepository authRepository;

    @Inject
    public SignInWithGooglViewModel(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public LiveData<FirebaseUser> getLoggedInUser() {
        return authRepository.getLoggedInUser();
    }

    public void signInWithGoogle(Activity activity, AuthCredential credential) {
        authRepository.signInWithGoogle(credential);
    }

    public void signOut() {
        authRepository.signOut();
    }
}

package com.example.steries.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

public class AuthRepository {
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private MutableLiveData<FirebaseUser> userModelMutableLiveData = new MutableLiveData<>();

    @Inject
    public AuthRepository () {

    }

    public LiveData<FirebaseUser> getLoggedInUser() {
        return userModelMutableLiveData;
    }

    public void signInWithGoogle(AuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        userModelMutableLiveData.setValue(user);
                    } else {
                        userModelMutableLiveData.setValue(null);
                    }
                });
    }

    public void signOut() {
        firebaseAuth.signOut();
        userModelMutableLiveData.setValue(null);
    }
}

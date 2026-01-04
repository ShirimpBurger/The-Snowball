package com.the.snowball.ui.authentication

import androidx.credentials.Credential
import androidx.credentials.CustomCredential
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {
    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        viewModelScope.launch {
            // accountService.signInWithEmail(_email.value, _password.value)
            //    openAndPopUp(NOTES_LIST_SCREEN, SIGN_IN_SCREEN)
        }
    }

    fun onSignInWithGoogle(credential: Credential, openAndPopUp: (String, String) -> Unit) {
        viewModelScope.launch {
            if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                //    accountService.signInWithGoogle(googleIdTokenCredential.idToken)
                //  openAndPopUp(NOTES_LIST_SCREEN, SIGN_IN_SCREEN)
            } else {
            }
        }
    }
}

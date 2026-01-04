package com.the.snowball.ui.authentication

import com.the.snowball.R
import com.the.snowball.ui.theme.Purple40

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.Credential
import com.the.snowball.ui.theme.TheSnowballTheme
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SignInScreen(
    openScreen: (String) -> Unit,
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    /*
        LaunchedEffect(Unit) {
            launchCredManBottomSheet(context) { result ->
                viewModel.onSignInWithGoogle(result, openAndPopUp)
            }
        }*/

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.penguin_sprite_frame0),
            contentDescription = "Auth image",
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 4.dp)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Text(
            text = stringResource(R.string.sign_in_description),
            fontSize = 16.sp,
            color = Purple40
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        AuthenticationButton {

        }
    }
}

@Composable
fun AuthenticationButton(onRequestResult: (Credential) -> Unit) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Button(
        onClick = { coroutineScope.launch { } },
        colors = ButtonDefaults.buttonColors(containerColor = Purple40),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google),
            modifier = Modifier.padding(horizontal = 16.dp),
            contentDescription = "Google logo"
        )

        Text(
            text = stringResource(R.string.sign_in_with_google),
            fontSize = 16.sp,
            modifier = Modifier.padding(0.dp, 6.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthPreview() {
    TheSnowballTheme() {
        SignInScreen({}, { _, _ -> })
    }
}
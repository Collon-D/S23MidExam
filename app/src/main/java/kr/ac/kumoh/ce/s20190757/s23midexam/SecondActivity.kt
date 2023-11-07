package kr.ac.kumoh.ce.s20190757.s23midexam

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.ac.kumoh.ce.s20190757.s23midexam.ui.theme.S23MidExamTheme

class SecondActivity : ComponentActivity() {
    companion object {
        const val BUTTON_PRESSED = "ButtonPressed"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23MidExamTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (intent.getIntExtra(
                        MainActivity.NEUVI_KEY,
                        MainActivity.NEUVI_NONE)) {
                        MainActivity.NEUVI_IMAGE -> NeuvilletteImage()
                        MainActivity.NEUVI_BUTTON -> NeuvilletteButton()
                        else -> finish()
                    }
                }
            }
        }
    }
}

@Composable
fun NeuvilletteImage() {
    Image(painter =
        painterResource(id = R.drawable.neuvillette),
        contentDescription = "Neuvillette Image")
}

@Composable
fun NeuvilletteButton() {
    val activity = LocalContext.current as Activity
    Button(onClick = {
        val result = Intent()
        result.getBooleanExtra(SecondActivity.BUTTON_PRESSED, true)
        activity.setResult(RESULT_OK, result)
        activity.finish()
    }) {
        Text("Neuvillette")
    }
}
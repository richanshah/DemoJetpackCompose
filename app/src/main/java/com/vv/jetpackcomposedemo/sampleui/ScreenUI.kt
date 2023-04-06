package com.vv.jetpackcomposedemo.sampleui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.demojetpackcompose.R
import com.google.accompanist.glide.rememberGlidePainter
import com.example.demojetpackcompose.ui.theme.hintColor
import com.example.demojetpackcompose.ui.theme.white


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        SampleButton(LocalContext.current)
    }


}


@Composable
fun SampleText() {
    Text(
        text = "Sample Compose",
        color = Color.Black,
        fontSize = 26.sp,
        fontFamily = FontFamily(Font(R.font.raleway_light)),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        textDecoration = TextDecoration.Underline,
        fontStyle = FontStyle.Italic,
        lineHeight = 20.sp,
        letterSpacing = 1.sp
    )
}


@Composable
fun SampleImage() {
    Image(
        painter = painterResource(id = R.drawable.compose),
        contentDescription = "compose",
        contentScale = ContentScale.Inside,
        alignment = Alignment.Center,
        alpha = 0.5f,
        colorFilter = ColorFilter.tint(Color.Red)
    )
}


@SuppressLint("CheckResult")
@Composable
fun SampleLoadImage() {
    Image(
        modifier = Modifier.size(200.dp),
        painter = rememberGlidePainter(
            request = "https://i.imgur.com/tGbaZCY.jpg",
            requestBuilder = {
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_error)
            }
        ),
        contentDescription = "dog",
        contentScale = ContentScale.FillBounds
    )
}


@Composable
fun SampleButton(context: Context) {
    Button(
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.white
        ),
        onClick = {
            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
        },
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = stringResource(id = R.string.login),
            fontSize = 18.sp
        )
    }
}


@Composable
fun SampleBox() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bg),
            contentDescription = "bg",
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Jetpack Compose", fontSize = 32.sp, fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SampleRow() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Text(text = "Sample text 1")
        Text(text = "Sample text 2")
        Text(text = "Sample text 3")

    }
}

@Composable
fun SampleColumn() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "Sample text 1")
        Text(text = "Sample text 2")
        Text(text = "Sample text 3")

    }
}



@Composable
fun ItemView(
    modifier: Modifier,
    imgId: Int,
    title: String,
    subTitle: String
) {
    Card(
        modifier = modifier,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.weight(.3f),
                painter = painterResource(id = imgId),
                contentDescription = "demoImg"
            )
            Column(
                modifier = Modifier.weight(.7f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subTitle,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}


data class UserData(
    val imgId: Int = R.drawable.compose,
    val title: String = "Sample Title",
    val subTitle: String = "This is dummy sub title text string"
)

fun dummyDataList(): List<UserData> {
    val list: ArrayList<UserData> = ArrayList()
    for (i in 1..30) {
        list.add(UserData(title = "Sample Title $i"))
    }
    return list
}

@Composable
fun SampleLazyColumn() {
    LazyColumn() {
        items(dummyDataList()) {
            ItemView(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                imgId = it.imgId,
                title = it.title,
                subTitle = it.subTitle
            )
        }
    }
}

@Composable
fun SampleLazyRow() {
    LazyRow() {
        items(dummyDataList()) {
            ItemView(
                modifier = Modifier
                    .width(300.dp)
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                imgId = it.imgId,
                title = it.title,
                subTitle = it.subTitle
            )
        }
    }
}


@Composable
fun SampleTextField() {
    val name = remember { (mutableStateOf("")) }
    TextField(
        value = name.value,
        onValueChange = {
            name.value = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.raleway_bold))
        ),
        readOnly = false,
        enabled = true,
        label = {
            Text(
                text = stringResource(id = R.string.user_name),
                color = MaterialTheme.colors.hintColor
            )
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.enter_username),
                color = MaterialTheme.colors.hintColor
            )
        },
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = "icon")
        },
        trailingIcon = {
            Icon(Icons.Default.Info, contentDescription = "icon")
        },
        singleLine = true,
        isError = false,
        visualTransformation = VisualTransformation.None,//PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Black
        )
    )
}


@SuppressLint("MissingInflatedId")
@Composable
fun DisplayView() {
    AndroidView(modifier = Modifier.fillMaxSize(),
        factory = {
            val view = LayoutInflater.from(it).inflate(R.layout.activity_main, null, false)
            val txtSample = view.findViewById<TextView>(R.id.txtSample)
            val imgSample = view.findViewById<ImageView>(R.id.imgSample)
            txtSample.text = it.getText(R.string.app_name)
            imgSample.setImageDrawable(it.getDrawable(R.drawable.compose))
            view
        })

}

/*
setContentView(R.layout.activity_main)
        val composeview = findViewById<ComposeView>(R.id.compose_view)
        composeview.setContent {
            SampleText()
        }
}*/


/*fun isUsernameValid(txt: String): Boolean {
    return txt.length >= 3
}

@Composable
fun DerivedStateTest() {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    val submitEnabled = remember {
        derivedStateOf { isUsernameValid(username) }
    }

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = username,
            placeholder = {Text(text = "Enter text", color = Color.Gray)},
            onValueChange = {
                username = it
            })
        Spacer(modifier = Modifier.height(12.dp))
        if(isUsernameValid(username)){
            Log.e("btnView", "Called")
            Button(
                onClick = {
                    Toast.makeText(context, "Btn Click", Toast.LENGTH_SHORT).show()
                }, //enabled = submitEnabled.value //isUsernameValid(username)
            ) {

                Text(text = "Click")
            }
        }

    }


}


 Text(
            text = "Jetpack Compose", fontSize = 32.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .graphicsLayer(alpha = .99f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Red,
                                    Color.Black
                                )
                            ),
                            blendMode = BlendMode.SrcAtop

                        )
                    }
                }
        )

*/
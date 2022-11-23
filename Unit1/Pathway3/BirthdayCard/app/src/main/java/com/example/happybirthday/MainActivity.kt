/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.happybirthday

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

package com.example.happybrithday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.happybrithday.ui.theme.HappyBrithdayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBrithdayTheme {
                // "배경" 색상을 사용하는 표면  컨테이너
                Surface(color = MaterialTheme.colors.background) {
                    BirthdayGreetingWithImage(getString(R.string.happy_birthday_text), "-from Emma")

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HappyBrithdayTheme {
        BirthdayGreetingWithText( " Happy Birthday Kim!", "- from Emma")
    }
}


@Composable
// 텍스트
//message : String(문자열)으로 받는다.
fun BirthdayGreetingWithText(message : String, from : String ){
    Column{
        Text(
            // happybirtgday
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
//                .padding(start = 16.dp, top = 16.dp)

        )
        // from emma
        Text(
            text =from ,
            fontSize =24.sp,
            modifier = Modifier
                .fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
            //  .padding(start = 16.dp, top = 16.dp)
        )
    }
}


// 카드 화면에 나오는지 확인
@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview(){
    HappyBrithdayTheme {
        BirthdayGreetingWithImage("Happy Birthday Kim!","- from Emma")
    }
}


// 이미지
@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    // R.id.drwawble 이전  -> R.drawable koltin compose 방식
    val image = painterResource(R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}




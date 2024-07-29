package com.example.starbucksui.data.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.starbucksui.R
import com.example.starbucksui.data.components.AppIconComponent
import com.example.starbucksui.data.components.IconComponent
import com.example.starbucksui.data.components.LogoComponent
import com.example.starbucksui.ui.theme.Background
import com.example.starbucksui.ui.theme.DarkGreen
import com.example.starbucksui.ui.theme.Gray500
import com.example.starbucksui.ui.theme.LightRed_1
import com.example.starbucksui.ui.theme.TextColor

@Composable
fun ProductDetailScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            ProductHeader{
                navHostController.navigateUp()
            }
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize( )
            ) {
                item {
                    ShowProduct()
                    ProductDescription()
                }
            }
        }
        ButtonComponent(
            modifier = Modifier
                .padding(40.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun ShowProduct(){
    var count by remember {
        mutableIntStateOf(0)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                LightRed_1,
                RoundedCornerShape(14.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter =  painterResource(id = R.drawable.image),
                contentDescription = "",
                modifier = Modifier.size(200.dp )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .background(
                        Color.White,
                        RoundedCornerShape(20.dp)
                    )
            ){
                Row {
                    AppIconComponent(
                        icon = R.drawable.minus,
                        background = DarkGreen
                    ){
                        if(count>0) count--
                    }
                    Spacer(modifier =  Modifier.width(10.dp))
                    Text(
                        text = "$count",
                        style = TextStyle(
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W500,
                            color = TextColor
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier =  Modifier.width(10.dp))
                    AppIconComponent(
                        icon = R.drawable.plus,
                        background = DarkGreen
                    ){
                        count++
                    }
                }
            }
        }
    }
}

@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        Text(
            text = stringResource(id =  R.string.coffee),
            style = TextStyle(
                fontSize = 18.sp,
                color = DarkGreen,
                fontWeight =  FontWeight.W400
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.chocolate_cappuccino ),
                fontSize = 22.sp,
                fontWeight =  FontWeight.W500,
                modifier = Modifier.weight(0.8f)
            )
            Row(
                modifier = Modifier.weight(0.2f),
            ){
                IconComponent(
                    icon = R.drawable.star,
                    size = 20.dp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically )

                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text =  stringResource(id = R.string._4_5 ),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = Gray500
                    ),
                )
            }
        }
        
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(id =  R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_etiam_at_mi_vitae_augue_feugiat_scelerisque_in_a_eros),
            style = TextStyle(
                fontSize = 18.sp,
                color = DarkGreen,
                fontWeight =  FontWeight.W400
            )
        )
    }
}

@Composable
private fun ButtonComponent(
    modifier: Modifier = Modifier
){
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkGreen,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(37.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Text(
            text = stringResource(id = R.string.add_to_bag),
            style = TextStyle(
                fontSize =  20.sp,
                fontWeight = FontWeight.W500
            ),
        )
    }
}

@Composable
private fun ProductHeader(
    onClick : ()->Unit
){
    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppIconComponent(
            icon = R.drawable.back,
            onClick = {onClick()}
        )
        LogoComponent(size = 55.dp)
        AppIconComponent(icon = R.drawable.love )
    }
}
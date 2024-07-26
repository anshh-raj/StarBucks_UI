package com.example.starbucksui.data.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.starbucksui.data.Menu
import com.example.starbucksui.data.components.AppIconComponent
import com.example.starbucksui.data.components.IconComponent
import com.example.starbucksui.data.components.LogoComponent
import com.example.starbucksui.data.menuList
import com.example.starbucksui.data.navigation.product_detail
import com.example.starbucksui.ui.theme.Background
import com.example.starbucksui.ui.theme.DarkGray_1
import com.example.starbucksui.ui.theme.DarkGreen
import com.example.starbucksui.ui.theme.Gray_1
import com.example.starbucksui.ui.theme.LightRed_1
import com.example.starbucksui.ui.theme.Red
import com.example.starbucksui.ui.theme.TextColor

@Composable
fun HomeScreen(navHostController: NavHostController) {
    var search by remember {
        mutableStateOf("")
    }

    var selectedButton by rememberSaveable {
        mutableIntStateOf(1)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .statusBarsPadding()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Header()
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item{
                    TextDescription()
                    Box(modifier = Modifier.fillMaxWidth()){
                        SearchBar(
                            text = search, 
                            onValueChange = { search=it }
                        )
                        AppIconComponent(
                            icon = R.drawable.filter,
                            background = DarkGreen,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(55.dp)
                        )
                    }
                    LazyRow(
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                    ) {
                        items(menuList.size){index->
                            CustomChipScreen(
                                menu = menuList[index],
                                selected = selectedButton == menuList[index].id,
                                onValueChange = {key->
                                    selectedButton = key
                                }
                            )
                        }
                    }
                    Popular{
                        navHostController.navigate(product_detail)
                    }
                }
            }
        }
    }
}

@Composable
private fun Header(){
    Box(
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppIconComponent(icon = R.drawable.menu)
            LogoComponent(size = 58.dp)
            AppIconComponent(icon = R.drawable.bag)
        }
    }
}

@Composable
private fun TextDescription(){
    Text(
        text = stringResource(id = R.string.our_way_of_loving_you_back),
        style = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black
        ),
        modifier = Modifier.padding(vertical = 30.dp)
    )
}

@Composable
private fun SearchBar(
    text: String,
    onValueChange: (String)->Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search),
                style = TextStyle(
                    color = DarkGray_1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                )
            )
        },
        leadingIcon = {
            IconComponent(icon = R.drawable.search)
        },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape( 26.5.dp),
        singleLine = true,
//        keyboardActions = KeyboardOptions(imeAction = ImeAction.Done),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = DarkGreen
        )
    )
}

@Composable
private fun CustomChipScreen(
    menu: Menu,
    modifier: Modifier = Modifier,
    selected: Boolean,
    onValueChange: (Int) -> Unit
){

    TextButton(
        onClick = { onValueChange(menu.id) },
        shape = RoundedCornerShape(22.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if(selected) DarkGreen else Gray_1,
            contentColor = if(selected) Color.White else TextColor
        ),
        contentPadding = PaddingValues(15.dp),
        modifier = modifier.padding(end=10.dp),
    ) {
        Text(
            text = menu.title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W400
            ),
        )
    }

}

@Composable
private fun Popular(
    onClick: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.popular),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = TextColor
                )
            )
            Text(
                text = stringResource(id = R.string.see_all),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = TextColor
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyRow {
            items(5){
                ItemEachRow {
                    onClick()
                }
            }
        }
    }
}

@Composable
fun ItemEachRow(
    onClick:()->Unit
){
    var like by rememberSaveable {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        LightRed_1,
                        RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
                    ),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier.size(180.dp)
                )
            }
            Column(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.chocolate_cappuccino),
                    style = TextStyle(
                        color = TextColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string._20_00),
                        style = TextStyle(
                            color = DarkGreen,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                    IconButton(
                        onClick = { like = !like },
                        modifier = Modifier
                            .size(24.dp)
                    ) {
                        IconComponent(
                            icon = R.drawable.love,
                            tint = if(like) Red else Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}
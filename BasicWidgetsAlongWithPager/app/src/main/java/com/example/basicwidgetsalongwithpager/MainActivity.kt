package com.example.basicwidgetsalongwithpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.basicwidgetsalongwithpager.ui.theme.BasicWidgetsAlongWithPagerTheme
import com.example.composepractice.PresentButtonsList
import com.example.composepractice.PresentCheckboxSwitchList
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicWidgetsAlongWithPagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val pagerState = rememberPagerState(
                        initialPage = 0,
                        initialPageOffsetFraction = 0f
                    ) {
                        // provide pageCount
                        4
                    }

                    val scope = rememberCoroutineScope()

                    Box(modifier = Modifier.fillMaxSize()) {
                        HorizontalPager(state = pagerState, beyondBoundsPageCount = 1) {
                            when (it) {
                                0 -> {
                                    PresentButtonsList()
                                }

                                1 -> {
                                    PresentCheckboxSwitchList()
                                }

                                2 -> {
                                    MyTextViewWithCustomFont()
                                }

                                3 -> {
                                    AnnotatedTextViewWithCustomFont()
                                }
                            }
                        }
                        Box(
                            modifier = Modifier
                                .offset(y = (-16).dp)
                                .fillMaxWidth(0.5f)
                                .clip(RoundedCornerShape(100))
                                .background(MaterialTheme.colorScheme.onPrimary)
                                .padding(8.dp)
                                .align(Alignment.BottomCenter)
                        ) {
                            IconButton(onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }

                            }, modifier = Modifier.align(Alignment.CenterStart)) {
                                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
                            }

                            IconButton(onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            }, modifier = Modifier.align(Alignment.CenterEnd)) {
                                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
                            }
                        }

                    }
                }
            }
        }
    }
}

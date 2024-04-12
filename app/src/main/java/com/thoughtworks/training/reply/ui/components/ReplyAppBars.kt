package com.thoughtworks.training.reply.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.thoughtworks.training.reply.data.Email

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyDockedSearchBar(
    emails: List<Email>,
    onSearchItemSelected: (Email) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val searchResults = remember { mutableStateListOf<Email>() }

    LaunchedEffect(query) {
        // TODO

    }

    // TODO
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailDetailAppBar(
    email: Email,
    isFullScreen: Boolean,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {
    // TODO
}

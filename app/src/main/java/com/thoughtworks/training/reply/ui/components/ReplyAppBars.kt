package com.thoughtworks.training.reply.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thoughtworks.training.reply.R
import com.thoughtworks.training.reply.data.Email

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyDockedSearchBar(
    emails: List<Email>,
    onSearchItemSelected: (Email) -> Unit,
    modifier: Modifier = Modifier,
) {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val searchResults = remember { mutableStateListOf<Email>() }

    LaunchedEffect(query) {
        searchResults.clear()
        if (query.isNotEmpty()) {
            val result =
                emails.filter { it.sender.fullName.contains(query) || it.subject.contains(query) }
            searchResults.addAll(result)
        }
    }
    DockedSearchBar(
        modifier = modifier,
        query = query,
        onQueryChange = { query = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it },
        placeholder = { Text("Search emails") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.padding(start = 10.dp),
            )
        },
        trailingIcon = {
            ReplyProfileImage(drawableResource = R.drawable.avatar_6, description = "my avatar")
        }
    ) {
        if (searchResults.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                items(searchResults) {
                    Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ReplyProfileImage(
                            drawableResource = it.sender.avatar,
                            description = "sender avatar"
                        )
                        Column (modifier = Modifier.fillMaxWidth().padding(start = 10.dp)){
                            Text(text = it.subject)
                            Text(text = it.sender.fullName)
                        }
                    }

                }
            }
        } else {
            if (query.isNotEmpty()) Text(text = "Not Found")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailDetailAppBar(
    email: Email,
    isFullScreen: Boolean,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
) {
    // TODO
}

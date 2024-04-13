package com.thoughtworks.training.reply.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.layout.DisplayFeature
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.ui.components.ReplyDockedSearchBar
import com.thoughtworks.training.reply.ui.components.ReplyEmailListItem
import com.thoughtworks.training.reply.ui.utils.ReplyContentType
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyInboxScreen(
    contentType: ReplyContentType,
    replyHomeUIState: ReplyHomeUIState,
    navigationType: ReplyNavigationType,
    displayFeatures: List<DisplayFeature>,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, ReplyContentType) -> Unit,
    toggleSelectedEmail: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val emailLazyListState = rememberLazyListState()
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        ReplySinglePaneContent(
            replyHomeUIState = replyHomeUIState,
            toggleEmailSelection = toggleSelectedEmail,
            emailLazyListState = emailLazyListState,
            closeDetailScreen = closeDetailScreen,
            navigateToDetail = navigateToDetail
        )

    }
}

@Composable
fun ReplySinglePaneContent(
    replyHomeUIState: ReplyHomeUIState,
    toggleEmailSelection: (Long) -> Unit,
    emailLazyListState: LazyListState,
    modifier: Modifier = Modifier,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, ReplyContentType) -> Unit,
) {
    ReplyEmailList(
        emails = replyHomeUIState.emails,
        openedEmail = replyHomeUIState.openedEmail,
        selectedEmailIds = replyHomeUIState.selectedEmails,
        toggleEmailSelection = toggleEmailSelection,
        emailLazyListState = emailLazyListState,
        navigateToDetail = navigateToDetail,
        modifier = modifier
    )
}

@Composable
fun ReplyEmailList(
    emails: List<Email>,
    openedEmail: Email?,
    selectedEmailIds: Set<Long>,
    toggleEmailSelection: (Long) -> Unit,
    emailLazyListState: LazyListState,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long, ReplyContentType) -> Unit,
) {
    Box(modifier = modifier.windowInsetsPadding(WindowInsets.statusBars)) {
        ReplyDockedSearchBar(
            emails,
            onSearchItemSelected = { email ->
                navigateToDetail(
                    email.id,
                    ReplyContentType.SINGLE_PANE
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        )

        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 80.dp), state = emailLazyListState
        ) {
            items(items = emails, key = { it.id }) {
                ReplyEmailListItem(
                    email = it,
                    navigateToDetail = { id -> navigateToDetail(id, ReplyContentType.SINGLE_PANE) },
                    toggleSelection = toggleEmailSelection
                )
            }
        }
    }
}

@Composable
fun ReplyEmailDetail(
    email: Email,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = true,
    onBackPressed: () -> Unit = {},
) {
    // TODO
}

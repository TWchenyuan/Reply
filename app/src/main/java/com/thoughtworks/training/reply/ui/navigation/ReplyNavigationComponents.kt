package com.thoughtworks.training.reply.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationContentPosition

@Composable
fun ReplyNavigationRail(
    selectedDestination: String,
    navigationContentPosition: ReplyNavigationContentPosition,
    navigateToTopLevelDestination: (ReplyTopLevelDestination) -> Unit,
    onDrawerClicked: () -> Unit = {},
) {
    // TODO
}

@Composable
fun PermanentNavigationDrawerContent(
    selectedDestination: String,
    navigationContentPosition: ReplyNavigationContentPosition,
    navigateToTopLevelDestination: (ReplyTopLevelDestination) -> Unit,
) {
    // TODO
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigationDrawerContent(
    selectedDestination: String,
    navigationContentPosition: ReplyNavigationContentPosition,
    navigateToTopLevelDestination: (ReplyTopLevelDestination) -> Unit,
    onDrawerClicked: () -> Unit = {}
) {
    // TODO
}

enum class LayoutType {
    HEADER, CONTENT
}

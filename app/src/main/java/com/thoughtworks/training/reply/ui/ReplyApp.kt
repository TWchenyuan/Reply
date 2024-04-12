package com.thoughtworks.training.reply.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.window.layout.DisplayFeature
import com.thoughtworks.training.reply.ui.navigation.ReplyRoute
import com.thoughtworks.training.reply.ui.navigation.ReplyTopLevelDestination
import com.thoughtworks.training.reply.ui.utils.ReplyContentType
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationContentPosition
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationType

@Composable
fun ReplyApp(
    windowSize: WindowSizeClass,
    displayFeatures: List<DisplayFeature>,
    replyHomeUIState: ReplyHomeUIState,
    closeDetailScreen: () -> Unit = {},
    navigateToDetail: (Long, ReplyContentType) -> Unit = { _, _ -> },
    toggleSelectedEmail: (Long) -> Unit = { }
) {
    // TODO
}

@Composable
private fun ReplyNavigationWrapper(
    navigationType: ReplyNavigationType,
    contentType: ReplyContentType,
    displayFeatures: List<DisplayFeature>,
    navigationContentPosition: ReplyNavigationContentPosition,
    replyHomeUIState: ReplyHomeUIState,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, ReplyContentType) -> Unit,
    toggleSelectedEmail: (Long) -> Unit
) {
     // TODO
}

@Composable
fun ReplyAppContent(
    modifier: Modifier = Modifier,
    navigationType: ReplyNavigationType,
    contentType: ReplyContentType,
    displayFeatures: List<DisplayFeature>,
    navigationContentPosition: ReplyNavigationContentPosition,
    replyHomeUIState: ReplyHomeUIState,
    navController: NavHostController,
    selectedDestination: String,
    navigateToTopLevelDestination: (ReplyTopLevelDestination) -> Unit,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, ReplyContentType) -> Unit,
    toggleSelectedEmail: (Long) -> Unit,
    onDrawerClicked: () -> Unit = {}
) {
     // TODO
}

@Composable
private fun ReplyNavHost(
    navController: NavHostController,
    contentType: ReplyContentType,
    displayFeatures: List<DisplayFeature>,
    replyHomeUIState: ReplyHomeUIState,
    navigationType: ReplyNavigationType,
    closeDetailScreen: () -> Unit,
    navigateToDetail: (Long, ReplyContentType) -> Unit,
    toggleSelectedEmail: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ReplyRoute.INBOX,
    ) {
        composable(ReplyRoute.INBOX) {
            ReplyInboxScreen(
                contentType = contentType,
                replyHomeUIState = replyHomeUIState,
                navigationType = navigationType,
                displayFeatures = displayFeatures,
                closeDetailScreen = closeDetailScreen,
                navigateToDetail = navigateToDetail,
                toggleSelectedEmail = toggleSelectedEmail
            )
        }
        composable(ReplyRoute.DM) {
            EmptyComingSoon()
        }
        composable(ReplyRoute.ARTICLES) {
            EmptyComingSoon()
        }
        composable(ReplyRoute.GROUPS) {
            EmptyComingSoon()
        }
    }
}

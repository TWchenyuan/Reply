package com.thoughtworks.training.reply.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.DisplayFeature
import com.thoughtworks.training.reply.ui.navigation.ReplyBottomNavigationBar
import com.thoughtworks.training.reply.ui.navigation.ReplyNavigationActions
import com.thoughtworks.training.reply.ui.navigation.ReplyRoute
import com.thoughtworks.training.reply.ui.navigation.ReplyTopLevelDestination
import com.thoughtworks.training.reply.ui.utils.ReplyContentType
import com.thoughtworks.training.reply.ui.utils.ReplyContentType.SINGLE_PANE
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationContentPosition
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationType
import com.thoughtworks.training.reply.ui.utils.ReplyNavigationType.BOTTOM_NAVIGATION

@Composable
fun ReplyApp(
    windowSize: WindowSizeClass,
    displayFeatures: List<DisplayFeature>,
    replyHomeUIState: ReplyHomeUIState,
    closeDetailScreen: () -> Unit = {},
    navigateToDetail: (Long, ReplyContentType) -> Unit = { _, _ -> },
    toggleSelectedEmail: (Long) -> Unit = { },
) {
    ReplyNavigationWrapper(
        navigationType = BOTTOM_NAVIGATION,
        contentType = SINGLE_PANE,
        displayFeatures = displayFeatures,
        navigationContentPosition = ReplyNavigationContentPosition.TOP,
        replyHomeUIState = replyHomeUIState,
        closeDetailScreen = closeDetailScreen,
        navigateToDetail = navigateToDetail,
        toggleSelectedEmail = toggleSelectedEmail
    )
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
    toggleSelectedEmail: (Long) -> Unit,
) {
    val navController = rememberNavController()
    val navigationActions = remember(navController) { ReplyNavigationActions(navController) }
    val selectedDestination = ReplyRoute.INBOX
    ReplyAppContent(
        navigationType = navigationType,
        contentType = contentType,
        displayFeatures = displayFeatures,
        navigationContentPosition = navigationContentPosition,
        replyHomeUIState = replyHomeUIState,
        navController = navController,
        selectedDestination = selectedDestination,
        navigateToTopLevelDestination = navigationActions::navigateTo,
        closeDetailScreen = closeDetailScreen,
        navigateToDetail = navigateToDetail,
        toggleSelectedEmail = toggleSelectedEmail
    )
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
    onDrawerClicked: () -> Unit = {},
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
    ) {
        ReplyNavHost(
            navController = navController,
            contentType = contentType,
            displayFeatures = displayFeatures,
            replyHomeUIState = replyHomeUIState,
            navigationType = navigationType,
            closeDetailScreen = { /*TODO*/ },
            navigateToDetail = navigateToDetail,
            toggleSelectedEmail = toggleSelectedEmail,
            modifier = Modifier.weight(1f)
        )
        ReplyBottomNavigationBar(navigateToTopLevelDestination, selectedDestination)
    }
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

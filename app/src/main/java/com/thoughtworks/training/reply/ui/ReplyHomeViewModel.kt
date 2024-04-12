package com.thoughtworks.training.reply.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.data.EmailsRepository
import com.thoughtworks.training.reply.data.EmailsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ReplyHomeViewModel(private val emailsRepository: EmailsRepository = EmailsRepositoryImpl()) :
    ViewModel() {

        private val _replyHomeUIState: MutableStateFlow<ReplyHomeUIState> = MutableStateFlow(
            ReplyHomeUIState()
        )
        val replyHomeUIState: StateFlow<ReplyHomeUIState> =_replyHomeUIState.asStateFlow()
}

data class ReplyHomeUIState(
    val emails: List<Email> = emptyList(),
    val selectedEmails: Set<Long> = emptySet(),
    val openedEmail: Email? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null,
)

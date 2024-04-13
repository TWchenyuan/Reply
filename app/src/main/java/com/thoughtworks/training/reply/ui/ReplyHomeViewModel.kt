package com.thoughtworks.training.reply.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.data.EmailsRepository
import com.thoughtworks.training.reply.data.EmailsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ReplyHomeViewModel(private val emailsRepository: EmailsRepository = EmailsRepositoryImpl()) :
    ViewModel() {
    private val _replyHomeUIState: MutableStateFlow<ReplyHomeUIState> = MutableStateFlow(
        ReplyHomeUIState()
    )
    val replyHomeUIState: StateFlow<ReplyHomeUIState> = _replyHomeUIState.asStateFlow()


    init {
        loadEmails()
    }

    private fun loadEmails() {
        viewModelScope.launch {
            try {
                val emails = emailsRepository.getAllEmails().first()
                _replyHomeUIState.value = ReplyHomeUIState(
                    emails = emails,
                    openedEmail = emails.first(),
                    )
            } catch (e: Exception) {
                _replyHomeUIState.value = ReplyHomeUIState(error = e.toString())
            }
        }
    }
}

data class ReplyHomeUIState(
    val emails: List<Email> = emptyList(),
    val selectedEmails: Set<Long> = emptySet(),
    val openedEmail: Email? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null,
)

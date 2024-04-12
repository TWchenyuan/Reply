package com.thoughtworks.training.reply.ui

import androidx.lifecycle.ViewModel
import com.thoughtworks.training.reply.data.Email
import com.thoughtworks.training.reply.data.EmailsRepository
import com.thoughtworks.training.reply.data.EmailsRepositoryImpl

class ReplyHomeViewModel(private val emailsRepository: EmailsRepository = EmailsRepositoryImpl()) :
    ViewModel() {


}

data class ReplyHomeUIState(
    val emails: List<Email> = emptyList(),
    val selectedEmails: Set<Long> = emptySet(),
    val openedEmail: Email? = null,
    val isDetailOnlyOpen: Boolean = false,
    val loading: Boolean = false,
    val error: String? = null
)

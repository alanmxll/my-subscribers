package com.alanmxll.mysubscribes.ui.subscriberlist

import androidx.lifecycle.ViewModel
import com.alanmxll.mysubscribes.repository.SubscriberRepository

class SubscriberListViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {

    val allSubscribersEvent = repository.getAllSubscribers()

}
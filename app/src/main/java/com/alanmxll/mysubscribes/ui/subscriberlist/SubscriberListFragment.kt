package com.alanmxll.mysubscribes.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.alanmxll.mysubscribes.R
import com.alanmxll.mysubscribes.data.db.AppDatabase
import com.alanmxll.mysubscribes.data.db.dao.SubscriberDAO
import com.alanmxll.mysubscribes.extension.navigateWithAnimations
import com.alanmxll.mysubscribes.repository.DatabaseDataSource
import com.alanmxll.mysubscribes.repository.SubscriberRepository
import kotlinx.android.synthetic.main.subscriber_list_fragment.*


class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {
    private val viewModel: SubscriberListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val subscriberDAO: SubscriberDAO =
                    AppDatabase.getInstance(requireContext()).subscriberDAO

                val repository: SubscriberRepository = DatabaseDataSource(subscriberDAO)

                return SubscriberListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModelEvents()
        configureViewListeners()
    }

    private fun observeViewModelEvents() {
        viewModel.allSubscribersEvent.observe(viewLifecycleOwner) { allSubscribers ->
            val subscriberListAdapter = SubscriberListAdapter(allSubscribers)

            with(recycler_subscribers) {
                setHasFixedSize(true)
                adapter = subscriberListAdapter
            }
        }
    }

    private fun configureViewListeners() {
        fabAddSubscriber.setOnClickListener {
            findNavController().navigateWithAnimations(R.id.subscriberFragment)
        }
    }

}
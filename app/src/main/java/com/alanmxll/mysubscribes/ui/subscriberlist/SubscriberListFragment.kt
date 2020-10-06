package com.alanmxll.mysubscribes.ui.subscriberlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alanmxll.mysubscribes.R
import com.alanmxll.mysubscribes.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_list_fragment.*


class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {
    private lateinit var viewModel: SubscriberListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val subscriberListAdapter = SubscriberListAdapter(
            listOf(
                SubscriberEntity(1, "Alan", "alanmaxwell@user.com"),
                SubscriberEntity(2, "Laise", "laisemaia@user.com")
            )
        )

        recycler_subscribers.run {
            setHasFixedSize(true)
            adapter = subscriberListAdapter
        }
    }

}
package com.darienalvarez.codechallenge.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> :
    Fragment() {

    abstract val contentLayoutId: Int
    abstract val viewModel: V

    lateinit var binding: T

    private val screenName = this::class.java.canonicalName.orEmpty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("event: onCreate: $screenName")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("event: onCreateView: $screenName")

        binding = DataBindingUtil.inflate(inflater, contentLayoutId, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Timber.d("event: onStart: $screenName")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("event: onResume: $screenName")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("event: onPause: $screenName")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("event: onStop: $screenName")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("event: onDestroyView: $screenName")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("event: onViewCreated: $screenName")

        setupView(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    onStateChange(it)
                }
            }
        }
    }

    abstract fun setupView(view: View, savedInstanceState: Bundle?)

    abstract fun onStateChange(state: BaseState)

    protected fun setTitle(title: String) {
        (activity as? BaseActivity)?.supportActionBar?.title = title
    }
}
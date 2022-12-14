package com.onix.internship.arch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import com.google.android.material.snackbar.Snackbar
import com.onix.internship.arch.ext.hideKeyboard
import com.onix.internship.arch.ext.navigation

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes private val resId: Int) : Fragment() {

    protected lateinit var binding: T
        private set

    protected abstract val viewModel: BaseViewModel

    protected open fun setObservers() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setObservers()
        onBaseObservers()
    }

    private fun onBaseObservers() {
        viewModel.loading.observe(viewLifecycleOwner) { hideKeyboard() }
        viewModel.massageEvent.observe(viewLifecycleOwner) { showSnack(it) }
        viewModel.navigate.observe(viewLifecycleOwner, ::navigate)
    }

    protected fun showSnack(msg: String) {
        Snackbar.make(this.requireView(), msg, Snackbar.LENGTH_SHORT).show()
    }

    protected fun navigate(direction: NavDirections) {
        navigation(direction)
    }

}
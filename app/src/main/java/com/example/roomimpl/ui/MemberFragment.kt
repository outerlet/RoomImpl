package com.example.roomimpl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.roomimpl.R
import com.example.roomimpl.viewmodel.MemberViewModel
import com.example.roomimpl.viewmodel.MemberViewModelFactory
import kotlinx.android.synthetic.main.fragment_member.*

class MemberFragment : Fragment() {
    private val mViewModel by viewModels<MemberViewModel> { MemberViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_member, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        buttonPrefecture.setOnClickListener {
            PopupMenu(requireContext(), buttonPrefecture).also { popup ->
                mViewModel.prefectures.value?.forEach {
                    popup.menu.add(0, it.id, Menu.NONE, it.name)
                }

                popup.setOnMenuItemClickListener { item ->
                    buttonPrefecture.text = mViewModel.prefectures.value!!.find { it.id == item.itemId }!!.name
                    true
                }
            }.show()
        }

        mViewModel.getPrefectures(requireContext())
    }
}
package com.example.roomimpl.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomimpl.R
import com.example.roomimpl.db.Prefecture
import com.example.roomimpl.viewmodel.PrefectureViewModelFactory
import com.example.roomimpl.viewmodel.PrefectureViewModel
import kotlinx.android.synthetic.main.fragment_prefecture.*

class PrefectureFragment : Fragment() {
    private val mViewModel by viewModels<PrefectureViewModel> { PrefectureViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_prefecture, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }

        mViewModel.prefectures.observe(viewLifecycleOwner) {
            if (it != null) {
                recyclerView.adapter = PrefAdapter(it)
            }
        }

        button.setOnClickListener {
            mViewModel.addPrefecture(
                requireContext(),
                Prefecture(editPrefName.text.toString(), editPrefNameKana.text.toString())
            )

            editPrefName.text.clear()
            editPrefNameKana.text.clear()
        }

        mViewModel.getPrefectures(requireContext())
    }

    private class PrefViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.textName)
        val nameKana: TextView = itemView.findViewById(R.id.textNameKana)
        val buttonDelete: ImageButton = itemView.findViewById(R.id.buttonDelete)
    }

    private inner class PrefAdapter(private val prefList: List<Prefecture>) : RecyclerView.Adapter<PrefViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrefViewHolder =
            PrefViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item_prefecture, parent, false)
            )

        override fun onBindViewHolder(holder: PrefViewHolder, position: Int) {
            prefList[position].let { pref ->
                holder.name.text = pref.name
                holder.nameKana.text = pref.nameKana
                holder.buttonDelete.setOnClickListener {
                    mViewModel.removePrefecture(requireContext(), pref)
                }
            }
        }

        override fun getItemCount(): Int = prefList.size
    }
}
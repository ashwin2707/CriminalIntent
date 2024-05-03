package com.ashwin.criminalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ashwin.criminalintent.databinding.FragmentCrimeListBinding


private const val TAG = "CrimeListFragment"
class CrimeListFragment: Fragment() {
    private val crimeListViewModel: CrimeListViewModel by viewModels()
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visiable?"
        }
    private var _binding: FragmentCrimeListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total Crimes: ${crimeListViewModel.crimes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCrimeListBinding.inflate(layoutInflater, container, false)
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        val crimes = crimeListViewModel.crimes
        val adapter = CrimeListAdapter(crimes)
        binding.crimeRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
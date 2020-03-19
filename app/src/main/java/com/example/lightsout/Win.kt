package com.example.lightsout

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lightsout.databinding.FragmentGame2Binding
import com.example.lightsout.databinding.FragmentWinBinding
import kotlinx.android.synthetic.main.fragment_game2.*
import kotlinx.android.synthetic.main.fragment_win.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Win.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Win.newInstance] factory method to
 * create an instance of this fragment.
 */
class Win : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val myActivity = activity as MainActivity?
        val binding = DataBindingUtil.inflate<FragmentWinBinding>(inflater, R.layout.fragment_win, container, false)
        binding.p.text = myActivity?.playerName.toString()
        binding.t.text = myActivity?.tap.toString() + " steps!"
        binding.restart.setOnClickListener { view:View -> view.findNavController().navigate(R.id.action_win_to_titleScreen) }
        return binding.root
    }


}

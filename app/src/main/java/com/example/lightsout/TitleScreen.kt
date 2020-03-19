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
import com.example.lightsout.databinding.FragmentTitleScreenBinding
import kotlinx.android.synthetic.main.fragment_game2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TitleScreen.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TitleScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleScreen : Fragment() {
    var player: UserInfo = UserInfo("", "0")
    private lateinit var binding: FragmentTitleScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding: FragmentTitleScreenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title_screen, container, false)
        binding.player = player
        binding.start.setOnClickListener {
                view: View -> view.findNavController().navigate(R.id.action_titleScreen_to_game)
                val myActivity = activity as MainActivity?
                myActivity?.playerName = nickname.text.toString()
                binding.player?.name = nickname.text.toString()

        }

        return binding.root


    }

}

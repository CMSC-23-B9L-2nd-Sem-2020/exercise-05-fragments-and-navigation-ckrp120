package com.example.lightsout

import android.content.Context
import android.media.Image
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.lightsout.databinding.FragmentGame2Binding
import kotlinx.android.synthetic.main.fragment_game2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [Game.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [Game.newInstance] factory method to
 * create an instance of this fragment.
 */
class Game : Fragment(){
    // TODO: Rename and change types of parameters



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = DataBindingUtil.inflate<FragmentGame2Binding>(inflater, R.layout.fragment_game2, container, false)



        var tapCount: Int = 0 //counter for how many lights a player has tapped
        var gameGrid = listOf( //array representation of the lights
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1),
            arrayOf(1, 1, 1, 1, 1)
        )
      fun updateNickname(){
           binding.apply {
               val myActivity = activity as MainActivity?

               nickname.visibility = View.GONE
               nicknameShow.text = myActivity?.playerName.toString()
               nicknameShow.visibility = View.VISIBLE
           }


        }





        fun getID(row: Int, column: Int): ImageView{
            val gridID = listOf(
                listOf(binding.light1, binding.light2, binding.light3, binding.light4, binding.light5),
                listOf(binding.light6, binding.light7, binding.light8, binding.light9, binding.light10),
                listOf(binding.light11, binding.light12, binding.light13, binding.light14, binding.light15),
                listOf(binding.light16, binding.light17, binding.light18, binding.light19, binding.light20),
                listOf(binding.light21, binding.light22, binding.light23, binding.light24, binding.light25)
            )

            return  gridID[row][column]
        }
        fun countUp(view: View) { //adds +1 to the counter whenever the player taps a light and updates the textView
            val myActivity = activity as MainActivity?
            tapCount++
            myActivity?.tap = tapCount
            if(tapShowCount !== null){
                tapShowCount.text = tapCount.toString()
            }
        }

        fun flipLights(view: View, row: Int, col: Int) { //main function for toggling lights on/off
            //toggles retry button visibility at the start

            //flip light itself
            val mainLight: ImageView = getID(row, col)
            if(gameGrid[row][col] == 0){
                mainLight.setImageResource(R.drawable.on)
                gameGrid[row][col] = 1
            }else{
                mainLight.setImageResource(R.drawable.off)
                gameGrid[row][col] = 0
            }

            //flip light on top
            if(row - 1 >= 0){ //check if top button exists
                val topLight: ImageView = getID(row-1, col)
                if(gameGrid[row-1][col] == 0){
                    topLight.setImageResource(R.drawable.on)
                    gameGrid[row-1][col] = 1
                }else{
                    topLight.setImageResource(R.drawable.off)
                    gameGrid[row-1][col] = 0
                }
            }

            //flip light below
            if(row+1 < 5){

                val bottomLight: ImageView = getID(row+1, col)
                if(gameGrid[row+1][col] == 0){
                    bottomLight.setImageResource(R.drawable.on)
                    gameGrid[row+1][col] = 1
                }else{
                    bottomLight.setImageResource(R.drawable.off)
                    gameGrid[row+1][col] = 0
                }

            }

            //flip light on the left
            if(col-1 >= 0){
                val leftLight: ImageView = getID(row, col-1)
                if(gameGrid[row][col-1] == 0){
                    leftLight.setImageResource(R.drawable.on)
                    gameGrid[row][col-1] = 1
                }else{
                    leftLight.setImageResource(R.drawable.off)
                    gameGrid[row][col-1] = 0
                }
            }

            //flip light on the right
            if(col+1 < 5){
                val leftLight: ImageView = getID(row, col+1)
                if(gameGrid[row][col+1] == 0){
                    leftLight.setImageResource(R.drawable.on)
                    gameGrid[row][col+1] = 1
                }else{
                    leftLight.setImageResource(R.drawable.off)
                    gameGrid[row][col+1] = 0
                }
            }

            countUp(view)
            var playerWin: Boolean = true
            //check if the player has won the game
            for(i: Int in (0..4)){
                for(j: Int in (0..4)){
                    if(gameGrid[i][j] == 1){
                        playerWin = false
                        break
                    }
                }
            }

            //shows a toast when the player has successfully turned off all the lights
            if(playerWin){

            }
        }

        fun setListeners(){ //checks which button is pressed and then sets a listener to handle flipLights
            for(row: Int in (0..4)){
                for(col: Int in (0..4)){
                    getID(row, col).setOnClickListener{
                        flipLights(it, row, col)
                    }
                }
            }
        }

        fun retry(){ //resets the game
            tapCount = 0
            if(tapShowCount !== null){
                tapShowCount.text = tapCount.toString()
            }

            for(i: Int in (0..4)){
                for(j: Int in (0..4)){
                    val light: ImageView = getID(i,j)
                    light.setImageResource(R.drawable.on)

                    gameGrid[i][j] = 1
                }
            }
        }

        binding.retry.setOnClickListener { retry() }
        updateNickname()
        setListeners()


      return binding.root
}





}

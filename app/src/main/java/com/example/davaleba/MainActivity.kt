package com.example.davaleba

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var button1:Button
    lateinit var button2:Button
    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var button5:Button
    lateinit var button6:Button
    lateinit var button7:Button
    lateinit var button8:Button
    lateinit var button9:Button
    lateinit var reset:Button
    var activeplayer=1
    //couner cvladi gansazgvavs imas rom, rodesac erti motamashe gaimarjvebs da tamashi morcheba, vegar daechiros arcert buttons
    private var counter=0

    //score 1 da score 2 cvladebia romelic stringshi shedis ${} it, textViewbshi
    var score1=0
    var score2=0
// scorebis textViews
    lateinit var firstscore:TextView
    lateinit var secScore:TextView


    var firstplayerchanse=ArrayList<Int>()
    var secondplayerchanse=ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset=findViewById(R.id.reset)

        firstscore= findViewById(R.id.Xscore)
        secScore=findViewById(R.id.Oscore)

        firstscore.text="X player score : ${score1}"
        secScore.text="Y player score : ${score2}"

            game()

        reset.setOnClickListener{
            // aq yvela buttonis moqmedeba true xdeba radgan gamoiricxos false shemdegi tamashistvis
            button1.isEnabled=true
            button2.isEnabled=true
            button3.isEnabled=true
            button4.isEnabled=true
            button5.isEnabled=true
            button6.isEnabled=true
            button7.isEnabled=true
            button8.isEnabled=true
            button9.isEnabled=true
            // aq vasuftaveb listebs radgan shecdomit mogebulad ar chautvalos shemdeg tamasshi mtamashes
            firstplayerchanse= ArrayList<Int>()
            secondplayerchanse=ArrayList<Int>()
          //iwmindeba yvela buttonis texti shemdegi tamashistvis
            button1.text=""
            button2.text=""
            button3.text=""
            button4.text=""
            button5.text=""
            button6.text=""
            button7.text=""
            button8.text=""
            button9.text=""

            //couner cvladi gansazgvavs imas rom, rodesac erti motamashe gaimarjvebs agar daechiros arcert buttons
            counter=0
            //activeplayer xdeba 1 radgan shemdegi tamashi X it daiwyos
            activeplayer=1

            //ubrundeba ferebi tavdapirvel fers
            button1.setBackgroundColor(Color.BLACK)
            button2.setBackgroundColor(Color.BLACK)
            button3.setBackgroundColor(Color.BLACK)
            button4.setBackgroundColor(Color.BLACK)
            button5.setBackgroundColor(Color.BLACK)
            button6.setBackgroundColor(Color.BLACK)
            button7.setBackgroundColor(Color.BLACK)
            button8.setBackgroundColor(Color.BLACK)
            button9.setBackgroundColor(Color.BLACK)


        }
    }
   fun game(){
       button1=findViewById(R.id.b1)
       button2=findViewById(R.id.b2)

       button3=findViewById(R.id.b3)
       button4=findViewById(R.id.b4)
       button5=findViewById(R.id.b5)
       button6=findViewById(R.id.b6)
       button7=findViewById(R.id.b7)
       button8=findViewById(R.id.b8)
       button9=findViewById(R.id.b9)






       button1.setOnClickListener(this)
       button2.setOnClickListener(this)
       button3.setOnClickListener(this)
       button4.setOnClickListener(this)
       button5.setOnClickListener(this)
       button6.setOnClickListener(this)
       button7.setOnClickListener(this)
       button8.setOnClickListener(this)
       button9.setOnClickListener(this)

   }
    override fun onClick(Clicked: View?) {
        var btnnum=0
        // am if statementit ganvsazgvrav imas rom tamashi morchenili ar aris, da motamashes sheudzlia
        // dawves buttons sanam counteri udris 0 s
        if(counter==0) {
            if (Clicked is Button) {
                when (Clicked.id) {
                    R.id.b1 -> btnnum = 1
                    R.id.b2 -> btnnum = 2
                    R.id.b3 -> btnnum = 3
                    R.id.b4 -> btnnum = 4
                    R.id.b5 -> btnnum = 5
                    R.id.b6 -> btnnum = 6
                    R.id.b7 -> btnnum = 7
                    R.id.b8 -> btnnum = 8
                    R.id.b9 -> btnnum = 9

                }

                if (btnnum != 0) {
                    playgame(Clicked, btnnum)
                }
            }
        }


    }

    private fun playgame(clicked: Button, btnnum: Int) {
        if(activeplayer==1) {
            clicked.text = "X"
            clicked.setBackgroundColor(Color.RED)
            activeplayer = 0
            clicked.isEnabled=false
            firstplayerchanse.add(btnnum)
        }else{
            clicked.text = "O"
            clicked.setBackgroundColor(Color.GREEN)
            activeplayer = 1
            clicked.isEnabled=false
            secondplayerchanse.add(btnnum)
        }
        check()
    }

    private fun check() {
        var player=0
        if(firstplayerchanse.contains(1) && firstplayerchanse.contains(2)&&firstplayerchanse.contains(3)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            //counter xdeba 1 radgan vercert buttons vegar dawves motamashe resetis garda
            counter=1
            //scores emateba erti qula
            score1++
            //score shedis textViewshi
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(secondplayerchanse.contains(1) && secondplayerchanse.contains(2)&&secondplayerchanse.contains(3)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(firstplayerchanse.contains(4) && firstplayerchanse.contains(5)&&firstplayerchanse.contains(6)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(secondplayerchanse.contains(4) && secondplayerchanse.contains(5)&&secondplayerchanse.contains(6)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(firstplayerchanse.contains(7) && firstplayerchanse.contains(8)&&firstplayerchanse.contains(9)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(secondplayerchanse.contains(7) && secondplayerchanse.contains(8) && secondplayerchanse.contains(9)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(firstplayerchanse.contains(1) && firstplayerchanse.contains(4)&&firstplayerchanse.contains(7)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(secondplayerchanse.contains(1) && secondplayerchanse.contains(4)&&secondplayerchanse.contains(7)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(firstplayerchanse.contains(2) && firstplayerchanse.contains(5)&&firstplayerchanse.contains(8)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(secondplayerchanse.contains(2) && secondplayerchanse.contains(5)&&secondplayerchanse.contains(8)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(firstplayerchanse.contains(3) && firstplayerchanse.contains(6)&&firstplayerchanse.contains(9)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"

        }
        if(secondplayerchanse.contains(3) && secondplayerchanse.contains(6)&&secondplayerchanse.contains(9)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"
        }
        if(firstplayerchanse.contains(1) && firstplayerchanse.contains(5)&&firstplayerchanse.contains(9)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"
        }
        if(secondplayerchanse.contains(1) && secondplayerchanse.contains(5)&&secondplayerchanse.contains(9)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"
        }
        if(firstplayerchanse.contains(3) && firstplayerchanse.contains(5)&&firstplayerchanse.contains(7)){
            Toast.makeText(this, "X won", Toast.LENGTH_SHORT).show()
            counter=1
            score1++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"
        }
        if(secondplayerchanse.contains(3) && secondplayerchanse.contains(5)&&secondplayerchanse.contains(7)){
            Toast.makeText(this, "O won", Toast.LENGTH_SHORT).show()
            counter=1
            score2++
            firstscore.text="X player score : ${score1}"
            secScore.text="Y player score : ${score2}"
        }
    }


}

package work.nbcc.asn2


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import work.nbcc.asn2.databinding.FragmentCheatBinding

/**
 * A simple [Fragment] subclass.
 */
class CheatFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var binding: FragmentCheatBinding

    private lateinit var args: CheatFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_cheat, container, false
        )

        args = CheatFragmentArgs.fromBundle(arguments!!)

        binding.apply {
            answerText.visibility = View.INVISIBLE
            answerText.text = args.answer

            if (answerText.text == "true") {
                answerText.setTextColor(Color.parseColor("#78AB46"))
            } else {
                answerText.setTextColor(Color.parseColor("#ff0000"))
            }

            questionText.setText(args.question)

            cheatButton.setOnClickListener { answerText.visibility = View.VISIBLE }
        }

        binding.apply {
            cancelButton.setOnClickListener{
                activity?.onBackPressed()
            }
        }

        return binding.root
    }

}
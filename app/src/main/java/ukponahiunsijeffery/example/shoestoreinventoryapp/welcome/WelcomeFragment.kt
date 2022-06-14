package ukponahiunsijeffery.example.shoestoreinventoryapp.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import ukponahiunsijeffery.example.shoestoreinventoryapp.R
import ukponahiunsijeffery.example.shoestoreinventoryapp.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,
            container, false)

        binding.nextButton.setOnClickListener { view : View ->
            view.findNavController().navigate(WelcomeFragmentDirections
                .actionWelcomeFragmentToInstructionFragment())
        }

        return binding.root
    }



}
package ukponahiunsijeffery.example.shoestoreinventoryapp.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import ukponahiunsijeffery.example.shoestoreinventoryapp.R
import ukponahiunsijeffery.example.shoestoreinventoryapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_login, container, false)

        binding.signInButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        binding.signUpButton.setOnClickListener { view : View ->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }


}
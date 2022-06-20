package ukponahiunsijeffery.example.shoestoreinventoryapp.shoedetail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import ukponahiunsijeffery.example.shoestoreinventoryapp.viewmodel.SharedViewModel
import ukponahiunsijeffery.example.shoestoreinventoryapp.shoeobject.Shoe
import ukponahiunsijeffery.example.shoestoreinventoryapp.R
import ukponahiunsijeffery.example.shoestoreinventoryapp.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    // SharedViewModel instance
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false);

        // Enable fragment_shoe_detail.xml direct access to variables in the ViewModel
        binding.sharedViewModel = sharedViewModel

        // Setup save button ClickListener
        binding.saveButton.setOnClickListener {

            // Check for empty details
            if (sharedViewModel.checkEditTextFields()){
                navigate()
            }
            else{
                Toast.makeText(context, "Enter all Shoe details", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


    /**
     *  Perform Navigation to ShoeListFragment
     */
    private fun navigate(){
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }



}
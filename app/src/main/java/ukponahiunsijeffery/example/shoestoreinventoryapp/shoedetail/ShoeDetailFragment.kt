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

        // Setup save button ClickListener
        binding.saveButton.setOnClickListener {
            getAndSaveEditTextFields()
        }

        return binding.root
    }



    /**
     *  Get EditText fields and save to the ViewModel
     */
    private fun getAndSaveEditTextFields() {

        // Get Shoe details from EditText fields
        val name = binding.nameEditText.text.toString()
        val company = binding.companyEditText.text.toString()
        val size = binding.sizeEditText.text.toString()
        val description = binding.descriptionEditText.text.toString()

        // Check for empty details
        if ((name.isEmpty() || name.isBlank() ) && (company.isEmpty() || company.isBlank() ) &&
            (size.isEmpty() || size.isBlank() ) && (description.isEmpty() || description.isBlank() )) {
            Toast.makeText(context, "Enter Shoe Details", Toast.LENGTH_SHORT).show()
            navigate()
        }
        else if (name.isEmpty() || name.isBlank() ) {
            Toast.makeText(context, "Name of Shoe is required", Toast.LENGTH_SHORT).show()
            navigate()
        }
        else if (company.isEmpty() || company.isBlank() ) {
            Toast.makeText(context, "Name of Company is required", Toast.LENGTH_SHORT).show()
            navigate()
        }
        else if (size.isEmpty() || size.isBlank() ) {
            Toast.makeText(context, "Shoe size is required", Toast.LENGTH_SHORT).show()
            navigate()
        }
        else if (description.isEmpty() || description.isBlank() ) {
            Toast.makeText(context, "Shoe description is required", Toast.LENGTH_SHORT).show()
            navigate()
        }

        // Create Shoe Object and pass to ViewModel
        else {
            val shoeInstance = Shoe(name, company, size, description)
            sharedViewModel.addShoes(shoeInstance)
            navigate()
        }

    }


    /**
     *  Perform Navigation to ShoeListFragment
     */
    private fun navigate(){
        findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }




}
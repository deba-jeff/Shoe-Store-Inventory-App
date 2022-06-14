package ukponahiunsijeffery.example.shoestoreinventoryapp.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import ukponahiunsijeffery.example.shoestoreinventoryapp.viewmodel.SharedViewModel
import ukponahiunsijeffery.example.shoestoreinventoryapp.R
import ukponahiunsijeffery.example.shoestoreinventoryapp.databinding.FragmentShoeListBinding
import ukponahiunsijeffery.example.shoestoreinventoryapp.databinding.ShoeListItemBinding


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    // SharedViewModel instance
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)

        // Setup FAB ClickListener
        binding.fabFloatingActionButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.
            actionShoeListFragmentToShoeDetailFragment())
        )

        // Set up LiveData Observation of mShoesListMutableLiveData for changes
        sharedViewModel.mShoesListMutableLiveData.observe(viewLifecycleOwner, Observer { shoeList ->

            // Perform the inflation and binding of each Shoe in shoeList to the Layout
            shoeList.forEach { currentShoe ->

                // Inflate shoe_list_item
                val listItemBinding: ShoeListItemBinding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.shoe_list_item, binding.parentLinearLayout, false)

                // Inflate shoe_list_item into fragment_shoe_list Layout
                binding.parentLinearLayout.addView(listItemBinding.root)

                // Update shoe_list_item TextViews using DataBinding
                listItemBinding.shoeData = currentShoe
            }

        })

        // Notify Android system that this fragment would have a menu associated with
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_shoe_list, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout ->
                findNavController().navigate(ShoeListFragmentDirections.
                actionShoeListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }




}
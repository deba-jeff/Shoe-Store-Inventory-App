package ukponahiunsijeffery.example.shoestoreinventoryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ukponahiunsijeffery.example.shoestoreinventoryapp.shoeobject.Shoe

class SharedViewModel : ViewModel(){

    var mName :String = ""
    var mCompanyName :String = ""
    var mShoeSize: String = ""
    var mDescription:String = ""

    private val mShoes = ArrayList<Shoe>()

    private val _mShoesListMutableLiveData = MutableLiveData<List<Shoe>>()
    val mShoesListMutableLiveData:LiveData<List<Shoe>>
        get() {
            return _mShoesListMutableLiveData
        }


    /**
     *  Check for empty EditText fields
     */
    fun checkEditTextFields(): Boolean{

        if (mName.isEmpty() || mName.isBlank() || mCompanyName.isEmpty() || mCompanyName.isBlank() ||
            mShoeSize.isEmpty() || mShoeSize.isBlank() || mDescription.isEmpty() || mDescription.isBlank()) {
            return false
        }

        addShoes()
        return true
    }


    /**
     *  Accept Shoe details from fragment_shoe_detail and pass to ArrayList and MutableLiveData
     */
    private fun addShoes(){
        val mShoe = Shoe(mName, mCompanyName, mShoeSize, mDescription)
        mShoes.add(mShoe)
        _mShoesListMutableLiveData.value = mShoes
    }


    /**
     *  Clear EditTextFields data stored in Shoe Object of its previous data
     */
    fun resetEditTextShoeData(){
        mName = ""
        mCompanyName = ""
        mShoeSize = ""
        mDescription = ""
    }


}
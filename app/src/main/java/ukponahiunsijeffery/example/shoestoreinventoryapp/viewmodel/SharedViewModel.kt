package ukponahiunsijeffery.example.shoestoreinventoryapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ukponahiunsijeffery.example.shoestoreinventoryapp.shoeobject.Shoe

class SharedViewModel : ViewModel(){

    private val mShoes = ArrayList<Shoe>()

    private val _mShoesListMutableLiveData = MutableLiveData<List<Shoe>>()
    val mShoesListMutableLiveData:LiveData<List<Shoe>>
        get() {
            return _mShoesListMutableLiveData
        }


    /**
     *  Accept Shoe Object from ShoeDetailFragment and pass to ArrayList and MutableLiveData
     */
    fun addShoes(currentShoe: Shoe){
        mShoes.add(currentShoe)
        _mShoesListMutableLiveData.value = mShoes
    }



}
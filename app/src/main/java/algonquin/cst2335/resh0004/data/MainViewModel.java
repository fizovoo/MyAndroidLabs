package algonquin.cst2335.resh0004.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    public MutableLiveData<String> editString = new MutableLiveData<>();
    public MutableLiveData<Boolean>  selectButtons = new MutableLiveData<>();
}

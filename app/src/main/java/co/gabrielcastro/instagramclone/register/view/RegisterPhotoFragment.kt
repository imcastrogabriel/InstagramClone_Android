package co.gabrielcastro.instagramclone.register.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.gabrielcastro.instagramclone.R
import co.gabrielcastro.instagramclone.common.view.CustomDialog

class RegisterPhotoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // View esta pronta e posso manipular interface do app
        val customDialog = CustomDialog(requireContext())
//        customDialog.setTitle(R.string.app_name)
        customDialog.addButton(R.string.photo, R.string.gallery) {
            when(it.id) {
                R.string.photo -> {
                    // open camera
                }
                R.string.gallery -> {
                    // open gallery
                }
            }
        }
        customDialog.show()
    }
}
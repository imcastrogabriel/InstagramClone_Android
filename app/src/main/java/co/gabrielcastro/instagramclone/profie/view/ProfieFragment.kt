package co.gabrielcastro.instagramclone.profie.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.gabrielcastro.instagramclone.R

class ProfieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profie, container, false)
    }

    // disparado depois que a view esta criada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.profile_rv)
        rv.layoutManager = GridLayoutManager(requireContext(), 3)
        rv.adapter = PostAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true) // vai informar que esse fragmento vai ser responsavel por gerar opcoes de menu
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    private class PostAdapter() : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            // layout que vamos criar
            return PostViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_profile_grid, parent, false)
            )
        }

        override fun getItemCount(): Int {
            // quantidade de items da celula
            return 30
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            // devolver posicao
            holder.bind(R.drawable.ic_insta_add)
        }

        private class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            fun bind(image: Int) {
                itemView.findViewById<ImageView>(R.id.item_profile_img_grid).setImageResource(image)
            }
        }

    }

}
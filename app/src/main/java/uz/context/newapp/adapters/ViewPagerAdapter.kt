package uz.context.newapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.context.newapp.fragments.BreakingNewsFragment
import uz.context.newapp.fragments.SavedNewsFragment
import uz.context.newapp.fragments.SearchNewsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BreakingNewsFragment()
            1 -> SavedNewsFragment()
            2 -> SearchNewsFragment()
            else -> Fragment()
        }
    }
}

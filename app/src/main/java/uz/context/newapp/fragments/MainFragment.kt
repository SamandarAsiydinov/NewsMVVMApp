package uz.context.newapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import uz.context.newapp.R
import uz.context.newapp.adapters.ViewPagerAdapter
import uz.context.newapp.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        initViews()
        return binding.root
    }
    private fun initViews() {
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)

        binding.viewPager.adapter = viewPagerAdapter

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.breakingNewsFragment -> binding.viewPager.currentItem = 0
                R.id.savedNewsFragment -> binding.viewPager.currentItem = 1
                R.id.searchNewsFragment -> binding.viewPager.currentItem = 2
            }
            true
        }
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })
    }
}
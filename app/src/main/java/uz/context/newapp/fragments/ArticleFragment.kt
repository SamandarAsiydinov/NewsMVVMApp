package uz.context.newapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.snackbar.Snackbar
import uz.context.newapp.R
import uz.context.newapp.activities.NewsActivity
import uz.context.newapp.databinding.FragmentArticleBinding
import uz.context.newapp.util.SaveArgs
import uz.context.newapp.viewmodel.NewsViewModel

class ArticleFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var binding: FragmentArticleBinding
    val args: ArticleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = (activity as NewsActivity).viewModel
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(SaveArgs.url)
        }
//        binding.fab.setOnClickListener {
//            viewModel.saveArticle(article)
//            Snackbar.make(it, "Article saved successfully", Snackbar.LENGTH_LONG).show()
//        }
    }
}
package com.brandjunhoe.presentation.ui.repos

import android.os.Bundle
import com.brandjunhoe.common.createViewModel
import com.brandjunhoe.presentation.BaseActivity
import com.brandjunhoe.presentation.R
import com.brandjunhoe.presentation.BR
import com.brandjunhoe.presentation.databinding.ActivityReposBinding


class ReposActivity : BaseActivity<ActivityReposBinding, ReposViewModel>() {

    override val layoutResource: Int = R.layout.activity_repos
    override val bindingVariable: Int = BR.vm
    override val viewModel: ReposViewModel by lazy {
        createViewModel(
            factory,
            ReposViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


}

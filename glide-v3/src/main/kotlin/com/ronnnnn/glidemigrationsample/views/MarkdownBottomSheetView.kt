package com.ronnnnn.glidemigrationsample.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import br.tiagohm.markdownview.MarkdownView
import br.tiagohm.markdownview.css.styles.Github
import com.ronnnnn.glidemigrationsample.R
import com.ronnnnn.glidemigrationsample.extentions.bindView

/**
 * Created by kokushiseiya on 2017/06/23.
 */
class MarkdownBottomSheetView @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0): FrameLayout(context, attributeSet, defStyleAttr, defStyleRes) {

    private val markdownView: MarkdownView

    init {
        View.inflate(context, R.layout.view_markdown_bottom_sheet, this)

        markdownView = bindView<MarkdownView>(R.id.markdown_view).apply {
            addStyleSheet(Github())
        }
    }

    fun loadMarkdownFromAsset(fileName: String) {
        markdownView.loadMarkdownFromAsset("md/$fileName")
    }
}
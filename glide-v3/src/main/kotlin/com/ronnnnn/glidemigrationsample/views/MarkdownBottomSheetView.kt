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
        defStyleRes: Int = 0) : FrameLayout(context, attributeSet, defStyleAttr, defStyleRes) {

    private val markdownView: MarkdownView

    init {
        View.inflate(context, R.layout.view_markdown_bottom_sheet, this)

        markdownView = bindView<MarkdownView>(R.id.markdown_view).apply {
            val githubStyleSheet = Github().apply {
                addRule("body", "line-height: 1.6", "padding: 0px")
                addRule("pre", "display: block", "padding: 0px", "margin: 0px", "font-size: 13px",
                        "line-height: 1.42857143", "color: #333", "background-color: #f6f8fa",
                        "border: 0px", "border-radius: 3px", "font-family: Menlo,Monaco,Consolas,\"Courier New\",monospace",
                        "overflow: auto", "position: relative")
            }
            addStyleSheet(githubStyleSheet)
        }
    }

    fun loadMarkdownFromAsset(fileName: String) {
        markdownView.loadMarkdownFromAsset("md/$fileName")
    }
}
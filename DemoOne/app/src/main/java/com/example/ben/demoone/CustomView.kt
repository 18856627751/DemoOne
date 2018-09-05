package com.example.ben.demoone

import android.view.View
import android.app.Activity
import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.util.DisplayMetrics
import com.example.ben.demoone.R.mipmap.ic_launcher


/**
 *@author：  BaiCha
 *@Time:2018/8/17
 *@description :
 *
 */
class CustomView(context: Context?,attributeSet: AttributeSet?,defStyleAttr:Int) : View(context,attributeSet,defStyleAttr) {


    constructor(context: Context?) :this(context,null)
    constructor(context: Context?,attributeSet: AttributeSet?):this(context,attributeSet,0)

    private var mPaint: Paint? = null// 画笔
    private val bitmap: Bitmap// 位图
    // 生成色彩矩阵
    internal var colorMatrix = ColorMatrix(floatArrayOf(
            0f, 0f, 0f, 0f, 0f,
            0f, 0f, 0f, 0f, 0f,
            0f, 0f, 0f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f))

    lateinit var metrics: DisplayMetrics
    init {
        // 初始化画笔
        initPaint()

        // 获取位图
        bitmap = BitmapFactory.decodeResource(context!!.resources, R.mipmap.imge)
        metrics = DisplayMetrics();
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics);
    }

    /**
     * 初始化画笔
     */
    private fun initPaint() {
        // 实例化画笔并打开抗锯齿
        mPaint = Paint(ANTI_ALIAS_FLAG)
        /*
		 * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
		 *
		 * 画笔样式分三种：
		 * 1.Paint.Style.STROKE：描边
		 * 2.Paint.Style.FILL_AND_STROKE：描边并填充
		 * 3.Paint.Style.FILL：填充
		 */
        mPaint!!.setStyle(Paint.Style.FILL)

        // 设置画笔颜色为自定义颜色
        mPaint!!.color = Color.argb(255, 255, 0, 0)
        /*
		 * 设置描边的粗细，单位：像素px 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
		 */
        mPaint!!.strokeWidth = 10f
        mPaint!!.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }

     override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        // 绘制圆形
        canvas.drawCircle(metrics.xdpi / 2, metrics.ydpi / 2, 200f, mPaint)
    }


}



